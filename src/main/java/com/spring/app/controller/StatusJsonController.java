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
@RequestMapping("admin/status/json")
public class StatusJsonController {

	/**
	 * index
	 * @param m
	 * @return
	 */
	@RequestMapping(value={"/index"}, method = RequestMethod.GET)
	public String index(ModelMap m) {
		return "/admin/status/json/status";
	}
	
	/**
	 * store
	 * @param m
	 * @return
	 */
	@RequestMapping(value={"/store"}, method = RequestMethod.GET)
	public String store(ModelMap m) {
		return "/admin/status/json/status";
	}
	
	/**
	 * update
	 * @param m
	 * @return
	 */
	@RequestMapping(value={"/update"}, method = RequestMethod.GET)
	public String update(ModelMap m) {
		return "/admin/status/json/status";
	}
}
