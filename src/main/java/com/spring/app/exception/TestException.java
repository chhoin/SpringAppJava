package com.spring.app.exception;

/**
 * 
 * @author sok.kimchhoin
 *
 */
public class TestException extends Exception{

	private static final long serialVersionUID = 8230478482513076729L;

	public TestException(){};
	
	public TestException(String message){
		super(message);
	};
}
