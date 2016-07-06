package main.routes;

import com.google.gson.Gson;

import main.domain.participant.reading.ParticipantSummary;
import main.domain.participant.reading.ReadParticipantsUseCase;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.ArrayList;
import java.util.Collection;

public class ReadParticipantsRoute implements Route {
    private Dependencies dependencies;
    private Gson converter = new Gson();

    public ReadParticipantsRoute(Dependencies dependencies) {
        this.dependencies = dependencies;
    }

    public Object handle(Request request, Response response) throws Exception {
        Collection<ParticipantSummary> output = new ArrayList<>();
        new ReadParticipantsUseCase(dependencies.getParticipantRepository(), output).execute();
        return converter.toJson(output);
    }
}
