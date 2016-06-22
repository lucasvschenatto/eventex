package main.routes;

import com.google.gson.Gson;

import main.domain.event.updating.UpdateEventRequest;
import main.domain.event.updating.UpdateEventResponse;
import main.domain.event.updating.UpdateEventUseCase;
import spark.Request;
import spark.Response;
import spark.Route;

public class UpdateEventRoute implements Route {
    private Dependencies dependencies;
    private Gson converter = new Gson();

    public UpdateEventRoute(Dependencies dependencies) {
        this.dependencies = dependencies;
    }

    public Object handle(Request request, Response response) throws Exception {
    	UpdateEventRequest input = converter.fromJson(request.body(), UpdateEventRequest.class);
    	input.id = request.params(":id");
        UpdateEventResponse output = new UpdateEventResponse();
        new UpdateEventUseCase(dependencies.getEventRepository(), input, output).execute();
        return converter.toJson(output);
    }
}
