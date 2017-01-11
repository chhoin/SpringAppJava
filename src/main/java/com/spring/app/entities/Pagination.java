package com.spring.app.entities;

import java.io.Serializable;

/**
 * 
 * @author sok.kimchhoin
 *
 */
public class Pagination implements Serializable{

	private static final long serialVersionUID = -7738938410064733771L;
	private Long page;
	private Double item;
	private Long begin;
	private Double totalRecord;
	private Long totalPage;
	

	public Long getPage() {
		return page;
	}

	public void setPage(Long page) {
		this.page = page;
	}

	public Long getItem() {
		return item.longValue();
	}

	public void setItem(Double item) {
		this.item = item;
	}

	public Long getBegin() {
		this.begin = (long) ((this.item*this.page)-this.item);
		return begin;
	}

	public void setBegin(Long begin) {
		this.begin = begin;
	}

	public Long getTotalRecord() {
		return totalRecord.longValue();
	}

	public void setTotalRecord(Double totalRecord) {
		this.totalRecord = totalRecord;
	}

	public Long getTotalPage() {
		this.totalPage = (long) Math.ceil(this.totalRecord/this.item) ;
		return totalPage;
	}

	public void setTotalPage(Long totalPage) {
		this.totalPage = totalPage;
	}
}
