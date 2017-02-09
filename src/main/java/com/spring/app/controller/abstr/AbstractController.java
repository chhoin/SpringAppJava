package com.spring.app.controller.abstr;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
 * @author sok.kimchhoin
 *
 */
@Controller
public class AbstractController {

	/**
	 * 
	 * @param m
	 * @return
	 */
	@RequestMapping(value={"/index"}, method = RequestMethod.GET)
	public String index(ModelMap m) {
		return "";
	}
	
	/**
	 * 
	 * @param m
	 * @return
	 */
	@RequestMapping(value={"/create"}, method = RequestMethod.GET)
	public String create(ModelMap m) {
		return "";
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/show/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<Map<String, Object>> show(@PathVariable("id") String id) {
		Map<String, Object> map = new HashMap<String, Object>();
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}
	
	/**
	 * 
	 * @param m
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/edit/{id}", method = RequestMethod.GET)
	public String edit(ModelMap m, @PathVariable("id") String id) {
		return "";
	}
}
