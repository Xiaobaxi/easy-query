package com.engineer.common.easyquery.impl;

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import com.engineer.common.easyquery.api.Qry;

/**
 * {描述: 功能，使用对象，使用方法等}
 * @author fangzhibin
 * @since 版本号，从什么版本开始
 * @createDate 2016年2月13日 下午10:24:45
 */
public class SimpleTest {
	
	public static void main(String[] args) {
		Qry q = Qry.build(App.class).eq("id", 1);
		List<App> apps1 = AbsHelper.list(q);
		DetachedCriteria dc = DetachedCriteria.forClass(App.class);
		dc.add(Restrictions.eq("id", 1));
		List<App> apps2 = AbsHelper.list2(dc);
		System.err.println(apps2.size() == apps1.size());
		q = Qry.build(App.class).eq("catalog", 0).ne("name", "test3").like("code", "%test%").lt("id", 200);
		apps1 = AbsHelper.list(q);
		dc = DetachedCriteria.forClass(App.class);
		dc.add(Restrictions.eq("catalog", 0)).add(Restrictions.ne("name", "test3")).add(Restrictions.like("code", "%test%")).add(Restrictions.lt("id", 200));
		apps2 = AbsHelper.list2(dc);
		System.err.println(apps2.size() == apps1.size());
		q = Qry.build(App.class).in("id", new Integer[] {1, 2, 11, 12}).notin("id", new Integer[] {11, 12});
		apps1 = AbsHelper.list(q);
		dc = DetachedCriteria.forClass(App.class);
		dc.add(Restrictions.in("id", new Integer[] {1, 2, 11, 12})).add(Restrictions.not(Restrictions.in("id", new Integer[] {11, 12})));
		apps2 = AbsHelper.list2(dc);
		System.err.println(apps2.size() == apps1.size());
		q = Qry.build(App.class).between("id", 1, 10);
		apps1 = AbsHelper.list(q);
		dc = DetachedCriteria.forClass(App.class);
		dc.add(Restrictions.between("id", 1, 10));
		apps2 = AbsHelper.list2(dc);
		System.err.println(apps2.size() == apps1.size());
	}
}
