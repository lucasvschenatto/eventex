package main.routes;

import com.google.gson.Gson;

import main.domain.certificate.creating.CreateCertificateRequest;
import main.domain.certificate.creating.CreateCertificateResponse;
import main.domain.certificate.creating.CreateCertificateUseCase;
import spark.Request;
import spark.Response;
import spark.Route;

public class CreateCertificateRoute implements Route {
    private Dependencies dependencies;
    private Gson converter = new Gson();

    public CreateCertificateRoute(Dependencies dependencies) {
        this.dependencies = dependencies;
    }

    public Object handle(Request request, Response response) throws Exception {
    	CreateCertificateRequest input = converter.fromJson(request.body(), CreateCertificateRequest.class);
        CreateCertificateResponse output = new CreateCertificateResponse();
        new CreateCertificateUseCase(dependencies.getCertificateRepository(), input, output).execute();
        return converter.toJson(output);
    }
}
