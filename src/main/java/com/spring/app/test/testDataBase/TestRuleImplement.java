package com.spring.app.test.testDataBase;

import com.spring.app.repositories.impl.RoleDaoIml;

public class TestRuleImplement {

	public static void main(String[] args) {
		RoleDaoIml role = new RoleDaoIml();
		
		System.out.println("ID="+role.all().get(1).getId() + "Name ="+role.all().get(1).getName());

	}

}
