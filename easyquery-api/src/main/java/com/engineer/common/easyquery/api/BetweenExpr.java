package com.engineer.common.easyquery.api;

/**
 * 区间
 * @author fangzhibin
 * @since 版本号，从什么版本开始
 * @createDate 2016年2月13日 下午10:03:22
 */
public class BetweenExpr implements Expr {
	
	/**
	 * TODO(用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = 7331513215793313181L;
	private String k;
	private Object lv;
	private Object rv;
	
	public BetweenExpr(String k, Object lv, Object rv) {
		this.k = k;
		this.lv = lv;
		this.rv = rv;
	}
	
	public int getOp() {
		return Expr.between;
	}
	
	public String getK() {
		return k;
	}
	
	public Object getLv() {
		return lv;
	}
	
	public Object getRv() {
		return rv;
	}
}
