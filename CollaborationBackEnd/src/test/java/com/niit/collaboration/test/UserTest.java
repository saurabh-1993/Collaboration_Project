package com.niit.collaboration.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaboration.dao.UserDAO;
import com.niit.collaboration.model.User;

public class UserTest {
public static void main(String[] args) {
	
	

	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
	context.scan("com.niit.collaboration");
	context.refresh();
	
	UserDAO userDAO = (UserDAO)context.getBean("userDAO");
	
	User user =(User) context.getBean("user");
	user.setId("15589");
	user.setAddress("Preet Vihar");


	user.setEmail("sau@gmail.com");
	user.setMobile("8130871913");
	user.setName("Saurabh");
	user.setPassword("saurabh");
	user.setRole("Admin");
	
	
	if(userDAO.save(user)==true){
		System.out.println("User Created Success");
	}
	else{
		System.out.println("Unable to create the user");
	}
	context.close();
}
}
