package com.spring.app.entities;

import org.springframework.security.core.GrantedAuthority;

/**
 * 
 * @author sok.kimchhoin
 *
 */
public class Role implements GrantedAuthority{

	private static final long serialVersionUID = -4986854255929832643L;
	
	private Integer id;
	private String name;
	
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	public String getAuthority() {
		return name;
	}

}
