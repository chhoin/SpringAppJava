package com.spring.app.test;

import com.spring.app.entities.Pagination;

public class TestPagination {

	public static void main(String[] args) {
		Pagination page = new Pagination();
		page.setItem(5D);
		page.setPage(3L);
		page.setTotalRecord(11D);
		
		System.out.println(page.getBegin());
		System.out.println(page.getTotalPage());
	}

}
