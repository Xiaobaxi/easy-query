package com.engineer.common.easyquery.test;

import java.io.Serializable;

/**
 * 测试对象
 * @author fangzhibin
 * @since 版本号，从什么版本开始
 * @createDate 2016年2月13日 下午10:24:08
 */
public class App implements Serializable {
	
	
	/** 
    * TODO(用一句话描述这个变量表示什么) 
    */ 
    private static final long serialVersionUID = -69192265921630443L;
	private Integer id;
	private String name;
	private String code;
	private Integer catalog = 1;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public Integer getCatalog() {
		return catalog;
	}
	
	public void setCatalog(Integer catalog) {
		this.catalog = catalog;
	}
}
