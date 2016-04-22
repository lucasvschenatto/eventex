package main.domain.event.reading;

import main.domain.event.EventRepository;
import main.domain.event.creating.CreateEventRequest;
import main.domain.event.creating.CreateEventResponse;
import main.domain.event.creating.CreateEventUseCase;
import main.domain.event.reading.EventSummary;
import main.domain.event.reading.ReadEventsSummaryUseCase;
import main.persistence.inmemory.InMemoryEventRepository;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class ReadEventsSummaryUseCaseTest {
    private EventRepository repository;
    private ArrayList<EventSummary> response;

    private void givenEvent(String name, String description, String date, String time, String place, String address) {
        CreateEventRequest request = new CreateEventRequest();
        request.name = name;
        request.description = description;
        request.date = date;
        request.time = time;
        request.place = place;
        request.address = address;
        CreateEventResponse response = new CreateEventResponse();
        new CreateEventUseCase(repository, request, response).execute();
    }

    private void whenReadingSummaries() {
        new ReadEventsSummaryUseCase(repository, response).execute();
    }

    private void thenTheSizeMustBe(int size) {
        assertEquals(size, response.size());
    }

    private void andItMustPresentAtIndex(int index, String id, String name, String description, String date, String time, String place, String address) {
        EventSummary summary = response.get(index);
        assertEquals(id, summary.id);
        assertEquals(name, summary.name);
        assertEquals(description, summary.description);
        assertEquals(date, summary.date);
        assertEquals(time, summary.time);
        assertEquals(place, summary.place);
        assertEquals(address, summary.address);
    }

    @Before
    public void setUp() throws Exception {
        repository = new InMemoryEventRepository();
        response = new ArrayList<>();
    }

    @Test
    public void givenNoProducts_itReturnsAnEmptyCollection() {
        whenReadingSummaries();
        thenTheSizeMustBe(0);
    }

    @Test
    public void givenAProduct_itMustBeReturnedInTheSummary() {
        givenEvent("name 1", "description 1", "2011-01-01", "01:01:01", "place 1", "address 1");
        givenEvent("name 2", "description 2", "2022-02-02", "02:02:02", "place 2", "address 2");
        whenReadingSummaries();
        thenTheSizeMustBe(2);
        andItMustPresentAtIndex(0, "1", "name 1", "description 1", "2011-01-01", "01:01:01", "place 1", "address 1");
        andItMustPresentAtIndex(1, "2", "name 2", "description 2", "2022-02-02", "02:02:02", "place 2", "address 2");
    }
}