package com.spring.app.utilities;

import java.text.DecimalFormat;

/**
 * 
 * @author kimchhoin.sok
 *
 */
public class MyCurrencyUtils {
	public static String euroWithDecimal(Double value) {
		DecimalFormat formatter = new DecimalFormat("###,###,###,###.##");
		String fm = formatter.format(value);
		return fm + " €";
	}
}
