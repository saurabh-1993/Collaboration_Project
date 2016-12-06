'use strict';
app.service('EventService',['$http','$q','$rootScope', function($http,$q,$rootScope){
 
	console.log("EventService.......")

	var BASE_URL ='http://localhost:8888/CollaborationBackEnd'
		return{
		listAllEvents: function(){
			return $http.get(BASE_URL+'/events')
			.then(
					function(response){
						return response.data;
					},
					function(errResponse){
						console.error("Error while fetching events")
						return $q.reject(errResponse);
					}
			);
		},
		
		createEvent: function(event){
			return $http.post(BASE_URL+'/event/', event)
			.then(
					function(response){
						return response.data;
					},
					function(errResponse){
						console.log("Error while creating event")
						$q.reject(errResponse);
					}
					
			);
		},
		
		
		updateEvent: function(event,id){
			return $http.put(BASE_URL+'/event/'+id,event)
			.then(
					function(response){
						return response.data;
						
					},
					function(errResponse){
						console.log("Error while updating Event")
						return $q.reject(errResponse);
					}
					);
				
			
		},
		
		
		
	}
	
	
	
	
}])
