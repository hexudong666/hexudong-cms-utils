package com.hexudong.cms.utils.entity;

import java.io.UnsupportedEncodingException;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

	public class StringUtils {
		
		/**
		 *  随机字符串源
		 */
		static char charArray[] = new char[36];
		static {
			// 构建随机字符串的原始数组
			for (int i = 0; i < 10; i++) {
				charArray[i] = (char)('0' + i);
			}
			for (int i = 0; i < 26; i++) {
				charArray[i+10] = (char)('A' + i);
			}		
		}
		
		
		/**
		 * 
		    * @Title: isEmail
		    * @Description: 是否邮箱
		    * @param @param str
		    * @param @return    参数
		    * @return boolean    返回类型
		    * @throws
		 */
		public static boolean isEmail(String str) {
			String pattern = "^\\w+@\\w+\\.[a-zA-Z]{2,3}$";
			Pattern compile = Pattern.compile(pattern);
			Matcher matcher = compile.matcher(str);
			return matcher.matches();
		}	
		

		/**
		 * 判断一个字符串是否为空，空字符串也认为是的空
		 * @param str
		 * @return 为空返回true  否则返回false
		 * 
		 */
		public static boolean isBlank(String str) {
			return null==str||"".equals(str.trim());
		}
		
		/**
		 * 判断手机号码是否为数值，是否长度为11位，开始位必须是1 
		 * @param src
		 * @return
		 */
		public static boolean judgeTelephoneIsOk(String src){
			
			String regex = "^1\\d{10}$";
			
			Pattern compile = Pattern.compile(regex);
			Matcher matcher = compile.matcher(src);
			boolean find = matcher.matches();
			return find;
			
		}
		
		/**
		 * 判断一个字符串时间否有值 
		 * @param str   
		 * @return 非空返回true  空字符串或空返回false
		 */
		public static boolean haveValue(String str) {
			return null!=str && !"".equals(str.trim());
		}
		
		/**
		 * 判断是否为数字
		 * @param str
		 * @return
		 */
		public static boolean isNumber(String str) {
			String regex = "^\\d{1,}$";
			Pattern compile = Pattern.compile(regex);
			Matcher matcher = compile.matcher(str);
			boolean find = matcher.find();
			return find;
		}
		
		/**
		 * 判断是否手机号
		 * @param str
		 * @return
		 */
		public static boolean isMobile(String str) {
			String regex = "^1(35|36|38)\\d{8}$";
			Pattern compile = Pattern.compile(regex);
			Matcher matcher = compile.matcher(str);
			boolean find = matcher.find();
			return find;
		}
		
		/**
		 * 
		 * @param n
		 * @return
		 */
		/*public static String getRandomStr(int n) {
			Random random = new Random();
			//Math.random();
			//UUID.randomUUID();
			//a -z;
			
			//  StringBuilder  线程不安全  但是执行效率高 ，效率高的原因在访问的时候不会加锁
			//  StringBuffer 线程安全 但是执行效率底下
			// 这里可以使用StringBuilder  ， 一个函数的执行只能在一个线程内部执行，
			// 也就是下边这个sb 不会被多个线程同时访问，不会出现线程安全的问题，因而选择效率较高的StringBuilder
			StringBuilder sb = new StringBuilder();
			//StringBuffer sb = new StringBuffer();
			for (int i = 0; i < n; i++) {
				char randomChar = (char)('a' +  random.nextInt(26));// 0 ~  25;
				sb.append(randomChar);
			}
			return sb.toString();
		}*/
		
		/**
		 * 获取英文和数字组合的字符串
		 * @param n
		 * @return
		 */
		public static String getRandomStrNum(int n) {
			//char charArray[] = {'0','1' ..}
			Random random = new Random();
			
			//获取随机字符串
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < n; i++) {
				// 获取数组的下标
				int index =  random.nextInt(36);// 0 ~  25;
				char randomChar = charArray[index];
				sb.append(randomChar);
			}
			
			return sb.toString();
			
		}
		
		
		/**
		 * 获取随机字符串 长度2为n
		 * @param n
		 * @return 
		 * @throws UnsupportedEncodingException 
		 */
		public static String getGb2312(int n) throws UnsupportedEncodingException {
			
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < n; i++) {
				sb.append(getGb2312());
			}
			return sb.toString();
		}
		
		/**
		 * 随机获取一个中文汉字
		 * @return
		 * @throws UnsupportedEncodingException 
		 */
		private static String getGb2312() throws UnsupportedEncodingException {
			
			byte word[] = new byte[2];
			//  0x1A   0x1A+94
			Random random = new Random();
			word[0] = (byte)(0xA1 + 0x10 + random.nextInt(39));
			word[1] = (byte)(0xA1  + random.nextInt(94));
			return new String(word,"UTF-8");
			
		}

		/**
		 * 验证是否是URL
		 * @param url
		 * @return
		 */
		public static boolean isurl(String url) {
			 //转换为小写
	        String str = url.toLowerCase();
	        String regex = "^((https|http|ftp|rtsp|mms)?://)"  //https、http、ftp、rtsp、mms
	                + "?(([0-9a-z_!~*'().&=+$%-]+: )?[0-9a-z_!~*'().&=+$%-]+@)?" //ftp的user@  
	               + "(([0-9]{1,3}\\.){3}[0-9]{1,3}" // IP形式的URL- 例如：199.194.52.184               
	                 + "|" // 允许IP和DOMAIN（域名） 
	                 + "([0-9a-z_!~*'()-]+\\.)*" // 域名- www.  
	                 + "([0-9a-z][0-9a-z-]{0,61})?[0-9a-z]\\." // 二级域名  
	                + "[a-z]{2,6})" // first level domain- .com or .museum  
	                + "(:[0-9]{1,5})?" // 端口号最大为65535,5位数
	                + "((/?)|" // a slash isn't required if there is no file name  
	                + "(/[0-9a-z_!~*'().;?:@&=+$,%#-]+)+/?)$";  
	        return  str.matches(regex);	
		}
		
	}