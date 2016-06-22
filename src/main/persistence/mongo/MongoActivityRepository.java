package main.persistence.mongo;

import main.domain.activity.Activity;
import main.domain.activity.ActivityRepository;
import main.persistence.mongo.converters.ActivityConverter;

public class MongoActivityRepository extends MongoRepository<Activity> implements ActivityRepository {

	protected MongoActivityRepository() {
		super("activities", new ActivityConverter());
	}
}
