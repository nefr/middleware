'use strict';

angular.module('myApp.package', ['ngRoute', 'ui.bootstrap'])

    .config(['$routeProvider', function ($routeProvider) {
        $routeProvider.when('/package', {
            templateUrl: 'components/package/package.html',
            controller: 'PackageCtrl'
        });
    }])

    .controller('PackageCtrl', ['$scope', '$http', function ($scope, $http) {
        $scope.accordion = {
            current: null
        };

        $http.get("cms/packages/").success(function (response) {
            $scope.packages = response;
        });

    }]);