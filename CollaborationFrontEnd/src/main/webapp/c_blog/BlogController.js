'use strict'
app.controller('BlogController',['$scope','BlogService','$location','$rootScope',
                                 
                                 function($scope,BlogService,$location,$rootScope){
	console.log("BlogController.......")
	
	var self = this;
	
	self.blog ={
			
			 id: '',
			title: '',
		  description: '',
			 userID: '',
			dateTime: '',
			 status: '',
			reason: '',
			errorMessage: ''
			
			
			
	};
	
	self.blogs =[];
	
	self.listAllBlogs = function(){
		BlogService.listAllBlogs()
		.then(
				function(d){
					self.blogs = d;
				},
				function(errResponse){
					console.log('Error while fetching blogs');
				}
		
		);
	};
	self.createBlog = function(blog){
		BlogService.createBlog(blog)
		.then(self.listAllBlogs,
				function(errResponse){
			console.log('Error while creating blog')
		});
	};
	
	self.updateBlog = function(blog,id){
	
		BlogService.updateBlog(blog,id).then(self.listAllBlogs,
		function(errResponse){
			console.log('Error while updating blog');
		}		
		);
	};
	
	
	self.deleteBlog = function(id){
		BlogService.deleteBlog(id).then(self.listAllBlogs,
				function(errResponse){
			console.log('Error while deleting blogs')
		});
	};
	self.listAllBlogs();
	
	self.submit = function() {
		

		{
			console.log('Saving new blog', self.blog);
			self.createBlog(self.blog);
		}

	
	
	
	
	
	
	}
	
	
	
	
	
	
	
	
}
 ])