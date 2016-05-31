package main.domain.event.activity;

import static org.junit.Assert.*;

import org.junit.Test;

import main.domain.Date;
import main.domain.EntityTest;
import main.domain.Text;
import main.domain.event.Quantity;
import main.domain.event.Time;
import main.domain.event.activity.Activity;

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
		activity.setAddress(new Text("address"));
		activity.setSpots(new Quantity("15"));
		activity.setDuration(new Minutes("3"));
		activity.setPoints(new Quantity("400"));
		return activity;
	}

	@Override
	protected void assertSameData(Activity entity, Activity copy) {
		assertEquals(entity.getSpots(),copy.getSpots());
        assertEquals(entity.getMinutes(),copy.getMinutes());
        assertEquals(entity.getPoints(),copy.getPoints());
	}

	@Test
	public void newActivityHasEmptyAttributes() {
        assertEquals(Quantity.ZERO,subject.getSpots());
        assertEquals(Minutes.ZERO,subject.getMinutes());
        assertEquals(Quantity.ZERO,subject.getPoints());
	}
}
