package main.routes;

import main.domain.account.Encryptor;
import main.domain.account.UserRepository;
import main.domain.activity.ActivityRepository;
import main.domain.event.EventRepository;
import main.domain.participantCategory.ParticipantCategoryRepository;

public class Dependencies {
	private ActivityRepository activityRepository;
    private ParticipantCategoryRepository participantCategoryRepository;
	private UserRepository userRepository;
	private EventRepository eventRepository;
    private Encryptor encryptor;
	public ActivityRepository getActivityRepository() {
    	return activityRepository;
    }
    
    public EventRepository getEventRepository() {
    	return eventRepository;
    }

    public ParticipantCategoryRepository getParticipantCategoryRepository() {
		return participantCategoryRepository;
	}

	public UserRepository getUserRepository() {
	    return userRepository;
	}

	public void setActivityRepository(ActivityRepository activityRepository) {
    	this.activityRepository = activityRepository;
    }

    public void setEventRepository(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }
    
    public void setUserRepository(UserRepository userRepository) {
    	this.userRepository = userRepository;
    }

    public Encryptor getEncryptor() {
        return encryptor;
    }

    public void setEncryptor(Encryptor encryptor) {
        this.encryptor = encryptor;
    }

	public void setParticipantCategoryRepository(ParticipantCategoryRepository participantCategoryRepository) {
		this.participantCategoryRepository = participantCategoryRepository;
	}

}
