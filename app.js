app = angular.module('app', [])

app.controller('MainController', function($scope) {
      $scope.fields = ["Name", "Social studies", "Maths", "Science"]
      $scope.students = {data:[
                         {
                            name: "Naren",
                            social:60,
                            maths:87,
                            science:85
                          },
                         {
                            name:"Saikiran",
                            social:80,
                            maths:70,
                            science:98
                          },
                          {
                            name:"Rajesh",
                            social:90,
                            maths:90,
                            science:78
                          }
                        ]} ;
      $scope.data_count = $scope.students.data.length;


      $scope.add_student = function()
      {
          // Get modal values using Angular's jqLite
          var name = angular.element(document.querySelector("#name"));
          var social_mark = angular.element(document.querySelector("#social"));
          var math_mark = angular.element(document.querySelector("#maths"));
          var science_mark = angular.element(document.querySelector("#science"));

          // Push data to students scope object. Magic is UI will be updated too.

          $scope.students.data.push(
              {
                  name: name.val(),
                  social: social_mark.val(),
                  maths: math_mark.val(),
                  science: science_mark.val()
              }
          );

          // Update student count.
          $scope.data_count += 1;

          // Clear modal
          name.val("");
          social_mark.val("");
          math_mark.val("");
          science_mark.val("");

      }

});
