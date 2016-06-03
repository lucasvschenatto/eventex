package main.domain.activity.creating;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import main.domain.activity.ActivityRepository;
import main.domain.activity.reading.ActivitySummary;
import main.domain.activity.reading.ReadActivitiesSummaryUseCase;
import main.persistence.inmemory.InMemoryActivityRepository;

public class CreateActivityUseCaseTest{
	private static final String VALID_NAME = "Valid name";
	private static final String VALID_DESCRIPTION = "Valid description";
	private static final String VALID_DATE = "1999-01-01";
	private static final String VALID_TIME = "01:01:01";
	private static final String VALID_PLACE = "Valid place";
	private static final String VALID_STREET = "Valid street";
	private static final String VALID_NUMBER = "510";
	private static final String VALID_COMPLEMENT = "valid complement";
	private static final String VALID_NEIGHBORHOOD = "Valid neighborhood";
	private static final String VALID_CITY = "Valid city";
	private static final String VALID_STATE = "Valid state";
	private static final String VALID_CEP = "10000-123";
	private static final String VALID_SPOTS = "15";
	private static final String VALID_DURATION = "60";
	private static final String VALID_POINTS = "400";
	private static final String VALID_GROUP_DISCOUNT = "true";
	private static final String VALID_VOUCHER = "false";
	private CreateActivityRequest request;
	private CreateActivityResponse response;
	private ActivityRepository repository;
	
	private void givenActivityInformation(String name, String description, String date, String time, String place, 
    		String street, String number, String complement, String neighborhood, String city, String state, String cep,
    		String spots, String duration, String points, String groupDiscount, String voucher) {
        request = new CreateActivityRequest();
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
        request.groupDiscount = groupDiscount;
        request.voucher = voucher;
    }
	
	public void whenCreatingTheActivity(){
		new CreateActivityUseCase(repository,request,response).execute();
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
        if (response.invalidStreet) list.add("invalidStreet");
        if (response.invalidNumber) list.add("invalidNumber");
        if (response.invalidComplement) list.add("invalidComplement");
        if (response.invalidNeighborhood) list.add("invalidNeighborhood");
        if (response.invalidCity) list.add("invalidCity");
        if (response.invalidState) list.add("invalidState");
        if (response.invalidCEP) list.add("invalidCEP");
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
    		String street, String number, String complement, String neighborhood, String city, String state, String cep,
    		String spots, String duration, String points,
    		String groupDiscount, String voucher) {
        assertTrue(response.success);
        ActivitySummary summary = getSummaries().get(0);
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
        assertEquals(spots,summary.spots);
        assertEquals(duration,summary.duration);
        assertEquals(points,summary.points);
        assertEquals(groupDiscount, summary.groupDiscount);
        assertEquals(voucher, summary.voucher);
    }
	
	private ArrayList<ActivitySummary> getSummaries() {
        ArrayList<ActivitySummary> summaries = new ArrayList<>();
        new ReadActivitiesSummaryUseCase(repository, summaries).execute();
        return summaries;
    }
	
	private void andItShouldNotReturnErrors() {
        assertEquals(0, makeErrorsArray().length);
    }
	
	@Before
	public void setUp(){
		response = new CreateActivityResponse();
		repository = new InMemoryActivityRepository();
	}
	
	@Test
    public void givenAllValidInput_theActivityMustBeCreated() {
        givenActivityInformation(VALID_NAME, VALID_DESCRIPTION, VALID_DATE, VALID_TIME, VALID_PLACE, 
        		VALID_STREET, VALID_NUMBER, VALID_COMPLEMENT, VALID_NEIGHBORHOOD, VALID_CITY, VALID_STATE, VALID_CEP,
        		VALID_SPOTS, VALID_DURATION, VALID_POINTS, VALID_GROUP_DISCOUNT, VALID_VOUCHER);
        whenCreatingTheActivity();
        thenItShouldBeCreatedWithTheData(VALID_NAME, VALID_DESCRIPTION, VALID_DATE, VALID_TIME, VALID_PLACE, 
        		VALID_STREET, VALID_NUMBER, VALID_COMPLEMENT, VALID_NEIGHBORHOOD, VALID_CITY, VALID_STATE, VALID_CEP,
        		VALID_SPOTS, VALID_DURATION, VALID_POINTS, VALID_GROUP_DISCOUNT, VALID_VOUCHER);
        andItShouldNotReturnErrors();
	}
	
