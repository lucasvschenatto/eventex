package main.domain.event;

import main.domain.Address;
import main.domain.AddressData;
import main.domain.Date;
import main.domain.Repository;
import main.domain.RepositoryTest;
import main.domain.Text;
import main.domain.Time;
import main.domain.event.Event;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public abstract class EventRepositoryTest extends RepositoryTest<Event> {
    private static final Text NAME1 = new Text("Name 1");
    private static final Text DESCRIPTION1 = new Text("Description 1");
    private static final Date DATE1 = new Date("2010-01-01");
    private static final Time TIME1 = new Time("11:01:01");
    private static final Text PLACE1 = new Text("Place 1");
    private static final Address ADDRESS1 = new Address(makeData1());

    
    private static final Text NAME2 = new Text("Name 2");
    private static final Text DESCRIPTION2 = new Text("Description 2");
    private static final Date DATE2 = new Date("2020-02-02");
    private static final Time TIME2 = new Time("12:02:02");
    private static final Text PLACE2 = new Text("Place 2");
    private static final Address ADDRESS2 = new Address(makeData2());

    private EventRepository repository;

    protected abstract EventRepository getRepository();

    private static AddressData makeData1() {
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

	private static AddressData makeData2() {
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

	protected Repository<Event> getAbstractRepository() {
        return getRepository();
    }

    protected Event makeNewEntity() {
        return new Event();
    }

    protected Event makeEntityWithId(String id) {
        Event event = new Event();
        event.setId(id);
        event.setName(NAME1);
        event.setDescription(DESCRIPTION1);
        event.setDate(DATE1);
        event.setTime(TIME1);
        event.setPlace(PLACE1);
        event.setAddress(ADDRESS1);
        return event;
    }

    protected void changeEntity(Event event) {
        event.setName(NAME2);
        event.setDescription(DESCRIPTION2);
        event.setDate(DATE2);
        event.setTime(TIME2);
        event.setPlace(PLACE2);
        event.setAddress(ADDRESS2);
    }

    protected void assertEntityHasSameValues(Event original, Event saved) {
        assertEquals(original.getId(), saved.getId());
        assertEquals(original.getName(), saved.getName());
        assertEquals(original.getDescription(), saved.getDescription());
        assertEquals(original.getDate(),saved.getDate());
        assertEquals(original.getTime(),saved.getTime());
        assertEquals(original.getPlace(),saved.getPlace());
        assertEquals(original.getAddress(),saved.getAddress());
    }

    protected void assertEntityDoesNotHaveSameValues(Event original, Event saved) {
        assertEquals(original.getId(), saved.getId());
        assertNotEquals(original.getName(), saved.getName());
        assertNotEquals(original.getDescription(), saved.getDescription());
        assertNotEquals(original.getDate(),saved.getDate());
        assertNotEquals(original.getTime(),saved.getTime());
        assertNotEquals(original.getPlace(),saved.getPlace());
        assertNotEquals(original.getAddress(),saved.getAddress());
    }

    @Before
    public void setUp() throws Exception {
        super.setUp();
        repository = getRepository();
    }

    @Test
    public void givenNoEvents_returnsEmptyCollection() {
        Iterable<Event> events = repository.getAll();
        assertFalse(events.iterator().hasNext());
    }

	@Test@SuppressWarnings("unused")
    public void givenTwoEvents_itReturnsTheTwo() {
        repository.save(new Event());
        repository.save(new Event());
        Iterable<Event> events = repository.getAll();
        int counter = 0;
        for (Event ignored : events)
        	counter++;
        assertEquals(2, counter);
    }
}
