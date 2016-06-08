package main.persistence.inmemory;

import main.domain.participantCategory.ParticipantCategoryRepository;
import main.domain.participantCategory.ParticipantCategoryRepositoryTest;

public class InMemoryParticipantCategoryRepositoryTest extends ParticipantCategoryRepositoryTest{

	protected ParticipantCategoryRepository getRepository() {
		return new InMemoryParticipantCategoryRepository();
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
