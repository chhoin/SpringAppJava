package com.spring.app.utilities;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;

/**
 * 
 * @author kimchhoin.sok
 *
 */
public class MyDateUtils {
	//private static final Logger logger = LoggerFactory.getLogger(MyDateUtils.class);
	public static Date MAX_DATE = new Date(9223372036854775807L);

	private static final int[] NON_WORKING_FIXED_DAYS = { 1, 121, 128, 195, 227, 305, 315, 359 };

	private static final int[] NON_WORKING_MOBILE_DAYS = { 0, 1, 39, 49 };
	public static final long MILLISECOND_IN_DAY = 86400000L;
	public static final String FORMAT_YYYYMMDD_HHMMSS_NOSEP = "yyyyMMdd_HH:mm:ss";
	public static final String FORMAT_YYYYMMDD_NOSEP = "yyyyMMdd";
	public static final String FORMAT_DDMMYYYY_SLASH = "dd/MM/yyyy";
	public static final String FORMAT_DDMMYYYY_HHMM_SLASH = "dd/MM/yyyy HH:mm";
	public static final String FORMAT_DDMMYYYY_MINUS = "dd-MM-yyyy";
	public static final String FORMAT_DDMMYYYY_HHMM_A_SLASH = "dd/MM/yyyy hh:mm a";
	public static final String FORMAT_YYYYMMDD = "yyyy-MM-dd";
	public static final String FORMAT_YYYYMMDD_HHMMSS = "yyyy-MM-dd HH:mm:ss";
	public static final String FORMAT_YYYYMMDD_HHMMSS_SLASH = "dd/MM/yyyy HH:mm:ss";
	public static final String FORMAT_MMMDDYYYY_HHMM_COMMA = "MMM dd, yyyy HH:mm";
	public static final String FORMAT_YYYYMMDD_SLASH = "yyyy/MM/dd";
	public static final String FORMAT_MMYYYY_SLASH = "MM/yyyy";
	public static final String GENERIC_DISPLAY_FORMAT = "E, dd MMM yyyy";
	public static final String TIME_DISPLAY_FORMAT = "HH mm ss";
	public static final String FORMAT_STR_DDMMYY_NOSEP = "ddMMyy";
	public static final String FORMAT_STR_DDMMYYYY_NOSEP = "ddMMyyyy";
	public static final String DEFAULT_DATE_FORMAT = "dd-MMM-yyyy";
	public static final String DEFAULT_TIME_FORMAT = "HH:mm";
	public static final String DEFAULT_DATE_TIME_FORMAT = "dd-MMM-yyyy HH:mm";
	public static final String JTDS_DATE_FORMAT = "yyyy-MM-dd";
	public static final String MONTH_YEAR_FORMAT = "MMM-yyyy";
	public static final String YEAR_FORMAT = "yyyy";
	public static final String DEFAULT_DATE_TIME_SEARCH_FORMAT = "yyyy-MM-dd 00:00:00";
	public static final String SHORT_DATE_FORMAT = "dd-MMM-yy";
	private static final Map REGEX_FORMAT = new HashMap();

	public static long dateDiff(Date date1, Date date2) {
		long diff = date2.getTime() - date1.getTime();
		return diff;
	}

	public static Date today() {
		return Calendar.getInstance().getTime();
	}

	public static String todayFullNoSeparator() {
		return date2String(today(), "yyyyMMdd_HH:mm:ss");
	}

	public static String todayFull() {
		return date2String(today(), "yyyy-MM-dd HH:mm:ss");
	}

	public static String todayShort() {
		return date2String(today(), "yyyy-MM-dd");
	}

	public static Date todayH00M00S00() {
		Calendar today = Calendar.getInstance();
		today.set(11, 0);
		today.set(12, 0);
		today.set(13, 0);
		return today.getTime();
	}

	public static String date2StringDDMMYYYY_HHMM_SLASH(Date dt) {
		return date2String(dt, "dd/MM/yyyy HH:mm");
	}

	public static Date string2DateDDMMYYYY_HHMM(String dt) throws ParseException {
		try {
			return string2Date(dt, "dd/MM/yyyy HH:mm");
		} catch (Exception e) {
		}
		return string2Date(dt, "dd/MM/yyyy HH:mm");
	}

	public static Date string2DateDDMMYYYY(String dt) {
		try {
			return string2Date(dt, "dd/MM/yyyy");
		} catch (Exception e) {
		}
		return string2Date(dt, "dd-MM-yyyy");
	}

	public static Date string2DateDDMMYYYYNoSeparator(String dt) {
		return string2Date(dt, "ddMMyyyy");
	}

	public static Date string2DateDDMMYYNoSeparator(String dt) {
		return string2Date(dt, "ddMMyyyy");
	}

	public static String date2StringYYYYMMDDNoSeparator(Date dt) {
		return date2String(dt, "yyyyMMdd");
	}

	public static String date2StringYYYYMMDD_HHMMSS(Date dt) {
		return date2String(dt, "yyyy-MM-dd HH:mm:ss");
	}

	public static String date2StringDDMMYYYY_SLASH(Date dt) {
		return date2String(dt, "dd/MM/yyyy");
	}

	public static String date2StringDDMMYYYY_MINUS(Date dt) {
		return date2String(dt, "dd-MM-yyyy");
	}

	public static Date string2Date(String dt, String format) {
		if (StringUtils.isEmpty(dt)) {
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		try {
			return sdf.parse(dt);
		} catch (ParseException e) {
			//logger.error(e.getMessage());
		}
		return minDate();
	}

	public static Date minDate() {
		Calendar cal = Calendar.getInstance();
		cal.set(1901, 1, 1);
		return cal.getTime();
	}

	public static Date addYearsDate(Date dt, int nbYears) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(dt);
		cal.add(1, nbYears);
		return cal.getTime();
	}

