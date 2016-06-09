package main.persistence.inmemory;

import main.domain.account.UserRepository;
import main.domain.activity.ActivityRepository;
import main.domain.category.ParticipantCategoryRepository;
import main.domain.covenant.CovenantRepository;
import main.domain.event.EventRepository;

public abstract class InMemoryRepositoryFactory {
	private static InMemoryActivityRepository activity;
	private static ParticipantCategoryRepository category;
	private static CovenantRepository covenant;
	private static InMemoryEventRepository event;
	private static InMemoryUserRepository user;

	public static void resetAll() {
		activity = null;
		event = null;
		category = null;
		covenant = null;
		user = null;
	}

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

	public static ParticipantCategoryRepository getCategoryRepository() {
		if(category == null)
			category = new InMemoryParticipantCategoryRepository();
		return category;
	}

	public static CovenantRepository getCovenantRepository() {
		if(covenant == null)
			covenant = new InMemoryCovenantRepository();
		return covenant;
	}

}
