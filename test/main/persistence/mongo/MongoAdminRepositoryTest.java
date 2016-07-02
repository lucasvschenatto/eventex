package main.persistence.mongo;

import com.mongodb.client.MongoDatabase;

import main.domain.admin.AdminRepository;
import main.domain.admin.AdminRepositoryTest;

import org.bson.types.ObjectId;
import org.junit.Before;

public class MongoAdminRepositoryTest extends AdminRepositoryTest {
    private MongoAdminRepository repository;

    protected AdminRepository getRepository() {
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
        repository = new MongoAdminRepository();
        super.setUp();
    }

    private void setUpDatabase() {
    	MongoDatabase database = MongoConnection.getDatabase();
        database.getCollection("admins").drop();
    }
}
