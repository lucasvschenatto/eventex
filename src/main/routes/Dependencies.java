package main.routes;

import main.domain.account.Encryptor;
import main.domain.account.UserRepository;
import main.domain.activity.ActivityRepository;
import main.domain.associate.AssociateRepository;
import main.domain.category.CategoryRepository;
import main.domain.event.EventRepository;

public class Dependencies {
	private ActivityRepository activityRepository;
	private CategoryRepository categoryRepository;
	private AssociateRepository associateRepository;
	private Encryptor encryptor;
	private EventRepository eventRepository;
	private UserRepository userRepository;

	public ActivityRepository getActivityRepository() {
		return activityRepository;
	}

	public AssociateRepository getAssociateRepository() {
		return associateRepository;
	}

	public Encryptor getEncryptor() {
		return encryptor;
	}

	public EventRepository getEventRepository() {
		return eventRepository;
	}

	public CategoryRepository getCategoryRepository() {
		return categoryRepository;
	}

	public UserRepository getUserRepository() {
		return userRepository;
	}

	public void setActivityRepository(ActivityRepository activityRepository) {
		this.activityRepository = activityRepository;
	}

	public void setAssociateRepository(AssociateRepository associateRepository) {
		this.associateRepository = associateRepository;
	}

	public void setEncryptor(Encryptor encryptor) {
		this.encryptor = encryptor;
	}

	public void setEventRepository(EventRepository eventRepository) {
		this.eventRepository = eventRepository;
	}

	public void setParticipantCategoryRepository(CategoryRepository participantCategoryRepository) {
		this.categoryRepository = participantCategoryRepository;
	}

	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

}
