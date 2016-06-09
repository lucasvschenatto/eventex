package main.routes;

import com.google.gson.Gson;

import main.domain.covenant.creating.CreateCovenantRequest;
import main.domain.covenant.creating.CreateCovenantResponse;
import main.domain.covenant.creating.CreateCovenantUseCase;
import spark.Request;
import spark.Response;
import spark.Route;

public class CreateCovenantRoute implements Route {
    private Dependencies dependencies;
    private Gson converter = new Gson();

    public CreateCovenantRoute(Dependencies dependencies) {
        this.dependencies = dependencies;
    }

    public Object handle(Request request, Response response) throws Exception {
    	CreateCovenantRequest input = converter.fromJson(request.body(), CreateCovenantRequest.class);
        CreateCovenantResponse output = new CreateCovenantResponse();
        new CreateCovenantUseCase(dependencies.getCovenantRepository(), dependencies.getCategoryRepository(),
        		input, output).execute();
        return converter.toJson(output);
    }
}
