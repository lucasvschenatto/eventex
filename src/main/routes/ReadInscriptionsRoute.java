package main.routes;

import com.google.gson.Gson;

import main.domain.inscription.reading.InscriptionSummary;
import main.domain.inscription.reading.ReadInscriptionsFilterRequest;
import main.domain.inscription.reading.ReadInscriptionsFilterUseCase;
import main.domain.inscription.reading.ReadInscriptionsUseCase;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.ArrayList;
import java.util.Collection;

public class ReadInscriptionsRoute implements Route {
    private Dependencies dependencies;
    private Gson converter = new Gson();

    public ReadInscriptionsRoute(Dependencies dependencies) {
        this.dependencies = dependencies;
    }

    public Object handle(Request request, Response response) throws Exception {
    	ReadInscriptionsFilterRequest filter = new ReadInscriptionsFilterRequest();
    	filter.activityId = request.queryParams("activity");
        Collection<InscriptionSummary> output = new ArrayList<>();
        if(filter.activityId != null)
        	new ReadInscriptionsFilterUseCase(dependencies.getInscriptionRepository(), filter, output).execute();
        else
        	new ReadInscriptionsUseCase(dependencies.getInscriptionRepository(), output).execute();
        return converter.toJson(output);
    }
}
