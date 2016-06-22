package main.routes;

import com.google.gson.Gson;

import main.domain.participant.reading.ReadParticipantRequest;
import main.domain.participant.reading.ParticipantSummary;
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
    	ReadParticipantRequest input = new ReadParticipantRequest();
    	input.id = request.params(":id");
        ParticipantSummary output = new ParticipantSummary();
        new ReadParticipantUseCase(dependencies.getParticipantRepository(), input, output).execute();
        return converter.toJson(output);
    }
}
