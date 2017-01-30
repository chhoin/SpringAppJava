package com.spring.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
 * @author sok.kimchhoin
 *
 */
@Controller
@RequestMapping("/admin/validator")
public class ValidatorController {

	/**
	 * index
	 * @param m
	 * @return
	 */
	@RequestMapping(value={"/serverIndex"}, method = RequestMethod.GET)
	public String index(ModelMap m) {
		return "/admin/validator/server";
	}
}
