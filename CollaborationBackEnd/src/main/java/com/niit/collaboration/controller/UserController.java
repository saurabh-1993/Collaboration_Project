package com.niit.collaboration.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niit.collaboration.dao.UserDAO;
import com.niit.collaboration.model.User;

@RestController
public class UserController {
	
	
	@Autowired
    User user;
	
	
	@Autowired
	UserDAO userDAO; 
	
	Logger log = LoggerFactory.getLogger(UserController.class);
	@RequestMapping(value = "/users" ,method = RequestMethod.GET)
	public ResponseEntity<List<User>> listAllUsers(){
		log.debug("Starting of the method listAllUser");
		List<User> users = userDAO.list();
		
		
		if(users.isEmpty()){
			return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
		}
		log.debug("Ending of the method listAllUser");
		return new ResponseEntity<List<User>>(users,HttpStatus.OK);
		
	}
	@RequestMapping(value ="/user/", method = RequestMethod.POST)
	public ResponseEntity<User> createUser(@RequestBody User user){
		log.debug("Starting of the method createUser");
/*	if(userDAO.get(user.getId())==null){*/
		userDAO.save(user);
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}
	/*log.debug("->->->->->->->->->->User already exist with this id"+ user.getId());
	user.setErrorMessage("user already exist with this id:" +user.getId());
	return new ResponseEntity<User>(user,HttpStatus.OK);
	
	}
*/
	@RequestMapping(value ="/user/{id}", method = RequestMethod.PUT)
	public ResponseEntity<User> updateUser(@PathVariable("id") String id ,@RequestBody User user){
	
		log.debug("Starting of the method updateUser");
		if(userDAO.get(user.getId())== null){
			user = new User();
			user.setErrorMessage("User does not exist with this id" + user.getId());
		    return new ResponseEntity<User>(user,HttpStatus.NOT_FOUND);
		}
		
		userDAO.update(user);
		log.debug("Ending of the method updateUser");
		return new ResponseEntity<User>(user, HttpStatus.OK);
		
		
		
	}		
	
@RequestMapping(value ="/user/{id}", method= RequestMethod.DELETE)
public ResponseEntity<User> deleteUser(@PathVariable("id") String id ,@RequestBody User user){
	log.debug("Starting of the method deleteUser");
	
	if(userDAO.get(user.getId()) == null){
		user = new User();
		user.setErrorMessage("User does not exist" + user.getId());
		return new ResponseEntity<User>(user, HttpStatus.NOT_FOUND);
	}
	userDAO.delete(user);
	log.debug("Ending of the method deleteUser");
	return new ResponseEntity<User>(user, HttpStatus.OK);
}
@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
public ResponseEntity<User> getUser(@PathVariable("id") String id, @RequestBody User user){
	log.debug("Starting of the method getUser");
	
	
	if(userDAO.get(user.getId())== null){
		user= new User();
		user.setErrorMessage("User does not exist" + user.getId());
		return new ResponseEntity<User>(user , HttpStatus.NOT_FOUND);
	}
	log.debug("Endting of the method getUser");
	return new ResponseEntity<User>(user, HttpStatus.OK);
}

@RequestMapping(value ="/user/authenticate/", method = RequestMethod.POST)
public ResponseEntity<User> authenticate(@RequestBody User user, HttpSession session){
	log.debug("Starting of the method authenticate");
	user = userDAO.authenticate(user.getId(), user.getPassword());
	if(user==null){
		user = new User();
		user.setErrorMessage("Invalid Credentials please enter valid credentials");
	}
	else{
		user.setErrorCode("200");
		log.debug("valid credentials");
		session.setAttribute("loggedInUser", user);
		session.setAttribute("loggedInUserID", user.getId());
		
	}
	log.debug("Endting of the method authenticate");
	return new ResponseEntity<User>(user,HttpStatus.OK);
}

}










	
