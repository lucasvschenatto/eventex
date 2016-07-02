package main.persistence.mongo;

import com.mongodb.client.MongoDatabase;

import main.domain.associate.AssociateRepository;
import main.domain.associate.AssociateRepositoryTest;

import org.bson.types.ObjectId;
import org.junit.Before;

public class MongoAssociateRepositoryTest extends AssociateRepositoryTest {
    private MongoAssociateRepository repository;

    protected AssociateRepository getRepository() {
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
        repository = new MongoAssociateRepository();
        super.setUp();
    }

    private void setUpDatabase() {
    	MongoDatabase database = MongoConnection.getDatabase();
        database.getCollection("associates").drop();
    }
}
