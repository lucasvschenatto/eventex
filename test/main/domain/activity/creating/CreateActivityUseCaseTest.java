package main.domain.activity.creating;

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
import main.domain.activity.reading.ActivitySummary;
import main.domain.activity.reading.ReadActivitiesSummaryUseCase;
import main.domain.event.Event;
import main.domain.event.EventRepository;
import main.persistence.inmemory.InMemoryActivityRepository;
import main.persistence.inmemory.InMemoryEventRepository;

public class CreateActivityUseCaseTest{
	private static final String VALID_NAME = "Valid name";
	private static final String VALID_DESCRIPTION = "Valid description";
	private static final String VALID_DATE = "1999-01-01";
	private static final String VALID_TIME = "01:01:01";
	private static final String VALID_PLACE = "Valid place";
	private static final AddressData VALID_ADDRESS_DATA = makeValidAddress();
	private static final AddressSummary VALID_ADDRESS_SUMMARY = makeValidAddressSummary();
	private static final String VALID_EVENT_ID = "9876543210Aa";
	private static final String VALID_SPOTS = "15";
	private static final String VALID_DURATION = "60";
	private static final String VALID_POINTS = "400";
	private static final String VALID_GROUP_DISCOUNT = "true";
	private static final String VALID_VOUCHER = "false";
	private CreateActivityRequest request;
	private CreateActivityResponse response;
	private ActivityRepository activityRepository;
	private EventRepository eventRepository;
	
	private void givenActivityInformation(String name, String description, String date, String time, String place, 
    		AddressData address,
    		String eventId,
    		String spots, String duration, String points, 
    		String groupDiscount, String voucher) {
        request = new CreateActivityRequest();
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
    }
	
	private static AddressSummary makeValidAddressSummary() {
    	AddressSummary summary = new AddressSummary();
		summary.street = "valid Street";
		summary.number = 510;
		summary.complement = "valid complement";
		summary.neighborhood = "valid neighborhood";
		summary.city = "valid city";
		summary.state = "valid state";
		summary.country = "valid country";
		summary.cep = "10000-123";
		return summary;
	}
	
	private static AddressData makeValidAddress() {
    	AddressData data = new AddressData();
		data.street = "valid Street";
		data.number = "510";
		data.complement = "valid complement";
		data.neighborhood = "valid neighborhood";
		data.city = "valid city";
		data.state = "valid state";
		data.country = "valid country";
		data.cep = "10000-123";
		return data;
	}
	
	public void whenCreatingTheActivity(){
		new CreateActivityUseCase(activityRepository,eventRepository,request,response).execute();
	}
	
	private void andItShouldReturnTheErrors(String... expectedErrors) {
        assertFalse(response.success);
        assertArrayEquals(expectedErrors, makeErrorsArray());
    }
	
	private String[] makeErrorsArray() {
        ArrayList<String> list = new ArrayList<>();
        if (response.invalidName) list.add("invalidName");
        if (response.invalidDescription) list.add("invalidDescription");
        if (response.invalidDate) list.add("invalidDate");
        if (response.invalidTime) list.add("invalidTime");
        if (response.invalidPlace) list.add("invalidPlace");
        if (!response.address.isValid()) list.add("invalidAddress");
        if (response.invalidEventId) list.add("invalidEventId");
        if (response.invalidSpots) list.add("invalidSpots");
        if (response.invalidDuration) list.add("invalidDuration");
        if (response.invalidPoints) list.add("invalidPoints");
        if (response.invalidGroupDiscount) list.add("invalidGroupDiscount");
        if (response.invalidVoucher) list.add("invalidVoucher");
        return list.toArray(new String[list.size()]);
    }
	
	private void thenItShouldNotBeCreated() {
        assertFalse(response.success);
        assertEquals(0, getSummaries().size());
    }
	
