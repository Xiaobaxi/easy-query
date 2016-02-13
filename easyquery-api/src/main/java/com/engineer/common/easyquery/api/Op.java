package com.engineer.common.easyquery.api;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * 表达式生成器
 * @author fangzhibin
 * @since 版本号，从什么版本开始
 * @createDate 2016年2月13日 下午10:05:14
 */
public class Op {
	
	public static Expr eq(String k, Object v) {
		return new SimpleExpr(Expr.eq, k, v);
	}
	
	public static Expr ne(String k, Object v) {
		return new SimpleExpr(Expr.ne, k, v);
	}
	
	public static Expr lt(String k, Object v) {
		return new SimpleExpr(Expr.lt, k, v);
	}
	
	public static Expr le(String k, Object v) {
		return new SimpleExpr(Expr.le, k, v);
	}
	
	public static Expr gt(String k, Object v) {
		return new SimpleExpr(Expr.gt, k, v);
	}
	
	public static Expr ge(String k, Object v) {
		return new SimpleExpr(Expr.ge, k, v);
	}
	
	public static Expr like(String k, Object v) {
		return new SimpleExpr(Expr.like, k, v);
	}
	
	public static Expr isnull(String k) {
		return new SimpleExpr(Expr.isnull, k, null);
	}
	
	public static Expr notnull(String k) {
		return new SimpleExpr(Expr.notnull, k, null);
	}
	
	public static Expr between(String k, Object l, Object r) {
		return new BetweenExpr(k, l, r);
	}
	
	public static Expr in(String k, Object[] v) {
		return new InExpr(Expr.in, k, v);
	}
	
	public static Expr in(String k, Collection<?> v) {
		return new InExpr(Expr.in, k, v.toArray());
	}
	
	public static Expr notin(String k, Object[] v) {
		return new InExpr(Expr.notin, k, v);
	}
	
	public static Expr notin(String k, Collection<?> v) {
		return new InExpr(Expr.notin, k, v.toArray());
	}
	
	public static Expr asc(String k) {
		return new OrderExpr(Expr.asc, k);
	}
	
	public static Expr desc(String k) {
		return new OrderExpr(Expr.desc, k);
	}
	
	public static Expr or(Expr l, Expr r) {
		return new CompExpr(Expr.or, l, r);
	}
	
	public static Expr or(Expr... e) {
		List<Expr> l = null;
		if (e.length > 0) {
			l = new LinkedList<Expr>();
			for (Expr expr : e) {
				l.add(expr);
			}
		}
		return new MoreExpr(Expr.or, l);
	}
	
	public static Expr and(Expr l, Expr r) {
		return new CompExpr(Expr.and, l, r);
	}
	
	public static Expr and(Expr... e) {
		List<Expr> l = null;
		if (e.length > 0) {
			l = new LinkedList<Expr>();
			for (Expr expr : e) {
				l.add(expr);
			}
		}
		return new MoreExpr(Expr.and, l);
	}
}
