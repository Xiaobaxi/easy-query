package com.engineer.common.easyquery.validation.support;

import com.engineer.common.easyquery.validation.QueryValidator;

/**
 * {描述: 功能，使用对象，使用方法等}
 * @author fangzhibin
 * @since 版本号，从什么版本开始
 * @createDate 2016年6月3日 上午11:19:51
 */
public class HikQueryValidation extends AbstractValidation {
	
	@Override
    protected QueryValidator createQueryValidator(String serviceInterface) {
	    return new HikQueryValidator(serviceInterface);
    }
}
