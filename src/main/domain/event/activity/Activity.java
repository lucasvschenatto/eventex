package main.domain.event.activity;

import main.domain.Entity;
import main.domain.Text;
import main.domain.event.Event;
import main.domain.event.Quantity;

public class Activity extends Event{

	private Quantity spots;
	private Quantity duration;
	private Quantity points;
	public Activity(){
		this("", Text.EMPTY, Text.EMPTY, Text.EMPTY, Text.EMPTY, Text.EMPTY, Text.EMPTY, Quantity.ZERO, Quantity.ZERO, Quantity.ZERO);
	}
	private Activity(String id, Text name, Text description, Text date, Text time, Text place, Text address, Quantity spots, Quantity duration, Quantity points) {
		super(id, Text.EMPTY, Text.EMPTY, Text.EMPTY, Text.EMPTY, Text.EMPTY, Text.EMPTY);
		this.spots = spots;
		this.duration = duration;
		this.points = points;
	}

	public Entity copy() {
		return new Activity (id, name, description, date, time, place, address, spots, duration, points);
	}
	public Quantity getSpots() {
		return spots;
	}
	public Quantity getDuration() {
		return duration;
	}
	public Quantity getPoints() {
		return points;
	}
	public void setSpots(String spots) {
		this.spots = new Quantity(spots);
	}
	public void setDuration(String duration) {
		this.duration = new Quantity(duration);		
	}
	public void setPoints(String points) {
		this.points = new Quantity(points);
	}

}
