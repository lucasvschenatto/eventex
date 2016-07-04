package main.domain.activity;

import main.domain.Repository;
import main.domain.Text;

public interface ActivityRepository extends Repository<Activity>{

	Iterable<Activity> getAllForEventId(Text eventId);

}
