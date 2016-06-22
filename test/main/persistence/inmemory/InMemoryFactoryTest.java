package main.persistence.inmemory;

import main.domain.RepositoryFactory;
import main.persistence.RepositoryFactoryTest;

public class InMemoryFactoryTest extends RepositoryFactoryTest{

	@Override
	protected RepositoryFactory getFactory() {
		return InMemoryFactory.getInstance();
	}

}
