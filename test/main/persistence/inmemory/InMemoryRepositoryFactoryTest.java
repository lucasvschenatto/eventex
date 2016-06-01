package main.persistence.inmemory;

import java.util.ArrayList;
import java.util.List;

import main.domain.Repository;
import main.persistence.RepositoryFactoryTest;

public class InMemoryRepositoryFactoryTest extends RepositoryFactoryTest{
	protected List<Repository<?>> getAll() {
		List<Repository<?>> result = new ArrayList<Repository<?>>();
		result.add(InMemoryRepositoryFactory.getActivityRepository());
		result.add(InMemoryRepositoryFactory.getEventRepository());
		result.add(InMemoryRepositoryFactory.getUserRepository());
		return result;
	}

}
