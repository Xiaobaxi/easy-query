package com.engineer.common.easyquery.impl;

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import com.engineer.common.easyquery.api.Op;
import com.engineer.common.easyquery.api.Qry;

/**
 * {描述: 功能，使用对象，使用方法等}
 * @author fangzhibin
 * @since 版本号，从什么版本开始
 * @createDate 2016年2月13日 下午10:24:35
 */
public class ComplexTest {
	
	public static void main(String[] args) {
		Qry q = Qry.build(App.class).between("id", 1, 200).eq("name", "test").or(Op.isnull("code"), Op.eq("name", "test1"), Op.eq("name", "test2"));
		List<App> apps1 = AbsHelper.list(q);
		DetachedCriteria dc = DetachedCriteria.forClass(App.class);
		dc.add(Restrictions.between("id", 1, 200)).add(Restrictions.eq("name", "test")).add(Restrictions.or(Restrictions.isNull("code"), Restrictions.eq("name", "test1"), Restrictions.eq("name", "test2")));
		List<App> apps2 = AbsHelper.list2(dc);
		System.err.println(apps2.size() == apps1.size());
		// ==more complex
		q = Qry.build(App.class).between("id", 1, 200).eq("name", "test").or(Op.isnull("code"), Op.gt("id", 20), Op.or(Op.eq("name", "test1"), Op.lt("id", 100)));
		apps1 = AbsHelper.list(q);
		dc = DetachedCriteria.forClass(App.class);
		dc.add(Restrictions.between("id", 1, 200)).add(Restrictions.eq("name", "test"))
		        .add(Restrictions.or(Restrictions.isNull("code"), Restrictions.gt("id", 20), Restrictions.or(Restrictions.eq("name", "test1"), Restrictions.lt("id", 100))));
		apps2 = AbsHelper.list2(dc);
		System.err.println(apps2.size() == apps1.size());
	}
}
