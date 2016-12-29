package com.spring.app.utilities;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;


/**
 * 
 * @author kimchhoin.sok
 *
 */
public class MyMathUtils {
	private static final double ZEROd = 0.0D;
	public static double EPSILON_COMPARISON = 1.0E-10D;

	public boolean equalsZero(double a) {
		return equals(a, 0.0D);
	}

	public boolean equals(double a, double b) {
		return (Math.abs(a - b) < EPSILON_COMPARISON);
	}

	public static double roundAmountTo(double ref) throws NumberFormatException {
		return roundTo(ref, 2);
	}

	public static Double roundAmountTo(Double ref) throws NumberFormatException {
		return ((ref == null) ? null : Double.valueOf(roundTo(ref.doubleValue(), 2)));
	}

	public static double roundRateTo(double ref) throws NumberFormatException {
		return roundTo(ref, 4);
	}

	public static double roundTo(double ref, int nbOfDec) throws NumberFormatException {
		try {
			double usedRef = ref;
			if (Double.isNaN(ref)) {
				usedRef = 0.0D;
			}
			if (Double.isInfinite(ref)) {
				if (ref == (-1.0D / 0.0D))
					usedRef = 4.9E-324D;
				else {
					usedRef = 1.7976931348623157E+308D;
				}
			}

			int pointPos = -1;
			String sRef = "" + usedRef;
			if ((pointPos = sRef.indexOf(46)) > 0) {
				String decPart = sRef.substring(pointPos);
				if (decPart.length() == nbOfDec + 2) {
					usedRef += getTrailingFive(nbOfDec);
				}
			}

			DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
			DecimalFormat df = new DecimalFormat("######.##", symbols);
			df.setMaximumFractionDigits(nbOfDec);
			df.setGroupingUsed(false);
			df.getDecimalFormatSymbols().setDecimalSeparator('.');
			return Double.parseDouble(df.format(usedRef));
		} catch (NumberFormatException exp) {
			throw exp;
		}
	}

	private static double getTrailingFive(int offset) {
		double res = 5.0D / Math.pow(10.0D, offset + 2);
		return res;
	}

	public static Amount calculateFromAmountExcl(double teAmount, double vatRate) {
		double vatAmount = teAmount * vatRate;
		return new Amount(Double.valueOf(teAmount), Double.valueOf(teAmount * vatRate), Double.valueOf(teAmount + vatAmount));
	}

	public static Amount calculateFromAmountExcl(double teAmount, double vatRate, int nbDecimal) {
		double vatAmount = teAmount * vatRate;
		return new Amount(Double.valueOf(teAmount), Double.valueOf(vatAmount), Double.valueOf(teAmount + vatAmount), nbDecimal);
	}

	public static Amount calculateFromAmountIncl(double tiAmount, double vatRate) {
		double vatAmount = tiAmount - (tiAmount / (1.0D + vatRate));
		return new Amount(Double.valueOf(tiAmount - vatAmount), Double.valueOf(vatAmount), Double.valueOf(tiAmount));
	}

	public static Amount calculateFromAmountIncl(double tiAmount, double vatRate, int nbDecimal) {
		double vatAmount = tiAmount - (tiAmount / (1.0D + vatRate));
		return new Amount(Double.valueOf(tiAmount - vatAmount), Double.valueOf(vatAmount), Double.valueOf(tiAmount), nbDecimal);
	}
}
