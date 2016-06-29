package main.routes;

import com.google.gson.Gson;

import main.domain.profession.updating.UpdateProfessionRequest;
import main.domain.profession.updating.UpdateProfessionResponse;
import main.domain.profession.updating.UpdateProfessionUseCase;
import spark.Request;
import spark.Response;
import spark.Route;

public class UpdateProfessionRoute implements Route {
    private Dependencies dependencies;
    private Gson converter = new Gson();

    public UpdateProfessionRoute(Dependencies dependencies) {
        this.dependencies = dependencies;
    }

    public Object handle(Request request, Response response) throws Exception {
    	UpdateProfessionRequest input = converter.fromJson(request.body(), UpdateProfessionRequest.class);
    	input.id = request.params(":id");
        UpdateProfessionResponse output = new UpdateProfessionResponse();
        new UpdateProfessionUseCase(dependencies.getProfessionRepository(), input, output).execute();
        if(!output.success) response.status(404);
        return converter.toJson(output);
    }
}
