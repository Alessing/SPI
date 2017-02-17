'use strict';



angular.module('app')
  .service('formationSvc', ['$http', function ($http) {
   this.fetchPopular = function(callback) {
   		var url = "http://localhost:8181/spi/formation/";
   		$http.get(url).then(function(response){
   			callback(response.data);
   		});
	};
		   this.createFormation = function(fct,obj){
			   //obj["Content-Type"] = "application/json";
			   $http.post("http://localhost:8181/spi/formation/",obj).then(function(){
				   fct();
			   },function(erreur){
				   console.log("Erreur" + erreur.data);
				   alert("Erreur coté serveur");
			   });
		   }
		   this.supprimerFormation = function(fct,codeFormation){
			   $http.delete("http://localhost:8181/spi/formation/" + codeFormation).then(function(){
				   fct();
			   },function(erreur){
				   console.log("Erreur" + erreur.data);
				   alert("Erreur coté serveur");
			   });
		   };
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

   this.fetchDetails = function(callback,a) {
   		var url = "http://localhost:8181/spi/formation/"+a;
   		$http.get(url).then(function(response){
   			callback(response.data);
   		});	  
   };
		
  }]);


angular.module('app')
	  	.controller('FormationCtrl', ['$scope','formationSvc','$stateParams',function ($scope,formationSvc,$stateParams) {
	    $scope.formation = {} ;
		$scope.frm = {} ;
		$scope.ajouterFormation = function(){
			formationSvc.createFormation(function(){
				swal({
                                title: "Ajout effectué!",
                                text: "La formation a été ajoutée avec succés!",
                                type: "success"
                            },
                            function () 
                            {
                                location.reload();
                            });
			},$scope.formation);
		};

		$scope.updateformation = function(){
			formationSvc.updateformation(function(){
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

		$scope.supprimerFormation = function(codeFormation){
			formationSvc.supprimerFormation(function(){
				swal({
                                title: "Suppression effectuée!",
                                text: "La formation a été supprimée avec succés!",
                                type: "success"
                            },
                            function () 
                            {
                                location.reload();
                            });
			},codeFormation);
		};

		formationSvc.fetchDetails(function(data){
    			$scope.frm=data;

				console.log($scope.frm);
    	},$stateParams.idfrm);
    
		$scope.formations=[];
    	formationSvc.fetchPopular(function(data){
    			$scope.formations=data;
                console.log(data);
    	})
 	  }]);
