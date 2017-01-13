package com.spring.app.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.spring.app.utilities.MyDateUtils;

public class TestDate {

	public static void main(String[] args) throws ParseException {
		
		/*String dt = "2017-01-04 20:32:27" + " UTC";
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date  parsed = format.parse(dt);
		System.out.println(parsed);*/
		
		
		/*Calendar calendar = Calendar.getInstance();
		calendar.setTime(MyDateUtils.today());
		int hours = calendar.get(Calendar.HOUR_OF_DAY);
		int minutes = calendar.get(Calendar.MINUTE);
		int seconds = calendar.get(Calendar.SECOND);
		
		System.out.println(hours +":"+ minutes +":"+ seconds +" UTC");*/
		
		System.out.println(MyDateUtils.getDateLabel(MyDateUtils.today(), "yyyy-MM-dd"));

	}

}
