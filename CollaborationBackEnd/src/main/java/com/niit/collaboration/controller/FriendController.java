package com.niit.collaboration.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niit.collaboration.dao.FriendDAO;
import com.niit.collaboration.dao.UserDAO;
import com.niit.collaboration.model.Friend;
import com.niit.collaboration.model.User;

@RestController
public class FriendController {
	@Autowired
	User user;
	@Autowired
	UserDAO userDAO;

	@Autowired
	FriendDAO friendDAO;
	
	@Autowired
	Friend friend;
	
	
	@RequestMapping(value= "/myFriends",method =RequestMethod.GET)
	public ResponseEntity<List<Friend>> getMyFriend(HttpSession http){
		User loggedInUser =(User) http.getAttribute("loggedInUser");
		List<Friend> myFriends =friendDAO.getMyFriends(loggedInUser.getId());
		return new ResponseEntity<List<Friend>>(myFriends,HttpStatus.OK);
		
	}
	
	@RequestMapping(value ="/addFriend/{friendID}", method= RequestMethod.GET)
	public ResponseEntity<Friend> sendFriendRequest(@PathVariable("friendID") String friendID,HttpSession http){
	
		User loggedInUser =(User) http.getAttribute("loggedInUser");
		friend.setUserID(loggedInUser.getId());
		friend.setFriendID(friendID);
		friend.setStatus("N");
		friendDAO.save(friend);
		return new ResponseEntity<Friend>(friend,HttpStatus.OK);
		
	}
	@RequestMapping(value ="/unfriend/{friendID}",method =RequestMethod.GET)
	public ResponseEntity<Friend> unfriend(@PathVariable("friendID") String friendID,HttpSession http){
		User loggedInUser =(User) http.getAttribute("loggedInUser");
		friend.setUserID(loggedInUser.getId());
		friend.setFriendID(friendID);
		friend.setStatus("U");
		friendDAO.update(friend);
		return new ResponseEntity<Friend>(friend,HttpStatus.OK);
	}
	
	@RequestMapping(value ="/getMyFriendRequests",method = RequestMethod.GET)
	public ResponseEntity<Friend> getMyFriendRequest(HttpSession http){
		
		User loggedInUser =(User) http.getAttribute("loggedInUser");
		friendDAO.getNewFriendRequest(loggedInUser.getId());
		return new ResponseEntity<Friend>(friend,HttpStatus.OK);
	}
	@RequestMapping(value ="/acceptFriend/{friendID}", method = RequestMethod.GET)
	public ResponseEntity<Friend> acceptFriendRequest(@PathVariable("friendID") String friendID,HttpSession http){
		User loggedInUser =(User) http.getAttribute("loggedInUser");
		friend.setUserID(loggedInUser.getId());
		friend.setFriendID(friendID);
		friend.setStatus("A");
		friendDAO.update(friend);
		return new ResponseEntity<Friend>(friend,HttpStatus.OK);
	}
	
	@RequestMapping(value ="/rejectFriend/{friendID}", method = RequestMethod.GET)
	public ResponseEntity<Friend> rejectFriendRequest(@PathVariable("friendID") String friendID,HttpSession http){
		User loggedInUser =(User) http.getAttribute("loggedInUser");
		friend.setUserID(loggedInUser.getId());
		friend.setFriendID(friendID);
		friend.setStatus("R");
		friendDAO.update(friend);
		return new ResponseEntity<Friend>(friend,HttpStatus.OK);
	}
	@RequestMapping(value ="/myFriends/{id}", method = RequestMethod.GET)
	public ResponseEntity<Friend> getMyFriendsTemp(@PathVariable("id")String id){
		List<Friend> myFriends = friendDAO.getMyFriends(id);
		return new ResponseEntity<Friend>((Friend) myFriends,HttpStatus.OK);
	
}
	
	
}