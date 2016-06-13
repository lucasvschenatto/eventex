package main.domain.activity;

import main.domain.Address;
import main.domain.Booleanic;
import main.domain.Date;
import main.domain.Entity;
import main.domain.Quantity;
import main.domain.Text;
import main.domain.Time;
import main.domain.event.Event;

public class Activity extends Event{
	
	private Text eventId;
	private Quantity spots;
	private Minutes minutes;
	private Quantity points;
	private Booleanic groupDiscount;
	private Booleanic voucher;
	public Activity(){
		this("", Text.EMPTY, Text.EMPTY, Date.MIN, Time.MIN, Text.EMPTY, new Address(null), 
				Text.EMPTY, Quantity.ZERO, Minutes.ZERO, Quantity.ZERO, Booleanic.FALSE, Booleanic.FALSE);
	}
	private Activity(String id, Text name, Text description, Date date, Time time, Text place, Address address, 
			Text eventId,
			Quantity spots, Minutes minutes, Quantity points,
			Booleanic groupDiscount, Booleanic voucher) {
		super(id, name, description, date, time, place, address);
		this.eventId = eventId;
		this.spots = spots;
		this.minutes = minutes;
		this.points = points;
		this.groupDiscount = groupDiscount;
		this.voucher = voucher;
	}

	public Entity copy() {
		return new Activity (id, name, description, date, time, place, address.copy(), 
				eventId, spots, minutes, points, groupDiscount, voucher);
	}

	public Text getEventId(){
		return eventId;
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
	public Booleanic getGroupDiscount() {
		return groupDiscount;
	}
	public Booleanic getVoucher() {
		return voucher;
	}
	
	public void setEventId(Text eventId){
		this.eventId = eventId;
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
	public void setGroupDiscount(Booleanic groupDiscount) {
		this.groupDiscount = groupDiscount;
	}
	public void setVoucher(Booleanic voucher) {
		this.voucher = voucher;
	}

}
