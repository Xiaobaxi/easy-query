package com.engineer.common.easyquery.api;

import java.io.Serializable;

/**
 * 表达式接口
 * @author fangzhibin
 * @since 版本号，从什么版本开始
 * @createDate 2016年2月13日 下午10:04:12
 */
public interface Expr extends Serializable {
	
	int eq = 0, ne = 1, lt = 2, le = 3, gt = 4, ge = 5, like = 6, isnull = 7, notnull = 8, // 一、二元
	        in = 100, notin = 101, // 集合
	        between = 1000, // 区间
	        asc = 10000, desc = 10001, // 排序
	        or = 100000, and = 100001; // 组合
	
	/**
	 * 返回操作码
	 * @return
	 */
	int getOp();
}
