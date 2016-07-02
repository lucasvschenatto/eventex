package main.domain.activity.reading;

import java.util.Collection;

import main.domain.Text;
import main.domain.activity.Activity;
import main.domain.activity.ActivityRepository;

public class ReadActivitiesFilterUseCase {
	private final ReadActivitiesFilterRequest request;
	private final Collection<ActivitySummary> response;
	private final ActivityRepository repository;
	
	public ReadActivitiesFilterUseCase(ActivityRepository repository, ReadActivitiesFilterRequest request, 
			Collection<ActivitySummary> response){
		this.request = request;
		this.repository = repository;
		this.response = response;
	}
	
	public void execute(){
		for (Activity activity: repository.getAllForEventId(new Text(request.eventId)))
			response.add(makeActivitySummary(activity));
	}
	
	private ActivitySummary makeActivitySummary(Activity activity){
		ActivitySummary summary = new ActivitySummary();
		summary.id = activity.getId();
        summary.name = activity.getName().toString();
        summary.description = activity.getDescription().toString();
        summary.date = activity.getDate().toString();
        summary.time = activity.getTime().toString();
        summary.place = activity.getPlace().toString();
        summary.address = activity.getAddress().toSummary();
        summary.eventId = activity.getEventId().toString();
        summary.spots = activity.getSpots().toInt();
        summary.duration = activity.getDuration().toInt();
        summary.points= activity.getPoints().toInt();
        summary.groupDiscount = activity.getGroupDiscount().toBoolean();
        summary.voucher = activity.getVoucher().toBoolean();
		return summary;
	}

}
