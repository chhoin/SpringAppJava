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
@RequestMapping("/admin/status/main")
public class StatusMainController {

	/**
	 * index
	 * @param m
	 * @return
	 */
	@RequestMapping(value={"/index"}, method = RequestMethod.GET)
	public String index(ModelMap m) {
		return "/admin/status/main/status";
	}
	
	/**
	 * create
	 * @param m
	 * @return
	 */
	@RequestMapping(value={"/create"}, method = RequestMethod.GET)
	public String create(ModelMap m) {
		return "/admin/status/main/form";
	}
	
	/**
	 * store
	 * @param m
	 * @return
	 */
	@RequestMapping(value={"/store"}, method = RequestMethod.GET)
	public String store(ModelMap m) {
		return "/admin/status/main/status";
	}
	
	/**
	 * edit
	 * @param m
	 * @return
	 */
	@RequestMapping(value={"/edit"}, method = RequestMethod.GET)
	public String edit(ModelMap m) {
		return "/admin/status/main/form";
	}
	
	/**
	 * update
	 * @param m
	 * @return
	 */
	@RequestMapping(value={"/update"}, method = RequestMethod.GET)
	public String update(ModelMap m) {
		return "/admin/status/main/status";
	}
	
	/**
	 * show
	 * @param m
	 * @return
	 */
	@RequestMapping(value={"/show"}, method = RequestMethod.GET)
	public String show(ModelMap m) {
		return "/admin/status/main/show";
	}
	
	/**
	 * delete
	 * @param m
	 * @return
	 */
	@RequestMapping(value={"/delete"}, method = RequestMethod.GET)
	public String delete(ModelMap m) {
		return "/admin/status/main/show";
	}
}
