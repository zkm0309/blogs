package com.angel.blogs.utils;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.springframework.jdbc.core.JdbcTemplate;

public class BaseUtile {
	/**
	 * 获取自增列值
	 * 
	 * @param jdbcTemplate
	 * @param sqName
	 *            自增序列名称
	 * @return
	 */
	public static int getSQBySQName(JdbcTemplate jdbcTemplate, String sqName) throws Exception {
		String sql = "select " + sqName + ".nextval from dual";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}

	/**
	 * 时分秒 转秒
	 * 
	 * @param s
	 *            时
	 * @param f
	 *            分
	 * @param m
	 *            秒
	 * @return
	 */
	public static int toMiao(Integer s, Integer f, Integer m) {
		int miao = 0;
		if (s != null && s > 0) {
			miao += 3600 * s;
		}
		if (f != null && f > 0) {
			miao += 60 * f;
		}
		if (m != null && m > 0) {
			miao += m;
		}
		return miao;
	}

	/**
	 * 时分秒 转秒
	 * 
	 * @param mk
	 *            秒
	 * @return
	 */
	public static String toSFM(Integer mk) {
		if (mk == null || mk == 0) {
			return "0:0:0";
		}
		String sfm = "";
		int s = 0;
		int f = 0;
		int m = 0;
		if (mk > 3600) {
			s = mk / 3600;
			mk = mk % 3600;
		}
		if (mk > 60) {
			f = mk / 60;
			mk = mk % 60;
		}
		m = mk;
		sfm = s + ":" + f + ":" + m;
		return sfm;
	}

	/**
	 * 时分秒 转秒
	 * 
	 * @param mk
	 *            秒
	 * @return
	 */
	public static String toSFM(Double mkx) {
		if (mkx == null || mkx == 0) {
			return "0:0:0";
		}
		String s1 = String.valueOf(mkx);
		String s2 = s1.substring(0, s1.indexOf("."));
		int mk = Integer.parseInt(s2);

		String sfm = "";
		int s = 0;
		int f = 0;
		int m = 0;
		if (mk > 3600) {
			s = mk / 3600;
			mk = mk % 3600;
		}
		if (mk > 60) {
			f = mk / 60;
			mk = mk % 60;
		}
		m = mk;
		sfm = s + ":" + f + ":" + m;
		return sfm;
	}

	/**
	 * Function:获取客户端IP地址，针对Nginx等反代作处理 Date:2016-11-01 URL:http://www.htcdc.com
	 */
	public static String getIP(ServletRequest requestt) {
		HttpServletRequest request = (HttpServletRequest) requestt;
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("X-Real-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

}
