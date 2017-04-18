angular.module('app.controllers')
.controller('searchCategoriesController', function($scope, $state, $window, Category, AuthService) {
	$scope.categories = Category.query();

	if(!AuthService.user)
		$scope.message = 'You are not logged in.';

		    $scope.setCategory = function(category) {
                $scope.category = category.title;
            };

})