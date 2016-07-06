package main.routes;

import com.google.gson.Gson;

import main.domain.event.reading.EventSummary;
import main.domain.event.reading.ReadEventsUseCase;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.ArrayList;
import java.util.Collection;

public class ReadEventsRoute implements Route {
    private Dependencies dependencies;
    private Gson converter = new Gson();

    public ReadEventsRoute(Dependencies dependencies) {
        this.dependencies = dependencies;
    }

    public Object handle(Request request, Response response) throws Exception {
        Collection<EventSummary> output = new ArrayList<>();
        new ReadEventsUseCase(dependencies.getEventRepository(), output).execute();
        return converter.toJson(output);
    }
}
