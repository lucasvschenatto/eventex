package main.routes;

import main.domain.account.Encryptor;
import main.domain.account.UserRepository;
import main.domain.event.EventRepository;

public class Dependencies {
    private UserRepository userRepository;
    private EventRepository eventRepository;
    private Encryptor encryptor;

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public EventRepository getEventRepository() {
        return eventRepository;
    }

    public void setEventRepository(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public Encryptor getEncryptor() {
        return encryptor;
    }

    public void setEncryptor(Encryptor encryptor) {
        this.encryptor = encryptor;
    }
}
