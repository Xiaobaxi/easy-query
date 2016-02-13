package com.engineer.common.easyquery.api;

/**
 * 二次组合
 * @author fangzhibin
 * @since 版本号，从什么版本开始
 * @createDate 2016年2月13日 下午10:03:51
 */
public class CompExpr implements Expr {
	
	/** 
    * TODO(用一句话描述这个变量表示什么) 
    */ 
    private static final long serialVersionUID = 7658585881467563417L;
	private Expr l;
	private Expr r;
	private int op;

	public CompExpr(int op, Expr l, Expr r) {
		this.op = op;
		this.l = l;
		this.r = r;
	}

	public Expr getL() {
		return l;
	}

	public Expr getR() {
		return r;
	}

	public int getOp() {
		return op;
	}
}
