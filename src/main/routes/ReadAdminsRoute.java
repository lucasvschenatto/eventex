package main.routes;

import com.google.gson.Gson;

import main.domain.admin.reading.AdminSummary;
import main.domain.admin.reading.ReadAdminsUseCase;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.ArrayList;
import java.util.Collection;

public class ReadAdminsRoute implements Route {
    private Dependencies dependencies;
    private Gson converter = new Gson();

    public ReadAdminsRoute(Dependencies dependencies) {
        this.dependencies = dependencies;
    }

    public Object handle(Request request, Response response) throws Exception {
        Collection<AdminSummary> output = new ArrayList<>();
        new ReadAdminsUseCase(dependencies.getAdminRepository(), output).execute();
        return converter.toJson(output);
    }
}
