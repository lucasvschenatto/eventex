package main.routes;

import com.google.gson.Gson;

import main.domain.category.reading.CategorySummary;
import main.domain.category.reading.ReadCategoriesUseCase;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.ArrayList;
import java.util.Collection;

public class ReadCategoriesRoute implements Route {
    private Dependencies dependencies;
    private Gson converter = new Gson();

    public ReadCategoriesRoute(Dependencies dependencies) {
        this.dependencies = dependencies;
    }

    public Object handle(Request request, Response response) throws Exception {
        Collection<CategorySummary> output = new ArrayList<>();
        new ReadCategoriesUseCase(dependencies.getCategoryRepository(), output).execute();
        return converter.toJson(output);
    }
}
