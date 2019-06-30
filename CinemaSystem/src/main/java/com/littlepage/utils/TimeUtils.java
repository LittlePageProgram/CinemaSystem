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
		int year=ca.get(Calendar.YEAR);
		int month=ca.get(Calendar.MONTH)+1;
		int day=ca.get(Calendar.DAY_OF_MONTH);
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
		matcher.find();
		String day=matcher.group();
		return year+"-"+month+"-"+day;
	}
}
