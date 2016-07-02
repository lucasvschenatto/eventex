package main.domain.activity.reading;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import main.domain.Address;
import main.domain.AddressData;
import main.domain.AddressSummary;
import main.domain.Date;
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

public class ReadActivitiesFilterUseCaseTest {
	private ActivityRepository activityRepository;
	private EventRepository eventRepository;
	private ReadActivitiesFilterRequest request;
	private ArrayList<ActivitySummary> response;
	
	private static AddressData addressData1() {
    	AddressData data = new AddressData();
		data.street = "Street 1";
		data.number = "100";
		data.complement = "apartment 1";
		data.neighborhood = "Downtown 1";
		data.city = "City 1";
		data.state = "State 1";
		data.country = "Country 1";
		data.cep = "10000-111";
		return data;
	}

	private static AddressData addressData2() {
    	AddressData data = new AddressData();
    	data.street = "Street 2";
		data.number = "200";
		data.complement = "apartment 2";
		data.neighborhood = "Downtown 2";
		data.city = "City 2";
		data.state = "State 2";
		data.country = "Country 2";
		data.cep = "20000-222";
		return data;
	}
	
	private static AddressSummary addressSummary1() {
		AddressSummary data = new AddressSummary();
		data.street = "Street 1";
		data.number = 100;
		data.complement = "apartment 1";
		data.neighborhood = "Downtown 1";
		data.city = "City 1";
		data.state = "State 1";
		data.country = "Country 1";
		data.cep = "10000-111";
		return data;
	}

	private static AddressSummary addressSummary2() {
    	AddressSummary data = new AddressSummary();
    	data.street = "Street 2";
		data.number = 200;
		data.complement = "apartment 2";
		data.neighborhood = "Downtown 2";
		data.city = "City 2";
		data.state = "State 2";
		data.country = "Country 2";
		data.cep = "20000-222";
		return data;
	}
	
	private void givenActivity(String name, String description, String date, String time, String place, 
    		AddressData address,
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
        request.address = address;
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
        event.setAddress(new Address(null));
        eventRepository.save(event);
	}

	private void whenReadingWithEventFilter(String eventId){
		request.eventId = eventId;
		new ReadActivitiesFilterUseCase(activityRepository, request, response).execute();
	}
	
	private void thenTheSizeMustBe(int size) {
        assertEquals(size, response.size());
    }
	
	private void andItMustPresentAtIndex(int index, String id, String name, String description, String date, String time, String place, 
    		AddressSummary address,
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
        assertEquals(address, summary.address);
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
		request = new ReadActivitiesFilterRequest();
		response = new ArrayList<>();
	}
	
	@Test
    public void givenNoActivities_itReturnsAnEmptyCollection() {
        whenReadingWithEventFilter("");
        thenTheSizeMustBe(0);
    }
	
	@Test
	public void givenAnActivity_itMustBeReturnedInTheSummary(){
		givenActivity("name 1", "description 1", "2011-01-01", "01:01:01", "place 1", addressData1(),"111Aafbe", "101","31","1100", "true", "true");
		givenActivity("name 2", "description 2", "2022-02-02", "02:02:02", "place 2", addressData2(),"222Aafbe", "202","32","2200", "false", "false");
		givenActivity("name 3", "description 3", "2011-01-01", "01:01:01", "place 1", addressData2(),"111Aafbe", "101","31","1100", "true", "true");
		whenReadingWithEventFilter("111Aafbe");
		thenTheSizeMustBe(2);
		andItMustPresentAtIndex(0, "1", "name 1", "description 1", "2011-01-01", "01:01:01", "place 1", addressSummary1(), "111Aafbe", 101,31,1100, true, true);
		andItMustPresentAtIndex(1, "3", "name 3", "description 3", "2011-01-01", "01:01:01", "place 1", addressSummary2(), "111Aafbe", 101,31,1100, true, true);
	}

}
