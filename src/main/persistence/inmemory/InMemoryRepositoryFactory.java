package main.persistence.inmemory;

import main.domain.account.UserRepository;
import main.domain.activity.ActivityRepository;
import main.domain.associate.AssociateRepository;
import main.domain.category.CategoryRepository;
import main.domain.event.EventRepository;

public abstract class InMemoryRepositoryFactory {
	private static InMemoryActivityRepository activity;
	private static CategoryRepository category;
	private static AssociateRepository associate;
	private static InMemoryEventRepository event;
	private static InMemoryUserRepository user;

	public static void resetAll() {
		activity = null;
		event = null;
		category = null;
		associate = null;
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

	public static CategoryRepository getCategoryRepository() {
		if(category == null)
			category = new InMemoryCategoryRepository();
		return category;
	}

	public static AssociateRepository getAssociateRepository() {
		if(associate == null)
			associate = new InMemoryAssociateRepository();
		return associate;
	}

}
