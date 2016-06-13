package main.domain.event;

import main.domain.Address;
import main.domain.Date;
import main.domain.Entity;
import main.domain.Text;
import main.domain.Time;

public class Event extends Entity {
    protected Text name;
    protected Text description;
    protected Date date;
    protected Time time;
    protected Text place;
    protected Address address;

    public Event() {
        this("", Text.EMPTY, Text.EMPTY, Date.MIN, Time.MIN, Text.EMPTY, new Address(null));
    }

    protected Event(String id, Text name, Text description, Date date, Time time, Text place, Address address) {
        super(id);
        this.name = name;
        this.description = description;
        this.date = date;
        this.time = time;
        this.place = place;
        this.address = address;
    }

    public Entity copy() {
        return new Event(id, name, description, date, time, place, address.copy());
    }

    public Text getName() {
    	return name;
    }

	public void setName(Text name) {
		this.name = name;
	}

	public Text getDescription() {
		return description;
	}

	public void setDescription(Text description) {
		this.description = description;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public Text getPlace() {
		return place;
	}

	public void setPlace(Text place) {
		this.place = place;
	}
	
	public Address getAddress(){
		return address;
	}
	
	public void setAddress(Address address){
		this.address = address;
	}
}
