package main.persistence.mongo;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;

public class MongoConnection {
	private MongoClientURI uri;
	private MongoClient client;
	private MongoDatabase database;
	private static MongoConnection instance;
	
	public static MongoConnection getInstance(){
		if(instance == null)
			instance = new MongoConnection();
		return instance;
	}
	
	public MongoDatabase getDatabase(){
		return database;
	}
	private MongoConnection(){
		uri = new MongoClientURI(System.getenv("MONGODB_URI"));
        client = new MongoClient(uri);
        database = client.getDatabase(uri.getDatabase());
	}
}
