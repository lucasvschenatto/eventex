package main.routes;

import com.google.gson.Gson;
import spark.Request;
import spark.Response;
import spark.Route;

public class DeleteParticipantCategoryRoute implements Route {
    private Dependencies dependencies;
    private Gson converter = new Gson();

    public DeleteParticipantCategoryRoute(Dependencies dependencies) {
        this.dependencies = dependencies;
    }

    public Object handle(Request request, Response response) throws Exception {
        dependencies.getParticipantCategoryRepository().deleteById(request.params(":id"));
        return converter.toJson(null);
    }
}
