package main.persistence.mongo;

import com.mongodb.client.MongoDatabase;

import main.domain.certificate.CertificateRepository;
import main.domain.certificate.CertificateRepositoryTest;

import org.bson.types.ObjectId;
import org.junit.Before;

public class MongoCertificateRepositoryTest extends CertificateRepositoryTest {
    private MongoCertificateRepository repository;

    protected CertificateRepository getRepository() {
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
        repository = new MongoCertificateRepository();
        super.setUp();
    }

    private void setUpDatabase() {
    	MongoConnection connection = MongoConnection.getInstance();
        MongoDatabase database = connection.getDatabase();
        database.getCollection("certificates").drop();
    }
}
