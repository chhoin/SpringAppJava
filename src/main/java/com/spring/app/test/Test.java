package com.spring.app.test;import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.spring.app.utilities.MyDateUtils;

public class Test {
	
	public static int calculation(int[] value) {
		int result = 0;
		for (int i = 0; i < value.length; i++) {
			result += value[i];
		}
		return result;
	}
	
	public static void validate(int age){  
	     if(age<18)  
	      throw new ArithmeticException("not valid");  
	     else  
	      System.out.println("welcome to vote");  
	   }  
	
	public static void main(String[] args)  {
		/*Test.validate(113);  
	    System.out.println("rest of the code...");  */
		
		/*Date systemTime = Calendar.getInstance().getTime();
		System.out.println(systemTime);*/
		
		//System.out.println(new java.sql.Timestamp(MyDateUtils.today().getTime()));
		
		  
		/*  java.sql.Timestamp timestamp = new java.sql.Timestamp(MyDateUtils.today().getTime());
		  System.out.println(timestamp);*/
		
		String dt = "2017-01-04 20:32:27" + " UTC";
	
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date parsed;
		try {
			parsed = format.parse(dt);
			System.out.println(parsed);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	
	    
		
		//System.out.println(new java.sql.Timestamp(MyDateUtils.getDateAtBeginningOfDay(MyDateUtils.today()).getTime()));
		    
		    
	}
}
