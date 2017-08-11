'use strict';

/**
 * @ngdoc overview
 * @name simpleErpClientApp
 * @description
 * # simpleErpClientApp
 *
 * Main module of the application.
 */
angular
  .module('simpleErpClientApp', [
    'ngAnimate',
    'ngCookies',
    'ngResource',
    'ngRoute',
    'ngSanitize',
    'ngTouch'
  ])
  .config(function ($routeProvider) {
    $routeProvider
      .when('/', {
        templateUrl: 'views/list.html',
        controller: 'MainCtrl',
        controllerAs: 'main'
      })
      .when('/about', {
        templateUrl: 'views/about.html',
        controller: 'AboutCtrl',
        controllerAs: 'about'
      })
      .otherwise({
        redirectTo: '/'
      });
  })
  .config(['$locationProvider', function($locationProvider) {
    $locationProvider.hashPrefix("");
  }]);
