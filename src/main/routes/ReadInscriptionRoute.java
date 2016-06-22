package main.routes;

import com.google.gson.Gson;

import main.domain.inscription.reading.ReadInscriptionRequest;
import main.domain.inscription.reading.InscriptionSummary;
import main.domain.inscription.reading.ReadInscriptionUseCase;
import spark.Request;
import spark.Response;
import spark.Route;

public class ReadInscriptionRoute implements Route {
    private Dependencies dependencies;
    private Gson converter = new Gson();

    public ReadInscriptionRoute(Dependencies dependencies) {
        this.dependencies = dependencies;
    }

    public Object handle(Request request, Response response) throws Exception {
    	ReadInscriptionRequest input = new ReadInscriptionRequest();
    	input.id = request.params(":id");
        InscriptionSummary output = new InscriptionSummary();
        new ReadInscriptionUseCase(dependencies.getInscriptionRepository(), input, output).execute();
        return converter.toJson(output);
    }
}
