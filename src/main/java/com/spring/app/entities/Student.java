package com.spring.app.entities;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.URL;

/**
 * 
 * @author sok.kimchhoin
 *
 */
public class Student {
	
	@Size(min=2 , max=50)
	private String name;
	
	@Size(min=2 , max=50)
	@Email
	private String email;
	
	@Size(min=9 , max=10)
	@Pattern(regexp = "[0-9]+" , message="Number Only!")
	private String phone;
	
	@NotEmpty
	@URL
	private String url;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	
	
	
}
