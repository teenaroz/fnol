var studentModule = angular.module("studentModule",[]);

studentModule.controller("createStudentController",["$scope", "studentFactory", "studentService", function($scope, studentFactory, studentService){
    $scope.master = {};
    
    $scope.update = function(student) {
        $scope.master = angular.copy(student);
        studentFactory.update($scope.master);
        $scope.successmsg = "Date Updated Successfully";
    };
    
    $scope.reset = function(form) {
        
       //$scope.student = angular.copy($scope.master);
    	$scope.student = {};
    }
    
    $scope.reset();
}]);

studentModule.controller("viewStudentController",["$scope", "studentFactory", "studentService", function($scope, studentFactory, studentService){
    $scope.students = studentFactory.list();
  
    
    $scope.remove = function(student) {
    	studentFactory.remove(student);        
    };
}]);

studentModule.factory("studentFactory", function(){
    

        var studentList = [];
    
        var thisService = {};
        
        thisService.update = function(student){

           studentList.push(student);           
        } 
        
        thisService.remove = function(student){
        	var index = studentList.indexOf(student);
        	studentList.splice(index, 1);
         } 
        
        thisService.list = function(){
            return studentList;
        }
        
        return thisService;

});

studentModule.service("studentService", function(){    

        var studentList = [];
        
        this.update = function(student){
        	studentList.push(student);        	
        } 
        
        this.list = function(){
            return studentList;
        }
        this.list.remove = function(student){
        	var index = studentList.indexOf(student);
        	this.list.splice(index, 1);
         } 

});

