package com.spring.app.test;import java.util.Calendar;
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
	
	public static void main(String[] args) {
		/*Test.validate(113);  
	    System.out.println("rest of the code...");  */
		
		/*Date systemTime = Calendar.getInstance().getTime();
		System.out.println(systemTime);*/
		
		//System.out.println(MyDateUtils.today());
		
		  
		  java.sql.Timestamp timestamp = new java.sql.Timestamp(MyDateUtils.today().getTime());
		  System.out.println(timestamp);
		    
		    
	}
}
