var app = angular.module('myApp',['ngRoute']);

app.config(function($routeProvider){
	$routeProvider
	
	/*.when('/',{
		templateUrl : 'c_home/home.html',
		controller : 'HomeController'
	})
	*/
	.when('/login',{
	
		templateUrl : 'c_user/login.html',
		controller  : 'UserController'
		
		
	})
	
	
	
	
	.when('/logout',{
	
		templateUrl : 'index.html',
		controller  : ''
		
		
	})
	
	
	.when('/register',{
		
		templateUrl : 'c_user/register.html',
		controller  : 'UserController'
	}
	)
	.when('/friend',{
		templateUrl : 'c_friend/friend.html',
		controller  :  'FriendController'
	})
	.when('/searchUser',{
		templateUrl : 'c_user/searchUser.html',
		controller  :  'UserController'
	})
	.when('/jobs',{
		templateUrl : 'c_job/job.html',
		controller : 'JobController'
	})
	.when('/blogs',{
		templateUrl : 'c_blog/blog.html',
			controller: 'BlogController'
	})
	.when('/createBlog',{
		templateUrl: 'c_blog/createBlog.html',
		controller: 'BlogController'
	})
	.when('/events',{
		templateUrl: 'c_event/listEvents.html',
	    controller: 'EventController'
	})
	
})