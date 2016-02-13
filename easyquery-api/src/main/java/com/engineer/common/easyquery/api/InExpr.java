package com.engineer.common.easyquery.api;

/**
 * in-notin集合
 * @author fangzhibin
 * @since 版本号，从什么版本开始
 * @createDate 2016年2月13日 下午10:04:34
 */
public class InExpr implements Expr {
	
	/** 
    * TODO(用一句话描述这个变量表示什么) 
    */ 
    private static final long serialVersionUID = -5815487501466804417L;
	private String k;
	private Object[] v;
	private int op;

	public InExpr(int op, String k, Object[] v) {
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

	public Object[] getV() {
		return v;
	}
}
