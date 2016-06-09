package main.routes;

import com.google.gson.Gson;

import main.domain.covenant.reading.CovenantSummary;
import main.domain.covenant.reading.ReadCovenantsSummaryUseCase;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.ArrayList;
import java.util.Collection;

public class CovenantsSummaryRoute implements Route {
    private Dependencies dependencies;
    private Gson converter = new Gson();

    public CovenantsSummaryRoute(Dependencies dependencies) {
        this.dependencies = dependencies;
    }

    public Object handle(Request request, Response response) throws Exception {
        Collection<CovenantSummary> output = new ArrayList<>();
        new ReadCovenantsSummaryUseCase(dependencies.getCovenantRepository(), output).execute();
        return converter.toJson(output);
    }
}
