'use strict';

angular.module('myApp.channel', ['ngRoute'])

    .config(['$routeProvider', function ($routeProvider) {
        $routeProvider.when('/channel', {
            templateUrl: 'components/channel/channel.html',
            controller: 'ChannelCtrl'
        });
    }])

    .controller('ChannelCtrl', ['$scope', '$http', function ($scope, $http) {
        $scope.getChannels = function () {
            $http.get("/demo/packages/channels").success(function (response) {
                $scope.channels = response;
            });
        }
    }]);