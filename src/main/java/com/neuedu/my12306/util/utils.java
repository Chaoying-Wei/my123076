package com.neuedu.my12306.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class utils {
	/**
	 * 时间转换(年月日)
	 * @param dateString
	 * @return
	 */
	public static Date parseDate(String dateString) {
		Date date =null;
		if(dateString==null||dateString.trim().length()==0) {
			return date;
		}
		String patternString="yyyy-MM-dd";
		SimpleDateFormat sFormat=new SimpleDateFormat(patternString);
		try {
			date=sFormat.parse(dateString);
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		return date;
	}
	/**
	 * 时间转换（年月日时分秒）
	 * @param timeString
	 * @return
	 */
	public static Date parseTime(String timeString) {
		Date date =null;
		if(timeString==null||timeString.trim().length()==0) {
			return date;
		}
		String patternString="yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat sFormat=new SimpleDateFormat(patternString);
		try {
			date=sFormat.parse(timeString);
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		return date;
	}
	/**
	 * 字符串转换为数值
	 * @param num 数字字符串
	 * @param data 默认返回值（转换失败后的默认返回值）
	 * @return
	 */
	public static int parseInt(String num,int data) {
		int ret=data;
		try {
			ret=Integer.parseInt(num);
		} catch (Exception e) {
			
		}
		
		return ret;
	}
	/**
	 * 判断字符串是否为null 或是否为空字符串 或 是否为只包含空格的字符串
	 * 
	 * @param dataString
	 * @return
	 */
	public static boolean isNull(String dataString) {
		if (dataString == null || dataString.trim().length() == 0) {
			return true;
		}
		return false;
	}
	
	/**
	 * 判断字符串是否不为null 或是否不为空字符串 或 是否不为只包含空格的字符串
	 * @param dataString
	 * @return
	 */
	public static boolean isNotNull(String dataString) {
		if (dataString == null || dataString.trim().length() == 0) {
			return false;
		}
		return true;
	}
	/**
	 * 字符串数组转换成数值数组
	 * @param arrs
	 * @return
	 */
	public static int[] stringToInt(String [] arrs) {
		int[] ints=new int[arrs.length];
		for(int i=0;i<arrs.length;i++) {
			ints[i]=Integer.parseInt(arrs[i]);
		}
		return ints;
	}

}
