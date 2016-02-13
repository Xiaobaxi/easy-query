package com.engineer.common.easyquery.api;

/**
 * 一元/二元
 * @author fangzhibin
 * @since 版本号，从什么版本开始
 * @createDate 2016年2月13日 下午10:06:24
 */
public class SimpleExpr implements Expr {
	
	/**
	 * TODO(用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = -8155030740174303136L;
	private String k;
	private Object v;
	private int op;
	
	public SimpleExpr(int op, String k, Object v) {
		this.op = op;
		this.k = k;
		this.v = v;
	}
	
	public int getOp() {
		return op;
	}
	
	public String getK() {
		return k;
	}
	
	public Object getV() {
		return v;
	}
}
