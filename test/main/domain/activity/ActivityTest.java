package main.domain.activity;

import static org.junit.Assert.*;

import org.junit.Test;

import main.domain.Address;
import main.domain.AddressData;
import main.domain.Booleanic;
import main.domain.Date;
import main.domain.EntityTest;
import main.domain.Quantity;
import main.domain.Text;
import main.domain.Time;
import main.domain.activity.Activity;
import main.domain.activity.Minutes;

public class ActivityTest extends EntityTest<Activity>{

	protected Activity makeNewSubject() {
		return new Activity();
	}

	protected Activity makeSubjectWithData() {
		Activity activity = new Activity();
		activity.setName(new Text("name"));
		activity.setDescription(new Text("description"));
		activity.setDate(new Date("1900-01-01"));
		activity.setTime(new Time("6:59:59"));
		activity.setPlace(new Text("place"));
		activity.setAddress(new Address(validAddressData()));
		activity.setEventId(new Text("1234567890"));
		activity.setSpots(new Quantity("15"));
		activity.setDuration(new Minutes("3"));
		activity.setPoints(new Quantity("400"));
		activity.setGroupDiscount(new Booleanic("true"));
		activity.setVoucher(new Booleanic("true"));
		return activity;
	}

	protected void assertSameData(Activity entity, Activity copy) {
		assertEquals(entity.getSpots(),copy.getSpots());
        assertEquals(entity.getDuration(),copy.getDuration());
        assertEquals(entity.getPoints(),copy.getPoints());
        assertEquals(entity.getGroupDiscount(),copy.getGroupDiscount());
        assertEquals(entity.getVoucher(),copy.getVoucher());
	}

	private AddressData validAddressData(){
    	AddressData data = new AddressData();
    	data.street = "street";
        data.number = "1";
        data.complement = "complement";
        data.neighborhood = "neighborhood";
        data.city = "city";
        data.state = "state";
        data.country = "country";
        data.cep = "11111-111";
    	return data;
    }
	
	@Test
	public void newActivityHasEmptyAttributes() {
        assertEquals(Quantity.ZERO,subject.getSpots());
        assertEquals(Minutes.ZERO,subject.getDuration());
        assertEquals(Quantity.ZERO,subject.getPoints());
        assertEquals(Booleanic.FALSE,subject.getGroupDiscount());
        assertEquals(Booleanic.FALSE,subject.getVoucher());
	}
}
