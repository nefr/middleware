'use strict';

angular.module('myApp.signup', ['ngRoute'])
    .config(['$routeProvider', function ($routeProvider) {
        $routeProvider.when('/signup', {
            templateUrl: 'components/login/signup.html'
        });
    }])

    .controller('SignupController', ['$scope', '$http', '$location', function($scope, $http, $location) {


        this.postForm = function() {
            //dummy
        }
    }]);