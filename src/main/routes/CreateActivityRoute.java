package main.routes;

import com.google.gson.Gson;

import main.domain.activity.creating.CreateActivityRequest;
import main.domain.activity.creating.CreateActivityResponse;
import main.domain.activity.creating.CreateActivityUseCase;
import spark.Request;
import spark.Response;
import spark.Route;

public class CreateActivityRoute implements Route {
	private Dependencies dependencies;
	private Gson converter = new Gson();

	public CreateActivityRoute(Dependencies dependencies){
		this.dependencies = dependencies;
	}
	public Object handle(Request request, Response response) throws Exception {
		CreateActivityRequest input = converter.fromJson(request.body(), CreateActivityRequest.class);
		CreateActivityResponse output = new CreateActivityResponse();
		new CreateActivityUseCase(dependencies.getActivityRepository(),dependencies.getEventRepository(),
				input,output).execute(); 
		return converter.toJson(output);
	}

}
