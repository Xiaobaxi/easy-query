package com.engineer.common.easyquery.validation;

import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.engineer.common.easyquery.validation.support.HikQueryValidation;


public class UserServiceValidationInterceptor extends AbstractPhaseInterceptor<Message> {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceValidationInterceptor.class);
	
	public UserServiceValidationInterceptor() {
		super(Phase.POST_STREAM);
	}

	@Override
    public void handleMessage(Message message) throws Fault {
		LOGGER.debug("userService validate interceptor in......");
		QueryValidation qv = new HikQueryValidation();
		String serviceInterface = "com.engineer.common.easyquery.validation.UserService";
		String methodName = "insert";
		QueryValidator validator = qv.getValidator(serviceInterface, methodName);
		if(null != validator) {
			User user = new User();
			try {
	            validator.validate(methodName, new Class[] {User.class}, new Object[] {user});
            } catch (Exception e) {
	            e.printStackTrace();
            }
		}
    }
}
