package main.routes;

import com.google.gson.Gson;

import main.domain.category.reading.ReadCategoryRequest;
import main.domain.category.reading.CategorySummary;
import main.domain.category.reading.ReadCategoryUseCase;
import spark.Request;
import spark.Response;
import spark.Route;

public class ReadCategoryRoute implements Route {
    private Dependencies dependencies;
    private Gson converter = new Gson();

    public ReadCategoryRoute(Dependencies dependencies) {
        this.dependencies = dependencies;
    }

    public Object handle(Request request, Response response) throws Exception {
    	ReadCategoryRequest input = new ReadCategoryRequest();
    	input.id = request.params(":id");
        CategorySummary output = new CategorySummary();
        new ReadCategoryUseCase(dependencies.getCategoryRepository(), input, output).execute();
        return converter.toJson(output);
    }
}
