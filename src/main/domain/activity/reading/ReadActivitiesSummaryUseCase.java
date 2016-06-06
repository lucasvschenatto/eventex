package main.domain.activity.reading;

import java.util.Collection;

import main.domain.activity.Activity;
import main.domain.activity.ActivityRepository;

public class ReadActivitiesSummaryUseCase {
	private final ActivityRepository repository;
	private final Collection<ActivitySummary> response;
	
	public ReadActivitiesSummaryUseCase(ActivityRepository repository, Collection<ActivitySummary> response){
		this.repository = repository;
		this.response = response;
	}
	
	public void execute(){
		for (Activity activity: repository.getAll())
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
        summary.street = activity.getStreet().toString();
        summary.number = activity.getNumber().toInt();
        summary.complement = activity.getComplement().toString();
        summary.neighborhood = activity.getNeighborhood().toString();
        summary.city = activity.getCity().toString();
        summary.state = activity.getState().toString();
        summary.cep = activity.getCEP().toString();
        summary.eventId = activity.getEventId().toString();
        summary.spots = activity.getSpots().toInt();
        summary.duration = activity.getMinutes().toInt();
        summary.points= activity.getPoints().toInt();
        summary.groupDiscount = activity.getGroupDiscount().toBoolean();
        summary.voucher = activity.getVoucher().toBoolean();
		return summary;
	}

}
