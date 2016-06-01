package main.domain.event.creating;

import main.domain.CEP;
import main.domain.Date;
import main.domain.Numeric;
import main.domain.Text;
import main.domain.event.Event;
import main.domain.event.EventRepository;
import main.domain.event.Time;

public class CreateEventUseCase {
    private final EventRepository repository;
    private final Text name;
    private final Text description;
    private final Date date;
    private final Time time;
    private final Text place;
    protected final Text street;
	protected final Numeric number;
	protected final Text complement;
	protected final Text neighborhood;
	protected final Text city;
	protected final Text state;
	protected final CEP cep;
    private final CreateEventResponse response;

    public CreateEventUseCase(EventRepository repository, CreateEventRequest request, CreateEventResponse response) {
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
        this.response = response;
    }

    public void execute() {
        if (isValidRequest())
            create();
        else
            sendErrors();
    }

    private boolean isValidRequest() {
        return name.isValid() && description.isValid() && date.isValid() && time.isValid() && place.isValid() &&
        		street.isValid() && number.isValid() && complement.isValid() && neighborhood.isValid() &&
        		city.isValid() && state.isValid() && cep.isValid();
    }

    private void create() {
        repository.save(makeEvent());
        response.success = true;
    }

    private Event makeEvent() {
        Event event = new Event();
        event.setName(name);
        event.setDescription(description);
        event.setDate(date);
        event.setTime(time);
        event.setPlace(place);
        event.setStreet(street);
        event.setNumber(number);
        event.setComplement(complement);
        event.setNeighborhood(neighborhood);
        event.setCity(city);
        event.setState(state);
        event.setCEP(cep);
        return event;
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
    }
}
