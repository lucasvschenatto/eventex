package main.routes;

import com.google.gson.Gson;

import main.domain.category.creating.CreateCategoryRequest;
import main.domain.category.creating.CreateCategoryResponse;
import main.domain.category.creating.CreateCategoryUseCase;
import spark.Request;
import spark.Response;
import spark.Route;

public class CreateCategoryRoute implements Route {
    private Dependencies dependencies;
    private Gson converter = new Gson();

    public CreateCategoryRoute(Dependencies dependencies) {
        this.dependencies = dependencies;
    }

    public Object handle(Request request, Response response) throws Exception {
    	CreateCategoryRequest input = converter.fromJson(request.body(), CreateCategoryRequest.class);
        CreateCategoryResponse output = new CreateCategoryResponse();
        if(input!=null)
			new CreateCategoryUseCase(dependencies.getCategoryRepository(), input, output).execute();
        if(output.success)
        	response.status(201);
        else
        	response.status(200);
        return converter.toJson(output);
    }
}