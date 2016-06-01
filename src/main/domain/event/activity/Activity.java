package main.domain.event.activity;

import main.domain.CEP;
import main.domain.Date;
import main.domain.Entity;
import main.domain.Numeric;
import main.domain.Quantity;
import main.domain.Text;
import main.domain.event.Event;
import main.domain.event.Time;

public class Activity extends Event{

	private Quantity spots;
	private Minutes minutes;
	private Quantity points;
	public Activity(){
		this("", Text.EMPTY, Text.EMPTY, Date.MIN, Time.MIN, Text.EMPTY, Text.EMPTY, Numeric.ZERO, Text.EMPTY, Text.EMPTY, Text.EMPTY, Text.EMPTY, CEP.ZERO, Quantity.ZERO, Minutes.ZERO, Quantity.ZERO);
	}
	private Activity(String id, Text name, Text description, Date date, Time time, Text place, Text street, Numeric number, Text complement, Text neighborhood, Text city, Text state, CEP cep, Quantity spots, Minutes minutes, Quantity points) {
		super(id, name, description, date, time, place, street, number, complement, neighborhood, city, state, cep);
		this.spots = spots;
		this.minutes = minutes;
		this.points = points;
	}

	public Entity copy() {
		return new Activity (id, name, description, date, time, place, street, number, complement, neighborhood, city, state, cep, spots, minutes, points);
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
