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

    private void givenEvent(String name, String description, String date, String time, String place, 
    		String street, String number, String complement, String neighborhood, String city, String state, String cep) {
        CreateEventRequest request = new CreateEventRequest();
        request.name = name;
        request.description = description;
        request.date = date;
        request.time = time;
        request.place = place;
        request.street = street;
        request.number = number;
        request.complement = complement;
        request.neighborhood = neighborhood;
        request.city = city;
        request.state = state;
        request.cep = cep;
        CreateEventResponse response = new CreateEventResponse();
        new CreateEventUseCase(repository, request, response).execute();
    }

    private void whenReadingSummaries() {
        new ReadEventsSummaryUseCase(repository, response).execute();
    }

    private void thenTheSizeMustBe(int size) {
        assertEquals(size, response.size());
    }

    private void andItMustPresentAtIndex(int index, String id, String name, String description, String date, String time, String place, 
    		String street, String number, String complement, String neighborhood, String city, String state, String cep) {
        EventSummary summary = response.get(index);
        assertEquals(id, summary.id);
        assertEquals(name, summary.name);
        assertEquals(description, summary.description);
        assertEquals(date, summary.date);
        assertEquals(time, summary.time);
        assertEquals(place, summary.place);
        assertEquals(street, summary.street);
        assertEquals(number, summary.number);
        assertEquals(complement, summary.complement);
        assertEquals(neighborhood, summary.neighborhood);
        assertEquals(city, summary.city);
        assertEquals(state, summary.state);
        assertEquals(cep, summary.cep);
    }

    @Before
    public void setUp() throws Exception {
        repository = new InMemoryEventRepository();
        response = new ArrayList<>();
    }

    @Test
    public void givenNoEvents_itReturnsAnEmptyCollection() {
        whenReadingSummaries();
        thenTheSizeMustBe(0);
    }

    @Test
    public void givenAnEvent_itMustBeReturnedInTheSummary() {
        givenEvent("name 1", "description 1", "2011-01-01", "01:01:01", "place 1", "street 1", "100", "ap. 11", "downtown 1", "city 1", "state 1", "10000-111");
        givenEvent("name 2", "description 2", "2022-02-02", "02:02:02", "place 2", "street 2", "200", "ap. 22", "downtown 2", "city 2", "state 2", "20000-222");
        whenReadingSummaries();
        thenTheSizeMustBe(2);
        andItMustPresentAtIndex(0, "1", "name 1", "description 1", "2011-01-01", "01:01:01", "place 1", "street 1", "100", "ap. 11", "downtown 1", "city 1", "state 1", "10000-111");
        andItMustPresentAtIndex(1, "2", "name 2", "description 2", "2022-02-02", "02:02:02", "place 2", "street 2", "200", "ap. 22", "downtown 2", "city 2", "state 2", "20000-222");
    }
}