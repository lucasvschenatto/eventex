package main.routes;

import main.domain.account.Encryptor;
import main.domain.account.UserRepository;
import main.domain.activity.ActivityRepository;
import main.domain.category.ParticipantCategoryRepository;
import main.domain.covenant.CovenantRepository;
import main.domain.event.EventRepository;

public class Dependencies {
	private ActivityRepository activityRepository;
	private ParticipantCategoryRepository categoryRepository;
	private CovenantRepository covenantRepository;
	private Encryptor encryptor;
	private EventRepository eventRepository;
	private UserRepository userRepository;

	public ActivityRepository getActivityRepository() {
		return activityRepository;
	}

	public CovenantRepository getCovenantRepository() {
		return covenantRepository;
	}

	public Encryptor getEncryptor() {
		return encryptor;
	}

	public EventRepository getEventRepository() {
		return eventRepository;
	}

	public ParticipantCategoryRepository getCategoryRepository() {
		return categoryRepository;
	}

	public UserRepository getUserRepository() {
		return userRepository;
	}

	public void setActivityRepository(ActivityRepository activityRepository) {
		this.activityRepository = activityRepository;
	}

	public void setCovenantRepository(CovenantRepository covenantRepository) {
		this.covenantRepository = covenantRepository;
	}

	public void setEncryptor(Encryptor encryptor) {
		this.encryptor = encryptor;
	}

	public void setEventRepository(EventRepository eventRepository) {
		this.eventRepository = eventRepository;
	}

	public void setParticipantCategoryRepository(ParticipantCategoryRepository participantCategoryRepository) {
		this.categoryRepository = participantCategoryRepository;
	}

	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

}
