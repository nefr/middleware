'use strict';

// Declare app level module which depends on views, and components
angular.module('myApp', [
  'ngRoute',
  'myApp.authentication',
  'myApp.lostpassword',
  'myApp.signup',
  'myApp.package',
  'myApp.channel',
  'myApp.page00'
]).
    config(['$routeProvider', function($routeProvider) {
      $routeProvider.otherwise({redirectTo: '/login'});
    }])
    .controller('coreSettingsCtrl', ['$scope', '$rootScope', '$location', function($scope, $rootScope, $location) {
      $scope.core = {
        name: '',
        version: '0.0.1',
        settings: {
          fullScreen: false,
          pageLoading: false,
          headerFixed: true,
          headerSearchForm: false,
          sidebarLeftOpen: false,
          sidebarLeftFixed: false,
          sidebarLeftCollapse: true
        }
      };

      /** hide sidebar and show loading indicator */
      $rootScope.$on('$stateChangeStart', function () {
        $scope.core.settings.sidebarLeftOpen = false;
        $scope.core.settings.pageLoading = true;
      });

      /** show loading indicator */
      $rootScope.$on('$stateChangeSuccess', function () {
        $scope.core.settings.pageLoading = false;
      });

    }]);
