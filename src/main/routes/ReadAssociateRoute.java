package main.routes;

import com.google.gson.Gson;

import main.domain.associate.reading.ReadAssociateRequest;
import main.domain.associate.reading.AssociateSummary;
import main.domain.associate.reading.ReadAssociateUseCase;
import spark.Request;
import spark.Response;
import spark.Route;

public class ReadAssociateRoute implements Route {
    private Dependencies dependencies;
    private Gson converter = new Gson();

    public ReadAssociateRoute(Dependencies dependencies) {
        this.dependencies = dependencies;
    }

    public Object handle(Request request, Response response) throws Exception {
    	ReadAssociateRequest input = new ReadAssociateRequest();
    	input.id = request.params(":id");
        AssociateSummary output = new AssociateSummary();
        new ReadAssociateUseCase(dependencies.getAssociateRepository(), input, output).execute();
        if(output.id == null || output.id.isEmpty()) response.status(404);
        return converter.toJson(output);
    }
}
