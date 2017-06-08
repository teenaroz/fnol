var app = angular.module("studentApp", []);

app.service('displayDetails', function() {
    this.displayStudentDetails = function (x) {
        return "test";
    }
});