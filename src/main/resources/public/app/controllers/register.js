angular.module('app.controllers')
.controller('RegisterController',function($scope, $http){
	$scope.user = {};
	$scope.showrole = false;
	$scope.show = true;
	$scope.required = true;
	$scope.roles = ['ROLE_USER','ROLE_TRADESMAN', 'ROLE_ADMIN'];
	$scope.user.role='ROLE_ADMIN'
	$scope.registerUser = function(){
		if($scope.user.password != $scope.user.confirmpassword)
			$scope.error = 'Password Not Matching';
		else
			$http.post('register', $scope.user).success(function(res) {
				$scope.success = 'Registration successfull!';
				$scope.user = {};
			}).error(function(error) {
				$scope.error = error.message;
			});
	}
})