	private void thenItShouldBeCreatedWithTheData(String name, String description, String date, String time, String place, 
    		AddressSummary address,
    		String eventId,
    		String spots, String duration, String points,
    		String groupDiscount, String voucher) {
        assertTrue(response.success);
        ActivitySummary summary = getSummaries().get(0);
        assertEquals(name, summary.name);
        assertEquals(description, summary.description);
        assertEquals(date, summary.date);
        assertEquals(time, summary.time);
        assertEquals(place, summary.place);
        assertEquals(address, summary.address);
        assertEquals(eventId, summary.eventId);
        assertEquals(Integer.parseInt(spots),summary.spots);
        assertEquals(Integer.parseInt(duration),summary.duration);
        assertEquals(Integer.parseInt(points),summary.points);
        assertEquals(Boolean.parseBoolean(groupDiscount), summary.groupDiscount);
        assertEquals(Boolean.parseBoolean(voucher), summary.voucher);
    }
	
	private ArrayList<ActivitySummary> getSummaries() {
        ArrayList<ActivitySummary> summaries = new ArrayList<>();
        new ReadActivitiesSummaryUseCase(activityRepository, summaries).execute();
        return summaries;
    }
	
	private void andItShouldNotReturnErrors() {
        assertEquals(0, makeErrorsArray().length);
    }
	
	@Before
	public void setUp(){
		response = new CreateActivityResponse();
		activityRepository = new InMemoryActivityRepository();
		eventRepository = new InMemoryEventRepository();
		
		Event event = new Event();
        event.setId(VALID_EVENT_ID);
        event.setName(new Text("Name 1"));
        event.setDescription(new Text("Description 1"));
        event.setDate(new Date("1900-01-01"));
        event.setTime(new Time("06:59:59"));
        event.setPlace(new Text("place"));
        event.setAddress(new Address(null));
        eventRepository.save(event);
	}
	
	@Test
    public void givenAllValidInput_theActivityMustBeCreated() {
        givenActivityInformation(VALID_NAME, VALID_DESCRIPTION, VALID_DATE, VALID_TIME, VALID_PLACE, 
        		VALID_ADDRESS_DATA,
        		VALID_EVENT_ID, VALID_SPOTS, VALID_DURATION, VALID_POINTS, VALID_GROUP_DISCOUNT, VALID_VOUCHER);
        whenCreatingTheActivity();
        thenItShouldBeCreatedWithTheData(VALID_NAME, VALID_DESCRIPTION, VALID_DATE, VALID_TIME, VALID_PLACE, 
        		VALID_ADDRESS_SUMMARY,
        		VALID_EVENT_ID, VALID_SPOTS, VALID_DURATION, VALID_POINTS, VALID_GROUP_DISCOUNT, VALID_VOUCHER);
        andItShouldNotReturnErrors();
	}
	
	@Test
    public void givenInexistentEventId_ItIsInvalid() {
        givenActivityInformation(VALID_NAME, VALID_DESCRIPTION, VALID_DATE, VALID_TIME, VALID_PLACE, 
        		VALID_ADDRESS_DATA,
        		"aeiou345DDF", VALID_SPOTS, VALID_DURATION, VALID_POINTS, VALID_GROUP_DISCOUNT, VALID_VOUCHER);
        whenCreatingTheActivity();
        thenItShouldNotBeCreated();
        andItShouldReturnTheErrors("invalidEventId");
	}
	
	@Test
    public void givenNameAndDescriptionSurroundedBySpaces_theActivityIsCreatedWithTheTextsTrimmed() {
		givenActivityInformation(VALID_NAME, VALID_DESCRIPTION, VALID_DATE, VALID_TIME, VALID_PLACE, 
				VALID_ADDRESS_DATA,
        		VALID_EVENT_ID, VALID_SPOTS, VALID_DURATION, VALID_POINTS, VALID_GROUP_DISCOUNT, VALID_VOUCHER);
		whenCreatingTheActivity();
		thenItShouldBeCreatedWithTheData(VALID_NAME, VALID_DESCRIPTION, VALID_DATE, VALID_TIME, VALID_PLACE, 
				VALID_ADDRESS_SUMMARY,
        		VALID_EVENT_ID, VALID_SPOTS, VALID_DURATION, VALID_POINTS, VALID_GROUP_DISCOUNT, VALID_VOUCHER);
        andItShouldNotReturnErrors();
	}


