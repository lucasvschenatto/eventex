package main.domain.event;

import main.domain.CEP;
import main.domain.Date;
import main.domain.Numeric;
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
    private static final Text STREET1 = new Text("Street 1");
    private static final Numeric NUMBER1 = new Numeric("100");
    private static final Text COMPLEMENT1 = new Text("apartment 1");
    private static final Text NEIGHBORHOOD1 = new Text("Downtown 1");
    private static final Text CITY1 = new Text("City 1");
    private static final Text STATE1 = new Text("State 1");
    private static final CEP CEP1 = new CEP("10000-111");
    
    private static final Text NAME2 = new Text("Name 2");
    private static final Text DESCRIPTION2 = new Text("Description 2");
    private static final Date DATE2 = new Date("2020-02-02");
    private static final Time TIME2 = new Time("12:02:02");
    private static final Text PLACE2 = new Text("Place 2");
    private static final Text STREET2 = new Text("Street 2");
    private static final Numeric NUMBER2 = new Numeric("200");
    private static final Text COMPLEMENT2 = new Text("apartment 2");
    private static final Text NEIGHBORHOOD2 = new Text("Downtown 2");
    private static final Text CITY2 = new Text("City 2");
    private static final Text STATE2 = new Text("State 2");
    private static final CEP CEP2 = new CEP("20000-222");
    private EventRepository repository;

    protected abstract EventRepository getRepository();

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
        event.setStreet(STREET1);
        event.setNumber(NUMBER1);
        event.setComplement(COMPLEMENT1);
        event.setNeighborhood(NEIGHBORHOOD1);
        event.setCity(CITY1);
        event.setState(STATE1);
        event.setCEP(CEP1);
        return event;
    }

    protected void changeEntity(Event event) {
        event.setName(NAME2);
        event.setDescription(DESCRIPTION2);
        event.setDate(DATE2);
        event.setTime(TIME2);
        event.setPlace(PLACE2);
        event.setStreet(STREET2);
        event.setNumber(NUMBER2);
        event.setComplement(COMPLEMENT2);
        event.setNeighborhood(NEIGHBORHOOD2);
        event.setCity(CITY2);
        event.setState(STATE2);
        event.setCEP(CEP2);
    }

    protected void assertEntityHasSameValues(Event original, Event saved) {
        assertEquals(original.getId(), saved.getId());
        assertEquals(original.getName(), saved.getName());
        assertEquals(original.getDescription(), saved.getDescription());
        assertEquals(original.getDate(),saved.getDate());
        assertEquals(original.getTime(),saved.getTime());
        assertEquals(original.getPlace(),saved.getPlace());
        assertEquals(original.getStreet(),saved.getStreet());
        assertEquals(original.getNumber(),saved.getNumber());
        assertEquals(original.getComplement(),saved.getComplement());
        assertEquals(original.getNeighborhood(),saved.getNeighborhood());
        assertEquals(original.getCity(),saved.getCity());
        assertEquals(original.getState(),saved.getState());
        assertEquals(original.getCEP(),saved.getCEP());
    }

    protected void assertEntityDoesNotHaveSameValues(Event original, Event saved) {
        assertEquals(original.getId(), saved.getId());
        assertNotEquals(original.getName(), saved.getName());
        assertNotEquals(original.getDescription(), saved.getDescription());
        assertNotEquals(original.getDate(),saved.getDate());
        assertNotEquals(original.getTime(),saved.getTime());
        assertNotEquals(original.getPlace(),saved.getPlace());
        assertNotEquals(original.getStreet(),saved.getStreet());
        assertNotEquals(original.getNumber(),saved.getNumber());
        assertNotEquals(original.getComplement(),saved.getComplement());
        assertNotEquals(original.getNeighborhood(),saved.getNeighborhood());
        assertNotEquals(original.getCity(),saved.getCity());
        assertNotEquals(original.getState(),saved.getState());
        assertNotEquals(original.getCEP(),saved.getCEP());
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
