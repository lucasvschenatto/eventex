package main.persistence.mongo;

import com.mongodb.client.MongoDatabase;

import main.domain.category.CategoryRepository;
import main.domain.category.CategoryRepositoryTest;

import org.bson.types.ObjectId;
import org.junit.Before;

public class MongoCategoryRepositoryTest extends CategoryRepositoryTest {
    private MongoCategoryRepository repository;

    protected CategoryRepository getRepository() {
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
        repository = new MongoCategoryRepository();
        super.setUp();
    }

    private void setUpDatabase() {
    	MongoDatabase database = MongoConnection.getDatabase();
        database.getCollection("categories").drop();
    }
}
