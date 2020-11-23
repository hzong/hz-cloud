package com.dzzh.hz.hzsf.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.time.DateFormatUtils;

/**
 * 日期工具类, 继承org.apache.commons.lang.time.DateUtils类
 *
 * @author chaiph
 * @version 2013-3-15
 */
public class DateUtils extends org.apache.commons.lang3.time.DateUtils {

	/**
	 * logger
	 */
	private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(DateUtils.class);

	private static String[] parsePatterns = { "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy/MM/dd",
			"yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm" };
	public static final String YYYY_MM_DD = "yyyy-MM-dd";
	public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
	public static final String HH_MM_SS = "HH:mm:ss";
	public static final String YYYY = "yyyy";

	public static final String MM = "MM";
	public static final String DD = "dd";
	public static final String E = "E";


	public static final String STARE_TIME =" 00:00:00";
	public static final String END_TIME =" 23:59:59";
	public static final String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
	public static final String YYYYMMDDHHMMSS_V2 = "yyyy年MM月dd日HH:mm:ss";



	/**
	 * 得到当前日期字符串 格式（yyyy-MM-dd）
	 */
	public static String parse() {
		return parse(YYYY_MM_DD);
	}

	/**
	 * 得到当前日期字符串 格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
	 */
	public static String parse(String pattern) {
		return parse(new Date(), pattern);
	}

	public static String parse(Date date, String pattern) {
		return DateFormatUtils.format(date, pattern);
	}



	/**
	 * 得到当前时间字符串 格式（HH:mm:ss）
	 */
	public static String parseTime() {
		return parse(new Date(), HH_MM_SS);
	}

	/**
	 * 得到当前日期和时间字符串 格式（yyyy-MM-dd HH:mm:ss）
	 */
	public static String getDateTime() {
		return parse(new Date(), YYYY_MM_DD_HH_MM_SS);
	}

	/**
	 * 得到当前年份字符串 格式（yyyy）
	 */
	public static String getYear() {
		return parse(new Date(), YYYY);
	}

	/**
	 * 得到当前月份字符串 格式（MM）
	 */
	public static String getMonth() {
		return getMonth(new Date());
	}

	public static String getMonth(Date date) {
		return parse(date, MM);
	}

	/**
	 * 得到当天字符串 格式（dd）
	 */
	public static String getDay() {
		return parse(new Date(), DD);
	}

	/**
	 * 得到当前星期字符串 格式（E）星期几
	 */
	public static String getWeek() {
		return parse(new Date(), E);
	}

	/**
	 * 日期型字符串转化为日期 格式 { "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm",
	 * "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm" }
	 */
	public static Date parseDate(Object str) {
		if (str == null) {
			return null;
		}
		try {
			return parseDate(str.toString(), parsePatterns);
		} catch (ParseException e) {
			LOGGER.error("转换异常",e);
			return null;
		}
	}

	/**
	 * 获取过去的天数
	 *
	 * @param date
	 * @return
	 */
	public static long pastDays(Date date) {
		long t = System.currentTimeMillis() - date.getTime();
		return t / (24 * 60 * 60 * 1000);
	}

	public static Date getDateStart(Date date) {
		if (date == null) {
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS);
		try {
			date = sdf.parse(parse(date, YYYY_MM_DD) + STARE_TIME);
		} catch (ParseException e) {
			LOGGER.error("转换异常",e);
		}
		return date;
	}

	public static String formatDateStr(String dateStr) {
		SimpleDateFormat sdf = new SimpleDateFormat(YYYYMMDDHHMMSS);
		SimpleDateFormat sdf2 = new SimpleDateFormat(YYYYMMDDHHMMSS_V2);
		Date date = null;
		String str = "";
		try {
			date = sdf.parse(dateStr);
			str = sdf2.format(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return str;
	}

	public static Date getDateEnd(Date date) {
		if (date == null) {
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS);
		try {
			date = sdf.parse(parse(date, YYYY_MM_DD) + END_TIME);
		} catch (ParseException e) {
			LOGGER.error("转换异常",e);
		}
		return date;
	}

	static public Date getCurrentDate() {
		Calendar c = Calendar.getInstance();

		return c.getTime();
	}

	static public String yyMMddHHmmss(Date time) {
		return new SimpleDateFormat("yyMMddHHmmss").format(time);
	}

	static public String yyyyMMddHHmmss(Date time) {
		return new SimpleDateFormat("yyyyMMddHHmmss").format(time);
	}

	static public Date getNextMonthDate(Date date) {
		Calendar now = Calendar.getInstance();
		now.setTime(date);
		now.add(Calendar.MONTH, 1);
		return now.getTime();
	}

	/** date1 是否比 date2小 */
	static public boolean isBefore(Date date1, Date date2) {
		return date1.getTime() < date2.getTime();
	}

	static public Date getNextHouseDate(Date date) {
		return getNextHouseDate(date, 1);
	}

	static public Date getNextHouseDate(Date date, int houses) {
		Calendar now = Calendar.getInstance();
		now.setTime(date);
		now.add(Calendar.HOUR_OF_DAY, houses);
		return now.getTime();
	}

	static public Date getNextDayDate(Date date, int days) {
		Calendar now = Calendar.getInstance();
		now.setTime(date);
		now.add(Calendar.DATE, days);
		return now.getTime();
	}

	/** 秒 相加 */
	static public Date getNextSecDate(Date date, int sec) {
		Calendar now = Calendar.getInstance();
		now.setTime(date);
		now.add(Calendar.SECOND, sec);
		return now.getTime();
	}

	/**
	 * <li>功能描述：时间相减得到天数
	 *
	 * @param beginDateStr
	 * @param endDateStr
	 * @return long
	 * @author Administrator
	 */
	public static long getDaySub(String beginDateStr, String endDateStr) {
		long day = 0;
		SimpleDateFormat format = new SimpleDateFormat(
				"yyyy-MM-dd");
		Date beginDate = null;
		Date endDate = null;

		try {
			beginDate = format.parse(beginDateStr);
			endDate = format.parse(endDateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		day = (endDate.getTime() - beginDate.getTime()) / TimeUnit.MILLISECONDS.toDays(1);

		return day;
	}

	/**
	 * 得到n天之后的日期
	 *
	 * @param days
	 * @return
	 */
	public static String getAfterDayDate(String days) {
		int daysInt = Integer.parseInt(days);

		Calendar canlendar = Calendar.getInstance(); // java.util包
		canlendar.add(Calendar.DATE, daysInt); // 日期减 如果不够减会将月变动
		Date date = canlendar.getTime();

		SimpleDateFormat sdfd = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS);
		String dateStr = sdfd.format(date);

		return dateStr;
	}

	/**
	 * 得到n天之后是周几
	 *
	 * @param days
	 * @return
	 */
	public static String getAfterDayWeek(String days) {
		int daysInt = Integer.parseInt(days);

		Calendar canlendar = Calendar.getInstance(); // java.util包
		canlendar.add(Calendar.DATE, daysInt); // 日期减 如果不够减会将月变动
		Date date = canlendar.getTime();

		SimpleDateFormat sdf = new SimpleDateFormat("E");
		String dateStr = sdf.format(date);

		return dateStr;
	}


}
