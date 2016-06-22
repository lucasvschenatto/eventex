package main.domain.event.updating;

import main.domain.event.Event;
import main.domain.event.EventRepository;
import main.domain.event.creating.CreateEventUseCase;
import main.persistence.EntityNotFoundException;

public class UpdateEventUseCase extends CreateEventUseCase{
	private final String id;

    public UpdateEventUseCase(EventRepository repository, UpdateEventRequest request, UpdateEventResponse response) {
    	super(repository, request, response);
    	this.id = request.id;
    }
    
    protected boolean isValidRequest() {
        return super.isValidRequest() && idExists();
    }

	private boolean idExists() {
		try{
    		repository.getById(id);   
    		return true;
    	}
    	catch(EntityNotFoundException ignored){
    		return false;
    	}
	}

	protected Event makeEvent() {
        Event event = super.makeEvent();
        event.setId(id);
        return event;
    }

    protected void sendErrors() {
        super.sendErrors();
        ((UpdateEventResponse)response).invalidId = ! idExists();
    }
}
