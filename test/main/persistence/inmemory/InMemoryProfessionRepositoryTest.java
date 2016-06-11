package main.persistence.inmemory;

import main.domain.profession.ProfessionRepository;
import main.domain.profession.ProfessionRepositoryTest;

public class InMemoryProfessionRepositoryTest extends ProfessionRepositoryTest{
	protected ProfessionRepository getRepository() {
		return new InMemoryProfessionRepository();
	}

	protected String getValidId() {
		return "1";
	}

	protected String getInvalidId() {
		return "";
	}

}
