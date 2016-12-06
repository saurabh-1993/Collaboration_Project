'use strict'
app.controller('EventController',['$scope','EventService','$location','$rootScope',
                                 
                                 function($scope,EventService,$location,$rootScope){
	console.log("EventController.......")
	
	var self = this;
	
	self.event ={
			
			 id: '',
			name: '',
		  description: '',
			 venue: '',
			dateTime: '',
			
			errorMessage: ''
			
			
			
	};
	
	self.events =[];
	
	self.listAllEvents = function(){
		EventService.listAllEvents()
		.then(
				function(d){
					self.events = d;
				},
				function(errResponse){
					console.log('Error while fetching events');
				}
		
		);
	};
	self.createEvent = function(event){
		EventService.createEvent(event)
		.then(self.listAllEvents,
				function(errResponse){
			console.log('Error while creating event')
		});
	};
	
	self.updateEvent = function(event,id){
	
		EventService.updateEvent(event,id).then(self.listAllEvents,
		function(errResponse){
			console.log('Error while updating event');
		}		
		);
	};
	
	
	self.deleteEvent = function(id){
		EventService.deleteEvent(id).then(self.listAllEvents,
				function(errResponse){
			console.log('Error while deleting events')
		});
	};
	self.listAllEvents();
	
	self.submit = function() {
		

		{
			console.log('Saving new event', self.event);
			self.createEvent(self.event);
		}

	
	
	
	
	
	
	}
	
	
	
	
	
	
	
	
}
 ])