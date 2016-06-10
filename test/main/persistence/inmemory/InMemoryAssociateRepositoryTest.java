package main.persistence.inmemory;

import main.domain.associate.AssociateRepository;
import main.domain.associate.AssociateRepositoryTest;

public class InMemoryAssociateRepositoryTest extends AssociateRepositoryTest {

	protected AssociateRepository getRepository() {
		return new InMemoryAssociateRepository();
	}

	protected String getValidId() {
        return "1";
    }

    protected String getInvalidId() {
        return "";
    }	
}
