package com.spring.app.entities;

/**
 * 
 * @author sok.kimchhoin
 *
 */
public class StatusUSER {
	
	private String value;
	private String title;
	
	public StatusUSER(String v, String t){
		this.value = v;
		this.title = t;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}


}
