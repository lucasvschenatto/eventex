package main.persistence.inmemory;

import main.domain.covenant.CovenantRepository;
import main.domain.covenant.CovenantRepositoryTest;

public class InMemoryCovenantRepositoryTest extends CovenantRepositoryTest {

	protected CovenantRepository getRepository() {
		return new InMemoryCovenantRepository();
	}

	protected String getValidId() {
        return "1";
    }

    protected String getInvalidId() {
        return "";
    }	
}