	public static Date addDaysDate(Date dt, int nbDays) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(dt);
		cal.add(5, nbDays);
		return cal.getTime();
	}

	public static Date addHoursDate(Date dt, int nbHours) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(dt);
		cal.add(10, nbHours);
		return cal.getTime();
	}

	public static Date addMonthsDate(Date dt, int nbMonths) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(dt);
		cal.add(2, nbMonths);
		return cal.getTime();
	}

	public static Date getDateWithHours(Date dt, String hhnnssmm) {
		boolean hasSeparator = hhnnssmm.contains(":");
		if ((hhnnssmm == null) || (hhnnssmm.length() < 2)) {
			hhnnssmm = "00";
		}
		int nbHours = 0;
		int nbMins = 0;
		int nbSecs = 0;
		int nbMilSecs = 0;

		int startIndex = 0;
		try {
			nbHours = Integer.valueOf(hhnnssmm.substring(startIndex, startIndex + 2)).intValue();
		} catch (Exception e) {
			//logger.error("Hours [" + hhnnssmm + "] - " + e.getMessage());
		}
		startIndex = (!(hasSeparator)) ? 2 : 3;
		if (hhnnssmm.length() >= startIndex + 2) {
			try {
				nbMins = Integer.valueOf(hhnnssmm.substring(startIndex, startIndex + 2)).intValue();
			} catch (Exception e) {
				//logger.error("Hours [" + hhnnssmm + "] - " + e.getMessage());
			}
		}
		startIndex = (!(hasSeparator)) ? 4 : 6;
		if (hhnnssmm.length() >= startIndex + 2) {
			try {
				nbSecs = Integer.valueOf(hhnnssmm.substring(startIndex, startIndex + 2)).intValue();
			} catch (Exception e) {
				//logger.error("Hours [" + hhnnssmm + "] - " + e.getMessage());
			}
		}
		startIndex = (!(hasSeparator)) ? 6 : 9;
		if (hhnnssmm.length() == startIndex + 2) {
			try {
				nbMilSecs = Integer.valueOf(hhnnssmm.substring(startIndex, startIndex + 2)).intValue();
			} catch (Exception e) {
				//logger.error("Hours [" + hhnnssmm + "] - " + e.getMessage());
			}
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(dt);
		cal.set(11, 0);
		cal.set(12, 0);
		cal.set(13, 0);
		cal.set(14, 0);
		cal.add(10, nbHours);
		cal.add(12, nbMins);
		cal.add(13, nbSecs);
		cal.add(14, nbMilSecs);
		return cal.getTime();
	}

	public static Date[] getDateRange(EnumDateRange range) {
		if (range == EnumDateRange.YESTERDAY) {
			return getDateRangeYesterday();
		}
		if (range == EnumDateRange.TODAY) {
			return getDateRangeToday();
		}

		if (range == EnumDateRange.LAST_WEEK) {
			return getDateRangeLastWeek();
		}
		if (range == EnumDateRange.CURRENT_WEEK) {
			return getDateRangeCurrentWeek();
		}

		if (range == EnumDateRange.LAST_MONTH) {
			return getDateRangeLastMonth();
		}
		if (range == EnumDateRange.CURRENT_MONTH) {
			return getDateRangeCurrentMonth();
		}

		if (range == EnumDateRange.LAST_YEAR) {
			return getDateRangeLastYear();
		}
		if (range == EnumDateRange.CURRENT_YEAR) {
			return getDateRangeCurrentYear();
		}

		return null;
	}

	public static Date[] getDateRangeToday() {
		Calendar start = new GregorianCalendar();
		start.set(11, 0);
		start.set(12, 0);
		start.set(13, 0);
		Calendar end = new GregorianCalendar();
		end.set(11, 23);
		end.set(12, 59);
		end.set(13, 59);

		return new Date[] { start.getTime(), start.getTime() };
	}

	public static Date[] getDateRangeYesterday() {
		Calendar start = new GregorianCalendar();
		start.add(5, -1);
		start.set(11, 0);
		start.set(12, 0);
		start.set(13, 0);
		Calendar end = new GregorianCalendar();
		end.set(11, 23);
		end.set(12, 59);
		end.set(13, 59);

		return new Date[] { start.getTime(), start.getTime() };
	}

	public static Date[] getDateRangeCurrentWeek() {
		Calendar start = new GregorianCalendar();
		while (start.get(7) != 2) {
			start.add(5, -1);
		}
		start.set(11, 0);
		start.set(12, 0);
		start.set(13, 0);

		Calendar end = new GregorianCalendar();
		end.setTime(start.getTime());
		end.add(5, 6);
		end.set(11, 23);
		end.set(12, 59);
		end.set(13, 59);

		return new Date[] { start.getTime(), end.getTime() };
	}

	public static Date[] getDateRangeLastWeek() {
		Calendar start = new GregorianCalendar();
		while (start.get(7) != 2) {
			start.add(5, -1);
		}
		start.add(5, -7);
		start.set(11, 0);
		start.set(12, 0);
		start.set(13, 0);

		Calendar end = new GregorianCalendar();
		end.setTime(start.getTime());
		end.add(5, 6);
		end.set(11, 23);
		end.set(12, 59);
		end.set(13, 59);

		return new Date[] { start.getTime(), end.getTime() };
	}

	public static Date[] getDateRangeCurrentMonth() {
		Calendar start = new GregorianCalendar();
		start.set(5, 1);
		start.set(11, 0);
		start.set(12, 0);
		start.set(13, 0);

		Calendar end = new GregorianCalendar();
		end.set(5, end.getActualMaximum(5));
		end.set(11, 23);
		end.set(12, 59);
		end.set(13, 59);

		return new Date[] { start.getTime(), end.getTime() };
	}

	public static Date[] getDateRangeLastMonth() {
		Calendar start = new GregorianCalendar();
		start.add(2, -1);
		start.set(5, 1);
		start.set(11, 0);
		start.set(12, 0);
		start.set(13, 0);

		Calendar end = new GregorianCalendar();
		end.setTime(start.getTime());
		end.set(5, end.getActualMaximum(5));
		end.set(11, 23);
		end.set(12, 59);
		end.set(13, 59);

		return new Date[] { start.getTime(), end.getTime() };
	}

	public static Date[] getDateRangeCurrentYear() {
		Calendar start = new GregorianCalendar();
		start.set(start.get(1), 0, 1, 0, 0, 0);
		Calendar end = new GregorianCalendar();
		end.set(start.get(1), 11, 31, 23, 59, 59);

		return new Date[] { start.getTime(), end.getTime() };
	}

	public static Date[] getDateRangeLastYear() {
		Calendar start = new GregorianCalendar();
		start.set(start.get(1) - 1, 0, 1, 0, 0, 0);
		Calendar end = new GregorianCalendar();
		end.set(start.get(1), 11, 31, 23, 59, 59);

		return new Date[] { start.getTime(), end.getTime() };
	}

	public static final String getGenericDisplayFormat(String dt) {
		Calendar cal = string2Calendar(dt, "-");
		SimpleDateFormat sdf = new SimpleDateFormat("E, dd MMM yyyy");
		return sdf.format(cal.getTime());
	}

	public static final String getGenericDisplayFormat(String dt, String tzString) {
		Calendar cal = stringToCalendar(dt, "-", tzString);
		SimpleDateFormat sdf = new SimpleDateFormat("E, dd MMM yyyy");
		return sdf.format(cal.getTime());
	}

	public static final String formatDate(Date dt, String format) {
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(dt);

		SimpleDateFormat sdf = new SimpleDateFormat(format);
		sdf.setTimeZone(TimeZone.getDefault());
		return sdf.format(cal.getTime());
	}

	public static final String getCurrentDate(String format) {
		Calendar cal = Calendar.getInstance(TimeZone.getDefault());
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		sdf.setTimeZone(TimeZone.getDefault());
		return sdf.format(cal.getTime());
	}

	public static final String getTimeFromDate(Date dt) {
		Calendar cal = new GregorianCalendar();
		cal.setTime(dt);

		StringBuffer ret = new StringBuffer();
		ret.append(StringUtils.leftPad(String.valueOf(cal.get(11)), 2, '0'));
		ret.append(":");
		ret.append(StringUtils.leftPad(String.valueOf(cal.get(12)), 2, '0'));
		ret.append(":");
		ret.append(StringUtils.leftPad(String.valueOf(cal.get(13)), 2, '0'));

		return ret.toString();
	}

	public static final String getTimeFromDate(Date dt, String tzString) {
		try {
			GregorianCalendar gc = new GregorianCalendar();
			gc.setTime(dt);
			gc.setTimeZone(TimeZone.getTimeZone(tzString));
			StringBuffer ret = new StringBuffer();
			ret.append(gc.get(10));
			ret.append(":");
			ret.append(gc.get(12));
			ret.append(" ");
			if (gc.get(9) == 0)
				ret.append("AM");
			else {
				ret.append("PM");
			}
			return ret.toString();
		} catch (Exception e) {
		}
		return "";
	}

	public static final String getDateTimeFromDate(Date dt, String tzString) {
		try {
			GregorianCalendar gc = new GregorianCalendar();
			gc.setTime(dt);
			gc.setTimeZone(TimeZone.getTimeZone(tzString));
			StringBuffer ret = new StringBuffer();
			ret.append(gc.get(1));
			ret.append("-");
			ret.append(gc.get(2) - 1);
			ret.append("-");
			ret.append(gc.get(5));
			ret.append(" ");
			ret.append(gc.get(10));
			ret.append(":");
			ret.append(gc.get(12));
			ret.append(" ");
			if (gc.get(9) == 0)
				ret.append("AM");
			else {
				ret.append("PM");
			}
			return ret.toString();
		} catch (Exception e) {
		}
		return "";
	}

	public static final String dateToString(Date dt, String tzString, String dateformat) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(dt);
		cal.setTimeZone(TimeZone.getTimeZone(tzString));
		return calendar2String(cal, dateformat);
	}

	public static final String date2String(Date dt, String dateformat) {
		if (dt == null) {
			return null;
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(dt);
		return calendar2String(cal, dateformat);
	}

	public static final String date2StringDB(Date dt) {
		return date2String(dt, "yyyy-MM-dd HH:mm:ss");
	}

	public static final String date2StringDB_YYYYMMDD(Date dt) {
		return date2String(dt, "yyyy-MM-dd");
	}

	public static final String calendar2String(Calendar cal, String dateformat) {
		StringBuffer ret = new StringBuffer();

		String separator = new String();
		int iSep = dateformat.indexOf(45);
		if (iSep > 0) {
			separator = "-";
		} else {
			iSep = dateformat.indexOf(47);
			if (iSep > 0) {
				separator = "/";
			}
		}

		if (iSep == 2) {
			ret.append(StringUtils.leftPad(String.valueOf(cal.get(5)), 2, '0'));
			ret.append(separator);
			ret.append(StringUtils.leftPad(String.valueOf(cal.get(2) + 1), 2, '0'));
			ret.append(separator);
			ret.append(cal.get(1));
		} else if (iSep == 4) {
			ret.append(cal.get(1));
			ret.append(separator);
			ret.append(StringUtils.leftPad(String.valueOf(cal.get(2) + 1), 2, '0'));
			ret.append(separator);
			ret.append(StringUtils.leftPad(String.valueOf(cal.get(5)), 2, '0'));
			ret.append(" ");
			ret.append(StringUtils.leftPad(String.valueOf(cal.get(11)), 2, '0'));
			ret.append(":");
			ret.append(StringUtils.leftPad(String.valueOf(cal.get(12)), 2, '0'));
			ret.append(":");
			ret.append(StringUtils.leftPad(String.valueOf(cal.get(13)), 2, '0'));
		} else if ("yyyyMMdd".equals(dateformat)) {
			ret.append(cal.get(1));
			ret.append(StringUtils.leftPad(String.valueOf(cal.get(2) + 1), 2, '0'));
			ret.append(StringUtils.leftPad(String.valueOf(cal.get(5)), 2, '0'));
		} else if ("yyyyMMdd_HH:mm:ss".equals(dateformat)) {
			ret.append(cal.get(1));
			ret.append(StringUtils.leftPad(String.valueOf(cal.get(2) + 1), 2, '0'));
			ret.append(StringUtils.leftPad(String.valueOf(cal.get(5)), 2, '0'));
			ret.append(StringUtils.leftPad(String.valueOf(cal.get(11)), 2, '0'));
			ret.append(StringUtils.leftPad(String.valueOf(cal.get(12)), 2, '0'));
			ret.append(StringUtils.leftPad(String.valueOf(cal.get(13)), 2, '0'));
		} else {
			DateFormat dateFormatter = new SimpleDateFormat(dateformat);
			ret.append(dateFormatter.format(cal.getTime()));
		}

		return ret.toString();
	}

	public static final Calendar string2Calendar(String date, String delim) {
		String[] split = StringUtils.splitByWholeSeparator(date, delim);
		int yr = Integer.parseInt(split[0]);
		int mo = Integer.parseInt(split[1]) - 1;

		int dt = Integer.parseInt(split[2]);

		GregorianCalendar gc = new GregorianCalendar(yr, mo, dt);
		return gc;
	}

	public static final Calendar stringToCalendar(String date, String delim, String tzString) {
		String[] split = StringUtils.splitByWholeSeparator(date, delim);
		int yr = Integer.parseInt(split[0]);
		int mo = Integer.parseInt(split[1]) - 1;

		int dt = Integer.parseInt(split[2]);

		GregorianCalendar gc = new GregorianCalendar(yr, mo, dt);
		gc.setTimeZone(TimeZone.getTimeZone(tzString));
		return gc;
	}

	public static final GregorianCalendar getCurrentCalendar(String utimezonestring) {
		try {
			GregorianCalendar gc = new GregorianCalendar();

			gc.setTimeZone(TimeZone.getTimeZone(utimezonestring));
			return gc;
		} catch (Exception e) {
		}
		return new GregorianCalendar();
	}

	public static final String getDayString(int day) {
		switch (day) {
		case 1:
			return "SUNDAY";
		case 2:
			return "MONDAY";
		case 3:
			return "TUESDAY";
		case 4:
			return "WEDNESDAY";
		case 5:
			return "THURSDAY";
		case 6:
			return "FRIDAY";
		case 7:
			return "SATURDAY";
		}
		return "";
	}

	public static int getNbDaysInMonth(Date dt) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(dt);
		return cal.getActualMaximum(5);
	}

	public static int getYearNow() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		return cal.get(1);
	}

	public static int getYearLastYear() {
		return (getYearNow() - 1);
	}

	public static int getYearNextYear() {
		return (getYearNow() + 1);
	}

	public static int getYear(Date dt) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(dt);
		return cal.get(1);
	}

	public static int getMonth(Date dt) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(dt);
		return (cal.get(2) + 1);
	}

	public static int getDay(Date dt) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(dt);
		return cal.get(5);
	}

	public static int getHour(Date dt) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(dt);
		return cal.get(10);
	}

	public static int getMinute(Date dt) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(dt);
		return cal.get(12);
	}

	public String getHoursMinutes(Date dt) {
		return getTimeFromDate(dt);
	}

	public static boolean isWorkingDay(Date date) {
		GregorianCalendar calendar = (GregorianCalendar) GregorianCalendar.getInstance();
		calendar.setTime(date);
		calendar.set(11, 0);
		calendar.set(12, 0);
		calendar.set(13, 0);
		calendar.set(14, 0);
		if ((calendar.get(7) == 7) || (calendar.get(7) == 1)) {
			return false;
		}

		int year = calendar.get(1);
		for (int i = 0; i < NON_WORKING_FIXED_DAYS.length; ++i) {
			int dayOfYear = calendar.get(6);
			if ((calendar.isLeapYear(calendar.get(1))) && (dayOfYear > 59)) {
				--dayOfYear;
			}
			if (dayOfYear == NON_WORKING_FIXED_DAYS[i]) {
				return false;
			}
		}

		Calendar easterCalendar = Easter.findHolyDay(year);
		int easterDayOfYear = easterCalendar.get(6);
		for (int i = 0; i < NON_WORKING_MOBILE_DAYS.length; ++i) {
			int dayOfYear = calendar.get(6);
			if (dayOfYear == easterDayOfYear + NON_WORKING_MOBILE_DAYS[i]) {
				return false;
			}
		}

		return true;
	}

	public static boolean isDate(String dateCandidate, String datePattern) {
		try {
			if ((dateCandidate == null) || (datePattern == null)) {
				return false;
			}
			SimpleDateFormat sdf = new SimpleDateFormat(datePattern);
			sdf.parse(dateCandidate);
			return true;
		} catch (Exception e) {
		}
		return false;
	}

	public static boolean isDate(String date) {
		return isDate(date, "yyyy-MM-dd HH:mm:ss");
	}

	public static int getNumberMonthsOfTwoDates(Date date1, Date date2) {
		Calendar calendar1 = Calendar.getInstance();
		calendar1.setTime(date1);
		int month1 = calendar1.get(2);
		int year1 = calendar1.get(1);

		Calendar calendar2 = Calendar.getInstance();
		calendar2.setTime(date2);
		int month2 = calendar2.get(2);
		int year2 = calendar2.get(1);
		int nbMonth = (year1 - year2) * 12 + month1 - month2;
		return (nbMonth + 1);
	}

	public static String getMonthYearLabel(Date date) {
		return getDateLabel(date, "MMM-yyyy");
	}

	public static int getNumberYearOfTwoDates(Date date1, Date date2) {
		Calendar calendar1 = Calendar.getInstance();
		calendar1.setTime(date1);
		int year1 = calendar1.get(1);
		int month1 = calendar1.get(2);
		int day1 = calendar1.get(5);

		Calendar calendar2 = Calendar.getInstance();
		calendar2.setTime(date2);
		int year2 = calendar2.get(1);
		int month2 = calendar2.get(2);
		int day2 = calendar2.get(5);

		int numberYear = year1 - year2;
		if ((month1 < month2) || ((month2 == month1) && (day1 < day2))) {
			--numberYear;
		}
		return numberYear;
	}

	public static Time getSqlTime(String dateLabel) {
		Date utilDate = getTime(dateLabel);
		return new Time(utilDate.getTime());
	}

	public static Long getDiffInDays(Date date1, Date date2) {
		if ((date1 != null) && (date2 != null)) {
			Calendar calendar1 = Calendar.getInstance();
			calendar1.setTime(date1);
			Calendar calendar2 = Calendar.getInstance();
			calendar2.setTime(date2);
			long diffDay = 0L;
			if (calendar1.before(calendar2))
				diffDay = -countDiffDay(calendar1, calendar2).longValue();
			else {
				diffDay = countDiffDay(calendar2, calendar1).longValue();
			}
			return Long.valueOf(diffDay);
		}
		return null;
	}

	private static Long countDiffDay(Calendar calendar1, Calendar calendar2) {
		Calendar date = (Calendar) calendar1.clone();
		long daysBetween = 0L;
		while (date.before(calendar2)) {
			date.add(5, 1);
			daysBetween += 1L;
		}
		return Long.valueOf(daysBetween);
	}

	public static Long getDiffInDaysPlusOneDay(Date date1, Date date2) {
		Long diffInDays = getDiffInDays(date1, date2);
		if (diffInDays != null) {
			diffInDays = Long.valueOf(diffInDays.longValue() + 1L);
		}
		return diffInDays;
	}

	public static Date getDateSmartly(String dateLabel) {
		Iterator iterator = REGEX_FORMAT.keySet().iterator();
		while (iterator.hasNext()) {
			String regex = (String) iterator.next();
			if (Pattern.matches(regex, dateLabel)) {
				return getDate(dateLabel, (String) REGEX_FORMAT.get(regex));
			}
		}
		return null;
	}

	public static Date getDate(String dateLabel) {
		return getDate(dateLabel, "dd-MMM-yyyy");
	}

	public static Date getDate(String dateLabel, String formatPattern) {
		if ((dateLabel != null) && (formatPattern != null)) {
			try {
				SimpleDateFormat sdf = new SimpleDateFormat(formatPattern);
				return sdf.parse(dateLabel);
			} catch (ParseException pe) {
				//logger.error(pe.getMessage());
				return null;
			}
		}
		return null;
	}

	public static Date getDateAtBeginningOfLastMonth() {
		return getDateAtBeginningOfLastNbMonths(1);
	}

	public static Date getDateAtBeginningOfLastNbMonths(int nbMonths) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(2, -nbMonths);
		calendar.set(5, 1);
		calendar.set(11, 0);
		calendar.set(12, 0);
		calendar.set(13, 0);
		calendar.set(14, 0);
		return calendar.getTime();
	}

	public static Date getDateAtBeginningOfYear() {
		return getDateAtBeginningOfYear((Date) null);
	}

	public static Date getDateAtBeginningOfLastYear() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(1, -1);
		calendar.set(6, 1);
		calendar.set(11, 0);
		calendar.set(12, 0);
		calendar.set(13, 0);
		calendar.set(14, 0);
		return calendar.getTime();
	}

	public static Date getDateAtBeginningOfYear(Date date) {
		Calendar calendar = Calendar.getInstance();
		if (date != null) {
			calendar.setTime(date);
		}
		calendar.set(6, 1);
		calendar.set(11, 0);
		calendar.set(12, 0);
		calendar.set(13, 0);
		calendar.set(14, 0);
		return calendar.getTime();
	}

	public static Date getDateAtBeginningOfYear(String dateLabel) {
		return getDateAtBeginningOfYear(getDate(dateLabel));
	}

	public static Date getDateAtEndOfYear() {
		return getDateAtEndOfYear((Date) null);
	}

	public static Date getDateAtEndOfLastYear() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(getDateAtBeginningOfLastYear());
		calendar.add(1, 1);
		calendar.add(14, -1);
		return calendar.getTime();
	}

	public static Date getDateAtEndOfYear(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(getDateAtBeginningOfYear(date));
		calendar.add(1, 1);
		calendar.add(14, -1);
		return calendar.getTime();
	}

	public static Date getDateAtEndOfYear(String dateLabel) {
		return getDateAtEndOfYear(getDate(dateLabel));
	}

	public static Date getDateAtBeginningOfMonth() {
		return getDateAtBeginningOfMonth((Date) null);
	}

	public static Date getDateAtBeginningOfMonth(Date date) {
		Calendar calendar = Calendar.getInstance();
		if (date != null) {
			calendar.setTime(date);
		}
		calendar.set(5, 1);
		calendar.set(11, 0);
		calendar.set(12, 0);
		calendar.set(13, 0);
		calendar.set(14, 0);
		return calendar.getTime();
	}

	public static Date getDateAtBeginningOfMonth(String dateLabel) {
		return getDateAtBeginningOfMonth(getDate(dateLabel));
	}

	public static Date getDateAtEndOfMonth() {
		return getDateAtEndOfMonth((Date) null);
	}

	public static Date getDateAtEndOfLastMonth() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(getDateAtBeginningOfLastMonth());
		calendar.add(2, 1);
		calendar.add(14, -1);
		return calendar.getTime();
	}

	public static Date getEndOfYear(int year) {
		return getDate("31/12/" + year + " 23:59", "dd/MM/yyyy HH:mm");
	}

	public static Date getBeginOfYear(int year) {
		return getDate("01/01/" + year, "dd/MM/yyyy");
	}

	public static Date getDateAtEndOfMonth(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(getDateAtBeginningOfMonth(date));
		calendar.add(2, 1);
		calendar.add(14, -1);
		return calendar.getTime();
	}

	public static Date getDateAtEndOfMonth(String dateLabel) {
		return getDateAtEndOfMonth(getDate(dateLabel));
	}

	public static Date getDateAtBeginningOfWeek() {
		return getDateAtBeginningOfWeek((Date) null);
	}

	public static Date getDateAtBeginningOfWeek(Date date) {
		Calendar calendar = Calendar.getInstance();
		if (date != null) {
			calendar.setTime(date);
		}
		calendar.set(11, 0);
		calendar.set(12, 0);
		calendar.set(13, 0);
		calendar.set(14, 0);
		while (calendar.get(7) != calendar.getFirstDayOfWeek()) {
			calendar.add(7, -1);
		}
		return calendar.getTime();
	}

	public static Date getDateAtBeginningOfWeek(String dateLabel) {
		return getDateAtBeginningOfWeek(getDate(dateLabel));
	}

	public static Date getDateAtEndOfWeek() {
		return getDateAtEndOfWeek((Date) null);
	}

	public static Date getDateAtEndOfWeek(Date date) {
		Calendar calendar = Calendar.getInstance();
		if (date != null) {
			calendar.setTime(getDateAtBeginningOfWeek(date));
		}
		calendar.add(3, 1);
		calendar.add(14, -1);
		return calendar.getTime();
	}

	public static Date getDateAtEndOfWeek(String dateLabel) {
		return getDateAtEndOfWeek(getDate(dateLabel));
	}

	public static Date getDateAtBeginningOfDay(Date date) {
		if (date == null) {
			return null;
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(11, 0);
		calendar.set(12, 0);
		calendar.set(13, 0);
		calendar.set(14, 0);
		return calendar.getTime();
	}

	public static Date getDateAtBeginningOfDay(String dateLabel) {
		return getDateAtBeginningOfDay(getDate(dateLabel));
	}

	public static Date getDateAtEndOfDay(Date date) {
		if (date == null) {
			return null;
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(getDateAtBeginningOfDay(date));
		calendar.add(5, 1);
		calendar.add(14, -1);
		return calendar.getTime();
	}

	public static Date getDateAtEndOfDay(String dateLabel) {
		return getDateAtEndOfDay(getDate(dateLabel));
	}

	public static Date getTime(String dateLabel) {
		return getDate(dateLabel, "HH:mm");
	}

	public static Date getDateTime(String dateTimeLabel) {
		return getDate(dateTimeLabel, "dd-MMM-yyyy HH:mm");
	}

	public static String getDateLabel(Date date, String formatPattern) {
		if ((date != null) && (formatPattern != null)) {
			return DateFormatUtils.format(date, formatPattern);
		}
		return null;
	}

	public static String getDateLabel(Date date) {
		return getDateLabel(date, "dd-MMM-yyyy");
	}

	public static String getTimeLabel(Date date) {
		return getDateLabel(date, "HH:mm");
	}

	public static String getDateTimeLabel(Date date) {
		return getDateLabel(date, "dd-MMM-yyyy HH:mm");
	}

	public static String getWeekLabel(Date date) {
		Calendar c = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("ww");
		c.setMinimalDaysInFirstWeek(4);
		formatter.setCalendar(c);
		return formatter.format(date);
	}

	public static Date plus(Date date, int days) {
		String day = DateFormatUtils.format(date, "dd");
		String year = DateFormatUtils.format(date, "yyyy");
		String month = getMonthStr(date);
		return getDate((new Long(day).intValue() + days) + "/" + month + "/" + year);
	}

	public static Date plusYear(Date date, int years) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(1, years);
		return calendar.getTime();
	}

	public static Date plusMonth(Date date, int months) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(2, months);
		return calendar.getTime();
	}

	public static Date minusMonth(Date date, int months) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(2, months * -1);
		return calendar.getTime();
	}

	public static String getYearStr(Date date) {
		return DateFormatUtils.format(date, "yy");
	}

	public static String getMonthStr(Date date) {
		return DateFormatUtils.format(date, "MM");
	}

	public static boolean isDateIntervalValid(Date startDate, Date endDate) {
		boolean isValid = false;
		if (startDate != null) {
			if (endDate == null)
				isValid = true;
			else if ((startDate.before(endDate)) || (startDate.compareTo(endDate) == 0)) {
				isValid = true;
			}
		}
		return isValid;
	}

	public static DateRange createInterval(Date startDate, Date endDate) {
		return new DateRange(startDate, endDate);
	}

	public static Date getDateWithoutTime(Date date) {
		if (date == null) {
			return date;
		}
		Calendar dateCalendar = Calendar.getInstance();
		dateCalendar.setTime(date);

		Calendar dateCalendar2 = Calendar.getInstance();
		dateCalendar2.clear();
		dateCalendar2.set(dateCalendar.get(1), dateCalendar.get(2), dateCalendar.get(5));

		return dateCalendar2.getTime();
	}

	public static boolean withinInterval(Date checkDate, Date startDate, Date endDate) {
		return withinInterval(checkDate, createInterval(startDate, endDate), true);
	}

	public static Date todayDate() {
		return getDateWithoutTime(new Date());
	}

	public static boolean withinInterval(Date checkDate, DateRange interval, boolean withoutTime) {
		Date date = (checkDate != null) ? new Date(checkDate.getTime()) : null;
		if (date == null) {
			return false;
		}

		Date creationDate = (interval.getCreationDate() != null) ? new Date(interval.getCreationDate().getTime()) : null;
		Date expirationDate = (interval.getExpirationDate() != null) ? new Date(interval.getExpirationDate().getTime()) : null;

		if (withoutTime) {
			date = getDateWithoutTime(date);
			creationDate = getDateWithoutTime(creationDate);
			expirationDate = getDateWithoutTime(expirationDate);
		}

		return (((creationDate == null) && (expirationDate == null))
				|| ((creationDate != null) && (((date.compareTo(creationDate) == 0) || (date.after(creationDate)))) && (expirationDate == null))
				|| ((expirationDate != null) && (((date.compareTo(expirationDate) == 0) || (date.before(expirationDate)))) && (creationDate == null)) || ((creationDate != null)
				&& (expirationDate != null) && (((date.compareTo(creationDate) == 0) || (date.after(creationDate)))) && (((date
				.compareTo(expirationDate) == 0) || (date.before(expirationDate))))));
	}

	public static boolean isSameDay(Date date1, Date date2) {
		if ((date1 == null) || (date2 == null)) {
			throw new IllegalArgumentException("The dates must not be null");
		}
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(date1);
		Calendar cal2 = Calendar.getInstance();
		cal2.setTime(date2);
		return isSameDay(cal1, cal2);
	}

	public static boolean isSameDay(Calendar cal1, Calendar cal2) {
		if ((cal1 == null) || (cal2 == null)) {
			throw new IllegalArgumentException("The dates must not be null");
		}

		return ((cal1.get(0) == cal2.get(0)) && (cal1.get(1) == cal2.get(1)) && (cal1.get(6) == cal2.get(6)));
	}

	public static boolean isToday(Date date) {
		return isSameDay(date, Calendar.getInstance().getTime());
	}

	public static boolean isToday(Calendar cal) {
		return isSameDay(cal, Calendar.getInstance());
	}

	public static boolean isBeforeDay(Date date1, Date date2) {
		if ((date1 == null) || (date2 == null)) {
			throw new IllegalArgumentException("The dates must not be null");
		}
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(date1);
		Calendar cal2 = Calendar.getInstance();
		cal2.setTime(date2);
		return isBeforeDay(cal1, cal2);
	}

	public static boolean isBeforeDay(Calendar cal1, Calendar cal2) {
		if ((cal1 == null) || (cal2 == null)) {
			throw new IllegalArgumentException("The dates must not be null");
		}
		if (cal1.get(0) < cal2.get(0))
			return true;
		if (cal1.get(0) > cal2.get(0))
			return false;
		if (cal1.get(1) < cal2.get(1))
			return true;
		if (cal1.get(1) > cal2.get(1))
			return false;
		return (cal1.get(6) < cal2.get(6));
	}

	public static boolean isAfterDay(Date date1, Date date2) {
		if ((date1 == null) || (date2 == null)) {
			throw new IllegalArgumentException("The dates must not be null");
		}
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(date1);
		Calendar cal2 = Calendar.getInstance();
		cal2.setTime(date2);
		return isAfterDay(cal1, cal2);
	}

	public static boolean isAfterDay(Calendar cal1, Calendar cal2) {
		if ((cal1 == null) || (cal2 == null)) {
			throw new IllegalArgumentException("The dates must not be null");
		}
		if (cal1.get(0) < cal2.get(0))
			return false;
		if (cal1.get(0) > cal2.get(0))
			return true;
		if (cal1.get(1) < cal2.get(1))
			return false;
		if (cal1.get(1) > cal2.get(1))
			return true;
		return (cal1.get(6) > cal2.get(6));
	}

	public static boolean isWithinDaysFuture(Date date, int days) {
		if (date == null) {
			throw new IllegalArgumentException("The date must not be null");
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return isWithinDaysFuture(cal, days);
	}

	public static boolean isWithinDaysFuture(Calendar cal, int days) {
		if (cal == null) {
			throw new IllegalArgumentException("The date must not be null");
		}
		Calendar today = Calendar.getInstance();
		Calendar future = Calendar.getInstance();
		future.add(6, days);
		return ((isAfterDay(cal, today)) && (!(isAfterDay(cal, future))));
	}

	public static Date getStart(Date date) {
		return clearTime(date);
	}

	public static Date clearTime(Date date) {
		if (date == null) {
			return null;
		}
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(11, 0);
		c.set(12, 0);
		c.set(13, 0);
		c.set(14, 0);
		return c.getTime();
	}

	public static boolean hasTime(Date date) {
		if (date == null) {
			return false;
		}
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		if (c.get(11) > 0) {
			return true;
		}
		if (c.get(12) > 0) {
			return true;
		}
		if (c.get(13) > 0) {
			return true;
		}

		return (c.get(14) > 0);
	}

	public static Date getEnd(Date date) {
		if (date == null) {
			return null;
		}
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(11, 23);
		c.set(12, 59);
		c.set(13, 59);
		c.set(14, 999);
		return c.getTime();
	}

	public static Date max(Date d1, Date d2) {
		if ((d1 == null) && (d2 == null))
			return null;
		if (d1 == null)
			return d2;
		if (d2 == null)
			return d1;
		return ((d1.after(d2)) ? d1 : d2);
	}

	public static Date min(Date d1, Date d2) {
		if ((d1 == null) && (d2 == null))
			return null;
		if (d1 == null)
			return d2;
		if (d2 == null)
			return d1;
		return ((d1.before(d2)) ? d1 : d2);
	}

	public static int getAge(Date dateOfBirth) {
		long ageInDay = getDiffInDays(today(), dateOfBirth).longValue();
		int ageInYear = (int) (ageInDay / 365L);
		return ageInYear;
	}

	public static long milliSec2Days(long millsec) {
		return (millsec / 86400000L);
	}

	public static boolean isWeekend(Date date) {
		GregorianCalendar calendar = (GregorianCalendar) GregorianCalendar.getInstance();
		calendar.setTime(date);
		calendar.set(11, 0);
		calendar.set(12, 0);
		calendar.set(13, 0);
		calendar.set(14, 0);

		return ((calendar.get(7) == 7) || (calendar.get(7) == 1));
	}

	public static String get24HourFormatTime(Date date) {
		SimpleDateFormat displayFormat = new SimpleDateFormat("HH:mm");
		SimpleDateFormat parseFormat = new SimpleDateFormat("hh:mm a");

		String result = null;
		String hourmin = "";
		try {
			hourmin = displayFormat.format(parseFormat.parse(parseFormat.format(date)));
			if (!(hourmin.equals("00:00")))
				result = hourmin.replace(":", "h");
			else
				result = "";
		} catch (Exception localException) {
		}
		return result;
	}

	public static String getTimeInHHMMSS(long ms) {
		int hrs = (int) TimeUnit.MILLISECONDS.toHours(ms) % 24;
		int min = (int) TimeUnit.MILLISECONDS.toMinutes(ms) % 60;
		int sec = (int) TimeUnit.MILLISECONDS.toSeconds(ms) % 60;
		return String.format("%02d:%02d:%02d", new Object[] { Integer.valueOf(hrs), Integer.valueOf(min), Integer.valueOf(sec) });
	}

	static {
		REGEX_FORMAT.put("\\d{2}:\\d{2}", "HH:mm");
		REGEX_FORMAT.put("\\d{2}:\\d{2}:\\d{2}", "HH:mm:ss");
		REGEX_FORMAT.put("\\d{2}/\\d{2}/\\d{2}", "dd/MM/yy");
		REGEX_FORMAT.put("\\d{2}/\\d{2}/\\d{2} \\d{2}:\\d{2}", "dd/MM/yy HH:mm");
		REGEX_FORMAT.put("\\d{2}/\\d{2}/\\d{2} \\d{2}:\\d{2}:\\d{2}", "dd/MM/yy HH:mm:ss");
		REGEX_FORMAT.put("\\d{2}/\\d{2}/\\d{4}", "dd/MM/yyyy");
		REGEX_FORMAT.put("\\d{2}/\\d{2}/\\d{4} \\d{2}:\\d{2}", "dd/MM/yyyy HH:mm");
		REGEX_FORMAT.put("\\d{2}/\\d{2}/\\d{4} \\d{2}:\\d{2}:\\d{2}", "dd/MM/yyyy HH:mm:ss");
	}

	static final class Easter {
		public static final Calendar findHolyDay(int year) {
			if (year <= 1582) {
				throw new IllegalArgumentException("Algorithm invalid before April 1583");
			}

			int golden = year % 19 + 1;
			int century = year / 100 + 1;
			int x = 3 * century / 4 - 12;
			int z = (8 * century + 5) / 25 - 5;
			int d = 5 * year / 4 - x - 10;
			int epact = (11 * golden + 20 + z - x) % 30;
			if (((epact == 25) && (golden > 11)) || (epact == 24))
				++epact;
			int n = 44 - epact;
			n += 30 * ((n < 21) ? 1 : 0);
			n += 7 - ((d + n) % 7);
			if (n > 31) {
				return new GregorianCalendar(year, 3, n - 31);
			}

			return new GregorianCalendar(year, 2, n);
		}
	}
}
