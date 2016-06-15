package main.routes;

import com.google.gson.Gson;

import main.domain.participant.reading.ParticipantSummary;
import main.domain.participant.reading.ReadParticipantsSummaryUseCase;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.ArrayList;
import java.util.Collection;

public class ParticipantsSummaryRoute implements Route {
    private Dependencies dependencies;
    private Gson converter = new Gson();

    public ParticipantsSummaryRoute(Dependencies dependencies) {
        this.dependencies = dependencies;
    }

    public Object handle(Request request, Response response) throws Exception {
        Collection<ParticipantSummary> output = new ArrayList<>();
        new ReadParticipantsSummaryUseCase(dependencies.getParticipantRepository(), output).execute();
        return converter.toJson(output);
    }
}
