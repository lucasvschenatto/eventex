package main.routes;

import com.google.gson.Gson;

import main.domain.participant.reading.ReadParticipantRequest;
import main.domain.participant.reading.ReadParticipantResponse;
import main.domain.participant.reading.ReadParticipantUseCase;
import spark.Request;
import spark.Response;
import spark.Route;

public class ReadParticipantRoute implements Route {
    private Dependencies dependencies;
    private Gson converter = new Gson();

    public ReadParticipantRoute(Dependencies dependencies) {
        this.dependencies = dependencies;
    }

    public Object handle(Request request, Response response) throws Exception {
        ReadParticipantResponse output = executeUseCase(request);
        if(!output.success) response.status(404);
        return converter.toJson(output);
    }
    
    private ReadParticipantResponse executeUseCase(Request request) {
    	ReadParticipantRequest input = new ReadParticipantRequest();
    	input.id = request.cookie("participant-id");
    	ReadParticipantResponse output = new ReadParticipantResponse();
    	new ReadParticipantUseCase(dependencies.getParticipantRepository(), input, output).execute();
        return output;
    }
}
