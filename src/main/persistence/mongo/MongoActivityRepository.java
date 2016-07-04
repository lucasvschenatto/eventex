package main.persistence.mongo;

import org.bson.Document;
import org.bson.conversions.Bson;

import main.domain.Text;
import main.domain.activity.Activity;
import main.domain.activity.ActivityRepository;
import main.persistence.mongo.converters.ActivityConverter;
import main.persistence.mongo.converters.TextConverter;

public class MongoActivityRepository extends MongoRepository<Activity> implements ActivityRepository {
	private TextConverter textConverter = new TextConverter();
	
	protected MongoActivityRepository() {
		super("activities", new ActivityConverter());
	}

	public Iterable<Activity> getAllForEventId(Text eventId) {
		return getAllBy(makeEventIdQuery(eventId));
	}

	private Bson makeEventIdQuery(Text eventId) {
		return new Document("event_id", textConverter.to(eventId));
	}
}
