package main.domain.activity.reading;

import main.domain.activity.Activity;
import main.domain.activity.ActivityRepository;

public class ReadActivityUseCase {
	private final String id;
	private final ActivityRepository repository;
	private final ActivitySummary response;
	
	public ReadActivityUseCase(ActivityRepository repository, ReadActivityRequest request, ActivitySummary response){
		id = request.id;
		this.repository = repository;
		this.response = response;
	}
	
	public void execute(){
		if(activityExists())
			sendActivity();
	}
	
	private boolean activityExists() {
		return repository.hasWithId(id);
	}

	private void sendActivity() {
		Activity activity = repository.getById(id);
		response.id = activity.getId();
		response.name = activity.getName().toString();
		response.description = activity.getDescription().toString();
		response.date = activity.getDate().toString();
		response.time = activity.getTime().toString();
		response.place = activity.getPlace().toString();
		response.address = activity.getAddress().toSummary();
		response.eventId = activity.getEventId().toString();
		response.spots = activity.getSpots().toInt();
		response.duration = activity.getDuration().toInt();
		response.points= activity.getPoints().toInt();
		response.groupDiscount = activity.getGroupDiscount().toBoolean();
		response.voucher = activity.getVoucher().toBoolean();
	}
}
