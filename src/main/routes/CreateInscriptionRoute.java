package main.routes;

import com.google.gson.Gson;

import main.domain.inscription.creating.CreateInscriptionRequest;
import main.domain.inscription.creating.CreateInscriptionResponse;
import main.domain.inscription.creating.CreateInscriptionUseCase;
import spark.Request;
import spark.Response;
import spark.Route;

public class CreateInscriptionRoute implements Route {
    private Dependencies dependencies;
    private Gson converter = new Gson();

    public CreateInscriptionRoute(Dependencies dependencies) {
        this.dependencies = dependencies;
    }

    public Object handle(Request request, Response response) throws Exception {
    	CreateInscriptionRequest input = converter.fromJson(request.body(), CreateInscriptionRequest.class);
        CreateInscriptionResponse output = new CreateInscriptionResponse();
        new CreateInscriptionUseCase(dependencies.getInscriptionRepository(),
        		dependencies.getParticipantRepository(), dependencies.getActivityRepository(),
        		dependencies.getCategoryRepository(), dependencies.getAssociateRepository(),
        		input, output).execute();
        if(output.success)
        	response.status(201);
        else
        	response.status(422);
        return converter.toJson(output);
    }
}
