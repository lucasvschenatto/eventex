package main.domain.activity;

import main.domain.Address;
import main.domain.AddressData;
import main.domain.Booleanic;
import main.domain.Date;
import main.domain.Quantity;
import main.domain.Repository;
import main.domain.RepositoryTest;
import main.domain.Text;
import main.domain.Time;
import main.domain.activity.Activity;
import main.domain.activity.ActivityRepository;
import main.domain.activity.Minutes;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public abstract class ActivityRepositoryTest extends RepositoryTest<Activity>{
	private static final Text NAME1 = new Text("Name 1");
    private static final Text DESCRIPTION1 = new Text("Description 1");
    private static final Date DATE1 = new Date("2010-01-01");
    private static final Time TIME1 = new Time("11:01:01");
    private static final Text PLACE1 = new Text("Place 1");
    private static final Address ADDRESS1 = new Address(makeData1());
    private static final Text EVENT_ID1 = new Text("abCDF0564");
    private static final Quantity SPOTS1 = new Quantity("10");
    private static final Minutes MINUTES1= new Minutes("11");
    private static final Quantity POINTS1 = new Quantity("100");
    private static final Booleanic GROUP_DISCOUNT1 = new Booleanic("false");
    private static final Booleanic VOUCHER1 = new Booleanic("false");
    
    private static final Text NAME2 = new Text("Name 2");
    private static final Text DESCRIPTION2 = new Text("Description 2");
    private static final Date DATE2 = new Date("2020-02-02");
    private static final Time TIME2 = new Time("12:02:02");
    private static final Text PLACE2 = new Text("Place 2");
    private static final Address ADDRESS2 = new Address(makeData2());
    private static final Text EVENT_ID2 = new Text("159aCeF");
    private static final Quantity SPOTS2 = new Quantity("20");
    private static final Minutes MINUTES2= new Minutes("22");
    private static final Quantity POINTS2 = new Quantity("200");
	private static final Booleanic GROUP_DISCOUNT2 = new Booleanic("true");
    private static final Booleanic VOUCHER2 = new Booleanic("true");
    private ActivityRepository repository;
	
	protected abstract ActivityRepository getRepository();
	
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

	protected Repository<Activity> getAbstractRepository(){
		return getRepository();
	}
	
	
	protected Activity makeNewEntity() {
		return new Activity();
	}

	protected Activity makeEntityWithId(String id) {
		Activity activity = new Activity();
        activity.setId(id);
        activity.setName(NAME1);
        activity.setDescription(DESCRIPTION1);
        activity.setDate(DATE1);
        activity.setTime(TIME1);
        activity.setPlace(PLACE1);
        activity.setAddress(ADDRESS1);
        activity.setEventId(EVENT_ID1);
        activity.setSpots(SPOTS1);
        activity.setDuration(MINUTES1);
        activity.setPoints(POINTS1);
        activity.setGroupDiscount(GROUP_DISCOUNT1);
        activity.setVoucher(VOUCHER1);
        return activity;
	}

	protected void changeEntity(Activity activity) {
		activity.setName(NAME2);
		activity.setDescription(DESCRIPTION2);
		activity.setDate(DATE2);
		activity.setTime(TIME2);
		activity.setPlace(PLACE2);
		activity.setAddress(ADDRESS2);
		activity.setEventId(EVENT_ID2);
		activity.setSpots(SPOTS2);
		activity.setDuration(MINUTES2);
		activity.setPoints(POINTS2);
		activity.setGroupDiscount(GROUP_DISCOUNT2);
		activity.setVoucher(VOUCHER2);
	}

	protected void assertEntityHasSameValues(Activity original, Activity saved) {
		assertEquals(original.getId(), saved.getId());
        assertEquals(original.getName(), saved.getName());
        assertEquals(original.getDescription(), saved.getDescription());
        assertEquals(original.getDate(),saved.getDate());
        assertEquals(original.getTime(),saved.getTime());
        assertEquals(original.getPlace(),saved.getPlace());
        assertEquals(original.getAddress(),saved.getAddress());
        assertEquals(original.getEventId(),saved.getEventId());
        assertEquals(original.getSpots(),saved.getSpots());
        assertEquals(original.getDuration(),saved.getDuration());
        assertEquals(original.getPoints(),saved.getPoints());
        assertEquals(original.getGroupDiscount(),saved.getGroupDiscount());
        assertEquals(original.getVoucher(),saved.getVoucher());
        
	}

	protected void assertEntityDoesNotHaveSameValues(Activity original, Activity saved) {
		assertEquals(original.getId(), saved.getId());
        assertNotEquals(original.getName(), saved.getName());
        assertNotEquals(original.getDescription(), saved.getDescription());
        assertNotEquals(original.getDate(),saved.getDate());
        assertNotEquals(original.getTime(),saved.getTime());
        assertNotEquals(original.getPlace(),saved.getPlace());
        assertNotEquals(original.getAddress(),saved.getAddress());
        assertNotEquals(original.getEventId(),saved.getEventId());
        assertNotEquals(original.getSpots(),saved.getSpots());
        assertNotEquals(original.getDuration(),saved.getDuration());
        assertNotEquals(original.getPoints(),saved.getPoints());
        assertNotEquals(original.getGroupDiscount(),saved.getGroupDiscount());
        assertNotEquals(original.getVoucher(),saved.getVoucher());
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

    @Test@SuppressWarnings("unused")
    public void givenTwoActivities_itReturnsTheTwo() {
        repository.save(makeNewEntity());
        repository.save(makeNewEntity());
        Iterable<Activity> activities = repository.getAll();
        int counter = 0;
        for (Activity ignored : activities)
        	counter++;
        assertEquals(2, counter);
    }
    
    @Test
    public void eventIdFilter_itReturnsRespectiveActivities(){
    	Activity a = makeNewEntity();
    	a.setEventId(EVENT_ID1);
    	Activity b = makeNewEntity();
    	b.setEventId(EVENT_ID2);
    	Activity c = makeNewEntity();
    	c.setEventId(EVENT_ID1);
    	Activity d = makeNewEntity();
    	d.setEventId(EVENT_ID2);
    	Activity e = makeNewEntity();
    	e.setEventId(EVENT_ID2);
    	repository.save(a);
        repository.save(b);
        repository.save(c);
        Iterable<Activity> filtered = repository.getAllForEventId(EVENT_ID1);
        
        int counter = 0;
        for (Activity f : filtered){
        	assertEquals(f.getEventId(),EVENT_ID1);
        	counter++;
        }
        assertEquals(2, counter);
    }

}
