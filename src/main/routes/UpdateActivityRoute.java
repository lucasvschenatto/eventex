package main.routes;

import com.google.gson.Gson;

import main.domain.activity.updating.UpdateActivityRequest;
import main.domain.activity.updating.UpdateActivityResponse;
import main.domain.activity.updating.UpdateActivityUseCase;
import spark.Request;
import spark.Response;
import spark.Route;

public class UpdateActivityRoute implements Route {
	private Dependencies dependencies;
	private Gson converter = new Gson();

	public UpdateActivityRoute(Dependencies dependencies){
		this.dependencies = dependencies;
	}
	public Object handle(Request request, Response response) throws Exception {
		UpdateActivityRequest input = converter.fromJson(request.body(), UpdateActivityRequest.class);
		input.id = request.params(":id");
		UpdateActivityResponse output = new UpdateActivityResponse();
		new UpdateActivityUseCase(dependencies.getActivityRepository(),dependencies.getEventRepository(),
				input,output).execute();
		if(!output.success) response.status(404);
		return converter.toJson(output);
	}

}
