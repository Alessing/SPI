'use strict';



angular.module('app')
  .service('formationDetailSvc', ['$http', function ($http) {

    

   this.fetchDetails = function(callback,a) {
   		var url = "http://localhost:8181/spi/formation/"+a;
   		$http.get(url).then(function(response){
   			callback(response.data);
   		});	  
   };
   }]);

   angular.module('app')
	  	.controller('FormationDetailCtrl', ['$scope','formationDetailSvc','$routeParams',function ($scope,formationDetailSvc,$routeParams) {


    	formationDetailSvc.fetchDetails(function(data){
    			$scope.frm=data;

				console.log($scope.frm);
    	},$routeParams.param1);

         	 }]);
