package com.hexudong.cms.utils.entity;

public class HtmlUtils {
	/**
	 * 
	    * @Title: htmlspecialchars
	    * @Description: html 字符的转义处理
	    * @param @param str
	    * @param @return    参数
	    * @return String    返回类型
	    * @throws
	 */
	public static String htmlspecialchars(String str) {
		str = str.replaceAll("&", "&amp;");
		str = str.replaceAll("<", "&lt;");
		str = str.replaceAll(">", "&gt;");
		str = str.replaceAll("\"", "&quot;");
		return str;
	}
	
}
