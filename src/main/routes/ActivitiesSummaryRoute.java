package main.routes;

import java.util.ArrayList;
import java.util.Collection;

import com.google.gson.Gson;

import main.domain.activity.reading.ActivitySummary;
import main.domain.activity.reading.ReadActivitiesSummaryUseCase;
import spark.Request;
import spark.Response;
import spark.Route;

public class ActivitiesSummaryRoute implements Route {
	private Dependencies dependencies;
    private Gson converter = new Gson();

    public ActivitiesSummaryRoute(Dependencies dependencies) {
        this.dependencies = dependencies;
    }

	public Object handle(Request request, Response response) throws Exception {
		Collection<ActivitySummary> output = new ArrayList<>();
        new ReadActivitiesSummaryUseCase(dependencies.getActivityRepository(), output).execute();
		return converter.toJson(output);
	}

}
