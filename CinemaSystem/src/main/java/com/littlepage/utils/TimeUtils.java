package com.littlepage.utils;

import java.util.Calendar;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 时间工具类
 * @author 74302
 *
 */

public class TimeUtils {
	/**
	 * 获取当前时间
	 * @return
	 */
	public static String getCurrentTime() {
		Calendar ca=Calendar.getInstance();
		String year=ca.get(Calendar.YEAR)+"";
		String month=ca.get(Calendar.MONTH)+1+"";
		String day=ca.get(Calendar.DAY_OF_MONTH)+"";
		if(month.length()==1) {
			month="0"+month;
		}
		if(day.length()==1) {
			day="0"+day;
		}
		return ""+year+"-"+month+"-"+day;
	}
	
	/**
	 * 格式化时间
	 * @param args
	 */
	public static String formatTime(String str) {
		Pattern pattern = Pattern.compile("\\d+");
		Matcher matcher=pattern.matcher(str);
		matcher.find();
		String year=matcher.group();
		matcher.find();
		String month=matcher.group();
		if(month.length()==1) {
			month="0"+month;
		}
		matcher.find();
		String day=matcher.group();
		if(day.length()==1) {
			day="0"+day;
		}
		return year+"-"+month+"-"+day;
	}
}
