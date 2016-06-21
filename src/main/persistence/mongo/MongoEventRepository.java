package main.persistence.mongo;

import main.domain.event.Event;
import main.domain.event.EventRepository;
import main.persistence.mongo.converters.EventConverter;

public class MongoEventRepository extends MongoRepository<Event> implements EventRepository {

	public MongoEventRepository() {
		super("events", new EventConverter());
	}
}