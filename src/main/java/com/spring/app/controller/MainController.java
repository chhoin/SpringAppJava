package com.spring.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.app.entities.User;
import com.spring.app.services.ser.UserService;

@Controller
/**
 * Indicates that an annotated class is a "Controller" of Spring
 * Framework (a web controller)
 */
@RequestMapping("/")
/**
 * is used to map the user’s requests to handler classes or methods. It can be
 * applied on the class level and also on the method level.
 */
public class MainController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = {"/","index","home","default"}, method = RequestMethod.GET)
	public String homePage() {
		return "home";
	}
	
	@RequestMapping(value = {"/admin"} ,method = RequestMethod.GET)
	public String adminPage(Model model) {
		User result = userService.detail(1L);
		model.addAttribute("user", result);
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = (User) authentication.getPrincipal();
		System.out.println("user id ="+user.getId()+" username ="+user.getUsername()+" password ="+user.getPassword());
		
		return "/admin/admin";
	}
	
	@RequestMapping(value = {"/dba"} ,method = RequestMethod.GET)
	public String dbaPage(Model model) {
		return "/dba/dba";
	}
	
	@RequestMapping(value = {"/user"} ,method = RequestMethod.GET)
	public String userPage(Model model) {
		return "/user/user";
	}
}
