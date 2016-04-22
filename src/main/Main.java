package main;

import static spark.Spark.delete;
import static spark.Spark.get;
import static spark.Spark.post;
import static spark.SparkBase.externalStaticFileLocation;
import static spark.SparkBase.port;

import main.persistence.inmemory.InMemoryUserRepository;
import main.persistence.inmemory.InMemoryEventRepository;
import main.routes.CreateEventRoute;
import main.routes.DeleteEventRoute;
import main.routes.Dependencies;
import main.routes.LoginRoute;
import main.routes.LogoutRoute;
import main.routes.EventsSummaryRoute;
import main.routes.ReadUserRoute;
import main.routes.RegisterRoute;
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
        get("/events", new EventsSummaryRoute(dependencies));
        post("/events", new CreateEventRoute(dependencies));
        delete("/events/:id", new DeleteEventRoute(dependencies));
    }

    private Dependencies buildDependencies() {
        Dependencies dependencies = new Dependencies();
        dependencies.setEncryptor(new JasyptEncryptor());
        dependencies.setUserRepository(new InMemoryUserRepository());
        dependencies.setEventRepository(new InMemoryEventRepository());
        return dependencies;
    }

}
