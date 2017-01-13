package com.spring.app.test.testEncryption;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * 
 * @author sok.kimchhoin
 *
 */
public class TestBCrypt {

	public static void main(String[] args) {
		/*for (int i = 0; i < 10; i++) {
			System.out.println(new BCryptPasswordEncoder().encode("123456"));
		}*/
		
		String x = "$2a$10$trT3.R/Nfey62eczbKEnueTcIbJXW.u1ffAo/XfyLpofwNDbEB86O";
		String y = "$2a$10$teJrCEnsxNT49ZpXU7n22O27aCGbVYYe/RG6/XxdWPJbOLZubLIi2";

	}

}
