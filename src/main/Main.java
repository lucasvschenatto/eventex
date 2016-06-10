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
        
        get("/categories", new CategoriesSummaryRoute(dependencies));
        post("/categories", new CreateCategoryRoute(dependencies));
        delete("/categories/:id", new DeleteCategoryRoute(dependencies));
        
        get("/associates", new AssociatesSummaryRoute(dependencies));
        post("/associates", new CreateAssociateRoute(dependencies));
        delete("/associates/:id", new DeleteAssociateRoute(dependencies));
        
    }

    private Dependencies buildDependencies() {
        Dependencies dependencies = new Dependencies();
        dependencies.setEncryptor(new JasyptEncryptor());
        dependencies.setActivityRepository(InMemoryRepositoryFactory.getActivityRepository());
        dependencies.setAssociateRepository(InMemoryRepositoryFactory.getAssociateRepository());
        dependencies.setParticipantCategoryRepository(InMemoryRepositoryFactory.getCategoryRepository());
        dependencies.setEventRepository(InMemoryRepositoryFactory.getEventRepository());
        dependencies.setUserRepository(InMemoryRepositoryFactory.getUserRepository());
        return dependencies;
    }

}
