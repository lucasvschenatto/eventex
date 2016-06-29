package main.routes;

import com.google.gson.Gson;

import main.domain.inscription.updating.UpdateInscriptionRequest;
import main.domain.inscription.updating.UpdateInscriptionResponse;
import main.domain.inscription.updating.UpdateInscriptionUseCase;
import spark.Request;
import spark.Response;
import spark.Route;

public class UpdateInscriptionRoute implements Route {
    private Dependencies dependencies;
    private Gson converter = new Gson();

    public UpdateInscriptionRoute(Dependencies dependencies) {
        this.dependencies = dependencies;
    }

    public Object handle(Request request, Response response) throws Exception {
    	UpdateInscriptionRequest input = converter.fromJson(request.body(), UpdateInscriptionRequest.class);
    	input.id = request.params(":id");
        UpdateInscriptionResponse output = new UpdateInscriptionResponse();
        new UpdateInscriptionUseCase(dependencies.getInscriptionRepository(),
        		dependencies.getParticipantRepository(), dependencies.getActivityRepository(),
        		dependencies.getCategoryRepository(), dependencies.getAssociateRepository(),
        		input, output).execute();
        if(!output.success) response.status(404);
        return converter.toJson(output);
    }
}
