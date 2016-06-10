package main.routes;

import com.google.gson.Gson;
import spark.Request;
import spark.Response;
import spark.Route;

public class DeleteCategoryRoute implements Route {
    private Dependencies dependencies;
    private Gson converter = new Gson();

    public DeleteCategoryRoute(Dependencies dependencies) {
        this.dependencies = dependencies;
    }

    public Object handle(Request request, Response response) throws Exception {
        dependencies.getCategoryRepository().deleteById(request.params(":id"));
        return converter.toJson(null);
    }
}
