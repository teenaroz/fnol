var app2 = angular.module("assignmentApp1", []);
		app2.controller("simpleController", ["$scope", "$http", "$log", "mySaveService", function( $scope, $http, $log, mySaveService) {

			$scope.updateStudentDetails = function() {
				var mark1 = 0;
				var mark2 = 0;
				var mark3 = 0;
			
				
				mark1 =  $scope.mark1;
				mark2 =  $scope.mark2;
				mark3 =  $scope.mark3;
				
				$scope.averageMarks=( parseInt(mark1)+ parseInt(mark2)+ parseInt(mark3))/3;
				mySaveService.saveStudentInfo($http, $log, $scope.name,mark1, mark2, mark3);
				
			}

		}]);		
		
		app2.service("mySaveService", function (){

			this.saveStudentInfo = function($http, $log, name, mark1, mark2, mark3){

			var req = {"name": name, "Mark1":mark1, "Mark2":mark2,"Mark3":mark3};

			$http.post('http://localhost:3000/studentInfo', req).then(
			function successCallback(response){
				$log.debug(response);
			},
			function errorCallback(response){
				$log.debug(response);
			}
			);
			}
			});
		
		
