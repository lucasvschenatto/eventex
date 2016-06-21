package main.persistence.mongo;

import main.domain.RepositoryFactory;
import main.persistence.RepositoryFactoryTest;
import main.persistence.mongo.MongoFactory;

public class MongoFactoryTest extends RepositoryFactoryTest {

	@Override
	protected RepositoryFactory getFactory() {
		return MongoFactory.getInstance();
	}

}
