package main.domain.activity.reading;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import main.domain.CEP;
import main.domain.Date;
import main.domain.IntNumber;
import main.domain.Text;
import main.domain.Time;
import main.domain.activity.ActivityRepository;
import main.domain.activity.creating.CreateActivityRequest;
import main.domain.activity.creating.CreateActivityResponse;
import main.domain.activity.creating.CreateActivityUseCase;
import main.domain.event.Event;
import main.domain.event.EventRepository;
import main.persistence.inmemory.InMemoryActivityRepository;
import main.persistence.inmemory.InMemoryEventRepository;

public class ReadActivityUseCaseTest {
	private ActivityRepository activityRepository;
	private EventRepository eventRepository;
	private ArrayList<ActivitySummary> response;
	
	private void givenActivity(String name, String description, String date, String time, String place, 
    		String street, String number, String complement, String neighborhood, String city, String state, String cep,
    		String eventId,
    		String spots, String duration, String points, 
    		String groupDiscount, String voucher) {
		createDummyEventWithId(eventId);
        CreateActivityRequest request = new CreateActivityRequest();
        CreateActivityResponse response = new CreateActivityResponse();
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
        request.eventId = eventId;
        request.spots = spots;
        request.duration = duration;
        request.points = points;
        request.groupDiscount = groupDiscount;
        request.voucher = voucher;
        new CreateActivityUseCase(activityRepository,eventRepository,request,response).execute();
    }
	
	private void createDummyEventWithId(String eventId) {
		Event event = new Event();
        event.setId(eventId);
        event.setName(new Text("Name"));
        event.setDescription(new Text("Description"));
        event.setDate(new Date("1900-01-01"));
        event.setTime(new Time("06:59:59"));
        event.setPlace(new Text("place"));
        event.setStreet(new Text("street"));
        event.setNumber(new IntNumber("1"));
        event.setComplement(new Text("complement"));
        event.setNeighborhood(new Text("neighborhood"));
        event.setCity(new Text("city"));
        event.setState(new Text("state"));
        event.setCEP(new CEP("11111-111"));
        eventRepository.save(event);
	}

	private void whenReadingSummaries(){
		new ReadActivitiesSummaryUseCase(activityRepository, response).execute();
	}
	
	private void thenTheSizeMustBe(int size) {
        assertEquals(size, response.size());
    }
	
	private void andItMustPresentAtIndex(int index, String id, String name, String description, String date, String time, String place, 
    		String street, int number, String complement, String neighborhood, String city, String state, String cep,
    		String eventId,
    		int spots, int duration, int points, 
    		boolean groupDiscount, boolean voucher) {
		ActivitySummary summary = response.get(index);
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
        assertEquals(eventId, summary.eventId);
        assertEquals(spots, summary.spots);
        assertEquals(duration, summary.duration);
        assertEquals(points, summary.points);
        assertEquals(groupDiscount, summary.groupDiscount);
        assertEquals(voucher, summary.voucher);
	}
	
	@Before
	public void setUp() throws Exception{
		activityRepository = new InMemoryActivityRepository();
		eventRepository = new InMemoryEventRepository();
		response = new ArrayList<>();
	}
	
	@Test
    public void givenNoActivities_itReturnsAnEmptyCollection() {
        whenReadingSummaries();
        thenTheSizeMustBe(0);
    }
	
	@Test
	public void givenAnActivity_itMustBeReturnedInTheSummary(){
		givenActivity("name 1", "description 1", "2011-01-01", "01:01:01", "place 1", "street 1", "100", "ap. 11", "downtown 1", "city 1", "state 1", "10000-111","111Aafbe", "101","31","1100", "true", "true");
		givenActivity("name 2", "description 2", "2022-02-02", "02:02:02", "place 2", "street 2", "200", "ap. 22", "downtown 2", "city 2", "state 2", "20000-222","222Aafbe", "202","32","2200", "false", "false");
		whenReadingSummaries();
		thenTheSizeMustBe(2);
		andItMustPresentAtIndex(0, "1", "name 1", "description 1", "2011-01-01", "01:01:01", "place 1", "street 1", 100, "ap. 11", "downtown 1", "city 1", "state 1", "10000-111", "111Aafbe", 101,31,1100, true, true);
		andItMustPresentAtIndex(1, "2", "name 2", "description 2", "2022-02-02", "02:02:02", "place 2", "street 2", 200, "ap. 22", "downtown 2", "city 2", "state 2", "20000-222", "222Aafbe", 202,32,2200, false, false);
	}

}
