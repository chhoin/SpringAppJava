package com.spring.app.utilities;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;

/**
 * 
 * @author sok.kimchhoin
 *
 */
public class MyUploadFile {
	
	/**
	 * UploadImage
	 * @param image
	 * @param request
	 * @return
	 */
	public static String UploadImage(MultipartFile image, HttpServletRequest request) {
		
		String fileReturn = "";
		String filename = image.getOriginalFilename();
		
		if(!image.isEmpty()){
			try{
				filename = UUID.randomUUID() + filename.substring(filename.lastIndexOf("."));
				
				byte[] bytes = image.getBytes();
				// creating the directory to store file
				String savePath = request.getSession().getServletContext().getRealPath("/WEB-INF/resources/images/user/");
				
				File path = new File(savePath);
				if(!path.exists()){
					path.mkdir();
				}
				// creating the file on server
				File serverFile = new File(savePath + File.separator + filename );
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();
				
				fileReturn = filename;
				
				
				System.out.println("Server Absolute Path: "+serverFile.getAbsolutePath());
			}catch(Exception e){
				System.out.println("You are failed to upload "+ filename + " => " + e.getMessage());
			}
		}else{
			fileReturn = "";
			
			System.out.println("You are failed to upload "+ filename + " because the file was empty!");
		}
		
		return fileReturn;
	}
	
	/**
	 * UploadFile
	 * @param file
	 * @param request
	 * @return
	 */
	public static String UploadFile(MultipartFile file, HttpServletRequest request) {
		
		String fileReturn = "";
		String filename = file.getOriginalFilename();
		
		if(!file.isEmpty()){
			try{
				filename = UUID.randomUUID() + filename.substring(filename.lastIndexOf("."));
				
				byte[] bytes = file.getBytes();
				// creating the directory to store file
				String savePath = request.getSession().getServletContext().getRealPath("/WEB-INF/resources/images/user/");
				
				File path = new File(savePath);
				if(!path.exists()){
					path.mkdir();
				}
				// creating the file on server
				File serverFile = new File(savePath + File.separator + filename );
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();
				
				fileReturn = filename;
				
				System.out.println("Server Absolute Path: "+serverFile.getAbsolutePath());
			}catch(Exception e){
				System.out.println("You are failed to upload "+ filename + " => " + e.getMessage());
			}
		}else{
			fileReturn = "";
			
			System.out.println("You are failed to upload "+ filename + " because the file was empty!");
		}
		return fileReturn;
	}

}
