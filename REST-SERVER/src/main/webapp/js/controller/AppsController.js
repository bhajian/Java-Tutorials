var app = angular.module("MyApp", []); 	

app.controller("AppListCtrl", function($scope, $http, $templateCache) {
	$scope.listApps = function() {
		
			$http(
				{method: 'GET', url: './rest/Gate/GetData', 
				headers: { 'command': 'youtubeSearch', 'subCommand' : 'search' , 'param':'{"query" : "rohani+piano+thoughts+of+the+past"}' } 
				, cache: $templateCache}).
				success(function(data, status, headers, config) {
					
			    	$scope.apps = data;                  //set view model
			    	$scope.view = './view/list.html'; //set to list view
				}).
				error(function(data, status, headers, config) {
					$scope.apps = data || "Request failed";
					$scope.status = status;
					$scope.view = './view/list.html';
				});
	}
	
	$scope.searchContent = function() {
		
		var paramValue = '{"query" : "'+$scope.user.phonenum+'"}';
		$http({method: 'GET', url: './rest/Gate/GetData', 
			headers: { 'command': 'youtubeSearch', 'subCommand' : 'search' , 'param':paramValue } 
			}).
			success(function(data, status, headers, config) {
	    	$scope.apps = data;                  //set view model
	    	$scope.view = './view/list.html'; //set to list view
			}).
			error(function(data, status, headers, config) {
				$scope.apps = data || "Request failed";
				$scope.status = status;
				$scope.view = './view/list.html';
			});
	}
	$scope.view = './view//list.html'; //set default view
	$scope.listApps();
});


/*


function AppListCtrl($scope, $http, $templateCache) {
 		$scope.listApps = function() {
 			$http({method: 'GET', url: './rest/Gate/GetData', 
 				headers: { 'command': 'youtubeSearch', 'subCommand' : 'search' , 'param':'{"query" : "rohani+piano+thoughts+of+the+past"}' } 
 				, cache: $templateCache}).
  				success(function(data, status, headers, config) {
  					
    		    	$scope.apps = data;                  //set view model
    		    	$scope.view = './view/list.html'; //set to list view
  				}).
  				error(function(data, status, headers, config) {
  					$scope.apps = data || "Request failed";
  					$scope.status = status;
  					$scope.view = './view/list.html';
  				});
  		}
 		
 		$scope.searchContent = function() {
 			debugger;
 			var paramValue = '{"query" : "'+$scope.user.phonenum+'"}';
 			$http({method: 'GET', url: './rest/Gate/GetData', 
 				headers: { 'command': 'youtubeSearch', 'subCommand' : 'search' , 'param':paramValue } 
 				, cache: $templateCache}).
  				success(function(data, status, headers, config) {
  					
    		    	$scope.apps = data;                  //set view model
    		    	$scope.view = './view/list.html'; //set to list view
  				}).
  				error(function(data, status, headers, config) {
  					$scope.apps = data || "Request failed";
  					$scope.status = status;
  					$scope.view = './view/list.html';
  				});
  		}
  			
  		$scope.showApp = function(id) {
  			var paramVal = '' + id;	
  			$http({method: 'GET', url: './rest/Gate/GetData',
  				headers: { 'command': 'content', 'subCommand' : 'contentInfo' , 'param':'{"contentId":"9qZCsbczfJU"}' }
  				, cache: $templateCache}).
  				success(function(data, status, headers, config) {
  					$scope.appDetail = data;               //set view model
  					debugger;
  					$scope.view = './view/detail.html'; //set to detail view
  				}).
  				error(function(data, status, headers, config) {
  					$scope.appDetail = data || "Request failed";
  					$scope.status = status;
  					$scope.view = './view/detail.html';
  				});
  		}
  		
  		$scope.view = './view//list.html'; //set default view
  		$scope.listApps();
 	}
 	AppListCtrl.$inject = ['$scope', '$http', '$templateCache'];

*/