package com.engineer.common.easyquery.impl;

import java.util.LinkedList;
import java.util.List;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import com.engineer.common.easyquery.api.BetweenExpr;
import com.engineer.common.easyquery.api.CompExpr;
import com.engineer.common.easyquery.api.Expr;
import com.engineer.common.easyquery.api.InExpr;
import com.engineer.common.easyquery.api.MoreExpr;
import com.engineer.common.easyquery.api.OrderExpr;
import com.engineer.common.easyquery.api.Qry;
import com.engineer.common.easyquery.api.SimpleExpr;

/**
 * 表达式解析器-解析成DetachedCriteria对象
 * @author fangzhibin
 * @since 版本号，从什么版本开始
 * @createDate 2016年2月13日 下午10:09:08
 */
public class CriteriaParse {
	
	/**
	 * 
	 * 外部调用的解析接口.
	 * <p>
	 * 外部调用的解析接口
	 * <p>
	 * <code>{样例代码， 小于号大于号转义&lt; &gt;}</code>
	 * @author fangzhibin 2016年2月13日 下午10:15:58
	 * @param q
	 * @return
	 * @modify {上次修改原因} by fangzhibin 2016年2月13日 下午10:15:58
	 */
	public static DetachedCriteria parse(Qry q) {
		if (null == q || null == q.getClazz()) return null;
		DetachedCriteria dc = DetachedCriteria.forClass(q.getClazz());
		List<Expr> exprs = q.getExprs();
		for (Expr e : exprs) {
			if (e instanceof OrderExpr) {
				if (e.getOp() == Expr.asc) dc.addOrder(Order.asc(((OrderExpr)e).getK()));
				else if (e.getOp() == Expr.desc) dc.addOrder(Order.desc(((OrderExpr)e).getK()));
			} else {
				Criterion c = _parse(e);
				if (c != null) dc.add(c);
			}
		}
		return dc;
	}
	
	/*
	 * 解析简单表达式
	 * @param e
	 * @return
	 */
	private static Criterion _parseSimpleExpr(SimpleExpr e) {
		switch (e.getOp()) {
			case Expr.eq:
				return Restrictions.eq(e.getK(), e.getV());
			case Expr.ne:
				return Restrictions.ne(e.getK(), e.getV());
			case Expr.lt:
				return Restrictions.lt(e.getK(), e.getV());
			case Expr.le:
				return Restrictions.le(e.getK(), e.getV());
			case Expr.gt:
				return Restrictions.gt(e.getK(), e.getV());
			case Expr.ge:
				return Restrictions.ge(e.getK(), e.getV());
			case Expr.like:
				return Restrictions.like(e.getK(), e.getV());
			case Expr.isnull:
				return Restrictions.isNull(e.getK());
			case Expr.notnull:
				return Restrictions.isNotNull(e.getK());
			default:
				return null;
		}
	}
	
	/*
	 * 解析in/notin表达式
	 * @param e
	 * @return
	 */
	private static Criterion _parseInExpr(InExpr e) {
		if (e.getOp() == Expr.notin) return Restrictions.not(Restrictions.in(e.getK(), e.getV()));
		return Restrictions.in(e.getK(), e.getV());
	}
	
	/*
	 * 解析between表达式
	 * @param e
	 * @return
	 */
	private static Criterion _parseBetweenExpr(BetweenExpr e) {
		return Restrictions.between(e.getK(), e.getLv(), e.getRv());
	}
	
	/*
	 * 解析组合表达式
	 * @param e
	 * @return
	 */
	private static Criterion _parseCompExpr(CompExpr e) {
		Criterion lc = _parse(e.getL());
		Criterion rc = _parse(e.getR());
		if (e.getOp() == Expr.or) return Restrictions.or(lc, rc);
		else return Restrictions.and(lc, rc);
	}
	
	/*
	 * 解析复杂表达式
	 * @param me
	 * @return
	 */
	private static Criterion _parseMoreExpr(MoreExpr me) {
		List<Criterion> rl = new LinkedList<Criterion>();
		List<Expr> exprs = me.getExprs();
		for (Expr e : exprs) {
			Criterion c = _parse(e);
			rl.add(c);
		}
		if (rl.size() > 0) {
			if (me.getOp() == Expr.or) return Restrictions.or(rl.toArray(new Criterion[rl.size()]));
			else return Restrictions.and(rl.toArray(new Criterion[rl.size()]));
		}
		return null;
	}
	
	/*
	 * 单个表达式解析成Criterion
	 * @param l
	 * @return
	 */
	private static Criterion _parse(Expr l) {
		Criterion lc = null;
		if (l instanceof SimpleExpr) {
			lc = _parseSimpleExpr((SimpleExpr)l);
		} else if (l instanceof InExpr) {
			lc = _parseInExpr((InExpr)l);
		} else if (l instanceof BetweenExpr) {
			lc = _parseBetweenExpr((BetweenExpr)l);
		} else if (l instanceof CompExpr) {
			lc = _parseCompExpr((CompExpr)l);
		} else if (l instanceof MoreExpr) {
			lc = _parseMoreExpr((MoreExpr)l);
		}
		return lc;
	}
}
