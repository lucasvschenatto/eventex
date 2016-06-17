package main.persistence.inmemory;

import main.domain.inscription.InscriptionRepository;
import main.domain.inscription.InscriptionRepositoryTest;

public class InMemoryInscriptionRepositoryTest extends InscriptionRepositoryTest{

	protected InscriptionRepository getRepository() {
		return new InMemoryInscriptionRepository();
	}

	@Override
	protected String getValidId() {
		return "1";
	}

	@Override
	protected String getInvalidId() {
		return "";
	}

}
