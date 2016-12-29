package com.spring.app.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.spring.app.services.ser.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService;
}
