package com.engineer.common.easyquery.api;

/**
 * 排序
 * @author fangzhibin
 * @since 版本号，从什么版本开始
 * @createDate 2016年2月13日 下午10:05:37
 */
public class OrderExpr implements Expr {


	/** 
    * TODO(用一句话描述这个变量表示什么) 
    */ 
    private static final long serialVersionUID = -3557303119504580736L;
	private String k;
	private int op;

	public OrderExpr(int op, String k) {
		this.op = op;
		this.k = k;
	}

	@Override
	public int getOp() {
		return op;
	}

	public String getK() {
		return k;
	}
}
