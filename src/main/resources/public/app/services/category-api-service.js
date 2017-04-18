angular.module('app.services')
.factory('Category', function($resource) {
	return $resource('/api/v1/categories/:id', { id: '@id' }, {update: {method: 'PUT'}});
})

