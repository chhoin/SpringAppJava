package com.spring.app.entities;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 
 * @author sok.kimchhoin
 *
 */
public class ValidateEntity {

	@Size(min = 4, max = 50)
	private String string;

	@NotNull
	private String phone;

	private String email;

	private String pass;

	private String url;

	private Date birthday;

	public String getString() {
		return string;
	}

	public void setString(String string) {
		this.string = string;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

}
