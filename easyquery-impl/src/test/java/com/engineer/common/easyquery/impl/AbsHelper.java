package com.engineer.common.easyquery.impl;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import com.engineer.common.easyquery.api.Qry;
import com.engineer.common.easyquery.impl.CriteriaParse;

/**
 * {描述: 功能，使用对象，使用方法等}
 * @author fangzhibin
 * @since 版本号，从什么版本开始
 * @createDate 2016年2月13日 下午10:24:21
 */
public class AbsHelper {
	

	@SuppressWarnings("unchecked")
	public static  List<App> list(Qry q) {
		DetachedCriteria dc = CriteriaParse.parse(q);
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Criteria criteria = dc.getExecutableCriteria(session);
		dc.setResultTransformer(Criteria.ROOT_ENTITY);
		List<App> l =  criteria.list();
		session.close();
		return l;
	}
	
	@SuppressWarnings("unchecked")
	public static  List<App> list2(DetachedCriteria dc) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Criteria criteria = dc.getExecutableCriteria(session);
		dc.setResultTransformer(Criteria.ROOT_ENTITY);
		List<App> l =  criteria.list();
		session.close();
		return l;
	}
}
