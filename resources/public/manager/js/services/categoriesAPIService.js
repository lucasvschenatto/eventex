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
		getCategories: _getCategories,
		getCategory: _getCategory,
		createCategory: _createCategory,
		updateCategory: _updateCategory,
		deleteCategory: _deleteCategory
	};
});