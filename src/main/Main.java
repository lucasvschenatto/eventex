package main;

import static spark.Spark.get;
import static spark.SparkBase.port;

public class Main {

	public static void main(String[] args) {
		int envPort;
		try{
// HEROKU configura a porta que deve usar através de variável de ambiente
			envPort = Integer.parseInt(System.getenv("PORT"));			
		}catch(NumberFormatException e){
			envPort = 8080;
		}
		port(envPort); 
        get("/hello", (req, res) -> "Eventex");
	}

}
