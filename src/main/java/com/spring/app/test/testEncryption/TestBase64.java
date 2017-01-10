package com.spring.app.test.testEncryption;

import javax.xml.bind.DatatypeConverter;

/**
 * 
 * @author sok.kimchhoin
 *
 */
public class TestBase64 {

	public static void main(String[] args) {
		String str = "1";
		
		// encode data using BASE64
        String encoded = DatatypeConverter.printBase64Binary(str.getBytes());
        System.out.println("encoded value is \t" + encoded);
        
        // Decode data 
        String decoded = new String(DatatypeConverter.parseBase64Binary(encoded));
        System.out.println("decoded value is \t" + decoded);
        System.out.println("original value is \t" + str);

	}

}
