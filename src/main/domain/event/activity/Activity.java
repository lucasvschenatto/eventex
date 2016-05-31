package main.domain.event.activity;

import main.domain.Date;
import main.domain.Entity;
import main.domain.Text;
import main.domain.event.Event;
import main.domain.event.Quantity;
import main.domain.event.Time;

public class Activity extends Event{

	private Quantity spots;
	private Minutes minutes;
	private Quantity points;
	public Activity(){
		this("", Text.EMPTY, Text.EMPTY, Date.MIN, Time.MIN, Text.EMPTY, Text.EMPTY, Quantity.ZERO, Minutes.ZERO, Quantity.ZERO);
	}
	private Activity(String id, Text name, Text description, Date date, Time time, Text place, Text address, Quantity spots, Minutes minutes, Quantity points) {
		super(id, name, description, date, time, place, address);
		this.spots = spots;
		this.minutes = minutes;
		this.points = points;
	}

	public Entity copy() {
		return new Activity (id, name, description, date, time, place, address, spots, minutes, points);
	}
	public Quantity getSpots() {
		return spots;
	}
	public Minutes getMinutes() {
		return minutes;
	}
	public Quantity getPoints() {
		return points;
	}
	public void setSpots(Quantity spots) {
		this.spots = spots;
	}
	public void setDuration(Minutes minutes) {
		this.minutes = minutes;		
	}
	public void setPoints(Quantity points) {
		this.points = points;
	}

}
