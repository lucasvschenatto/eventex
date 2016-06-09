package main.routes;

import com.google.gson.Gson;

import main.domain.category.reading.ParticipantCategorySummary;
import main.domain.category.reading.ReadParticipantCategoriesSummaryUseCase;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.ArrayList;
import java.util.Collection;

public class ParticipantCategoriesSummaryRoute implements Route {
    private Dependencies dependencies;
    private Gson converter = new Gson();

    public ParticipantCategoriesSummaryRoute(Dependencies dependencies) {
        this.dependencies = dependencies;
    }

    public Object handle(Request request, Response response) throws Exception {
        Collection<ParticipantCategorySummary> output = new ArrayList<>();
        new ReadParticipantCategoriesSummaryUseCase(dependencies.getCategoryRepository(), output).execute();
        return converter.toJson(output);
    }
}
