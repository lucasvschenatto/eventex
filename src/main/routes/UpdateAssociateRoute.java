package main.routes;

import com.google.gson.Gson;

import main.domain.associate.updating.UpdateAssociateRequest;
import main.domain.associate.updating.UpdateAssociateResponse;
import main.domain.associate.updating.UpdateAssociateUseCase;
import spark.Request;
import spark.Response;
import spark.Route;

public class UpdateAssociateRoute implements Route {
    private Dependencies dependencies;
    private Gson converter = new Gson();

    public UpdateAssociateRoute(Dependencies dependencies) {
        this.dependencies = dependencies;
    }

    public Object handle(Request request, Response response) throws Exception {
    	UpdateAssociateRequest input = converter.fromJson(request.body(), UpdateAssociateRequest.class);
    	input.id = request.params(":id");
        UpdateAssociateResponse output = new UpdateAssociateResponse();
        new UpdateAssociateUseCase(dependencies.getAssociateRepository(), dependencies.getCategoryRepository(),
        		input, output).execute();
        return converter.toJson(output);
    }
}
