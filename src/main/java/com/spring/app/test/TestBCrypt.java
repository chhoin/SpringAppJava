package com.spring.app.test;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * 
 * @author sok.kimchhoin
 *
 */
public class TestBCrypt {

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			System.out.println(new BCryptPasswordEncoder().encode("123456"));
		}
	}

}
