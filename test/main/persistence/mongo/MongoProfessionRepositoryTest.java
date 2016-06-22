package main.persistence.mongo;

import com.mongodb.client.MongoDatabase;

import main.domain.profession.ProfessionRepository;
import main.domain.profession.ProfessionRepositoryTest;

import org.bson.types.ObjectId;
import org.junit.Before;

public class MongoProfessionRepositoryTest extends ProfessionRepositoryTest {
    private MongoProfessionRepository repository;

    protected ProfessionRepository getRepository() {
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
        repository = new MongoProfessionRepository();
        super.setUp();
    }

    private void setUpDatabase() {
    	MongoConnection connection = MongoConnection.getInstance();
        MongoDatabase database = connection.getDatabase();
        database.getCollection("professions").drop();
    }
}
