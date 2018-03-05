'use strict';

describe('quadraticCalculator', function() {

  // Load the module that contains the `phoneList` component before each test
  beforeEach(module('quadraticCalculator'));

  // Test the controller
  describe('QuadraticCalculatorController', function() {
    var $httpBackend, ctrl;

    // The injector ignores leading and trailing underscores here (i.e. _$httpBackend_).
    // This allows us to inject a service and assign it to a variable with the same name
    // as the service while avoiding a name conflict.
    beforeEach(inject(function($componentController, _$httpBackend_) {
      $httpBackend = _$httpBackend_;
      ctrl = $componentController('quadraticCalculator');
    }));

    it('should set x1 to -0.2 and x2 to -1', function() {
      $httpBackend.expectGET('http://localhost:8080/quadratic_equation?a=5&b=6&c=1')
                  .respond({x1: '-0.2', x2: '-1'});
      ctrl.coeffa = "5";
      ctrl.coeffb = "6";
      ctrl.coeffc = "1";
      ctrl.calculate()
      $httpBackend.flush();
      expect(ctrl.x1).toEqual('x1 = -0.2');
      expect(ctrl.x2).toEqual('x2 = -1');
    });

    it('should set x1 to -3', function() {
      $httpBackend.expectGET('http://localhost:8080/quadratic_equation?a=1&b=6&c=9')
                  .respond({x1: '-3', x2: ''});
      ctrl.coeffa = "1";
      ctrl.coeffb = "6";
      ctrl.coeffc = "9";
      ctrl.calculate()
      $httpBackend.flush();
      expect(ctrl.x1).toEqual('x = -3');
      expect(ctrl.x2).toEqual('');
    });

    it('should set x1 to Invalid inputs', function() {
      ctrl.coeffa = "";
      ctrl.coeffb = "6";
      ctrl.coeffc = "9";
      ctrl.calculate()
      expect(ctrl.x1).toEqual('Invalid inputs');
      expect(ctrl.x2).toEqual('');
    });

  });

});