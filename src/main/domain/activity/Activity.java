package main.domain.activity;

import main.domain.Booleanic;
import main.domain.CEP;
import main.domain.Date;
import main.domain.Entity;
import main.domain.Numeric;
import main.domain.Quantity;
import main.domain.Text;
import main.domain.Time;
import main.domain.event.Event;

public class Activity extends Event{

	private Quantity spots;
	private Minutes minutes;
	private Quantity points;
	private Booleanic groupDiscount;
	private Booleanic voucher;
	public Activity(){
		this("", Text.EMPTY, Text.EMPTY, Date.MIN, Time.MIN, Text.EMPTY, Text.EMPTY, Numeric.ZERO, Text.EMPTY, Text.EMPTY, Text.EMPTY, Text.EMPTY, CEP.ZERO, Quantity.ZERO, Minutes.ZERO, Quantity.ZERO, Booleanic.FALSE, Booleanic.FALSE);
	}
	private Activity(String id, Text name, Text description, Date date, Time time, Text place, Text street, Numeric number, Text complement, Text neighborhood, Text city, Text state, CEP cep, 
			Quantity spots, Minutes minutes, Quantity points,
			Booleanic groupDiscount, Booleanic voucher) {
		super(id, name, description, date, time, place, street, number, complement, neighborhood, city, state, cep);
		this.spots = spots;
		this.minutes = minutes;
		this.points = points;
		this.groupDiscount = groupDiscount;
		this.voucher = voucher;
	}

	public Entity copy() {
		return new Activity (id, name, description, date, time, place, street, number, complement, neighborhood, city, state, cep, spots, minutes, points, groupDiscount, voucher);
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
