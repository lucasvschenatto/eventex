package main.domain.event.reading;

import main.domain.event.Event;
import main.domain.event.EventRepository;

public class ReadEventUseCase {
	private final ReadEventRequest request;
    private final EventRepository repository;
    private final EventSummary response;

    public ReadEventUseCase(EventRepository repository, ReadEventRequest request, EventSummary response) {
    	this.request = request;
        this.repository = repository;
        this.response = response;
    }

    public void execute() {
    	if(eventExists())
    		sendEvent();
    }

    private boolean eventExists() {
		return repository.hasWithId(request.id);
	}

	private void sendEvent() {
		Event event = repository.getById(request.id);
        response.id = event.getId();
        response.name = event.getName().toString();
        response.description = event.getDescription().toString();
        response.date = event.getDate().toString();
        response.time = event.getTime().toString();
        response.place = event.getPlace().toString();
        response.address = event.getAddress().toSummary();
    }
}
