'use strict';



angular.module('app')
  .service('enseignantSvc', ['$http', function ($http) {
	  
   this.fetchPopular = function(callback) {
   		var url = "http://localhost:8181/spi/enseignant/";
   		$http.get(url).then(function(response){
   			callback(response.data);
   		});
   };
		   this.createEnseignant = function(fct,obj){
			   $http.post("http://localhost:8181/spi/enseignant/",obj).then(function(){
				   fct();
			   },function(erreur){
				   console.log("Erreur" + erreur.data);
				   alert("Erreur coté serveur");
			   });
		   }
		   this.supprimerEnseignant = function(fct,codeEnseignant){
			   $http.delete("http://localhost:8181/spi/enseignant/" + codeEnseignant).then(function(){
				   fct();
			   },function(erreur){
				   console.log("Erreur" + erreur.data);
				   alert("Erreur coté serveur");
			   });
		   }
		   this.updateenseignant = function(fct,obj){
			   $http.put("http://localhost:8181/spi/enseignant/",obj).then(function(){
				   fct();
			   },function(erreur){
				   console.log("Erreur" + erreur.data);
				   alert("Erreur coté serveur");
			   });
		   };
   

   this.fetchDetails = function(callback,a) {
   		var url = "http://localhost:8181/spi/enseignant/"+a;
   		$http.get(url).then(function(response){
   			callback(response.data);
   		});
		  
   };

    this.fetchproms = function(callback,a) {
   		var url = "http://localhost:8181/spi/promotion/getbyens/"+a;
   		$http.get(url).then(function(response){
   			callback(response.data);
   		});	  
   };
		

  }]);


angular.module('app')
	  	.controller('EnseignantCtrl', ['$scope','enseignantSvc','$stateParams',function ($scope,enseignantSvc,$stateParams) {

		$scope.ens={};
		$scope.ensedit={};

		if($stateParams.id != null)
			{
				enseignantSvc.fetchDetails(function(data){
						$scope.enseignantdetails=data;
				},$stateParams.id);

				enseignantSvc.fetchproms(function(data){
					$scope.proms=data;
				},$stateParams.id);
			}
			
		$scope.ajouterEnseignant = function(){
			enseignantSvc.createEnseignant(function(){
				swal({
                                title: "Ajout effectué!",
                                text: "L'enseignant a été ajoutée avec succés!",
                                type: "success"
                            },
                            function () 
                            {
                                location.reload();
                            });
			},$scope.ens);
		};

		$scope.supprimerEnseignant = function(codeEnseignant){
			enseignantSvc.supprimerEnseignant(function(){
				swal({
                                title: "Suppression effectuée!",
                                text: "L'enseignant a été supprimée avec succés!",
                                type: "success"
                            },
                            function () 
                            {
                                location.reload();
                            });
			},codeEnseignant);
		};

			$scope.updateenseignant = function(){
				console.log($scope.enseignantdetails);
			enseignantSvc.updateenseignant(function(){
				swal({
                                title: "Mise à jour effectuée!",
                                text: "L'enseignant a été mis à jour avec succés!",
                                type: "success"
                            },
                            function () 
                            {
								window.location="#/enseignants";
                            });
			},$scope.enseignantdetails);
		};

		
		
		$scope.enseignants=[];
    	enseignantSvc.fetchPopular(function(data){
    			$scope.enseignants=data;
    	})
 	  }]);
