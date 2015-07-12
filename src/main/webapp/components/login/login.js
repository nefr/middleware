'use strict';

angular.module('myApp.authentication', ['ngRoute'])
    .config(['$routeProvider', function ($routeProvider) {
        $routeProvider.when('/login', {
            templateUrl: 'components/login/login.html'
        });
    }])

    .controller('LoginController', ['$scope', '$http', '$location', function($scope, $http, $location) {


          this.postForm = function() {

              var dataObj = {
                  "username" : this.inputData.username,
                  "password" : this.inputData.password
              };

              $http.post('/cms/login/login', dataObj)
                    .success(function(data, status, headers, config) {
                      console.log(data);
                      if(data != "") {
                          $location.path('/package');
                      }else{
                          $scope.errorMsg = "Login not correct";
                      }
                    })
                    .error(function(data, status, headers, config) {
                        $scope.errorMsg = "Login failed";
                    })
          }
        }]);