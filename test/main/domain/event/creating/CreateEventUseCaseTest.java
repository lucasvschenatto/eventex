package main.domain.event.creating;

import main.domain.event.EventRepository;
import main.domain.event.creating.CreateEventRequest;
import main.domain.event.creating.CreateEventResponse;
import main.domain.event.creating.CreateEventUseCase;
import main.domain.event.reading.EventSummary;
import main.domain.event.reading.ReadEventsSummaryUseCase;
import main.persistence.inmemory.InMemoryEventRepository;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class CreateEventUseCaseTest {
	protected static final String VALID_NAME = "Valid name";
	protected static final String VALID_DESCRIPTION = "Valid description";
	protected static final String VALID_DATE = "1999-01-01";
	protected static final String VALID_TIME = "01:01:01";
	protected static final String VALID_PLACE = "Valid place";
	protected static final String VALID_ADDRESS = "Valid address";
	protected CreateEventRequest request;
	protected CreateEventResponse response;
	protected EventRepository repository;

    private void givenEventInformation(String name, String description, String date, String time, String place, String address) {
        request = new CreateEventRequest();
        request.name = name;
        request.description = description;
        request.date = date;
        request.time = time;
        request.place = place;
        request.address = address;
    }

    public void whenCreatingTheProduct() {
        new CreateEventUseCase(repository, request, response).execute();
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
        if (response.invalidAddress) list.add("invalidAddress");
        return list.toArray(new String[list.size()]);
    }

    private void thenItShouldNotBeCreated() {
        assertFalse(response.success);
        assertEquals(0, getSummaries().size());
    }

    private void thenItShouldBeCreatedWithTheData(String name, String description, String date, String time, String place, String address) {
        assertTrue(response.success);
        EventSummary summary = getSummaries().get(0);
        assertEquals(name, summary.name);
        assertEquals(description, summary.description);
        assertEquals(date, summary.date);
        assertEquals(time, summary.time);
        assertEquals(place, summary.place);
        assertEquals(address, summary.address);
    }

    private ArrayList<EventSummary> getSummaries() {
        ArrayList<EventSummary> summaries = new ArrayList<>();
        new ReadEventsSummaryUseCase(repository, summaries).execute();
        return summaries;
    }

    private void andItShouldNotReturnErrors() {
        assertEquals(0, makeErrorsArray().length);
    }

    @Before
    public void setUp() {
        response = new CreateEventResponse();
        repository = new InMemoryEventRepository();
    }

    @Test
    public void givenNullName_itIsInvalid() {
        givenEventInformation(null, VALID_DESCRIPTION, VALID_DATE, VALID_TIME, VALID_PLACE, VALID_ADDRESS);
        whenCreatingTheProduct();
        thenItShouldNotBeCreated();
        andItShouldReturnTheErrors("invalidName");
    }

    @Test
    public void givenEmptyName_itIsInvalid() {
        givenEventInformation("", VALID_DESCRIPTION, VALID_DATE, VALID_TIME, VALID_PLACE, VALID_ADDRESS);
        whenCreatingTheProduct();
        thenItShouldNotBeCreated();
        andItShouldReturnTheErrors("invalidName");
    }

    @Test
    public void givenNameWithOnlySpaces_itIsInvalid() {
        givenEventInformation("   ", VALID_DESCRIPTION, VALID_DATE, VALID_TIME, VALID_PLACE, VALID_ADDRESS);
        whenCreatingTheProduct();
        thenItShouldNotBeCreated();
        andItShouldReturnTheErrors("invalidName");
    }

    @Test
    public void givenNullDescription_itIsInvalid() {
        givenEventInformation(VALID_NAME, null, VALID_DATE, VALID_TIME, VALID_PLACE, VALID_ADDRESS);
        whenCreatingTheProduct();
        thenItShouldNotBeCreated();
        andItShouldReturnTheErrors("invalidDescription");
    }

    @Test
    public void givenEmptyDescription_itIsInvalid() {
        givenEventInformation(VALID_NAME, "", VALID_DATE, VALID_TIME, VALID_PLACE, VALID_ADDRESS);
        whenCreatingTheProduct();
        thenItShouldNotBeCreated();
        andItShouldReturnTheErrors("invalidDescription");
    }

    @Test
    public void givenDescriptionWithOnlySpaces_itIsInvalid() {
        givenEventInformation(VALID_NAME, "  ", VALID_DATE, VALID_TIME, VALID_PLACE, VALID_ADDRESS);
        whenCreatingTheProduct();
        thenItShouldNotBeCreated();
        andItShouldReturnTheErrors("invalidDescription");
    }

//    @Test
//    public void givenNullPrice_itIsInvalid() {
//        givenEventInformation(VALID_NAME, VALID_DESCRIPTION, null, VALID_UNITS_IN_STOCK);
//        whenCreatingTheProduct();
//        thenItShouldNotBeCreated();
//        andItShouldReturnTheErrors("invalidPrice");
//    }
//
//    @Test
//    public void givenEmptyPrice_itIsInvalid() {
//        givenEventInformation(VALID_NAME, VALID_DESCRIPTION, "", VALID_UNITS_IN_STOCK);
//        whenCreatingTheProduct();
//        thenItShouldNotBeCreated();
//        andItShouldReturnTheErrors("invalidPrice");
//    }
//
//    @Test
//    public void givenNonNumericPrice_itIsInvalid() {
//        givenEventInformation(VALID_NAME, VALID_DESCRIPTION, "Not a number", VALID_UNITS_IN_STOCK);
//        whenCreatingTheProduct();
//        thenItShouldNotBeCreated();
//        andItShouldReturnTheErrors("invalidPrice");
//    }
//
//    @Test
//    public void givenZeroPrice_itIsInvalid() {
//        givenEventInformation(VALID_NAME, VALID_DESCRIPTION, "0.0", VALID_UNITS_IN_STOCK);
//        whenCreatingTheProduct();
//        thenItShouldNotBeCreated();
//        andItShouldReturnTheErrors("invalidPrice");
//    }
//
//    @Test
//    public void givenNegativePrice_itIsInvalid() {
//        givenEventInformation(VALID_NAME, VALID_DESCRIPTION, "-1.0", VALID_UNITS_IN_STOCK);
//        whenCreatingTheProduct();
//        thenItShouldNotBeCreated();
//        andItShouldReturnTheErrors("invalidPrice");
//    }
//
//    @Test
//    public void givenNullUnitsInStock_itIsInvalid() {
//        givenEventInformation(VALID_NAME, VALID_DESCRIPTION, VALID_PRICE, null);
//        whenCreatingTheProduct();
//        thenItShouldNotBeCreated();
//        andItShouldReturnTheErrors("invalidUnitsInStock");
//    }
//
//    @Test
//    public void givenEmptyUnitsInStock_itIsInvalid() {
//        givenEventInformation(VALID_NAME, VALID_DESCRIPTION, VALID_PRICE, "");
//        whenCreatingTheProduct();
//        thenItShouldNotBeCreated();
//        andItShouldReturnTheErrors("invalidUnitsInStock");
//    }
//
//    @Test
//    public void givenNonNumericUnitsInStock_itIsInvalid() {
//        givenEventInformation(VALID_NAME, VALID_DESCRIPTION, VALID_PRICE, "Not a number");
//        whenCreatingTheProduct();
//        thenItShouldNotBeCreated();
//        andItShouldReturnTheErrors("invalidUnitsInStock");
//    }
//
//    @Test
//    public void givenNegativeUnitsInStock_itIsInvalid() {
//        givenEventInformation(VALID_NAME, VALID_DESCRIPTION, VALID_PRICE, "-1");
//        whenCreatingTheProduct();
//        thenItShouldNotBeCreated();
//        andItShouldReturnTheErrors("invalidUnitsInStock");
//    }
//
//    @Test
//    public void givenCompletelyInvalidData_itAllMustBeInvalid() {
//        givenEventInformation(null, "   ", "0.0", "-1");
//        whenCreatingTheProduct();
//        thenItShouldNotBeCreated();
//        andItShouldReturnTheErrors("invalidName", "invalidDescription", "invalidPrice", "invalidUnitsInStock");
//    }
//
    @Test
    public void givenAllValidInput_theEventMustBeCreated() {
        givenEventInformation(VALID_NAME, VALID_DESCRIPTION, VALID_DATE, VALID_TIME, VALID_PLACE, VALID_ADDRESS);
        whenCreatingTheProduct();
        thenItShouldBeCreatedWithTheData(VALID_NAME, VALID_DESCRIPTION, VALID_DATE, VALID_TIME, VALID_PLACE, VALID_ADDRESS);
        andItShouldNotReturnErrors();
    }

    @Test
    public void givenNameAndDescriptionSurroundedBySpaces_theEventIsCreatedWithTheTextsTrimmed() {
        givenEventInformation("  Valid name  ", "  Valid description  ", VALID_DATE, VALID_TIME, VALID_PLACE, VALID_ADDRESS);
        whenCreatingTheProduct();
        thenItShouldBeCreatedWithTheData(VALID_NAME, VALID_DESCRIPTION, VALID_DATE, VALID_TIME, VALID_PLACE, VALID_ADDRESS);
        andItShouldNotReturnErrors();
    }
}