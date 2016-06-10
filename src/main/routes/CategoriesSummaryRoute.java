package main.routes;

import com.google.gson.Gson;

import main.domain.category.reading.CategorySummary;
import main.domain.category.reading.ReadCategoriesSummaryUseCase;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.ArrayList;
import java.util.Collection;

public class CategoriesSummaryRoute implements Route {
    private Dependencies dependencies;
    private Gson converter = new Gson();

    public CategoriesSummaryRoute(Dependencies dependencies) {
        this.dependencies = dependencies;
    }

    public Object handle(Request request, Response response) throws Exception {
        Collection<CategorySummary> output = new ArrayList<>();
        new ReadCategoriesSummaryUseCase(dependencies.getCategoryRepository(), output).execute();
        return converter.toJson(output);
    }
}
