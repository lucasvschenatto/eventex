package main.routes;

import com.google.gson.Gson;

import main.domain.associate.reading.AssociateSummary;
import main.domain.associate.reading.ReadAssociatesFilterRequest;
import main.domain.associate.reading.ReadAssociatesFilterUseCase;
import main.domain.associate.reading.ReadAssociatesUseCase;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.ArrayList;
import java.util.Collection;

public class ReadAssociatesRoute implements Route {
    private Dependencies dependencies;
    private Gson converter = new Gson();

    public ReadAssociatesRoute(Dependencies dependencies) {
        this.dependencies = dependencies;
    }

    public Object handle(Request request, Response response) throws Exception {
    	ReadAssociatesFilterRequest filter = new ReadAssociatesFilterRequest();
    	filter.categoryId = request.queryParams("category");
        Collection<AssociateSummary> output = new ArrayList<>();
        if(filter.categoryId != null)
        	new ReadAssociatesFilterUseCase(dependencies.getAssociateRepository(), filter, output).execute();
        else
        	new ReadAssociatesUseCase(dependencies.getAssociateRepository(), output).execute();
        return converter.toJson(output);
    }
}
