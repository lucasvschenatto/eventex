package main;

import static spark.Spark.delete;
import static spark.Spark.get;
import static spark.Spark.post;
import static spark.SparkBase.externalStaticFileLocation;
import static spark.SparkBase.port;

import main.persistence.inmemory.InMemoryRepositoryFactory;
import main.routes.*;
import main.security.JasyptEncryptor;

public class Main {

	public static void main(String... arguments) {
        new Main().startSparkServer();
    }
	
	private void startSparkServer() {
		setUpPort();
		setUpStaticFiles();
		setUpRoutes();
	}		 

    private void setUpPort() {
    	int envPort;
    	try{
// HEROKU configura a porta que deve usar através de variável de ambiente
			envPort = Integer.parseInt(System.getenv("PORT"));
		}catch(NumberFormatException e){
			envPort = 8080;
		}
		port(envPort);
    }

    private void setUpStaticFiles() {
//        externalStaticFileLocation("resources/public");
    	externalStaticFileLocation("html");
    }
    
    private void setUpRoutes() {
    	Dependencies dependencies = buildDependencies();
    	
        get("/read-user", new ReadUserRoute(dependencies));
        post("/login", new LoginRoute(dependencies));
        post("/logout", new LogoutRoute(dependencies));
        post("/register", new RegisterRoute(dependencies));
        
        get("/activities", new ActivitiesSummaryRoute(dependencies));
        post("/activities", new CreateActivityRoute(dependencies));
        delete("/activities/:id", new DeleteActivityRoute(dependencies));
        
        get("/events", new EventsSummaryRoute(dependencies));
        post("/events", new CreateEventRoute(dependencies));
        delete("/events/:id", new DeleteEventRoute(dependencies));
        
        get("/covenants", new CovenantsSummaryRoute(dependencies));
        post("/covenants", new CreateCovenantRoute(dependencies));
        delete("/covenants/:id", new DeleteCovenantRoute(dependencies));
        
        get("/participant_categories", new ParticipantCategoriesSummaryRoute(dependencies));
        post("/participant_categories", new CreateParticipantCategoryRoute(dependencies));
        delete("/participant_categories/:id", new DeleteParticipantCategoryRoute(dependencies));
    }

    private Dependencies buildDependencies() {
        Dependencies dependencies = new Dependencies();
        dependencies.setEncryptor(new JasyptEncryptor());
        dependencies.setActivityRepository(InMemoryRepositoryFactory.getActivityRepository());
        dependencies.setCovenantRepository(InMemoryRepositoryFactory.getCovenantRepository());
        dependencies.setParticipantCategoryRepository(InMemoryRepositoryFactory.getCategoryRepository());
        dependencies.setEventRepository(InMemoryRepositoryFactory.getEventRepository());
        dependencies.setUserRepository(InMemoryRepositoryFactory.getUserRepository());
        return dependencies;
    }

}
