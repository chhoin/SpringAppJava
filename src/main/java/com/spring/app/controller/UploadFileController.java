package com.spring.app.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


/**
 * 
 * @author sok.kimchhoin
 *
 */
@Controller
@RequestMapping("/test/upload")
public class UploadFileController {
	
	@RequestMapping(method = RequestMethod.POST, value = "/image", headers = "Accept=application/json")
	public ResponseEntity<Map<String, Object>> image(@RequestParam("image") MultipartFile image, HttpServletRequest request) {
		
		Map<String, Object> map = new HashMap<String, Object>();
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
		
		try {
			if (StringUtils.isEmpty(fileReturn)) {
				map.put("STATUS", false);
				map.put("MESSAGE", "Empty");
				map.put("CODE", 400);
				
			} else {
				map.put("STATUS", true);
				map.put("MESSAGE", "Upload success");
				map.put("DATA", fileReturn);
				map.put("CODE", 200);
			}
		}  catch (Exception e) {
			map.put("MESSAGE"		, 	"ERROR OCCURRING!");
			map.put("STATUS"		, 	false);
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/file", headers = "Accept=application/json")
	public ResponseEntity<Map<String, Object>> file(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		String fileReturn = "";
		String filename = file.getOriginalFilename();
		
		if(!file.isEmpty()){
			try{
				filename = UUID.randomUUID() + filename.substring(filename.lastIndexOf("."));
				
				byte[] bytes = file.getBytes();
				// creating the directory to store file
				String savePath = request.getSession().getServletContext().getRealPath("/WEB-INF/resources/file/");
				
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
		
		try {
			if (StringUtils.isEmpty(fileReturn)) {
				map.put("STATUS", false);
				map.put("MESSAGE", "Empty");
				map.put("CODE", 400);
				
			} else {
				map.put("STATUS", true);
				map.put("MESSAGE", "Upload success");
				map.put("DATA", fileReturn);
				map.put("CODE", 200);
			}
		}  catch (Exception e) {
			map.put("MESSAGE"		, 	"ERROR OCCURRING!");
			map.put("STATUS"		, 	false);
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}
	
}
