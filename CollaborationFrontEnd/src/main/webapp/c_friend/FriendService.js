'use Strict'
app.service('FriendService',['$http','$q','$rootScope',function($http,$q,$rootScope){

	console.log("FriendService.............")
	var BASE_URL ='http://localhost:8888/CollaborationBackEnd'
	    return{
		GetMyFriends: function(){
			return $http.get(BASE_URL+'/myFriends')
			.then(
					function(response){
						return response.data;
					},
					function(errResponse){
						console.error('Error while fetching friend')
						return $q.reject(errResponse);
					}
					);
		},
		
		sendRequest: function(friend,friendID){
			return $http.get(BASE_URL+'/addFriend/'+friendID,friend)
			.then(
					function(response){
						return response.data;
					},
					function(errResponse){
						console.error('Error while sending request')
						return $q.reject(errResponse);
					}
					);
		},
		
		unFriend: function(friend,friendID){
			return $http.get(BASE_URL+'/unfriend/'+friendID)
			.then(
					function(response){
						return response.data;
					},
					function(errResponse){
						console.error("Error while unfriend....")
						return $q.reject(errResponse);
					}
					
			);
		},
		
		myFriendRequests: function(friend,friendID){
			return $http.get(BASE_URL+'/getMyFriendRequests')
			.then(
					function(response){
						return response.data;
					},
					function(errResponse){
						console.error("Error while fetching your friend request")
						return $q.reject(errResponse);
					}
					
			);
		},
		
		acceptFriend: function(friend,friendID){
			return $http.get(BASE_URL+'/acceptFriend/'+friendID,friend)
			.then(
			     function(response){
			    	 return response.data;
			    	 
			     }	,
			     function(errResponse){
			    	 console.error("Error while accepting request")
			    	 return $q.reject(errResponse);
			     }
			     
			);
		},
		
		rejectFriend: function(friend,friendID){
			$http.get(BASE_URL+'/rejectFriend/'+friendID,friend)
			.then(
					function(response){
						return response.data;
					},
					function(errResponse){
						console.error('Error while rejecting')
						return $q.reject(errResponse)
					}
			);
		},
		
		
		
		
		
	}	
}])