package com.engineer.common.easyquery.validation;

/**
 * {描述: 功能，使用对象，使用方法等}
 * @author fangzhibin
 * @since 版本号，从什么版本开始
 * @createDate 2016年6月3日 上午10:10:53
 */
public interface QueryValidator {
	
	public void validate(String methodName, Class<?>[] parameterTypes, Object[] arguments) throws Exception;
}
