angular.module("eventex").factory("categoriesAPI", function ($http){
	var _getCategories = function(){
		return $http.get("/categories");
	};
	var _getCategory = function(id){
		return $http.get("/categories/"+id);
	}
	var _createCategory = function(category){
		return $http.post("/categories", category) 
	};
	var _updateCategory = function(category){
		return $http.put("/categories/"+category.id, category) 
	};
	var _deleteCategory = function(category){
		$http.delete("/categories/"+category.id, {});
	}
	
	return {
		getAll: _getCategories,
		get: _getCategory,
		create: _createCategory,
		update: _updateCategory,
		delete: _deleteCategory
	};
});