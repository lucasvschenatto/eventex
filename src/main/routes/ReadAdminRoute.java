package main.routes;

import com.google.gson.Gson;

import main.domain.admin.reading.ReadAdminRequest;
import main.domain.admin.reading.ReadAdminResponse;
import main.domain.admin.reading.ReadAdminUseCase;
import spark.Request;
import spark.Response;
import spark.Route;

public class ReadAdminRoute implements Route {
    private Dependencies dependencies;
    private Gson converter = new Gson();

    public ReadAdminRoute(Dependencies dependencies) {
        this.dependencies = dependencies;
    }

    public Object handle(Request request, Response response) throws Exception {
        ReadAdminResponse output = executeUseCase(request);
        if(!output.success) response.status(404);
        return converter.toJson(output);
    }
    
    private ReadAdminResponse executeUseCase(Request request) {
    	ReadAdminRequest input = new ReadAdminRequest();
    	input.id = request.cookie("admin-id");
    	ReadAdminResponse output = new ReadAdminResponse();
    	new ReadAdminUseCase(dependencies.getAdminRepository(), input, output).execute();
        return output;
    }
}