	@Test
    public void givenNullName_itIsInvalid() {
        givenActivityInformation(null, VALID_DESCRIPTION, VALID_DATE, VALID_TIME, VALID_PLACE, 
        		VALID_ADDRESS_DATA,
        		VALID_EVENT_ID, VALID_SPOTS, VALID_DURATION, VALID_POINTS, VALID_GROUP_DISCOUNT, VALID_VOUCHER);
        whenCreatingTheActivity();
        thenItShouldNotBeCreated();
        andItShouldReturnTheErrors("invalidName");
    }

    @Test
    public void givenEmptyName_itIsInvalid() {
        givenActivityInformation("", VALID_DESCRIPTION, VALID_DATE, VALID_TIME, VALID_PLACE, 
        		VALID_ADDRESS_DATA,
        		VALID_EVENT_ID, VALID_SPOTS, VALID_DURATION, VALID_POINTS, VALID_GROUP_DISCOUNT, VALID_VOUCHER);
        whenCreatingTheActivity();
        thenItShouldNotBeCreated();
        andItShouldReturnTheErrors("invalidName");
    }

    @Test
    public void givenNameWithOnlySpaces_itIsInvalid() {
        givenActivityInformation("   ", VALID_DESCRIPTION, VALID_DATE, VALID_TIME, VALID_PLACE, 
        		VALID_ADDRESS_DATA,
        		VALID_EVENT_ID, VALID_SPOTS, VALID_DURATION, VALID_POINTS, VALID_GROUP_DISCOUNT, VALID_VOUCHER);
        whenCreatingTheActivity();
        thenItShouldNotBeCreated();
        andItShouldReturnTheErrors("invalidName");
    }

    @Test
    public void givenNullDescription_itIsInvalid() {
        givenActivityInformation(VALID_NAME, null, VALID_DATE, VALID_TIME, VALID_PLACE, 
        		VALID_ADDRESS_DATA,
        		VALID_EVENT_ID, VALID_SPOTS, VALID_DURATION, VALID_POINTS, VALID_GROUP_DISCOUNT, VALID_VOUCHER);
        whenCreatingTheActivity();
        thenItShouldNotBeCreated();
        andItShouldReturnTheErrors("invalidDescription");
    }

    @Test
    public void givenEmptyDescription_itIsInvalid() {
        givenActivityInformation(VALID_NAME, "", VALID_DATE, VALID_TIME, VALID_PLACE,
        		VALID_ADDRESS_DATA,
        		VALID_EVENT_ID, VALID_SPOTS, VALID_DURATION, VALID_POINTS, VALID_GROUP_DISCOUNT, VALID_VOUCHER);
        whenCreatingTheActivity();
        thenItShouldNotBeCreated();
        andItShouldReturnTheErrors("invalidDescription");
    }

    @Test
    public void givenDescriptionWithOnlySpaces_itIsInvalid() {
        givenActivityInformation(VALID_NAME, "  ", VALID_DATE, VALID_TIME, VALID_PLACE,
        		VALID_ADDRESS_DATA,
        		VALID_EVENT_ID, VALID_SPOTS, VALID_DURATION, VALID_POINTS, VALID_GROUP_DISCOUNT, VALID_VOUCHER);
        whenCreatingTheActivity();
        thenItShouldNotBeCreated();
        andItShouldReturnTheErrors("invalidDescription");
    }
    
    @Test
    public void givenNullEventId_itIsInvalid() {
        givenActivityInformation(VALID_NAME, VALID_DESCRIPTION, VALID_DATE, VALID_TIME, VALID_PLACE, 
        		VALID_ADDRESS_DATA,
        		null, VALID_SPOTS, VALID_DURATION, VALID_POINTS, VALID_GROUP_DISCOUNT, VALID_VOUCHER);
        whenCreatingTheActivity();
        thenItShouldNotBeCreated();
        andItShouldReturnTheErrors("invalidEventId");
    }

    @Test
    public void givenEmptyEventId_itIsInvalid() {
        givenActivityInformation(VALID_NAME, VALID_DESCRIPTION, VALID_DATE, VALID_TIME, VALID_PLACE,
        		VALID_ADDRESS_DATA,
        		"", VALID_SPOTS, VALID_DURATION, VALID_POINTS, VALID_GROUP_DISCOUNT, VALID_VOUCHER);
        whenCreatingTheActivity();
        thenItShouldNotBeCreated();
        andItShouldReturnTheErrors("invalidEventId");
    }

