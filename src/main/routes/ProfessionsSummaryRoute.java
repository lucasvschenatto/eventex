package main.routes;

import com.google.gson.Gson;

import main.domain.profession.reading.ProfessionSummary;
import main.domain.profession.reading.ReadProfessionsSummaryUseCase;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.ArrayList;
import java.util.Collection;

public class ProfessionsSummaryRoute implements Route {
    private Dependencies dependencies;
    private Gson converter = new Gson();

    public ProfessionsSummaryRoute(Dependencies dependencies) {
        this.dependencies = dependencies;
    }

    public Object handle(Request request, Response response) throws Exception {
        Collection<ProfessionSummary> output = new ArrayList<>();
        new ReadProfessionsSummaryUseCase(dependencies.getProfessionRepository(), output).execute();
        return converter.toJson(output);
    }
}
