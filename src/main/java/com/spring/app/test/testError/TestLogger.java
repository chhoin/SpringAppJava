package com.spring.app.test.testError;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestLogger {
	private static final Logger logger = LoggerFactory.getLogger(TestLogger.class);
	
	public static void hello() {
		logger.debug( ">>> Start to run (checkNoUpdate) scheduler...!" );
		try {
			int num[] = {1, 2, 3, 4};
		    System.out.println(num[5]);
		} catch (Exception e) {
			logger.info( e.getMessage(), e );
			logger.error( e.getMessage(), e );
		
			System.out.println("Exception thrown  :" + e);
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		TestLogger.hello();

	}

}
