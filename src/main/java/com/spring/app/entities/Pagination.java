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
	private Long item;
	private Long begin;
	private Long totalCount;
	private Long totalPages;
	
	public Pagination(){
		this(1L,15L,0L,0L);
	}	
	
	public Pagination(Long page, Long item, Long totalCount, Long totalPages){
		this.page = page;
		this.item = item;
		this.totalCount = totalCount;
		this.totalPages = totalPages;
	}
	public Long getPage() {
		return page;
	}

	public Long totalPages(){
		return  (long) Math.ceil(this.totalCount/item);
		
	}
	
	public Long nextPage(){
		return this.page+1;
	}
	
	public Long previousPage(){
		return this.page-1;
	}
	
	public boolean hasNextPage(){
		return this.nextPage() <=this.totalPages()? true :false;
	}
	
	public boolean hasPreviousPage(){
		return this.previousPage()>=1 ? true : false;
	}	
	
	public Long offset(){
		return (this.page-1)* item;
	}
	
	public void setPage(Long currentPage) {
		this.page = currentPage;
	}

	public Long getItem() {
		return item;
	}

	public void setItem(Long item) {
		this.item = item;
	}

	public Long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}

	public Long getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(Long totalPages) {
		this.totalPages = totalPages;
	}

	public Long getBegin() {
		this.begin = (this.getItem()*this.getPage())-this.getItem();
		return begin;
	}

	public void setBegin(Long begin) {
		this.begin = begin;
	}
}
