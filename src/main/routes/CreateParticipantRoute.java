package main.routes;

import com.google.gson.Gson;

import main.domain.participant.creating.CreateParticipantRequest;
import main.domain.participant.creating.CreateParticipantResponse;
import main.domain.participant.creating.CreateParticipantUseCase;
import spark.Request;
import spark.Response;
import spark.Route;

public class CreateParticipantRoute implements Route {
    private Dependencies dependencies;
    private Gson converter = new Gson();

    public CreateParticipantRoute(Dependencies dependencies) {
        this.dependencies = dependencies;
    }

    public Object handle(Request request, Response response) throws Exception {
    	CreateParticipantRequest input = converter.fromJson(request.body(), CreateParticipantRequest.class);
        CreateParticipantResponse output = new CreateParticipantResponse();
        new CreateParticipantUseCase(dependencies.getParticipantRepository(), input, output).execute();
        return converter.toJson(output);
    }
}