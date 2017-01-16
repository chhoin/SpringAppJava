package com.spring.app.test;

public class TestIncreaseNumber {

	public static void main(String[] args) {
		
		int count = 50;
		
		String id = String.format( "ID_%05d", (count + 1) );
		
		System.out.println(id);
	}

}
