package main.routes;

import com.google.gson.Gson;

import main.domain.profession.creating.CreateProfessionRequest;
import main.domain.profession.creating.CreateProfessionResponse;
import main.domain.profession.creating.CreateProfessionUseCase;
import spark.Request;
import spark.Response;
import spark.Route;

public class CreateProfessionRoute implements Route {
    private Dependencies dependencies;
    private Gson converter = new Gson();

    public CreateProfessionRoute(Dependencies dependencies) {
        this.dependencies = dependencies;
    }

    public Object handle(Request request, Response response) throws Exception {
    	CreateProfessionRequest input = converter.fromJson(request.body(), CreateProfessionRequest.class);
        CreateProfessionResponse output = new CreateProfessionResponse();
        new CreateProfessionUseCase(dependencies.getProfessionRepository(), input, output).execute();
        if(output.success)
        	response.status(201);
        else
        	response.status(422);
        return converter.toJson(output);
    }
}
