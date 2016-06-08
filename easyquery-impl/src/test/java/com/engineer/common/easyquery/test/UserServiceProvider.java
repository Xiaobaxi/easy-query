package com.engineer.common.easyquery.test;

import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;
import com.engineer.common.easyquery.validation.UserService;
import com.engineer.common.easyquery.validation.UserServiceImpl;
import com.engineer.common.easyquery.validation.UserServiceValidationInterceptor;


public class UserServiceProvider {
	
	public static void main(String[] args) {
		JaxWsServerFactoryBean serverFactoryBean = new JaxWsServerFactoryBean();
		serverFactoryBean.setServiceClass(UserService.class);
		serverFactoryBean.setServiceBean(new UserServiceImpl());
		serverFactoryBean.setAddress("http://localhost:6666/UserService");
		serverFactoryBean.getInInterceptors().add(new UserServiceValidationInterceptor());
		Server server = serverFactoryBean.create();
		server.start();
	    
    }
}
