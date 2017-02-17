'use strict';



angular.module('app')
  .service('candidatSvc', ['$http', function ($http) {
   this.fetchPopular = function(callback) {
   		var url = "http://localhost:8181/spi/candidat/";
   		$http.get(url).then(function(response){
   			callback(response.data);
   		});
		   this.createFormation = function(fct,obj){
			   //obj["Content-Type"] = "application/json";
			   $http.post("http://localhost:8181/spi/candidat/",obj).then(function(){
				   fct();
			   },function(erreur){
				   console.log("Erreur" + erreur.data);
				   alert("Erreur coté serveur");
			   });
		   }
		   this.supprimerFormation = function(fct,noCandidat){
			   $http.delete("http://localhost:8181/spi/candidat/" + noCandidat).then(function(){
				   fct();
			   },function(erreur){
				   console.log("Erreur" + erreur.data);
				   alert("Erreur coté serveur");
			   });
		   }
   };

  }]);


angular.module('app')
	  	.controller('CandidatCtrl', ['$scope','candidatSvc',function ($scope,candidatSvc) {
	    $scope.candidat = {} ;
		$scope.formation.codeFormation = "";
		$scope.formation.diplome = "";
		$scope.formation.debutAccreditation = "";
		$scope.formation.doubleDiplome = "";
		$scope.formation.finAccreditation = "";
		$scope.formation.n0Annee = "";
		$scope.formation.nomFormation = "";

		$scope.ajouterFormation = function(){
			candidatSvc.createFormation(function(){
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

		$scope.supprimerFormation = function(codeFormation){
			candidatSvc.supprimerFormation(function(){
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

		$scope.formations=[];
    	candidatSvc.fetchPopular(function(data){
    			$scope.formations=data;
                console.log(data);
    	})
 	  }]);
