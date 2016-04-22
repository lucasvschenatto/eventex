package main.persistence.inmemory;

import main.domain.event.EventRepository;
import main.domain.event.EventRepositoryTest;

public class InMemoryEventRepositoryTest extends EventRepositoryTest {
    protected EventRepository getRepository() {
        return new InMemoryEventRepository();
    }

    protected String getValidId() {
        return "1";
    }

    protected String getInvalidId() {
        return "";
    }
}