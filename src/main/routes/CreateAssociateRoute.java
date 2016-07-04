package main.routes;

import com.google.gson.Gson;

import main.domain.associate.creating.CreateAssociateRequest;
import main.domain.associate.creating.CreateAssociateResponse;
import main.domain.associate.creating.CreateAssociateUseCase;
import spark.Request;
import spark.Response;
import spark.Route;

public class CreateAssociateRoute implements Route {
    private Dependencies dependencies;
    private Gson converter = new Gson();

    public CreateAssociateRoute(Dependencies dependencies) {
        this.dependencies = dependencies;
    }

    public Object handle(Request request, Response response) throws Exception {
    	CreateAssociateRequest input = converter.fromJson(request.body(), CreateAssociateRequest.class);
        CreateAssociateResponse output = new CreateAssociateResponse();
        if(input!=null)
			new CreateAssociateUseCase(dependencies.getAssociateRepository(), dependencies.getCategoryRepository(),
        		input, output).execute();
        if(output.success)
        	response.status(201);
        else
        	response.status(422);
        return converter.toJson(output);
    }
}
