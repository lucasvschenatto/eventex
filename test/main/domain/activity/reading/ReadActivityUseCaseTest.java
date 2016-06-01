package main.domain.activity.reading;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import main.domain.activity.ActivityRepository;
import main.domain.activity.creating.CreateActivityRequest;
import main.domain.activity.creating.CreateActivityResponse;
import main.domain.activity.creating.CreateActivityUseCase;
import main.persistence.inmemory.InMemoryActivityRepository;

public class ReadActivityUseCaseTest {
	private ActivityRepository repository;
	private ArrayList<ActivitySummary> response;
	
	private void givenActivity(String name, String description, String date, String time, String place, 
    		String street, String number, String complement, String neighborhood, String city, String state, String cep,
    		String spots, String duration, String points) {
        CreateActivityRequest request = new CreateActivityRequest();
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
        request.spots = spots;
        request.duration = duration;
        request.points = points;
        CreateActivityResponse response = new CreateActivityResponse();
        new CreateActivityUseCase(repository,request,response).execute();
    }
	
	private void whenReadingSummaries(){
		new ReadActivitiesSummaryUseCase(repository, response).execute();
	}
	
	private void thenTheSizeMustBe(int size) {
        assertEquals(size, response.size());
    }
	
	private void andItMustPresentAtIndex(int index, String id, String name, String description, String date, String time, String place, 
    		String street, String number, String complement, String neighborhood, String city, String state, String cep,
    		String spots, String duration, String points) {
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
        assertEquals(spots, summary.spots);
        assertEquals(duration, summary.duration);
        assertEquals(points, summary.points);
	}
	
	@Before
	public void setUp() throws Exception{
		repository = new InMemoryActivityRepository();
		response = new ArrayList<>();
	}
	
	@Test
    public void givenNoActivities_itReturnsAnEmptyCollection() {
        whenReadingSummaries();
        thenTheSizeMustBe(0);
    }
	
	@Test
	public void givenAnActivity_itMustBeReturnedInTheSummary(){
		givenActivity("name 1", "description 1", "2011-01-01", "01:01:01", "place 1", "street 1", "100", "ap. 11", "downtown 1", "city 1", "state 1", "10000-111", "101","31","1100");
		givenActivity("name 2", "description 2", "2022-02-02", "02:02:02", "place 2", "street 2", "200", "ap. 22", "downtown 2", "city 2", "state 2", "20000-222", "202","32","2200");
		whenReadingSummaries();
		thenTheSizeMustBe(2);
		andItMustPresentAtIndex(0, "1", "name 1", "description 1", "2011-01-01", "01:01:01", "place 1", "street 1", "100", "ap. 11", "downtown 1", "city 1", "state 1", "10000-111", "101","31","1100");
		andItMustPresentAtIndex(1, "2", "name 2", "description 2", "2022-02-02", "02:02:02", "place 2", "street 2", "200", "ap. 22", "downtown 2", "city 2", "state 2", "20000-222", "202","32","2200");
	}

}
