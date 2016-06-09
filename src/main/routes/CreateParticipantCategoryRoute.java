package main.routes;

import com.google.gson.Gson;

import main.domain.category.creating.CreateParticipantCategoryRequest;
import main.domain.category.creating.CreateParticipantCategoryResponse;
import main.domain.category.creating.CreateParticipantCategoryUseCase;
import spark.Request;
import spark.Response;
import spark.Route;

public class CreateParticipantCategoryRoute implements Route {
    private Dependencies dependencies;
    private Gson converter = new Gson();

    public CreateParticipantCategoryRoute(Dependencies dependencies) {
        this.dependencies = dependencies;
    }

    public Object handle(Request request, Response response) throws Exception {
    	CreateParticipantCategoryRequest input = converter.fromJson(request.body(), CreateParticipantCategoryRequest.class);
        CreateParticipantCategoryResponse output = new CreateParticipantCategoryResponse();
        new CreateParticipantCategoryUseCase(dependencies.getCategoryRepository(), input, output).execute();
        return converter.toJson(output);
    }
}
