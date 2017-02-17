(function() {
	'use strict';
	var app = angular.module(
			'app',
			[ 'ngRoute', 'ngAnimate', 'ui.bootstrap', 'easypiechart',
					'mgo-angular-wizard', 'textAngular', 'ui.tree',
					'ngTagsInput','ui.router',]).config(
			[ '$routeProvider','$stateProvider','$urlRouterProvider',function($routeProvider,$stateProvider,$urlRouterProvider) {

          $urlRouterProvider.otherwise('/');
    
    $stateProvider
        
        .state('home', {
            url: '/',
            templateUrl: 'views/home.html'
        })
        .state('home.accueil', {
            url: 'accueil',
            templateUrl: 'views/accueil.html'
        })
        .state('home.formations', {
            url: 'formations',
            templateUrl: 'views/formation.html',
            controller: 'FormationCtrl'
        })
        .state('home.enseignants', {
            url: 'enseignants',
            templateUrl: 'views/enseignant.html',
            controller: 'EnseignantCtrl'
        })
        .state('home.enseignants.edit', {
            url: '/edit',
            templateUrl: 'views/enseignantEdit.html',
            params : { id: null, },
            controller: 'EnseignantCtrl'
        }).state('home.enseignants.details', {
            url: '/details',
            templateUrl: 'views/enseignantDetails.html',
            params : { id: null, },
            controller: 'EnseignantCtrl'
        })
        .state('home.formations.editfrm', {
            url: '/edit',
            templateUrl: 'views/formationEdit.html',
            params : { idfrm: null, },
            controller: 'FormationCtrl'
        }).state('home.formations.detailsfrm', {
            url: '/details',
            templateUrl: 'views/formationDetails.html',
            params : { idfrm: null, },
            controller: 'FormationCtrl'
        })
         
        // ABOUT PAGE AND MULTIPLE NAMED VIEWS =================================
        .state('login', {
            url: '/login',
            templateUrl: 'views/login.html',
            controller: 'LoginCtrl'
        });
        
}]);

  
}).call(this);
