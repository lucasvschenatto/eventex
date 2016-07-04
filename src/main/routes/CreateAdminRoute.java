package main.routes;

import com.google.gson.Gson;

import main.domain.admin.creating.CreateAdminRequest;
import main.domain.admin.creating.CreateAdminResponse;
import main.domain.admin.creating.CreateAdminUseCase;
import spark.Request;
import spark.Response;
import spark.Route;

public class CreateAdminRoute implements Route {
    private Dependencies dependencies;
    private Gson converter = new Gson();

    public CreateAdminRoute(Dependencies dependencies) {
        this.dependencies = dependencies;
    }

    public Object handle(Request request, Response response) throws Exception {
    	CreateAdminRequest input = converter.fromJson(request.body(), CreateAdminRequest.class);
        CreateAdminResponse output = new CreateAdminResponse();
        if(input!=null)
			new CreateAdminUseCase(dependencies.getAdminRepository(), input, output).execute();
        if(output.success)
        	response.status(201);
        else
        	response.status(200);
        return converter.toJson(output);
    }
}
