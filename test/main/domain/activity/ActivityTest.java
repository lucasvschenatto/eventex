package main.domain.activity;

import static org.junit.Assert.*;

import org.junit.Test;

import main.domain.Booleanic;
import main.domain.CEP;
import main.domain.Date;
import main.domain.EntityTest;
import main.domain.Numeric;
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
		activity.setStreet(new Text("street"));
		activity.setNumber(new Numeric("1"));
		activity.setComplement(new Text("complement"));
		activity.setNeighborhood(new Text("neighborhood"));
		activity.setCity(new Text("city"));
		activity.setState(new Text("state"));
		activity.setCEP(new CEP("11111-111"));
		activity.setSpots(new Quantity("15"));
		activity.setDuration(new Minutes("3"));
		activity.setPoints(new Quantity("400"));
		activity.setGroupDiscount(new Booleanic("true"));
		activity.setVoucher(new Booleanic("true"));
		return activity;
	}

	@Override
	protected void assertSameData(Activity entity, Activity copy) {
		assertEquals(entity.getSpots(),copy.getSpots());
        assertEquals(entity.getMinutes(),copy.getMinutes());
        assertEquals(entity.getPoints(),copy.getPoints());
        assertEquals(entity.getGroupDiscount(),copy.getGroupDiscount());
        assertEquals(entity.getVoucher(),copy.getVoucher());
	}

	@Test
	public void newActivityHasEmptyAttributes() {
        assertEquals(Quantity.ZERO,subject.getSpots());
        assertEquals(Minutes.ZERO,subject.getMinutes());
        assertEquals(Quantity.ZERO,subject.getPoints());
        assertEquals(Booleanic.FALSE,subject.getGroupDiscount());
        assertEquals(Booleanic.FALSE,subject.getVoucher());
	}
}
