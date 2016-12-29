package com.spring.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller 
/*
 * Indicates that an annotated class is a "Controller" of Spring
 * Framework (a web controller)
 */
@RequestMapping("/")
/*
 * is used to map the user’s requests to handler classes or methods. It can be
 * applied on the class level and also on the method level.
 */
public class AuthenticationController {
	
	@RequestMapping(value="/accessDenied", method = RequestMethod.GET)
	public String accessDeniedPage(ModelMap m){
		m.addAttribute("msg","You are not authorized to access this page");
		return "accessdenied";
	}
	
	@RequestMapping(value="/login" , method = RequestMethod.GET)
	public String loginPage(ModelMap m){
		return "login";
	}
}
