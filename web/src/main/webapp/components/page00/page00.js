'use strict';

angular.module('myApp.page00', ['ngRoute'])

    .config(['$routeProvider', function ($routeProvider) {
      $routeProvider.when('/page00', {
        templateUrl: 'components/page00/page00.html',
        controller: 'Page00'
      });
    }])

    .controller('Page00', ['$scope', '$http', function ($scope, $http) {
      //$http.get("/cms/packages/channels/").success(function (response) {
      //  $scope.channels = response;
      //});
    }]);