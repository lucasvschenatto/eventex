package main;

import static spark.Spark.delete;
import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.put;
import static spark.SparkBase.externalStaticFileLocation;
import static spark.SparkBase.port;

import java.util.HashMap;

import main.domain.RepositoryFactory;
import main.persistence.mongo.MongoFactory;
import main.routes.*;
import main.security.JasyptEncryptor;
import spark.Spark;

public class Main {
	private static RepositoryFactory factory;
	private static String externalFolder;

	public static void main(String... arguments) {
        new Main().startSparkServer();
    }


	private void startSparkServer() {
		setUpPort();
		setUpStaticFiles();
		setUpRoutes();
		setUpCors();
		setUpPDFResponses();
	}

    private void setUpCors() {
    	HashMap<String, String> corsHeaders = new HashMap<String, String>();
            corsHeaders.put("Access-Control-Allow-Methods", "GET,PUT,POST,DELETE,OPTIONS");
            corsHeaders.put("Access-Control-Allow-Origin", "*");
            corsHeaders.put("Access-Control-Allow-Headers", "Content-Type,Authorization,X-Requested-With,Content-Length,Accept,Origin,");
            corsHeaders.put("Access-Control-Allow-Credentials", "true");
    	Spark.after((req, res) -> corsHeaders.forEach((key, value) -> res.header(key, value)));
	}
	private void setUpPDFResponses() {
		Spark.after("pdf/*", (req,res) -> { 
        	res.header("Content-type", "application/pdf");
        	res.header("Content-Disposition", "inline; filename=\"certificado.pdf\"");
        	res.header("Connection", "keep-alive");
        });
	}
	private void setUpPort() {
    	try{port(Integer.parseInt(System.getenv("PORT")));
		}catch(NumberFormatException ignored){}
    }

    private void setUpStaticFiles() {
    	externalFolder = externalFolder != null? externalFolder : "html";
    	externalStaticFileLocation(externalFolder);
    }
    
    private void setUpRoutes() {
    	
    	Dependencies dependencies = buildDependencies();
    	
        get("/read-user", new ReadUserRoute(dependencies));
        post("/login", new LoginRoute(dependencies));
        post("/logout", new LogoutRoute(dependencies));
        post("/register", new RegisterRoute(dependencies));
        
        get("/activities", new ActivitiesSummaryRoute(dependencies));
        post("/activities", new CreateActivityRoute(dependencies));
        get("/activities/:id", new ReadActivityRoute(dependencies));
        put("/activities/:id", new UpdateActivityRoute(dependencies));
        delete("/activities/:id", new DeleteActivityRoute(dependencies));
        
        get("/admins", new AdminsSummaryRoute(dependencies));
        post("/admins", new CreateAdminRoute(dependencies));
        get("/admins/:id", new ReadAdminRoute(dependencies));
        put("/admins/:id", new UpdateAdminRoute(dependencies));
        delete("/admins/:id", new DeleteAdminRoute(dependencies));
        
        get("/associates", new AssociatesSummaryRoute(dependencies));
        post("/associates", new CreateAssociateRoute(dependencies));
        get("/associates/:id", new ReadAssociateRoute(dependencies));
        put("/associates/:id", new UpdateAssociateRoute(dependencies));
        delete("/associates/:id", new DeleteAssociateRoute(dependencies));
        
        get("/categories", new CategoriesSummaryRoute(dependencies));
        post("/categories", new CreateCategoryRoute(dependencies));
        get("/categories/:id", new ReadCategoryRoute(dependencies));
        put("/categories/:id", new UpdateCategoryRoute(dependencies));
        delete("/categories/:id", new DeleteCategoryRoute(dependencies));
        
        get("/certificates", new PrintCertificateRoute(dependencies));

        get("/events", new EventsSummaryRoute(dependencies));
        post("/events", new CreateEventRoute(dependencies));
        get("/events/:id", new ReadEventRoute(dependencies));
        put("/events/:id", new UpdateEventRoute(dependencies));
        delete("/events/:id", new DeleteEventRoute(dependencies));
        
        get("/inscriptions", new InscriptionsSummaryRoute(dependencies));
        post("/inscriptions", new CreateInscriptionRoute(dependencies));
        get("/inscriptions/:id", new ReadInscriptionRoute(dependencies));
        put("/inscriptions/:id", new UpdateInscriptionRoute(dependencies));
        delete("/inscriptions/:id", new DeleteInscriptionRoute(dependencies));
        
        get("/participants", new ParticipantsSummaryRoute(dependencies));
        post("/participants", new CreateParticipantRoute(dependencies));
        get("/participants/:id", new ReadParticipantRoute(dependencies));
        put("/participants/:id", new UpdateParticipantRoute(dependencies));
        delete("/participants/:id", new DeleteParticipantRoute(dependencies));
        
        get("/professions", new ProfessionsSummaryRoute(dependencies));
        post("/professions", new CreateProfessionRoute(dependencies));
        get("/professions/:id", new ReadProfessionRoute(dependencies));
        put("/professions/:id", new UpdateProfessionRoute(dependencies));
        delete("/professions/:id", new DeleteProfessionRoute(dependencies));
    }

    private Dependencies buildDependencies() {
        Dependencies d = new Dependencies();
        d.setEncryptor(new JasyptEncryptor());
        d.setRepositoryFactory(getFactory());
        d.setStaticFileLocation(externalFolder);
        return d;
    }
    
    private RepositoryFactory getFactory(){
    	if(factory == null)
    		factory = MongoFactory.getInstance();
    	return factory;
    }
    
    public static void setFactory(RepositoryFactory newFactory){
    	factory = newFactory;
    }
    public static void setStaticFilesLocation(String externalFolderLocation){
    	externalFolder = externalFolderLocation;
    }

}
