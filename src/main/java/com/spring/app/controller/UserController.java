package com.spring.app.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.app.common.UserStatus;
import com.spring.app.entities.Pagination;
import com.spring.app.entities.Status;
import com.spring.app.entities.User;
import com.spring.app.services.ser.RoleService;
import com.spring.app.services.ser.UserService;

/**
 * 
 * @author sok.kimchhoin
 *
 */
@Controller
@RequestMapping("/admin/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	/**
	 * index
	 * @param m
	 * @return
	 */
	@RequestMapping(value={"/index"}, method = RequestMethod.GET)
	public String index(ModelMap m) {
		return "/admin/user/user";
	}
	
	/**
	 * create
	 * @param m
	 * @return
	 */
	@RequestMapping(value={"/create"}, method = RequestMethod.GET)
	public String create(ModelMap m) {
		
		m.addAttribute("title"		,	"Add User" )
		 .addAttribute("message"	,	"")
		 .addAttribute("action"		,	"store")
		 .addAttribute("edit"		,	false)
		 .addAttribute("student"	,	new User())
		 .addAttribute("role"		,	roleService.all());
		
		return "/admin/user/form";
	}
	
	/**
	 * store
	 * @param m
	 * @param user
	 * @param request
	 * @return
	 */
	@RequestMapping(value={"/store"}, method = RequestMethod.POST)
	public String store(ModelMap m, User user, HttpServletRequest request) {
		
			
		try {
			
			if (userService.insert(user)) {
				m.addAttribute("title"		,	"Add User" )
				 .addAttribute("message"	,	"<div class='alert alert-success'> <a href='#' class='close' data-dismiss='alert' aria-label='close'>&times;</a><strong>Intert Success</strong>. </div>")
				 .addAttribute("action"		,	"store")
				 .addAttribute("edit"		,	false)
				 .addAttribute("user"		,	new User());
				
			} else {
				m.addAttribute("title"		,	"Add User" )
				.addAttribute("message"		,	"<div class='alert alert-danger'> <a href='#' class='close' data-dismiss='alert' aria-label='close'>&times;</a><strong>Intert Fail!</strong>. </div>")
				 .addAttribute("action"		,	"store")
				 .addAttribute("edit"		,	false)
				 .addAttribute("user"		, 	user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "/admin/user/form";
	}
	
	/**
	 * show
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/show/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<Map<String, Object>> show(@PathVariable("id") String id) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		User user = new User();
		user = userService.detail(Long.parseLong(id));

		try {
			if (user != null) {
				map.put("STATUS"	,	 true);
				map.put("MESSAGE"	, 	"OPERATION SUCCESS!");
				map.put("DATA"		,	 user);
			} else {
				map.put("STATUS"	, 	false);
				map.put("MESSAGE"	,	 "RECORD NOT FOUND!");
			}
		} catch (Exception e) {
			map.put("MESSAGE"		, 	"ERROR OCCURRING!");
			map.put("STATUS"		, 	false);
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}
	
	/**
	 * edit
	 * @param m
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/edit/{id}", method = RequestMethod.GET)
	public String edit(ModelMap m, @PathVariable("id") String id) {
		
		ArrayList<Status> status = new ArrayList<Status>();
		status.add(new Status(UserStatus.ACTIVE, "Active"));
		status.add(new Status(UserStatus.DELETE, "Delete"));
		status.add(new Status(UserStatus.PENDING, "Pending"));
		
		m.addAttribute("title"		,	"Update User" )
		 .addAttribute("message"	,	"")
		 .addAttribute("action"		,	"update")
		 .addAttribute("edit"		, 	true)
		 .addAttribute("user"		,	userService.detail(Long.parseLong(id)))
		 .addAttribute("status"		, 	status);
		
		return "/admin/user/form";
	}
	
	/**
	 * update
	 * @param m
	 * @param user
	 * @param request
	 * @return
	 */
	@RequestMapping(value={"/update"}, method = RequestMethod.POST)
	public String update(ModelMap m, User user, HttpServletRequest request) {
		
		ArrayList<Status> status = new ArrayList<Status>();
		status.add(new Status(UserStatus.ACTIVE, "Active"));
		status.add(new Status(UserStatus.DELETE, "Delete"));
		status.add(new Status(UserStatus.PENDING, "Pending"));
		
		try {
			
			if (userService.update(user)) {
				m.addAttribute("title"		,	"Update User" )
				 .addAttribute("message"	,	"<div class='alert alert-success'> <a href='#' class='close' data-dismiss='alert' aria-label='close'>&times;</a><strong>Update Success</strong>. </div>")
				 .addAttribute("action"		,	"update")
				 .addAttribute("edit"		,	true)
				 .addAttribute("user"		,	userService.detail(user.getId()))
				 .addAttribute("status"		, 	status);
				
			} else {
				m.addAttribute("title"		,	"Update User" )
				.addAttribute("message"		,	"<div class='alert alert-danger'> <a href='#' class='close' data-dismiss='alert' aria-label='close'>&times;</a><strong>Update Fail!</strong>. </div>")
				 .addAttribute("action"		,	"update")
				 .addAttribute("edit"		,	true)
				 .addAttribute("user"		,	userService.detail(user.getId()))
				 .addAttribute("status"		, 	status);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/admin/user/form";
	}
	
	/**
	 * delete
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/delete/{id}", method= RequestMethod.GET, headers= "Accept=application/json")
	public ResponseEntity<Map<String, Object>> delete(@PathVariable("id") String id) {
		
		Map<String, Object> map= new HashMap<String, Object>();
		
		try {
			if (userService.delete(Long.valueOf(id))) {
				
				map.put("STATUS"		, 	true);
				map.put("MESSAGE"		, 	"DELETE SUCCESSFULLY");
			} else {
				map.put("STATUS"		, 	false);
				map.put("MESSAGE"		, 	"DELETE UNSUCCESSFULLY");
			}
		} catch (Exception e) {
			
			map.put("STATUS"			, 	false);
			map.put("MESSAGE"			,	 "ERROR OCCURRING!");
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}

	/**
	 * all
	 * @param pageId
	 * @param itemId
	 * @return
	 */
	@RequestMapping(value = "/all/page/{pageId}/item/{itemId}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<Map<String, Object>> getUser(@PathVariable("pageId") String pageId, @PathVariable("itemId") String itemId) {

		Map<String, Object> map = new HashMap<String, Object>();
		Pagination page = new Pagination();
		ArrayList<User> user = new ArrayList<User>();

		try {
			page.setItem(Double.valueOf(itemId));
			page.setPage(Long.valueOf(pageId));
			page.setTotalRecord(userService.count().doubleValue());
			
			user = userService.getUser(page);

			if (user != null && !user.isEmpty()) {
				
				map.put("STATUS"		, 	true);
				map.put("MESSAGE"		, 	"RECORD FOUND");
				map.put("DATA"			, 	user);
				map.put("PAGINATION"	, 	page);
			} else {
				map.put("STATUS"		,	 false);
				map.put("MESSAGE"		, 	"RECORD NOT FOUND!");
			}
		} catch (Exception e) {
			map.put("STATUS"			,	 false);
			map.put("MESSAGE"			,	 "ERROR OCCURRING!");
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}
	
	/**
	 * search
	 * @param pageId
	 * @param itemId
	 * @param key
	 * @return
	 */
	@RequestMapping(value = "/search/page/{pageId}/item/{itemId}/{key}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<Map<String, Object>> search(	@PathVariable("pageId") String pageId, 
														@PathVariable("itemId") String itemId,
														@PathVariable("key") 	String key) {

		Map<String, Object> map = new HashMap<String, Object>();
		Pagination page = new Pagination();
		ArrayList<User> user = new ArrayList<User>();

		try {
			page.setItem(Double.valueOf(itemId));
			page.setPage(Long.valueOf(pageId));
			page.setTotalRecord(userService.countSearch(key).doubleValue());
			
			user = userService.searchUser(key, page);

			if (!user.isEmpty()) {
				
				map.put("STATUS"		, 	true);
				map.put("MESSAGE"		, 	"RECORD FOUND");
				map.put("DATA"			, 	user);
				map.put("PAGINATION"	, 	page);
			} else {
				map.put("STATUS"		, 	false);
				map.put("MESSAGE"		,	 "RECORD NOT FOUND!");
			}
		} catch (Exception e) {
			map.put("STATUS"			,	 false);
			map.put("MESSAGE"			,	 "ERROR OCCURRING!");
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/reset/userId/{userId}/pass/{pass}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<Map<String, Object>> resetUserPassByAdmin(@PathVariable("userId") String userId, @PathVariable("pass") String pass) {

		Map<String, Object> map = new HashMap<String, Object>();

		try {
			
			if (userService.resetUserPassByAdmin(Long.valueOf(userId), pass)) {
				
				map.put("STATUS"		, 	true);
				map.put("MESSAGE"		, 	"PASSWORD WAS RESETED");
				map.put("CODE"			, 	"200");
			} else {
				map.put("STATUS"		,	 false);
				map.put("MESSAGE"		, 	"PASSWORD WAS NOT RESETED");
			}
		} catch (Exception e) {
			map.put("STATUS"			,	 false);
			map.put("MESSAGE"			,	 "PASSWORD WAS NOT RESETED");
			e.printStackTrace();
		}
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}
	
	
}
