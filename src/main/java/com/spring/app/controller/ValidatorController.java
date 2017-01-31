package com.spring.app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.app.entities.ValidateEntity;

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
		m.addAttribute("testValidate", new ValidateEntity());
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
	@RequestMapping(value = { "/server" }, method = RequestMethod.POST)
	public String testValidate(ModelMap m, @Valid ValidateEntity test, BindingResult result) {

			if (result.hasErrors()) {
				m.addAttribute("message", "Validation Error!")
				 .addAttribute("testValidate", test);

				System.out.println("!!!!!!!!!!!!!!!!Error");
				return "/admin/validator/server";

			} else {
				m.addAttribute("message", "")
				 .addAttribute("testValidate", new ValidateEntity());
			}
		return "/admin/validator/server";
	}
}
