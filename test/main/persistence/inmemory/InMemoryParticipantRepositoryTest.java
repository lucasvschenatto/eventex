package main.persistence.inmemory;

import main.domain.participant.ParticipantRepository;
import main.domain.participant.ParticipantRepositoryTest;

public class InMemoryParticipantRepositoryTest extends ParticipantRepositoryTest {
    protected ParticipantRepository getRepository() {
        return new InMemoryParticipantRepository();
    }

    protected String getValidId() {
        return "1";
    }

    protected String getInvalidId() {
        return "";
    }
}