package main.domain.event.activity;

import static org.junit.Assert.*;

import org.junit.Test;

import main.domain.EntityTest;
import main.domain.Text;
import main.domain.event.Quantity;
import main.domain.event.activity.Activity;

public class ActivityTest extends EntityTest<Activity>{

	protected Activity makeNewSubject() {
		return new Activity();
	}

	protected Activity makeSubjectWithData() {
		Activity activity = new Activity();
		activity.setName(new Text("name"));
		activity.setDescription(new Text("description"));
		activity.setDate(new Text("1900-01-01"));
		activity.setTime(new Text("6:59:59"));
		activity.setPlace(new Text("place"));
		activity.setAddress(new Text("address"));
		activity.setSpots("15");
		activity.setDuration("3");
		activity.setPoints("400");
		return activity;
	}

	@Override
	protected void assertSameData(Activity entity, Activity copy) {
		assertEquals(entity.getSpots(),copy.getSpots());
        assertEquals(entity.getDuration(),copy.getDuration());
        assertEquals(entity.getPoints(),copy.getPoints());
	}

	@Test
	public void newActivityHasEmptyAttributes() {
        assertEquals(Quantity.ZERO,subject.getSpots());
        assertEquals(Quantity.ZERO,subject.getDuration());
        assertEquals(Quantity.ZERO,subject.getPoints());
	}
}
