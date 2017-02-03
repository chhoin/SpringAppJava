package com.spring.app.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.app.entities.Student;

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
	 * 
	 * @param m
	 * @return
	 */
	@RequestMapping(value = { "/serverIndex" }, method = RequestMethod.GET)
	public String index(ModelMap m) {
		m.addAttribute("student", new Student());
		return "/admin/validator/server";
	}

	/**
	 * testValidate
	 * 
	 * @param m
	 * @param validate
	 * @param result
	 * @param request
	 * @return
	 */
	@RequestMapping(value ="/server", method = RequestMethod.POST)
	public String testValidate(@Valid Student student, BindingResult result, ModelMap m) {

			if (result.hasErrors()) {
				m.addAttribute("message", "Validation Error!")
				 .addAttribute("testValidate", student);

				return "/admin/validator/server";

			} else {
				m.addAttribute("message", "Success Validate")
				 .addAttribute("testValidate", new Student());
			}
		return "/admin/validator/server";
	}
	
	/**
	 * indexJquery
	 * @param m
	 * @return
	 */
	@RequestMapping(value = { "/jqueryIndex" }, method = RequestMethod.GET)
	public String indexJquery(ModelMap m) {
		m.addAttribute("student", new Student());
		return "/admin/validator/jquery";
	}
	
}
