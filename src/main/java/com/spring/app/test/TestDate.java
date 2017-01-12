package com.spring.app.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDate {

	public static void main(String[] args) throws ParseException {
		
		String dt = "2017-01-04 20:32:27" + " UTC";
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date  parsed = format.parse(dt);
		System.out.println(parsed);

	}

}
