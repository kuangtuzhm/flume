/*
 * COPYRIGHT. ShenZhen JiMi Technology Co., Ltd. 2017.
 * ALL RIGHTS RESERVED.
 *
 * No part of this publication may be reproduced, stored in a retrieval system, or transmitted,
 * on any form or by any means, electronic, mechanical, photocopying, recording, 
 * or otherwise, without the prior written permission of ShenZhen JiMi Network Technology Co., Ltd.
 *
 * Amendment History:
 * 
 * Date                   By              Description
 * -------------------    -----------     -------------------------------------------
 * 2017年8月11日    Li.Shangzhi         Create the class
 * http://www.jimilab.com/
 */

package com.zealot.flume.statistics.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @FileName DatetimeUtil.java
 * @Description:
 *
 * @Date 2017年8月11日 下午2:04:31
 * @author Li.Shangzhi
 * @version 1.0
 */
public class DatetimeUtil {

	public static final String LONG_DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

	public DatetimeUtil() {
	}

	public static String getCurrentDate(String pattern) {
		SimpleDateFormat formatter = new SimpleDateFormat(pattern);
		String result = formatter.format(new Date());
		return result;
	}

	public static String getFormatDatetime() {
		GregorianCalendar gCalendar = new GregorianCalendar();
		SimpleDateFormat formatter = new SimpleDateFormat(LONG_DATE_TIME_PATTERN);
		String strDateTime;
		try {
			strDateTime = formatter.format(gCalendar.getTime());
		} catch (Exception ex) {
			System.err.println("Error Message:".concat(String.valueOf(String.valueOf(ex.toString()))));
			String s = null;
			return s;
		}
		return strDateTime;
	}

	public static Date StringToDate(String dateStr) {
		SimpleDateFormat formatter = new SimpleDateFormat(LONG_DATE_TIME_PATTERN);
		try {
			return formatter.parse(dateStr);
		} catch (Exception e) {
			System.err.println(String.valueOf((new StringBuffer(String.valueOf(e))).append(",").append(dateStr)));
		}
		return new Date();
	}

	public static String DateToString(Date dt, String fmtStr) {
		SimpleDateFormat format = new SimpleDateFormat(fmtStr);
		return format.format(dt);
	}

	public static String DateToString(Date dt) {
		SimpleDateFormat format = new SimpleDateFormat("yyMMdd");
		return format.format(dt);
	}
	
	/**
	 * 获得日期中的月份
	 * 
	 * @param date
	 *            Date
	 * @return int
	 */
	public static final int getMonth(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.MONTH) + 1;
	}
}
