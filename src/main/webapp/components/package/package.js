'use strict';

angular.module('myApp.package', ['ngRoute'])

    .config(['$routeProvider', function ($routeProvider) {
        $routeProvider.when('/package', {
            templateUrl: 'components/package/package.html',
            controller: 'PackageCtrl'
        });
    }])

    .controller('PackageCtrl', ['$scope', '$http', function ($scope, $http) {
        //$scope.getPackages = function () {
            $http.get("/demo/packages").success(function (response) {
                $scope.packages = response;
            });
        //};

    }]);