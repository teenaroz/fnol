var app2 = angular.module("assignmentApp1", []);
		app2.controller("simpleController", ["$scope", "$http", "$log", "mySaveService", function( $scope, $http, $log, mySaveService) {

			$scope.updateStudentDetails = function() {
				var inputBoxMark1 = 0;
				var inputBoxMark2 = 0;
				var inputBoxMark3 = 0;
			
				
				inputBoxMark1 =  $scope.inputBoxMark1;
				inputBoxMark2 =  $scope.inputBoxMark2;
				inputBoxMark3 =  $scope.inputBoxMark3;
				
				$scope.averageMarks=( parseInt(inputBoxMark1)+ parseInt(inputBoxMark2)+ parseInt(inputBoxMark3))/3;
				mySaveService.saveStudentInfo($http, $log, $scope.inputBoxName,inputBoxMark1, inputBoxMark2, inputBoxMark3);
				
			}

		}]);		
		
		app2.service("mySaveService", function (){

			this.saveStudentInfo = function($http, $log, name, mark1, mark2, mark3){

			var req = {"name": name, "subject1Mark":mark1, "subject2Mark":mark2,"subject3Mark":mark3};

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
		
		
