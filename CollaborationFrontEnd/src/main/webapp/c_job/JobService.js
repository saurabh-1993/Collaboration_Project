'use Strict';
app.service('JobService',['$http','$q','$rootScope', function($http,$q,$rootScope){

	console.log('JobService');
	var BASE_URL ='http://localhost:8888/CollaborationBackEnd'
		return {
		listAllJobs: function(){
			return $http.get(BASE_URL+'/jobs')
			.then(
					function(response){
						return response.data;
					},
					function(errResponse){
						console.log('Error while fetching jobs')
						return $q.reject('errResponse')
					}
					
			
			
			);
		},
		
		createJob: function(job){
			$http.post(BASE_URL+'/job/',job)
			.then(
					function(response){
						return response.data
					},
					function(errResponse){
						console.log('Error while creating job')
						return $q.reject(errResponse)
					}
			
			);
		},
		
		updateJob: function(job,id){
			$http.put(BASE_URL+'/job/'+id ,job)
			.then(
					function(response){
						return response.data;
						
					},
					function(errResponse){
						console.log('Error while updating job');
						$q.reject(errResponse);
						
					}
			);
		},
		
		getVacantJobs: function(){
			$http.get(BASE_URL+'/getVacantJobs')
			.then(
			     	function(response){
			     		return response.data;
			     	}	,
			     	function(errResponse){
			     		console.log('Error while getting vacant jobs');
			     		$q.reject(errResponse);
			     	}
			);
		},
		
		applyJob: function(jobApplication){
			$http.get(BASE_URL+'/apply',jobApplication)
			.then(
					function(response){
						return response.data;
					},
					function(errResponse){
						console.log('Error while applying job');
						$q.reject(errResponse);
					}
			);
		},
		
		updateJobApplication: function(jobApplication){
		$http.post(BASE_URL+'/updatejobapplication',jobApplication)
		.then(
				function(response){
					return response.data;
				},
				function(errResponse){
					console.log('Error while updating jobApplication');
					return $q.reject(errResponse);
				}
		
		);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	
	}
	
	
	
}])


