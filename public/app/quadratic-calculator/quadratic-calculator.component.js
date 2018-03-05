'use strict';

// Register `quadraticCalculator` component, along with its associated controller and template
angular.
  module('quadraticCalculator').
  component('quadraticCalculator', {
    templateUrl: 'quadratic-calculator/quadratic-calculator.template.html',
    controller: function QuadraticCalculatorController($http) {
    	var self = this;

    	this.calculate = calculate; // make the calculate function available to the template



		function calculate() {

			self.x1 = '';
		    self.x2 = '';
		    var coeffa = self.coeffa;
		    var coeffb = self.coeffb;
		    var coeffc = self.coeffc;
		    if(validInputs(coeffa, coeffb, coeffc)) {
		        $http({
		            method: "GET",
		            url: 'http://localhost:8080/quadratic_equation',
		            params: {
		                a: coeffa,
		                b: coeffb,
		                c: coeffc
		            }
		        })
		        .success(function(data) {
		            console.log(data);
		            
		            if(data.x2 === "") {//only 1 x intercept
		                self.x1 = "x = " + data.x1;
		            } else {
		                self.x1 = "x1 = " + data.x1;
		                self.x2 = "x2 = " + data.x2;
		            }
		        })
		        .error(function(data) {
		            console.log("Error: " + data);
		        });
		    } else {
		        self.x1 = "Invalid inputs";
		    }
		}

      	function validInputs(a, b, c) {
		    return !!a && !!b && !!c //needed for empty values
		    && !isNaN(Number(a)) && !isNaN(Number(b)) && !isNaN(Number(c));
		}
    }
  });
