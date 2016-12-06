'use strict'
app.controller('FriendController',[
         '$scope',
         'FriendService',
         '$location',
         '$rootScope',
         
         function($scope,FriendService,$location,$rootScope){
        console.log("FriendController.....")	 
        var self = this;
        self.friend ={
        		id : '',
        		userID : '',
        		friendID : '',
        		status : ''
        		 };
        self.friends =[];
        
        self.GetMyFriends = function(){
        	FriendService.GetMyFriends()
        	.then(
        			function(d){
        				self.friends = d;
        			},
        			function(errResponse){
        				console.error('Error while getting friends');
        			}
        			
        	);
        };
        
        self.sendRequest = function(friend,friendID){
        	console.log("Send Request");
        	FriendService.sendRequest()
        	.then(
        		function(d){
        			self.friends = d;
        			console.log("request sent")
        		}	,
        		function(errResponse){
        			console.error('Error while sending Request')
        		}
        	);
        };
        
        self.unFriend = function(){
        	FriendService.unFriend()
        	.then(
        	function(d){
        		self.friends = d;
        	}		,
        	function(errResponse){
        		console.error('Error while unfriend')
        	}
        	);
        };
        self.myFriendRequests = function(){
        	console.log("getting frien requests")
        	FriendService.myFriendRequests()
        	.then(
        			function(d){
        				self.friends = d;
        			console.log("Success")
        			},
        			function(errResponse){
        				console.error('Error while fetvhing you requests');
        			}
        			
        	);
        };
        
        self.acceptFriend = function(){
        	FriendService.acceptFriend()
        	.then(
        			function(d){
        				self.friends = d;
        				
        			},
        			function(errResponse){
        				console.error('Error while accepting friend');
        			}
        			);
        };
        
        self.rejectFriend = function(){
        	FriendService.rejectFriend()
        	.then(
        			function(d){
        				self.friends = d;
        			},
        			function(errResponse){
        				console.error('Error while rejecting friend')
        			}
        			);
        };
         }
         
                                   
                                   
                                   
                                   
                                   
                                   
                                   
                                   
                                   
                                   ])