package main.routes;

import com.google.gson.Gson;

import main.domain.profession.reading.ReadProfessionRequest;
import main.domain.profession.reading.ProfessionSummary;
import main.domain.profession.reading.ReadProfessionUseCase;
import spark.Request;
import spark.Response;
import spark.Route;

public class ReadProfessionRoute implements Route {
    private Dependencies dependencies;
    private Gson converter = new Gson();

    public ReadProfessionRoute(Dependencies dependencies) {
        this.dependencies = dependencies;
    }

    public Object handle(Request request, Response response) throws Exception {
    	ReadProfessionRequest input = new ReadProfessionRequest();
    	input.id = request.params(":id");
        ProfessionSummary output = new ProfessionSummary();
        new ReadProfessionUseCase(dependencies.getProfessionRepository(), input, output).execute();
        if(output.id == null || output.id.isEmpty()) response.status(404);
        return converter.toJson(output);
    }
}
