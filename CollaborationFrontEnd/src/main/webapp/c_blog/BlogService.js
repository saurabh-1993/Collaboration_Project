'use strict';
app.service('BlogService',['$http','$q','$rootScope', function($http,$q,$rootScope){
 
	console.log("BlogService.......")

	var BASE_URL ='http://localhost:8888/CollaborationBackEnd'
		return{
		listAllBlogs: function(){
			return $http.get(BASE_URL+'/blogs')
			.then(
					function(response){
						return response.data;
					},
					function(errResponse){
						console.error("Error while fetching blogs")
						return $q.reject(errResponse);
					}
			);
		},
		
		createBlog: function(blog){
			return $http.post(BASE_URL+'/blog/', blog)
			.then(
					function(response){
						return response.data;
					},
					function(errResponse){
						console.log("Error while creating blog")
						$q.reject(errResponse);
					}
					
			);
		},
		
		
		updateBlog: function(blog,id){
			return $http.put(BASE_URL+'/blog/'+id,blog)
			.then(
					function(response){
						return response.data;
						
					},
					function(errResponse){
						console.log("Error while updating Blog")
						return $q.reject(errResponse);
					}
					);
				
			
		},
		
		
		
	}
	
	
	
	
}])
