package main.persistence.inmemory;

import main.domain.account.UserRepository;
import main.domain.event.EventRepository;
import main.domain.event.activity.ActivityRepository;

public abstract class InMemoryRepositoryFactory {
	private static InMemoryActivityRepository activity;
	private static InMemoryEventRepository event;
	private static InMemoryUserRepository user;

	public static ActivityRepository getActivityRepository() {
		if(activity == null)
			activity = new InMemoryActivityRepository();
		return activity;
	}
	
	public static EventRepository getEventRepository() {
		if(event == null)
			event = new InMemoryEventRepository();
		return event;
	}
	
	public static UserRepository getUserRepository() {
		if(user == null)
			user = new InMemoryUserRepository();
		return user;
	}

}
