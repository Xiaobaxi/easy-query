package com.engineer.common.easyquery.api;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * 查询器
 * @author fangzhibin
 * @since 版本号，从什么版本开始
 * @createDate 2016年2月13日 下午10:06:06
 */
public class Qry implements Serializable{
	
	/** 
    * TODO(用一句话描述这个变量表示什么) 
    */ 
    private static final long serialVersionUID = 7471753443109277236L;
	private Class<?> clazz;
	List<Expr> exprs;

	public static Qry build(Class<?> clazz) {
		Qry q = new Qry();
		q.clazz = clazz;
		q.exprs = new LinkedList<Expr>();
		return q;
	}

	public Qry eq(String k, Object v) {
		add(Op.eq(k, v));
		return this;
	}

	public Qry ne(String k, Object v) {
		add(Op.ne(k, v));
		return this;
	}

	public Qry lt(String k, Object v) {
		add(Op.lt(k, v));
		return this;
	}

	public Qry le(String k, Object v) {
		add(Op.le(k, v));
		return this;
	}

	public Qry gt(String k, Object v) {
		add(Op.gt(k, v));
		return this;
	}

	public Qry ge(String k, Object v) {
		add(Op.ge(k, v));
		return this;
	}

	public Qry like(String k, Object v) {
		add(Op.like(k, v));
		return this;
	}
	
	public Qry isnull(String k) {
		add(Op.isnull(k));
		return this;
	}
	
	public Qry notnull(String k) {
		add(Op.notnull(k));
		return this;
	}

	public Qry between(String k, Object l, Object r) {
		add(Op.between(k, l, r));
		return this;
	}

	public Qry in(String k, Object[] v) {
		add(Op.in(k, v));
		return this;
	}

	public Qry in(String k, Collection<?> v) {
		add(Op.in(k, v));
		return this;
	}
	
	public Qry notin(String k, Object[] v) {
		add(Op.notin(k, v));
		return this;
	}

	public Qry notin(String k, Collection<?> v) {
		add(Op.notin(k, v));
		return this;
	}

	public Qry asc(String k) {
		add(Op.asc(k));
		return this;
	}

	public Qry desc(String k) {
		add(Op.desc(k));
		return this;
	}

	public Qry or(Expr l, Expr r) {
		add(Op.or(l, r));
		return this;
	}
	
	public Qry or(Expr... e) {
		add(Op.or(e));
		return this;
	}
	
	public Qry and(Expr l, Expr r) {
		add(Op.and(l, r));
		return this;
	}
	
	public Qry and(Expr... e) {
		add(Op.and(e));
		return this;
	}

	private void add(Expr expr) {
		exprs.add(expr);
	}

	public Class<?> getClazz() {
		return clazz;
	}

	public List<Expr> getExprs() {
		return exprs;
	}
}
