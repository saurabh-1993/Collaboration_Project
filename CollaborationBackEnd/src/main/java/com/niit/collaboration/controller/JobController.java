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

import com.niit.collaboration.dao.JobDAO;
import com.niit.collaboration.dao.UserDAO;
import com.niit.collaboration.model.Job;
import com.niit.collaboration.model.JobApplication;
import com.niit.collaboration.model.User;

@RestController
public class JobController {
	
	@Autowired
	User user;
	
	
	@Autowired
	UserDAO userDAO;
	
	@Autowired
	Job job;
	
	@Autowired
	JobDAO jobDAO;
	
	@Autowired
	JobApplication jobApplication;
	
	Logger log = LoggerFactory.getLogger(JobController.class);

	@RequestMapping(value = "/jobs" , method = RequestMethod.GET)
	public ResponseEntity<List<Job>> listAllJobs(){
		log.debug("Starting of the method listAllJobs");
	
		List<Job> jobs = jobDAO.list();
		
		if(jobs.isEmpty()){
			return new ResponseEntity<List<Job>>(HttpStatus.NO_CONTENT);
		}
		log.debug("Ending of the method listAllJobs");
		return new ResponseEntity<List<Job>>(jobs,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/job/", method = RequestMethod.POST)
	public ResponseEntity<Job> createJob(@RequestBody Job job){
		log.debug("Starting of the method createJob");
		jobDAO.postJob(job);
		return new ResponseEntity<Job>(job,HttpStatus.OK);
	}
	
	@RequestMapping(value ="/job/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Job> updateJob(@PathVariable("id") String id , @RequestBody Job job){
		log.debug("Starting of the method updateJob");
		if(jobDAO.get(id)== null){
			job = new Job();
			job.setErrorMessage("Job does not exist with this id" + job.getId());
			return new ResponseEntity<Job>(job,HttpStatus.NOT_FOUND);
			
		}
		jobDAO.updateJob(job);
		log.debug("Ending of the method updateJob");
		return new ResponseEntity<Job>(job,HttpStatus.OK);
	}
	
	@RequestMapping(value ="/getVacantJobs", method = RequestMethod.GET)
	public ResponseEntity<List<Job>> getVacantJobs(){
		List<Job> listofJob = 
		jobDAO.getAllvacantJobs();
		return new ResponseEntity<List<Job>>(listofJob,HttpStatus.OK);
		
	}
	
	@RequestMapping(value = "/apply" , method = RequestMethod.GET)
	public ResponseEntity<JobApplication> applyJob(@RequestBody JobApplication jobApplication){
		jobDAO.applyForJob(jobApplication);
		return new ResponseEntity<JobApplication>(jobApplication,HttpStatus.OK);
	}
	
	@RequestMapping(value ="/updatejobapplication", method = RequestMethod.POST)
	public ResponseEntity<JobApplication> updateJobApp(@PathVariable("jobID") String jobID, HttpSession session){
		
		User loggedInUser = (User) session.getAttribute("loggedInUser");
		job.setUserID(loggedInUser.getId());
		job.setJobID(jobID);
		job.setStatus('A');
		jobDAO.updateJobApplication(jobApplication);
		return new ResponseEntity<JobApplication>(jobApplication,HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
