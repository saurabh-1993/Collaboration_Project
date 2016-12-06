package com.niit.collaboration.controller;

import java.util.List;

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

import com.niit.collaboration.dao.BlogDAO;
import com.niit.collaboration.model.Blog;
import com.niit.collaboration.model.User;

@RestController
public class BlogController {
@Autowired
	Blog blog;
	

@Autowired
	BlogDAO blogDAO;

Logger log = LoggerFactory.getLogger(BlogController.class);

@RequestMapping(value = "/blogs", method = RequestMethod.GET)
public ResponseEntity<List<Blog>> listAllBlogs(){
	log.debug("Starting of the method listAllBlogs");
	
	List<Blog> blogs = blogDAO.list();
	if(blogs.isEmpty()){
		return new ResponseEntity<List<Blog>>(HttpStatus.NO_CONTENT);
	}
	log.debug("Ending of the method listAllUser");
	return new ResponseEntity<List<Blog>>(blogs,HttpStatus.OK);
}
@RequestMapping(value = "/blog/" , method = RequestMethod.POST)
public ResponseEntity<Blog> createBlog(@RequestBody Blog blog){
	log.debug("Starting of the method create blog");
	blogDAO.save(blog);
	log.debug("Ending of the method create blog");
	return new ResponseEntity<Blog>(blog,HttpStatus.OK);
}

@RequestMapping(value ="/blog/{id}", method = RequestMethod.PUT)
public ResponseEntity<Blog> updateBlog(@PathVariable("id") String id , @RequestBody Blog blog){
	log.debug("Starting of the method updateBlog");
	if(blogDAO.get(blog.getId())== null){
		blog = new Blog();
		blog.setErrorMessage("Blog does not exist" + blog.getId());
		return new ResponseEntity<Blog>(blog,HttpStatus.NOT_FOUND);
		
	}
	blogDAO.update(blog);
	log.debug("Ending of the method updateBlog");
	return new ResponseEntity<Blog>(blog,HttpStatus.OK);
}

@RequestMapping(value ="/blog/{id}", method = RequestMethod.DELETE)
public ResponseEntity<Blog> deleteBlog(@PathVariable("id") String id, @RequestBody Blog blog){
	
log.debug("Starting of the method deleteBlog");
if(blogDAO.get(blog.getId())==null){
	blog = new Blog();
	blog.setErrorMessage("Blog does not exist" + blog.getId());
	return new ResponseEntity<Blog>(blog,HttpStatus.NOT_FOUND);
}
blogDAO.delete(blog);
log.debug("Ending of the method deleteBlog");
return new ResponseEntity<Blog>(blog,HttpStatus.OK);
}

@RequestMapping(value = "/blog/{id}", method = RequestMethod.GET)
public ResponseEntity<Blog> getBlog(@PathVariable("id") String id,@RequestBody Blog blog){
	log.debug("Starting of the method getBlog");
	if(blogDAO.get(blog.getId())== null){
		blog = new Blog();
	    blog.setErrorMessage("Blog does not exist" + blog.getId());
	    return new ResponseEntity<Blog>(blog,HttpStatus.NOT_FOUND);
	}
	log.debug("Ending of the method getBlog");
	return new ResponseEntity<Blog>(blog,HttpStatus.OK);
}




}