    @Test
    public void givenEventIdWithOnlySpaces_itIsInvalid() {
        givenActivityInformation(VALID_NAME, VALID_DESCRIPTION, VALID_DATE, VALID_TIME, VALID_PLACE,
        		VALID_ADDRESS_DATA,
        		"    ", VALID_SPOTS, VALID_DURATION, VALID_POINTS, VALID_GROUP_DISCOUNT, VALID_VOUCHER);
        whenCreatingTheActivity();
        thenItShouldNotBeCreated();
        andItShouldReturnTheErrors("invalidEventId");
    }
    @Test
    public void givenEventIdWithNotExistingId_itIsInvalid() {
    	givenActivityInformation(VALID_NAME, VALID_DESCRIPTION, VALID_DATE, VALID_TIME, VALID_PLACE,
    			VALID_ADDRESS_DATA,
    			"not existing id", VALID_SPOTS, VALID_DURATION, VALID_POINTS, VALID_GROUP_DISCOUNT, VALID_VOUCHER);
    	whenCreatingTheActivity();
    	thenItShouldNotBeCreated();
    	andItShouldReturnTheErrors("invalidEventId");
    }

    @Test
    public void givenNullSpots_itIsInvalid() {
        givenActivityInformation(VALID_NAME, VALID_DESCRIPTION, VALID_DATE, VALID_TIME, VALID_PLACE, 
        		VALID_ADDRESS_DATA,
        		VALID_EVENT_ID, null, VALID_DURATION, VALID_POINTS, VALID_GROUP_DISCOUNT, VALID_VOUCHER);
        whenCreatingTheActivity();
        thenItShouldNotBeCreated();
        andItShouldReturnTheErrors("invalidSpots");
    }

    @Test
    public void givenEmptySpots_itIsInvalid() {
        givenActivityInformation(VALID_NAME, VALID_DESCRIPTION, VALID_DATE, VALID_TIME, VALID_PLACE,
        		VALID_ADDRESS_DATA,
        		VALID_EVENT_ID, "", VALID_DURATION, VALID_POINTS, VALID_GROUP_DISCOUNT, VALID_VOUCHER);
        whenCreatingTheActivity();
        thenItShouldNotBeCreated();
        andItShouldReturnTheErrors("invalidSpots");
    }

    @Test
    public void givenSpotsWithOnlySpaces_itIsInvalid() {
        givenActivityInformation(VALID_NAME, VALID_DESCRIPTION, VALID_DATE, VALID_TIME, VALID_PLACE,
        		VALID_ADDRESS_DATA,
        		VALID_EVENT_ID, "    ", VALID_DURATION, VALID_POINTS, VALID_GROUP_DISCOUNT, VALID_VOUCHER);
        whenCreatingTheActivity();
        thenItShouldNotBeCreated();
        andItShouldReturnTheErrors("invalidSpots");
    }
    @Test
    public void givenSpotsWithoutANumber_itIsInvalid() {
    	givenActivityInformation(VALID_NAME, VALID_DESCRIPTION, VALID_DATE, VALID_TIME, VALID_PLACE,
    			VALID_ADDRESS_DATA,
    			VALID_EVENT_ID, "not a number", VALID_DURATION, VALID_POINTS, VALID_GROUP_DISCOUNT, VALID_VOUCHER);
    	whenCreatingTheActivity();
    	thenItShouldNotBeCreated();
    	andItShouldReturnTheErrors("invalidSpots");
    }
    @Test
    public void givenNullDuration_itIsInvalid() {
    	givenActivityInformation(VALID_NAME, VALID_DESCRIPTION, VALID_DATE, VALID_TIME, VALID_PLACE, 
    			VALID_ADDRESS_DATA,
    			VALID_EVENT_ID, VALID_SPOTS, null, VALID_POINTS, VALID_GROUP_DISCOUNT, VALID_VOUCHER);
    	whenCreatingTheActivity();
    	thenItShouldNotBeCreated();
    	andItShouldReturnTheErrors("invalidDuration");
    }
    
