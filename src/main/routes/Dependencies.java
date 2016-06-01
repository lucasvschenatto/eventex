package main.routes;

import main.domain.account.Encryptor;
import main.domain.account.UserRepository;
import main.domain.activity.ActivityRepository;
import main.domain.event.EventRepository;

public class Dependencies {
	private ActivityRepository activityRepository;
    private UserRepository userRepository;
    private EventRepository eventRepository;
    private Encryptor encryptor;

    public ActivityRepository getActivityRepository() {
    	return activityRepository;
    }
    
    public UserRepository getUserRepository() {
        return userRepository;
    }
    
    public EventRepository getEventRepository() {
    	return eventRepository;
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

}
