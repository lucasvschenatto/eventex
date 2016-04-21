package main;

import static spark.Spark.get;
import static spark.Spark.post;
import static spark.SparkBase.externalStaticFileLocation;
import static spark.SparkBase.port;

public class Main {

	public static void main(String... arguments) {
        new Main().startSparkServer();
    }
	
	private void startSparkServer() {
		setUpPort();
		setUpStaticFiles();
//		setUpRoutes();
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
        port(Integer.parseInt(System.getenv("PORT")));
    }

    private void setUpStaticFiles() {
        externalStaticFileLocation("resources/public");
    }

}
