package main.routes;

import com.google.gson.Gson;

import main.domain.admin.updating.UpdateAdminRequest;
import main.domain.admin.updating.UpdateAdminResponse;
import main.domain.admin.updating.UpdateAdminUseCase;
import spark.Request;
import spark.Response;
import spark.Route;

public class UpdateAdminRoute implements Route {
    private Dependencies dependencies;
    private Gson converter = new Gson();

    public UpdateAdminRoute(Dependencies dependencies) {
        this.dependencies = dependencies;
    }

    public Object handle(Request request, Response response) throws Exception {
    	UpdateAdminRequest input = converter.fromJson(request.body(), UpdateAdminRequest.class);
    	input.id = request.params(":id");
        UpdateAdminResponse output = new UpdateAdminResponse();
        new UpdateAdminUseCase(dependencies.getAdminRepository(), input, output).execute();
        if(!output.success) response.status(404);
        return converter.toJson(output);
    }
}
