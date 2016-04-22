package main.domain.event.creating;

import main.domain.Text;
import main.domain.event.Event;
import main.domain.event.EventRepository;

public class CreateEventUseCase {
    private final EventRepository repository;
    private final Text name;
    private final Text description;
    private final Text date;
    private final Text time;
    private final Text place;
    private final Text address;
    private final CreateEventResponse response;

    public CreateEventUseCase(EventRepository repository, CreateEventRequest request, CreateEventResponse response) {
        this.repository = repository;
        name = new Text(request.name);
        description = new Text(request.description);
        date = new Text(request.date);
        time = new Text(request.time);
        place = new Text(request.place);
        address = new Text(request.address);
        this.response = response;
    }

    public void execute() {
        if (isValidRequest())
            create();
        else
            sendErrors();
    }

    private boolean isValidRequest() {
        return name.isValid() && description.isValid() && date.isValid() && time.isValid() && place.isValid() && address.isValid();
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
        event.setAddress(address);
        return event;
    }

    private void sendErrors() {
        response.invalidName = !name.isValid();
        response.invalidDescription = !description.isValid();
        response.invalidDate = !date.isValid();
        response.invalidTime = !time.isValid();
        response.invalidPlace = !place.isValid();
        response.invalidAddress = !address.isValid();
    }
}
