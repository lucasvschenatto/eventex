angular.module("eventex").factory("categoriesAPI", function ($http, config){
	var _getCategories = function(){
		return $http.get(config.baseUrl+"/categories");
	};
	var _getCategory = function(id){
		return $http.get(config.baseUrl+"/categories/"+id);
	}
	var _saveCategory = function(category){
		return $http.post(config.baseUrl+"/categories", category) 
	};
	var _deleteCategory = function(category){
		$http.delete(config.baseUrl+"/categories/"+category.id, {});
	}
	
	return {
		getCategories: _getCategories,
		getCategory: _getCategory,
		saveCategory: _saveCategory,
		deleteCategory: _deleteCategory
	};
});