var app = angular.module("studentApp", []);

app.controller('studentController', function($scope) {
    $scope.marks = [
        {
            subject : 'English',
            marks: $scope.subject1
        },
        {
            subject : 'History',
            marks: $scope.subject2
        },
        {
            subject : 'Maths',
            marks: $scope.subject3
        }
    ];
    $scope.calcAvg = function(){
        var total = 0;
        var sub1 = !!$scope.subject1 ? parseInt($scope.subject1) : null;
        var sub2 = !!$scope.subject2 ? parseInt($scope.subject2) : null;
        var sub3 = !!$scope.subject3 ? parseInt($scope.subject3) : null;
        if(!!sub1 && !! sub2 && !!sub3){
            total =  (sub1+sub2+sub3) / 3;
        }
        return total;
    };
});



