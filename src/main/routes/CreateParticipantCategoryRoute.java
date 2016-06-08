package main.routes;

import com.google.gson.Gson;

import main.domain.participantCategory.creating.CreateParticipantCategoryRequest;
import main.domain.participantCategory.creating.CreateParticipantCategoryResponse;
import main.domain.participantCategory.creating.CreateParticipantCategoryUseCase;
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
        new CreateParticipantCategoryUseCase(dependencies.getParticipantCategoryRepository(), input, output).execute();
        return converter.toJson(output);
    }
}
