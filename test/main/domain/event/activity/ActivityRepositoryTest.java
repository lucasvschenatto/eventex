package main.domain.event.activity;

import main.domain.CEP;
import main.domain.Date;
import main.domain.Numeric;
import main.domain.Quantity;
import main.domain.Repository;
import main.domain.RepositoryTest;
import main.domain.Text;
import main.domain.event.Time;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public abstract class ActivityRepositoryTest extends RepositoryTest<Activity>{
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
    private static final Quantity SPOTS1 = new Quantity("10");
    private static final Minutes MINUTES1= new Minutes("11");
    private static final Quantity POINTS1 = new Quantity("100");
    
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
    private static final Quantity SPOTS2 = new Quantity("20");
    private static final Minutes MINUTES2= new Minutes("22");
    private static final Quantity POINTS2 = new Quantity("200");
	private ActivityRepository repository;
	
	protected abstract ActivityRepository getRepository();
	
	protected Repository<Activity> getAbstractRepository(){
		return getRepository();
	}
	@Override
	protected Activity makeNewEntity() {
		return new Activity();
	}

	@Override
	protected Activity makeEntityWithId(String id) {
		Activity activity = new Activity();
        activity.setId(id);
        activity.setName(NAME1);
        activity.setDescription(DESCRIPTION1);
        activity.setDate(DATE1);
        activity.setTime(TIME1);
        activity.setPlace(PLACE1);
        activity.setStreet(STREET1);
        activity.setNumber(NUMBER1);
        activity.setComplement(COMPLEMENT1);
        activity.setNeighborhood(NEIGHBORHOOD1);
        activity.setCity(CITY1);
        activity.setState(STATE1);
        activity.setCEP(CEP1);
        activity.setSpots(SPOTS1);
        activity.setDuration(MINUTES1);
        activity.setPoints(POINTS1);
        return activity;
	}

	@Override
	protected void changeEntity(Activity activity) {
		activity.setName(NAME2);
		activity.setDescription(DESCRIPTION2);
		activity.setDate(DATE2);
		activity.setTime(TIME2);
		activity.setPlace(PLACE2);
		activity.setStreet(STREET2);
		activity.setNumber(NUMBER2);
		activity.setComplement(COMPLEMENT2);
		activity.setNeighborhood(NEIGHBORHOOD2);
		activity.setCity(CITY2);
		activity.setState(STATE2);
		activity.setCEP(CEP2);
		activity.setSpots(SPOTS2);
		activity.setDuration(MINUTES2);
		activity.setPoints(POINTS2);
	}

	@Override
	protected void assertEntityHasSameValues(Activity original, Activity saved) {
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
        assertEquals(original.getSpots(),saved.getSpots());
        assertEquals(original.getMinutes(),saved.getMinutes());
        assertEquals(original.getPoints(),saved.getPoints());
        
	}

	@Override
	protected void assertEntityDoesNotHaveSameValues(Activity original, Activity saved) {
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
        assertNotEquals(original.getSpots(),saved.getSpots());
        assertNotEquals(original.getMinutes(),saved.getMinutes());
        assertNotEquals(original.getPoints(),saved.getPoints());
	}
	
	@Before
    public void setUp() throws Exception {
        super.setUp();
        repository = getRepository();
    }

    @Test
    public void givenNoActivities_returnsEmptyCollection() {
        Iterable<Activity> activities = repository.getAll();
        assertFalse(activities.iterator().hasNext());
    }

    @Test
    public void givenTwoActivities_itReturnsTheTwo() {
        repository.save(new Activity());
        repository.save(new Activity());
        Iterable<Activity> activities = repository.getAll();
        int counter = 0;
        for (Activity ignored : activities)
        	counter++;
        assertEquals(2, counter);
    }

}
