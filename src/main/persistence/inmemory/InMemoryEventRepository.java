package main.persistence.inmemory;

import main.domain.event.Event;
import main.domain.event.EventRepository;

public class InMemoryEventRepository extends InMemoryRepository<Event> implements EventRepository {
}