    @Test
    public void givenEmptyDuration_itIsInvalid() {
    	givenActivityInformation(VALID_NAME, VALID_DESCRIPTION, VALID_DATE, VALID_TIME, VALID_PLACE,
    			VALID_ADDRESS_DATA,
    			VALID_EVENT_ID, VALID_SPOTS, "", VALID_POINTS, VALID_GROUP_DISCOUNT, VALID_VOUCHER);
    	whenCreatingTheActivity();
    	thenItShouldNotBeCreated();
    	andItShouldReturnTheErrors("invalidDuration");
    }
    
    @Test
    public void givenDurationWithOnlySpaces_itIsInvalid() {
    	givenActivityInformation(VALID_NAME, VALID_DESCRIPTION, VALID_DATE, VALID_TIME, VALID_PLACE,
    			VALID_ADDRESS_DATA,
    			VALID_EVENT_ID, VALID_SPOTS, "    ", VALID_POINTS, VALID_GROUP_DISCOUNT, VALID_VOUCHER);
    	whenCreatingTheActivity();
    	thenItShouldNotBeCreated();
    	andItShouldReturnTheErrors("invalidDuration");
    }
    @Test
    public void givenDurationWithoutANumber_itIsInvalid() {
    	givenActivityInformation(VALID_NAME, VALID_DESCRIPTION, VALID_DATE, VALID_TIME, VALID_PLACE,
    			VALID_ADDRESS_DATA,
    			VALID_EVENT_ID, VALID_SPOTS, "not a number", VALID_POINTS, VALID_GROUP_DISCOUNT, VALID_VOUCHER);
    	whenCreatingTheActivity();
    	thenItShouldNotBeCreated();
    	andItShouldReturnTheErrors("invalidDuration");
    }
    @Test
    public void givenNullPoints_itIsInvalid() {
    	givenActivityInformation(VALID_NAME, VALID_DESCRIPTION, VALID_DATE, VALID_TIME, VALID_PLACE, 
    			VALID_ADDRESS_DATA,
    			VALID_EVENT_ID, VALID_SPOTS, VALID_DURATION, null, VALID_GROUP_DISCOUNT, VALID_VOUCHER);
    	whenCreatingTheActivity();
    	thenItShouldNotBeCreated();
    	andItShouldReturnTheErrors("invalidPoints");
    }
    
    @Test
    public void givenEmptyPoints_itIsInvalid() {
    	givenActivityInformation(VALID_NAME, VALID_DESCRIPTION, VALID_DATE, VALID_TIME, VALID_PLACE,
    			VALID_ADDRESS_DATA,
    			VALID_EVENT_ID, VALID_SPOTS, VALID_DURATION, "", VALID_GROUP_DISCOUNT, VALID_VOUCHER);
    	whenCreatingTheActivity();
    	thenItShouldNotBeCreated();
    	andItShouldReturnTheErrors("invalidPoints");
    }
    
    @Test
    public void givenPointsWithOnlySpaces_itIsInvalid() {
    	givenActivityInformation(VALID_NAME, VALID_DESCRIPTION, VALID_DATE, VALID_TIME, VALID_PLACE,
    			VALID_ADDRESS_DATA,
    			VALID_EVENT_ID, VALID_SPOTS, VALID_DURATION, "    ", VALID_GROUP_DISCOUNT, VALID_VOUCHER);
    	whenCreatingTheActivity();
    	thenItShouldNotBeCreated();
    	andItShouldReturnTheErrors("invalidPoints");
    }
    @Test
    public void givenPointsWithoutANumber_itIsInvalid() {
    	givenActivityInformation(VALID_NAME, VALID_DESCRIPTION, VALID_DATE, VALID_TIME, VALID_PLACE,
    			VALID_ADDRESS_DATA,
    			VALID_EVENT_ID, VALID_SPOTS, VALID_DURATION, "not a number", VALID_GROUP_DISCOUNT, VALID_VOUCHER);
    	whenCreatingTheActivity();
    	thenItShouldNotBeCreated();
    	andItShouldReturnTheErrors("invalidPoints");
    }

}
