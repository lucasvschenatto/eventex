package main.routes;

import com.google.gson.Gson;

import main.domain.inscription.reading.InscriptionSummary;
import main.domain.inscription.reading.ReadInscriptionsSummaryUseCase;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.ArrayList;
import java.util.Collection;

public class InscriptionsSummaryRoute implements Route {
    private Dependencies dependencies;
    private Gson converter = new Gson();

    public InscriptionsSummaryRoute(Dependencies dependencies) {
        this.dependencies = dependencies;
    }

    public Object handle(Request request, Response response) throws Exception {
        Collection<InscriptionSummary> output = new ArrayList<>();
        new ReadInscriptionsSummaryUseCase(dependencies.getInscriptionRepository(), output).execute();
        return converter.toJson(output);
    }
}
