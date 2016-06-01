package main.persistence.inmemory;

import main.domain.activity.ActivityRepository;
import main.domain.activity.ActivityRepositoryTest;

public class InMemoryActivityRepositoryTest extends ActivityRepositoryTest{
	protected ActivityRepository getRepository() {
		return new InMemoryActivityRepository();
	}

	protected String getValidId() {
		return "1";
	}

	protected String getInvalidId() {
		return "";
	}

}
