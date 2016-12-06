/*package com.niit.collaboration.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaboration.dao.UserDAO;
import com.niit.collaboration.model.User;

public class TestCaseUser {
	@Autowired
	UserDAO userDAO;

	@Autowired

	User user;


	AnnotationConfigApplicationContext context;


	@Before
	public void init(){
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		
	userDAO = (UserDAO)context.getBean("userDAO");
		 user =(User) context.getBean("user");

	}

	@Test
	public void deleteUserTestCase(){
	user.setId("10SS69");;
		userDAO.delete(user);
		assertEquals("deleteUserTestCase",userDAO.delete(user),true);
	}
	@Test
	public void addCategoryTestCase(){
		user.setId("sau1272");
		user.setAddress("LKO");
	
		
		user.setEmail("sau@gmail");
		user.setMobile("8130871913");
		user.setName("saurabh");
		user.setPassword("81305555");
		user.setRole("User");
		userDAO.save(user);
		assertEquals("addUserTestCase",userDAO.save(user), true);
	}


	}
*/