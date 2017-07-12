var myApp = angular.module("myApp", ["ngRoute", "studentModule"]);

myApp.config(function($routeProvider){
   $routeProvider
       .when("/", {templateUrl: "myApp-home.html"})
       .when("/saveStudent", {templateUrl: "myApp-saveStudent.html"})
	   .when("/viewStudent", {templateUrl: "myApp-viewStudent.html"})
    
});