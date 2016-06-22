package main.routes;

import com.google.gson.Gson;

import main.domain.event.reading.ReadEventRequest;
import main.domain.event.reading.EventSummary;
import main.domain.event.reading.ReadEventUseCase;
import spark.Request;
import spark.Response;
import spark.Route;

public class ReadEventRoute implements Route {
    private Dependencies dependencies;
    private Gson converter = new Gson();

    public ReadEventRoute(Dependencies dependencies) {
        this.dependencies = dependencies;
    }

    public Object handle(Request request, Response response) throws Exception {
    	ReadEventRequest input = new ReadEventRequest();
    	input.id = request.params(":id");
        EventSummary output = new EventSummary();
        new ReadEventUseCase(dependencies.getEventRepository(), input, output).execute();
        return converter.toJson(output);
    }
}
