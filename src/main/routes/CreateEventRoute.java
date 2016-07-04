package main.routes;

import com.google.gson.Gson;

import main.domain.event.creating.CreateEventRequest;
import main.domain.event.creating.CreateEventResponse;
import main.domain.event.creating.CreateEventUseCase;
import spark.Request;
import spark.Response;
import spark.Route;

public class CreateEventRoute implements Route {
    private Dependencies dependencies;
    private Gson converter = new Gson();

    public CreateEventRoute(Dependencies dependencies) {
        this.dependencies = dependencies;
    }

    public Object handle(Request request, Response response) throws Exception {
    	CreateEventRequest input = converter.fromJson(request.body(), CreateEventRequest.class);
        CreateEventResponse output = new CreateEventResponse();
        if(input!=null)
			new CreateEventUseCase(dependencies.getEventRepository(), input, output).execute();
        if(output.success)
        	response.status(201);
        else
        	response.status(200);
        return converter.toJson(output);
    }
}
