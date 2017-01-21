package com.spring.app.utilities.validator;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;

public class MyImageExtensionValidator {
	   private Pattern patternImage;
	   private Pattern patternFile;
	   private Matcher matcher;
	 
	   private static final String IMAGE_PATTERN = "([^\\s]+(\\.(?i)(/bmp|jpg|gif|png))$)";
	   private static final String FILE_PATTERN = "([^\\s]+(\\.(?i)(/pdf|docx))$)";
	 
	   public MyImageExtensionValidator(){
		   patternImage = Pattern.compile(IMAGE_PATTERN);
		   patternFile = Pattern.compile(FILE_PATTERN);
	   }
	 
	   public boolean validateImage(final String image){
	 
		  matcher = patternImage.matcher(image);
		  return matcher.matches();
	   }
	   
	   public boolean validateFile(final String image){
			 
		  matcher = patternFile.matcher(image);
		  return matcher.matches();
	   }
	   
	   public boolean  isWidth(String image) {
		   BufferedImage bimg;
			try {
				bimg = ImageIO.read(new File(image));
				int width          = bimg.getWidth();
				int height         = bimg.getHeight();
				if (width > 0 && height > 0) {
					return true;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			return false;
	   }
}
