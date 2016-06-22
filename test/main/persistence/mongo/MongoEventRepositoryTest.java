package main.persistence.mongo;

import com.mongodb.client.MongoDatabase;

import main.domain.event.EventRepository;
import main.domain.event.EventRepositoryTest;

import org.bson.types.ObjectId;
import org.junit.Before;

public class MongoEventRepositoryTest extends EventRepositoryTest {
    private MongoEventRepository repository;

    protected EventRepository getRepository() {
        return repository;
    }

    protected String getValidId() {
        return new ObjectId().toString();
    }

    protected String getInvalidId() {
        return "some text";
    }

    @Before
    public void setUp() throws Exception {
        setUpDatabase();
        repository = new MongoEventRepository();
        super.setUp();
    }

    private void setUpDatabase() {
    	MongoConnection connection = MongoConnection.getInstance();
        MongoDatabase database = connection.getDatabase();
        database.getCollection("events").drop();
    }
}
