package main.domain.activity.creating;

import main.domain.Booleanic;
import main.domain.CEP;
import main.domain.Date;
import main.domain.Numeric;
import main.domain.Quantity;
import main.domain.Text;
import main.domain.Time;
import main.domain.activity.ActivityRepository;
import main.domain.activity.Minutes;
import main.domain.activity.Activity;

public class CreateActivityUseCase {
	private final ActivityRepository repository;
	private final Text name;
    private final Text description;
    private final Date date;
    private final Time time;
    private final Text place;
    private final Text street;
	private final Numeric number;
	private final Text complement;
	private final Text neighborhood;
	private final Text city;
	private final Text state;
	private final CEP cep;
	private final Quantity spots;
	private final Minutes duration;
	private final Quantity points;
	private final Booleanic groupDiscount;
	private final Booleanic voucher;
    private final CreateActivityResponse response;
    
    public CreateActivityUseCase(ActivityRepository repository, CreateActivityRequest request, CreateActivityResponse response){
    	this.repository = repository;
        name = new Text(request.name);
        description = new Text(request.description);
        date = new Date(request.date);
        time = new Time(request.time);
        place = new Text(request.place);
        street = new Text(request.street);
        number = new Numeric(request.number);
        complement = new Text(request.complement);
        neighborhood = new Text(request.neighborhood);
        city = new Text(request.city);
        state = new Text(request.state);
        cep = new CEP(request.cep);
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
    
    private boolean isValidRequest() {
        return name.isValid() && description.isValid() && date.isValid() && time.isValid() && place.isValid() &&
        		street.isValid() && number.isValid() && complement.isValid() && neighborhood.isValid() &&
        		city.isValid() && state.isValid() && cep.isValid() &&
        		spots.isValid() && duration.isValid() && points.isValid() &&
        		groupDiscount.isValid() && voucher.isValid();
    }
    
    private void create(){
    	repository.save(makeActivity());
    	response.success = true;
    }
    
    private Activity makeActivity() {
        Activity activity = new Activity();
        activity.setName(name);
        activity.setDescription(description);
        activity.setDate(date);
        activity.setTime(time);
        activity.setPlace(place);
        activity.setStreet(street);
        activity.setNumber(number);
        activity.setComplement(complement);
        activity.setNeighborhood(neighborhood);
        activity.setCity(city);
        activity.setState(state);
        activity.setCEP(cep);
        activity.setSpots(spots);
        activity.setDuration(duration);
        activity.setPoints(points);
        activity.setGroupDiscount(groupDiscount);
        activity.setVoucher(voucher);
        return activity;
    }
    
    private void sendErrors() {
        response.invalidName = !name.isValid();
        response.invalidDescription = !description.isValid();
        response.invalidDate = !date.isValid();
        response.invalidTime = !time.isValid();
        response.invalidPlace = !place.isValid();
        response.invalidStreet = !street.isValid();
        response.invalidNumber = !number.isValid();
        response.invalidComplement = !complement.isValid();
        response.invalidNeighborhood = !neighborhood.isValid();
        response.invalidCity = !city.isValid();
        response.invalidState = !state.isValid();
        response.invalidCEP = !cep.isValid();
        response.invalidSpots = !spots.isValid();
        response.invalidDuration = !duration.isValid();
        response.invalidPoints = !points.isValid();
        response.invalidGroupDiscount = !groupDiscount.isValid();
        response.invalidGroupDiscount = !voucher.isValid();
    }

}
