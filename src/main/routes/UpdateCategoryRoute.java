package main.routes;

import com.google.gson.Gson;

import main.domain.category.updating.UpdateCategoryRequest;
import main.domain.category.updating.UpdateCategoryResponse;
import main.domain.category.updating.UpdateCategoryUseCase;
import spark.Request;
import spark.Response;
import spark.Route;

public class UpdateCategoryRoute implements Route {
    private Dependencies dependencies;
    private Gson converter = new Gson();

    public UpdateCategoryRoute(Dependencies dependencies) {
        this.dependencies = dependencies;
    }

    public Object handle(Request request, Response response) throws Exception {
    	UpdateCategoryRequest input = converter.fromJson(request.body(), UpdateCategoryRequest.class);
    	input.id = request.params(":id");
        UpdateCategoryResponse output = new UpdateCategoryResponse();
        new UpdateCategoryUseCase(dependencies.getCategoryRepository(), input, output).execute();
        if(!output.success) response.status(404);
        return converter.toJson(output);
    }
}
