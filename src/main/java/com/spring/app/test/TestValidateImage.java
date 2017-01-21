package com.spring.app.test;

import com.spring.app.utilities.MyImageExtensionValidator;

public class TestValidateImage {

	public static void main(String[] args) {
		System.out.println(new MyImageExtensionValidator().validateImage("aa.png"));
	}

}
