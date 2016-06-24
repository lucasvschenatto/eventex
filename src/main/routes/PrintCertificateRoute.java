package main.routes;

import com.google.gson.Gson;

import main.domain.certificate.PrintCertificateRequest;
import main.domain.certificate.PrintCertificateResponse;
import main.domain.certificate.PrintCertificateUseCase;
import spark.Request;
import spark.Response;
import spark.Route;

public class PrintCertificateRoute implements Route {
    private Dependencies dependencies;
    private Gson converter = new Gson();

    public PrintCertificateRoute(Dependencies dependencies) {
        this.dependencies = dependencies;
    }

    public Object handle(Request request, Response response) throws Exception {
    	PrintCertificateRequest input = converter.fromJson(request.body(), PrintCertificateRequest.class);
        PrintCertificateResponse output = new PrintCertificateResponse();
        new PrintCertificateUseCase(dependencies.getActivityRepository(), dependencies.getParticipantRepository(), 
        		dependencies.getInscriptionRepository(), dependencies.getStaticFileLocation(), input, output).execute();
        return converter.toJson(output);
    }
}
