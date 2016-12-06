package com.niit.collaboration.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaboration.dao.FriendDAO;
import com.niit.collaboration.dao.UserDAO;
import com.niit.collaboration.model.Friend;
import com.niit.collaboration.model.User;

public class FriendTest {
public static void main(String[] args) {
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
	context.scan("com.niit.collaboration");
	context.refresh();
	
	FriendDAO friendDAO = (FriendDAO)context.getBean("friendDAO");
	
	Friend friend =(Friend) context.getBean("friend");

	friend.setId(12);
	friend.setFriendID("sau12");
	friend.setUserID("54564");
	friend.setStatus("N");
	
	
	
	if(friendDAO.save(friend)==true){
		System.out.println("User Created Success");
	}
	else{
		System.out.println("Unable to create the user");
	}
	context.close();



}
}
