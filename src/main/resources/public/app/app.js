'use strict';
var app = angular
    .module('app',['ui.router',
                  // 'navController',
                  //  'ngAnimate',
                    'ui.bootstrap',
                    'ngResource',
                    'app.controllers',
                    'app.services',
                    'multipleSelect',
                    'LocalStorageModule'])
    .config(function($stateProvider, $urlRouterProvider,
    $controllerProvider, $httpProvider, localStorageServiceProvider){
		localStorageServiceProvider.setPrefix('Suntehnicv1');
		$httpProvider.interceptors.push('AuthInterceptor');
		$httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';

		var viewsPrefix = 'app/html/';

		$urlRouterProvider
			.otherwise("/")

		$stateProvider
			// you can set this to no template if you just want to use the html in the page
			.state('home', {
				url: "/",
				templateUrl: viewsPrefix + "home.html",
				data: {
					pageTitle: 'Home'
				}
			})
			.state('login', {
				url: "/login",
				templateUrl: viewsPrefix + "login.html",
				controller: 'navController'
			})
			.state('register', {
				url: "/register",
				templateUrl: viewsPrefix + "register.html",
				controller: 'RegisterController'
			})
	})
	.directive('updateTitle', ['$rootScope', '$timeout',
		function($rootScope, $timeout) {
			return {
				link: function(scope, element) {
					var listener = function(event, toState) {
						var title = 'Project Name';
						if (toState.data && toState.data.pageTitle) title = toState.data.pageTitle + ' - ' + title;
						$timeout(function() {
							element.text(title);
						}, 0, false);
					};

					$rootScope.$on('$stateChangeSuccess', listener);
				}
			};
		}
	]);
