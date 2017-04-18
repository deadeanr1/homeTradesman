'use strict'
angular.module('app.controllers',[])
.controller('navController', function($http, $scope, AuthService, $state, $rootScope) {
	$scope.isUrl = function(url) {
			if (url === '#') return false;
			return ('#' + $state.$current.url.source + '/').indexOf(url + '/') === 0;
		};
    $scope.login = function() {
            var base64Credential = btoa($scope.user.username + ':' + $scope.user.password);
           // AuthService.authorization = 'Basic ' + base64Credential;
             var  headers = {"Authorization": "Basic " + base64Credential};
            $http({url:'login',
                    method: 'GET',
                    headers:headers}).success(function(res) {
          /*  $http.post('/login', {
                       username: $scope.user.username,
                       password: $scope.user.password
                   })*/
                if (res.authenticated) {
                    $scope.message = null;
                    AuthService.user = res;
                    $rootScope.user = AuthService.user;
                    localStorageService.set('AuthService',{'user':AuthService.user,'authorization':AuthService.authorization})
                    $state.go('home');
                } else {
                    $scope.message = 'Wrong credentials.';
                }
            }).error(function(error) {
                $scope.message = 'Wrong credentials.';
            });
        };

        $scope.logout = function(){
            $rootScope.user = null;
            AuthService.user = null;
            AuthService.authorization = null;
            localStorageService.remove('AuthService');
            $state.go('login');
        };
});