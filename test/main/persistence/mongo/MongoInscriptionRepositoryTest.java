package main.persistence.mongo;

import com.mongodb.client.MongoDatabase;

import main.domain.inscription.InscriptionRepository;
import main.domain.inscription.InscriptionRepositoryTest;

import org.bson.types.ObjectId;
import org.junit.Before;

public class MongoInscriptionRepositoryTest extends InscriptionRepositoryTest {
    private MongoInscriptionRepository repository;

    protected InscriptionRepository getRepository() {
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
        repository = new MongoInscriptionRepository();
        super.setUp();
    }

    private void setUpDatabase() {
    	MongoDatabase database = MongoConnection.getDatabase();
        database.getCollection("inscriptions").drop();
    }
}
