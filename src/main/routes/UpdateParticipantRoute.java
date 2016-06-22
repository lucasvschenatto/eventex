package main.routes;

import com.google.gson.Gson;

import main.domain.participant.updating.UpdateParticipantRequest;
import main.domain.participant.updating.UpdateParticipantResponse;
import main.domain.participant.updating.UpdateParticipantUseCase;
import spark.Request;
import spark.Response;
import spark.Route;

public class UpdateParticipantRoute implements Route {
    private Dependencies dependencies;
    private Gson converter = new Gson();

    public UpdateParticipantRoute(Dependencies dependencies) {
        this.dependencies = dependencies;
    }

    public Object handle(Request request, Response response) throws Exception {
    	UpdateParticipantRequest input = converter.fromJson(request.body(), UpdateParticipantRequest.class);
    	input.id = request.params(":id");
        UpdateParticipantResponse output = new UpdateParticipantResponse();
        new UpdateParticipantUseCase(dependencies.getParticipantRepository(), input, output).execute();
        return converter.toJson(output);
    }
}
