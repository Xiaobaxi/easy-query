package com.engineer.common.easyquery.test;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * {描述: 功能，使用对象，使用方法等}
 * @author fangzhibin
 * @since 版本号，从什么版本开始
 * @createDate 2016年2月13日 下午10:24:40
 */
public class HibernateUtil {
	
	private static final SessionFactory sessionFactory = buildSessionFactory();
	
	@SuppressWarnings("deprecation")
	private static SessionFactory buildSessionFactory() {
		try {
			// Create the SessionFactory from hibernate.cfg.xml
			return new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			// Make sure you log the exception, as it might be swallowed
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public static void shutdown() {
		// Close caches and connection pools
		getSessionFactory().close();
	}
}
