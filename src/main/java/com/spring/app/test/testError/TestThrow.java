package com.spring.app.test.testError;

import com.spring.app.test.Test;

public class TestThrow {

	public static void validate(int age){  
	     if(age<18)  
	      throw new ArithmeticException("not valid");  
	     else  
	      System.out.println("welcome to vote");  
	}  
	
	public static void main(String[] args) {
		Test.validate(13);  
	    System.out.println("rest of the code...");  

	}

}
