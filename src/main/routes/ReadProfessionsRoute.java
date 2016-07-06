package main.routes;

import com.google.gson.Gson;

import main.domain.profession.reading.ProfessionSummary;
import main.domain.profession.reading.ReadProfessionsUseCase;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.ArrayList;
import java.util.Collection;

public class ReadProfessionsRoute implements Route {
    private Dependencies dependencies;
    private Gson converter = new Gson();

    public ReadProfessionsRoute(Dependencies dependencies) {
        this.dependencies = dependencies;
    }

    public Object handle(Request request, Response response) throws Exception {
        Collection<ProfessionSummary> output = new ArrayList<>();
        new ReadProfessionsUseCase(dependencies.getProfessionRepository(), output).execute();
        return converter.toJson(output);
    }
}
