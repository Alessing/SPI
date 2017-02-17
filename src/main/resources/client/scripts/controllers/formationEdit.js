'use strict';



angular.module('app')
  .service('formationeditSvc', ['$http', function ($http) {

	  this.updateformation = function(fct,obj){
			   $http.put("http://localhost:8181/spi/formation/",obj).then(function(){
				   fct();
			   },function(erreur){
				   console.log("Erreur" + erreur.data);
				   alert("Erreur coté serveur");
			   });
		   };

   this.fetchOne = function(callback,a) {
   		var url = "http://localhost:8181/spi/formation/"+a;
   		$http.get(url).then(function(response){
   			callback(response.data);
   		});
		  
   };


  }]);


angular.module('app')
	  	.controller('FormationEditCtrl', ['$scope','formationeditSvc','$routeParams','$location',function ($scope,formationeditSvc,$routeParams,$location) {
	   		
			$scope.frm = {} ;
			$scope.updateformation = function(){
			formationeditSvc.updateformation(function(){
				swal({
                                title: "Mise à jour effectuée!",
                                text: "La formation a été mise à jour avec succés!",
                                type: "success"
                            },
                            function () 
                            {
								window.location="#/formations";
                            });
			},$scope.frm);
		};

    	formationeditSvc.fetchOne(function(data){
    			$scope.frm=data;

				console.log($scope.frm);
    	},$routeParams.param)
 	  }]);
