package main.routes;

import com.google.gson.Gson;
import spark.Request;
import spark.Response;
import spark.Route;

public class DeleteAdminRoute implements Route {
    private Dependencies dependencies;
    private Gson converter = new Gson();

    public DeleteAdminRoute(Dependencies dependencies) {
        this.dependencies = dependencies;
    }

    public Object handle(Request request, Response response) throws Exception {
        dependencies.getAdminRepository().deleteById(request.params(":id"));
        return converter.toJson(null);
    }
}
