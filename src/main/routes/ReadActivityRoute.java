package main.routes;

import com.google.gson.Gson;

import main.domain.activity.reading.ReadActivityRequest;
import main.domain.activity.reading.ActivitySummary;
import main.domain.activity.reading.ReadActivityUseCase;
import spark.Request;
import spark.Response;
import spark.Route;

public class ReadActivityRoute implements Route {
	private Dependencies dependencies;
	private Gson converter = new Gson();

	public ReadActivityRoute(Dependencies dependencies){
		this.dependencies = dependencies;
	}
	public Object handle(Request request, Response response) throws Exception {
		ReadActivityRequest input = new ReadActivityRequest();
		input.id = request.params(":id");
		ActivitySummary output = new ActivitySummary();
		new ReadActivityUseCase(dependencies.getActivityRepository(),input,output).execute();
		if(output.id == null || output.id.isEmpty()) response.status(404);
		return converter.toJson(output);
	}

}
