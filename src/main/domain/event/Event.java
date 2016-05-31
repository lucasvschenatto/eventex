package main.domain.event;

import main.domain.Date;
import main.domain.Entity;
import main.domain.Text;

public class Event extends Entity {
    protected Text name;
    protected Text description;
    protected Date date;
    protected Time time;
    protected Text place;
    protected Text address;

    public Event() {
        this("", Text.EMPTY, Text.EMPTY, Date.MIN, Time.MIN, Text.EMPTY, Text.EMPTY);
    }

    protected Event(String id, Text name, Text description, Date date, Time time, Text place, Text address) {
        super(id);
        this.id = id;
        this.name = name;
        this.description = description;
        this.date = date;
        this.time = time;
        this.place = place;
        this.address = address;
    }

    public Entity copy() {
        return new Event(id, name, description, date, time, place, address);
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

	public Text getAddress() {
		return address;
	}

	public void setAddress(Text address) {
		this.address = address;
	}
}
