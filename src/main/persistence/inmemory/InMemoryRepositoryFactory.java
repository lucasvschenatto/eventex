package main.persistence.inmemory;

import main.domain.account.UserRepository;
import main.domain.activity.ActivityRepository;
import main.domain.event.EventRepository;
import main.domain.participantCategory.ParticipantCategoryRepository;

public abstract class InMemoryRepositoryFactory {
	private static InMemoryActivityRepository activity;
	private static InMemoryEventRepository event;
	private static ParticipantCategoryRepository participantCategory;
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

	public static ParticipantCategoryRepository getParticipantCategoryRepository() {
		if(participantCategory == null)
			participantCategory = new InMemoryParticipantCategoryRepository();
		return participantCategory;
	}

	public static void resetAll() {
		activity = null;
		event = null;
		participantCategory = null;
		user = null;
	}

}
