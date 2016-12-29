package com.spring.app.utilities;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;
import org.apache.commons.lang.RandomStringUtils;

public class MyRandomUtils {
	public static String randomName(int length) {
		return RandomStringUtils.randomAlphabetic(length);
	}

	public static Date randomDate() {
		Random call = new Random();
		int month = call.nextInt(11);
		int year = call.nextInt(50) + 1950;
		int day = call.nextInt(30);

		GregorianCalendar calendar = new GregorianCalendar(year, month, day);
		Date dt = calendar.getTime();
		return dt;
	}
}
