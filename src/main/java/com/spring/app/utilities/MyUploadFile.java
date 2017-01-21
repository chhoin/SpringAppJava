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
		MyImageExtensionValidator imgValidate = new MyImageExtensionValidator();
		
		if(!image.isEmpty()){
			
			if (imgValidate.validateImage(filename)) {
				
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
					
					//check file width to make sure it is image not file
					if (imgValidate.isWidth(savePath + File.separator + filename)) {
						fileReturn = filename;
						System.out.println("Server Absolute Path: "+serverFile.getAbsolutePath());
					} else {
						serverFile.delete();
						System.out.println("Invalie Image!!!! File not allow to upload ");
					}
					
				}catch(Exception e){
					System.out.println("You are failed to upload "+ filename + " => " + e.getMessage());
				}
			} else {
				System.out.println("Invalid extension !!! we allow only bmp|jpg|gif|png");
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
		MyImageExtensionValidator imgValidate = new MyImageExtensionValidator();
		
		if(!file.isEmpty()){
			
			if (imgValidate.validateFile(filename)) {
				
				try{
					filename = UUID.randomUUID() + filename.substring(filename.lastIndexOf("."));
					
					byte[] bytes = file.getBytes();
					// creating the directory to store file
					String savePath = request.getSession().getServletContext().getRealPath("/WEB-INF/resources/files/");
					
					File path = new File(savePath);
					if(!path.exists()){
						path.mkdir();
					}
					// creating the file on server
					File serverFile = new File(savePath + File.separator + filename );
					BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
					stream.write(bytes);
					stream.close();
					
					//check file width to make sure it is image not file
					if (!imgValidate.isWidth(savePath + File.separator + filename)) {
						fileReturn = filename;
						System.out.println("Server Absolute Path: "+serverFile.getAbsolutePath());
					} else {
						serverFile.delete();
						System.out.println("Invalie File!!!! Image not allow to upload ");
					}
					
				}catch(Exception e){
					System.out.println("You are failed to upload "+ filename + " => " + e.getMessage());
				}
			} else {
				System.out.println("Invalid extension !!! we allow only pdf|docx only");
			}
		}else{
			fileReturn = "";
			System.out.println("You are failed to upload "+ filename + " because the file was empty!");
		}
		return fileReturn;
	}

}
