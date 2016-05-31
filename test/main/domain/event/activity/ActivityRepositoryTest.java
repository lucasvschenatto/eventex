package main.domain.event.activity;

import main.domain.Date;
import main.domain.Repository;
import main.domain.RepositoryTest;
import main.domain.Text;
import main.domain.event.Quantity;
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
    private static final Text ADDRESS1 = new Text("Address 1");
    private static final Quantity SPOTS1 = new Quantity("10");
    private static final Minutes MINUTES1= new Minutes("11");
    private static final Quantity POINTS1 = new Quantity("100");
    
    private static final Text NAME2 = new Text("Name 2");
    private static final Text DESCRIPTION2 = new Text("Description 2");
    private static final Date DATE2 = new Date("2020-02-02");
    private static final Time TIME2 = new Time("12:02:02");
    private static final Text PLACE2 = new Text("Place 2");
    private static final Text ADDRESS2 = new Text("Address 2");
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
        activity.setAddress(ADDRESS1);
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
		activity.setAddress(ADDRESS2);
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
        assertEquals(original.getAddress(),saved.getAddress());
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
        assertNotEquals(original.getAddress(),saved.getAddress());
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