	@Test
    public void givenNameAndDescriptionSurroundedBySpaces_theActivityIsCreatedWithTheTextsTrimmed() {
		givenActivityInformation(VALID_NAME, VALID_DESCRIPTION, VALID_DATE, VALID_TIME, VALID_PLACE, 
        		VALID_STREET, VALID_NUMBER, VALID_COMPLEMENT, VALID_NEIGHBORHOOD, VALID_CITY, VALID_STATE, VALID_CEP,
        		VALID_SPOTS, VALID_DURATION, VALID_POINTS, VALID_GROUP_DISCOUNT, VALID_VOUCHER);
		whenCreatingTheActivity();
		thenItShouldBeCreatedWithTheData(VALID_NAME, VALID_DESCRIPTION, VALID_DATE, VALID_TIME, VALID_PLACE, 
        		VALID_STREET, VALID_NUMBER, VALID_COMPLEMENT, VALID_NEIGHBORHOOD, VALID_CITY, VALID_STATE, VALID_CEP,
        		VALID_SPOTS, VALID_DURATION, VALID_POINTS, VALID_GROUP_DISCOUNT, VALID_VOUCHER);
        andItShouldNotReturnErrors();
	}


	@Test
    public void givenNullName_itIsInvalid() {
        givenActivityInformation(null, VALID_DESCRIPTION, VALID_DATE, VALID_TIME, VALID_PLACE, 
        		VALID_STREET, VALID_NUMBER, VALID_COMPLEMENT, VALID_NEIGHBORHOOD, VALID_CITY, VALID_STATE, VALID_CEP,
        		VALID_SPOTS, VALID_DURATION, VALID_POINTS, VALID_GROUP_DISCOUNT, VALID_VOUCHER);
        whenCreatingTheActivity();
        thenItShouldNotBeCreated();
        andItShouldReturnTheErrors("invalidName");
    }

    @Test
    public void givenEmptyName_itIsInvalid() {
        givenActivityInformation("", VALID_DESCRIPTION, VALID_DATE, VALID_TIME, VALID_PLACE, 
        		VALID_STREET, VALID_NUMBER, VALID_COMPLEMENT, VALID_NEIGHBORHOOD, VALID_CITY, VALID_STATE, VALID_CEP,
        		VALID_SPOTS, VALID_DURATION, VALID_POINTS, VALID_GROUP_DISCOUNT, VALID_VOUCHER);
        whenCreatingTheActivity();
        thenItShouldNotBeCreated();
        andItShouldReturnTheErrors("invalidName");
    }

    @Test
    public void givenNameWithOnlySpaces_itIsInvalid() {
        givenActivityInformation("   ", VALID_DESCRIPTION, VALID_DATE, VALID_TIME, VALID_PLACE, 
        		VALID_STREET, VALID_NUMBER, VALID_COMPLEMENT, VALID_NEIGHBORHOOD, VALID_CITY, VALID_STATE, VALID_CEP,
        		VALID_SPOTS, VALID_DURATION, VALID_POINTS, VALID_GROUP_DISCOUNT, VALID_VOUCHER);
        whenCreatingTheActivity();
        thenItShouldNotBeCreated();
        andItShouldReturnTheErrors("invalidName");
    }

    @Test
    public void givenNullDescription_itIsInvalid() {
        givenActivityInformation(VALID_NAME, null, VALID_DATE, VALID_TIME, VALID_PLACE, 
        		VALID_STREET, VALID_NUMBER, VALID_COMPLEMENT, VALID_NEIGHBORHOOD, VALID_CITY, VALID_STATE, VALID_CEP,
        		VALID_SPOTS, VALID_DURATION, VALID_POINTS, VALID_GROUP_DISCOUNT, VALID_VOUCHER);
        whenCreatingTheActivity();
        thenItShouldNotBeCreated();
        andItShouldReturnTheErrors("invalidDescription");
    }

    @Test
    public void givenEmptyDescription_itIsInvalid() {
        givenActivityInformation(VALID_NAME, "", VALID_DATE, VALID_TIME, VALID_PLACE,
        		VALID_STREET, VALID_NUMBER, VALID_COMPLEMENT, VALID_NEIGHBORHOOD, VALID_CITY, VALID_STATE, VALID_CEP,
        		VALID_SPOTS, VALID_DURATION, VALID_POINTS, VALID_GROUP_DISCOUNT, VALID_VOUCHER);
        whenCreatingTheActivity();
        thenItShouldNotBeCreated();
        andItShouldReturnTheErrors("invalidDescription");
    }

    @Test
    public void givenDescriptionWithOnlySpaces_itIsInvalid() {
        givenActivityInformation(VALID_NAME, "  ", VALID_DATE, VALID_TIME, VALID_PLACE,
        		VALID_STREET, VALID_NUMBER, VALID_COMPLEMENT, VALID_NEIGHBORHOOD, VALID_CITY, VALID_STATE, VALID_CEP,
        		VALID_SPOTS, VALID_DURATION, VALID_POINTS, VALID_GROUP_DISCOUNT, VALID_VOUCHER);
        whenCreatingTheActivity();
        thenItShouldNotBeCreated();
        andItShouldReturnTheErrors("invalidDescription");
    }
}
