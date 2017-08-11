'use strict';

/**
 * @ngdoc function
 * @name simpleErpClientApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the simpleErpClientApp
 */
angular.module('simpleErpClientApp')
  .controller('MainCtrl', function ($scope) {
    $scope.customers = [
      {displayName: "Simon Huang", customerType: "CORPORATE CUSTOMER", email: "simon.huang@sap.com", phone: "13800000000"},
      {displayName: "Echo Liang", customerType: "INDIViDUAL CUSTOMER", email: "echo.liang@sap.com", phone: "13900000000"}
    ]
  });
