package com.spring.app.utilities;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

import org.apache.commons.lang3.StringUtils;
/**
 * 
 * @author kimchhoin.sok
 *
 */
public class MyNumberUtils {
	public static long getLong(Long value) {
		return ((value == null) ? 0L : value.longValue());
	}

	public static int getInteger(Integer value) {
		return ((value == null) ? 0 : value.intValue());
	}

	public static Integer getInteger(String value, int defaultValue) {
		try {
			return Integer.valueOf(Integer.parseInt(value));
		} catch (NumberFormatException e) {
		}
		return Integer.valueOf(defaultValue);
	}

	public static double getDouble(Double value) {
		return ((value == null) ? 0.0D : value.doubleValue());
	}

	public static Double getDouble(String value) {
		return getDouble(value, null);
	}

	public static Double getDouble(String value, Double defaultValue) {
		try {
			return Double.valueOf(Double.parseDouble(value));
		} catch (NumberFormatException e) {
		}
		return defaultValue;
	}

	public static BigDecimal getBigDecimal(String value, BigDecimal defaultValue) {
		try {
			return new BigDecimal(value);
		} catch (Exception e) {
		}
		return defaultValue;
	}

	public static BigDecimal getBigDecimal(String value) {
		return getBigDecimal(value, null);
	}

	public static Double formatDouble(Double amount) {
		DecimalFormatSymbols unusualSymbols = new DecimalFormatSymbols(Locale.US);
		NumberFormat nf = NumberFormat.getNumberInstance(Locale.US);
		DecimalFormat formatter = (DecimalFormat) nf;
		formatter.applyPattern("##0.00");
		formatter.setDecimalFormatSymbols(unusualSymbols);
		String value = formatter.format(amount);
		amount = Double.valueOf(Double.parseDouble(value));
		return amount;
	}

	public static String formatDoubleToString(Double amount) {
		return formatDoubleToString(amount, null);
	}

	public static String formatDoubleToString(Double amount, String format) {
		DecimalFormatSymbols unusualSymbols = new DecimalFormatSymbols(Locale.US);
		NumberFormat nf = NumberFormat.getNumberInstance(Locale.US);
		DecimalFormat formatter = (DecimalFormat) nf;

		if (StringUtils.isEmpty(format))
			formatter.applyPattern("#,###,##0.00");
		else {
			formatter.applyPattern(format);
		}
		formatter.setDecimalFormatSymbols(unusualSymbols);
		String value = formatter.format(amount);
		return value;
	}

	public static Double stringToDouble(String value) {
		String pattern = "#,###,##0.00";
		DecimalFormat formatterUS = new DecimalFormat(pattern);
		Double doubleValue = new Double(0.0D);
		try {
			doubleValue = Double.valueOf(formatterUS.parse(value).doubleValue());
		} catch (ParseException e) {
			throw new IllegalStateException("Error on parsing [" + value + "] String To Double.", e);
		}
		return doubleValue;
	}
}
