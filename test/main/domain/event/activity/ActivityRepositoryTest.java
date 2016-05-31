package main.domain.event.activity;

import static org.junit.Assert.*;

import org.junit.Test;

import main.domain.Repository;
import main.domain.RepositoryTest;
import main.domain.Text;
import main.domain.event.Event;
import main.domain.event.EventRepository;
import main.domain.event.Quantity;

public abstract class ActivityRepositoryTest extends RepositoryTest<Activity>{
	private static final Text NAME1 = new Text("Name 1");
    private static final Text DESCRIPTION1 = new Text("Description 1");
    private static final Text DATE1 = new Text("2010-01-01");
    private static final Text TIME1 = new Text("11:01:01");
    private static final Text PLACE1 = new Text("Place 1");
    private static final Text ADDRESS1 = new Text("Address 1");
    private static final Quantity SPOTS1 = new Quantity("10");
    private static final Quantity DURATION1= new Quantity("11");
    private static final Quantity POINTS1 = new Quantity("100");
    
    private static final Text NAME2 = new Text("Name 2");
    private static final Text DESCRIPTION2 = new Text("Description 2");
    private static final Text DATE2 = new Text("2020-02-02");
    private static final Text TIME2 = new Text("12:02:02");
    private static final Text PLACE2 = new Text("Place 2");
    private static final Text ADDRESS2 = new Text("Address 2");
    private static final Quantity SPOTS2 = new Quantity("20");
    private static final Quantity DURATION2= new Quantity("22");
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
	@Test
	public void test() {
		fail("Not yet implemented");
	}

	@Override
	protected String getValidId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String getInvalidId() {
		// TODO Auto-generated method stub
		return null;
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
        activity.setSpots(TIME1);
        activity.setDuration(PLACE1);
        activity.setPoints(ADDRESS1);
        return activity;
	}

	@Override
	protected void changeEntity(Activity activity) {
		activity.setName(NAME2);
		activity.setDescription(DESCRIPTION2);
		activity.setDate(DATE2);
		activity.setTime(TIME2);
		activity.setPlace(PLACE2);
		activity.setSpots(SPOTS2);
		activity.setAddress(ADDRESS2);
		activity.setSpots(SPOTS2);
		activity.setDuration(DURATION2);
		activity.setPoints(POINTS2);
	}

	@Override
	protected void assertEntityHasSameValues(Activity original, Activity saved) {
		assertEquals(original.getId(), saved.getId());
        assertNotEquals(original.getName(), saved.getName());
        assertNotEquals(original.getDescription(), saved.getDescription());
        assertNotEquals(original.getDate(),saved.getDate());
        assertNotEquals(original.getTime(),saved.getTime());
        assertNotEquals(original.getPlace(),saved.getPlace());
        assertNotEquals(original.getAddress(),saved.getAddress());
        assertNotEquals(original.getSpots(),saved.getSpots());
        assertNotEquals(original.getDuration(),saved.getDuration());
        assertNotEquals(original.getPoints(),saved.getPoints());
        
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
        assertNotEquals(original.getDuration(),saved.getDuration());
        assertNotEquals(original.getPoints(),saved.getPoints());
	}

}
