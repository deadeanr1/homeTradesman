'use strict'
angular.module('app.services', [])
.service('AuthService', function() {
	return {
		user : null,
		authorization: null,
	}
})
.factory('AuthInterceptor', function($rootScope, AuthService, localStorageService) {
	var service = this;
    service.request = function(config) {
    	if(!AuthService.user){
    		var auth = localStorageService.get('AuthService');
    		if (auth){
    			AuthService.user = auth.user;
    			$rootScope.user = auth.user;
    			AuthService.authorization = auth.authorization;
    		}
    	}

        if (AuthService.authorization) {
        	if (!config.headers.Authorization)
        		config.headers.Authorization = AuthService.authorization;
        }
        return config;
    };
    return service;
})