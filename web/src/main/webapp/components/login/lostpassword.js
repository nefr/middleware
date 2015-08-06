'use strict';

angular.module('myApp.lostpassword', ['ngRoute'])
    .config(['$routeProvider', function ($routeProvider) {
        $routeProvider.when('/lostpassword', {
            templateUrl: 'components/login/lostpassword.html'
        });
    }])

    .controller('LostPasswordController', ['$scope', '$http', '$location', function($scope, $http, $location) {


        this.postForm = function() {

            //dummy
        }
    }]);