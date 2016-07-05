package main.domain.activity.updating;

import main.domain.activity.ActivityRepository;
import main.domain.activity.creating.CreateActivityUseCase;
import main.domain.event.EventRepository;
import main.persistence.EntityNotFoundException;
import main.domain.activity.Activity;

public class UpdateActivityUseCase extends CreateActivityUseCase{
	private final String id;
    
    public UpdateActivityUseCase(ActivityRepository activityRepository, EventRepository eventRepository, UpdateActivityRequest request, UpdateActivityResponse response){
    	super(activityRepository, eventRepository, request, response);
    	id = request.id;
    }
    
    protected boolean isValidRequest() {
        return super.isValidRequest() && idExists();
    }
    
    private boolean idExists() {
    	try{
    		activityRepository.getById(id);   
    		return true;
    	}
    	catch(EntityNotFoundException ignored){
    		return false;
    	}
	}
    
    protected Activity makeActivity() {
        Activity activity = super.makeActivity();
        activity.setId(id);
        return activity;
    }
    
    protected void sendErrors() {
    	super.sendErrors();
        ((UpdateActivityResponse)response).invalidId = !idExists();
    }

}
