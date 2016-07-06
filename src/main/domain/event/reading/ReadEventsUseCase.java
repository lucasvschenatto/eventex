package main.domain.event.reading;

import java.util.Collection;

import main.domain.event.Event;
import main.domain.event.EventRepository;

public class ReadEventsUseCase {
    private final EventRepository repository;
    private final Collection<EventSummary> response;

    public ReadEventsUseCase(EventRepository repository, Collection<EventSummary> response) {
        this.repository = repository;
        this.response = response;
    }

    public void execute() {
        for (Event event : repository.getAll())
            response.add(makeEventSummary(event));
    }

    private EventSummary makeEventSummary(Event event) {
        EventSummary summary = new EventSummary();
        summary.id = event.getId();
        summary.name = event.getName().toString();
        summary.description = event.getDescription().toString();
        summary.date = event.getDate().toString();
        summary.time = event.getTime().toString();
        summary.place = event.getPlace().toString();
        summary.address = event.getAddress().toSummary();
        return summary;
    }
}
