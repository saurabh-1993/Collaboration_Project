'use Strict'
app.controller('JobController',['$scope','JobService','$location','$rootScope',
                                
                                function($scope,JobService,$location,$rootScope){
	console.log('JobController');
	var self = this;
	self.job ={
			id: '',
			title: '',
			description: '',
			dateTime: '',
			qualification:'',
			status: '',
			jobID:''
	};
	self.jobs =[];
		self.listAllJobs = function(){
		JobService.listAllJobs()
		.then(
				function(d){
					self.jobs = d;
				},
				function(errResponse){
					console.log('Error while getting all jobs');
					
				}
				
		);
	}	;
	
	
	
		self.createJob = function(){
			JobService.createJobs()
			.then(
					function(d){
						self.jobs = d;
					},
					function(errResponse){
						console.log('Error while creating Job')
					}
			);
		}	;
		
		self.updateJob = function(){
			JobService.updateJob()
			.then(
			      function(d){
			    	  self.jobs = d;
			      }		,
			      function(errResponse){
			    	  console.log('Error while updating Job');
			      }
			);
		};
		
		self.getVacantJobs = function(){
			JobService.getVacantJobs()
			.then(
			function(d){
				self.jobs = d;
			}		,
			function(errResponse){
				console.log('Error while getting vacanjobs');
			}
			);
		};
			
		self.listAllJobs();
		self.applyJob = function(jobApplication){
			JobService.applyJob(jobApplication)
			.then(
					function(d){
				    	  self.jobs = d;
				      }		
					
					,
					function(errResponse){
						console.log('Error while updating jobapplicaton')
					}
			);
		};
		
		self.updateJobApplication = function(){
			JobService.updateJobApplication()
			.then(
					function(d){
						self.jobs = d;
					},
					function(errResponse){
						console.log('Error while updating jobapplication');
					}
			);
		};
	
		
}
                                
                                
                                ])