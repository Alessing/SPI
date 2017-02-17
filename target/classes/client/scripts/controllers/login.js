'use strict';



angular.module('app')
  .service('loginSvc', ['$http',  function ($http) {
   
		   this.authentifier = function(fct,obj){
			   //obj["Content-Type"] = "application/json";
			   $http.post("http://localhost:8181/spi/auth/",obj).then(function(){
				   fct();
			   },function(erreur){
				   console.log("Erreur" + erreur.data);
				   alert("Erreur coté serveur");
			   });
		   };
		  

		

  }]);


angular.module('app')
	  	.controller('LoginCtrl', ['$scope','loginSvc',function ($scope,loginSvc) {
	    
		$scope.user = {} ;
	$scope.authentifier = function(){
    	loginSvc.authentifier(function(data){
    			$scope.user=data;
				window.location="#/accueil";
    	},$scope.user)
	}
 	  }]);
