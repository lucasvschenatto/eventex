package main.routes;

import com.google.gson.Gson;

import main.domain.associate.reading.AssociateSummary;
import main.domain.associate.reading.ReadAssociatesSummaryUseCase;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.ArrayList;
import java.util.Collection;

public class AssociatesSummaryRoute implements Route {
    private Dependencies dependencies;
    private Gson converter = new Gson();

    public AssociatesSummaryRoute(Dependencies dependencies) {
        this.dependencies = dependencies;
    }

    public Object handle(Request request, Response response) throws Exception {
        Collection<AssociateSummary> output = new ArrayList<>();
        new ReadAssociatesSummaryUseCase(dependencies.getAssociateRepository(), output).execute();
        return converter.toJson(output);
    }
}
