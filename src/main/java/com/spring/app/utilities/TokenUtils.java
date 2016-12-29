package com.spring.app.utilities;

import org.apache.commons.lang3.RandomStringUtils;

/**
 * 
 * @author kimchhoin.sok
 *
 */
public class TokenUtils {
	private static String RANDOM_ID = "abcdefghijklmnopqrstuvwxyz1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	public static String generateTokenString() {
		return RandomStringUtils.random(32, RANDOM_ID);
	}
}
