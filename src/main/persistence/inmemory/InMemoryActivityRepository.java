package main.persistence.inmemory;

import java.util.HashSet;
import java.util.Set;

import main.domain.Text;
import main.domain.activity.Activity;
import main.domain.activity.ActivityRepository;

public class InMemoryActivityRepository extends InMemoryRepository<Activity> implements ActivityRepository {
	
	public Iterable<Activity> getAllForEventId(Text eventId) {
		Set<Activity> filteredByEventId = new HashSet<Activity>();
		getAll().forEach((activity)->{
			if(activity.getEventId().equals(eventId))
				filteredByEventId.add(activity);
		});
		return filteredByEventId;
	}
}
