package main.persistence.mongo;

import com.mongodb.client.MongoDatabase;
import main.domain.activity.ActivityRepository;
import main.domain.activity.ActivityRepositoryTest;

import org.bson.types.ObjectId;
import org.junit.Before;

public class MongoActivityRepositoryTest extends ActivityRepositoryTest {
    private MongoActivityRepository repository;

    protected ActivityRepository getRepository() {
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
        repository = new MongoActivityRepository();
        super.setUp();
    }

    private void setUpDatabase() {
        MongoDatabase database = MongoConnection.getDatabase();
        database.getCollection("activities").drop();
    }
}
