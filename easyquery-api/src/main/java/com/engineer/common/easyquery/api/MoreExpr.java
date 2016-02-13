package com.engineer.common.easyquery.api;

import java.util.Collections;
import java.util.List;

/**
 * 复杂组合
 * @author fangzhibin
 * @since 版本号，从什么版本开始
 * @createDate 2016年2月13日 下午10:04:54
 */
public class MoreExpr implements Expr{

	/** 
    * TODO(用一句话描述这个变量表示什么) 
    */ 
    private static final long serialVersionUID = -3928062078076813380L;
	private List<Expr> exprs;
	private int op;
	
	public MoreExpr(int op, List<Expr> exprs){
		this.op = op;
		this.exprs = exprs;
		if(this.exprs == null)
			this.exprs = Collections.emptyList();
	}
	
	public int getOp() {
		return op;
	}
	public List<Expr> getExprs() {
		return exprs;
	}
}
