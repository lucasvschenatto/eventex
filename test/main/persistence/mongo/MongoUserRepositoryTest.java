package main.persistence.mongo;

import com.mongodb.client.MongoDatabase;
import main.domain.account.UserRepository;
import main.domain.account.UserRepositoryTest;
import org.bson.types.ObjectId;
import org.junit.Before;

public class MongoUserRepositoryTest extends UserRepositoryTest {
    private MongoUserRepository repository;

    protected UserRepository getRepository() {
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
        repository = new MongoUserRepository();
        super.setUp();
    }

    private void setUpDatabase() {
    	MongoDatabase database = MongoConnection.getDatabase();
        database.getCollection("users").drop();
    }
}
