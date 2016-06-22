package main.domain.activity.creating;

import main.domain.Address;
import main.domain.AddressValidation;
import main.domain.Booleanic;
import main.domain.Date;
import main.domain.Quantity;
import main.domain.Text;
import main.domain.Time;
import main.domain.activity.ActivityRepository;
import main.domain.activity.Minutes;
import main.domain.event.EventRepository;
import main.persistence.EntityNotFoundException;
import main.domain.activity.Activity;

public class CreateActivityUseCase {
	protected final ActivityRepository activityRepository;
	private final EventRepository eventRepository;
	private final Text name;
    private final Text description;
    private final Date date;
    private final Time time;
    private final Text place;
    private final Address address;
	private final Text eventId;
	private final Quantity spots;
	private final Minutes duration;
	private final Quantity points;
	private final Booleanic groupDiscount;
	private final Booleanic voucher;
    protected final CreateActivityResponse response;
    
    public CreateActivityUseCase(ActivityRepository activityRepository, EventRepository eventRepository, CreateActivityRequest request, CreateActivityResponse response){
    	this.activityRepository = activityRepository;
    	this.eventRepository = eventRepository;
        name = new Text(request.name);
        description = new Text(request.description);
        date = new Date(request.date);
        time = new Time(request.time);
        place = new Text(request.place);
        address = new Address(request.address);
        eventId = new Text(request.eventId);
        spots = new Quantity(request.spots);
        duration = new Minutes(request.duration);
        points = new Quantity(request.points);
        groupDiscount = new Booleanic(request.groupDiscount);
        voucher = new Booleanic(request.voucher);
        this.response = response;
    }
    
    public void execute(){
    	if(isValidRequest())
    		create();
    	else
    		sendErrors();
    }
    
    protected boolean isValidRequest() {
        return isValidFields() && eventIdExists();
    }
    
    private boolean eventIdExists() {
    	try{
    		eventRepository.getById(eventId.toString());   
    		return true;
    	}
    	catch(EntityNotFoundException ignored){
    		return false;
    	}
	}

	private boolean isValidFields() {
		return name.isValid() && description.isValid() && date.isValid() && time.isValid() && place.isValid() &&
	    		address.isValid() &&
	    		eventId.isValid() &&
	    		spots.isValid() && duration.isValid() && points.isValid() &&
	    		groupDiscount.isValid() && voucher.isValid();
	}

	private void create(){
    	activityRepository.save(makeActivity());
    	response.success = true;
    	response.address = sendAddressIsValid();
    }
	
	private AddressValidation sendAddressIsValid() {
    	AddressValidation validation = new AddressValidation();
		return validation;
	}
    
    protected Activity makeActivity() {
        Activity activity = new Activity();
        activity.setName(name);
        activity.setDescription(description);
        activity.setDate(date);
        activity.setTime(time);
        activity.setPlace(place);
        activity.setAddress(address);
        activity.setEventId(eventId);
        activity.setSpots(spots);
        activity.setDuration(duration);
        activity.setPoints(points);
        activity.setGroupDiscount(groupDiscount);
        activity.setVoucher(voucher);
        return activity;
    }
    
    protected void sendErrors() {
        response.invalidName = !name.isValid();
        response.invalidDescription = !description.isValid();
        response.invalidDate = !date.isValid();
        response.invalidTime = !time.isValid();
        response.invalidPlace = !place.isValid();
        response.address = address.getValidation();
        response.invalidEventId = (!eventId.isValid()) || (!eventIdExists());
        response.invalidSpots = !spots.isValid();
        response.invalidDuration = !duration.isValid();
        response.invalidPoints = !points.isValid();
        response.invalidGroupDiscount = !groupDiscount.isValid();
        response.invalidVoucher = !voucher.isValid();
    }

}
