package com.engineer.common.easyquery.validation.support;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import com.engineer.common.easyquery.validation.QueryValidation;
import com.engineer.common.easyquery.validation.QueryValidator;

/**
 * {描述: 功能，使用对象，使用方法等}
 * @author fangzhibin
 * @since 版本号，从什么版本开始
 * @createDate 2016年6月3日 上午10:26:25
 */
public abstract class AbstractValidation implements QueryValidation {

    private final ConcurrentMap<String, QueryValidator> validators = new ConcurrentHashMap<String, QueryValidator>();

    public QueryValidator getValidator(String serviceInterface, String method) {
    	String key = serviceInterface + method;
    	QueryValidator validator = validators.get(key);
        if (validator == null) {
            validators.put(key, createQueryValidator(serviceInterface));
            validator = validators.get(key);
        }
        return validator;
    }

    protected abstract QueryValidator createQueryValidator(String serviceInterface);

}
