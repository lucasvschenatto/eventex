package main.persistence.mongo;

import com.mongodb.client.MongoDatabase;

import main.domain.participant.ParticipantRepository;
import main.domain.participant.ParticipantRepositoryTest;

import org.bson.types.ObjectId;
import org.junit.Before;

public class MongoParticipantRepositoryTest extends ParticipantRepositoryTest {
    private MongoParticipantRepository repository;

    protected ParticipantRepository getRepository() {
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
        repository = new MongoParticipantRepository();
        super.setUp();
    }

    private void setUpDatabase() {
    	MongoConnection connection = MongoConnection.getInstance();
        MongoDatabase database = connection.getDatabase();
        database.getCollection("participants").drop();
    }
}
