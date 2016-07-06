package main.routes;

import java.util.ArrayList;
import java.util.Collection;

import com.google.gson.Gson;

import main.domain.activity.reading.ActivitySummary;
import main.domain.activity.reading.ReadActivitiesFilterRequest;
import main.domain.activity.reading.ReadActivitiesFilterUseCase;
import main.domain.activity.reading.ReadActivitiesUseCase;
import spark.Request;
import spark.Response;
import spark.Route;

public class ReadActivitiesRoute implements Route {
	private Dependencies dependencies;
    private Gson converter = new Gson();

    public ReadActivitiesRoute(Dependencies dependencies) {
        this.dependencies = dependencies;
    }

	public Object handle(Request request, Response response) throws Exception {
		ReadActivitiesFilterRequest filter = new ReadActivitiesFilterRequest();
		filter.eventId = request.queryParams("event");
		Collection<ActivitySummary> output = new ArrayList<>();
		if(filter.eventId != null)
			new ReadActivitiesFilterUseCase(dependencies.getActivityRepository(), filter, output).execute();
		else
			new ReadActivitiesUseCase(dependencies.getActivityRepository(), output).execute();
		return converter.toJson(output);
	}

}
