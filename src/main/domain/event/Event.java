package main.domain.event;

import main.domain.Entity;
import main.domain.Text;

public class Event extends Entity {
    private Text name;
    private Text description;
    private Text date;
    private Text time;
    private Text place;
    private Text address;

    public Event() {
        this("", Text.EMPTY, Text.EMPTY, Text.EMPTY, Text.EMPTY, Text.EMPTY, Text.EMPTY);
    }

    private Event(String id, Text name, Text description, Text date, Text time, Text place, Text address) {
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

	public Text getDate() {
		return date;
	}

	public void setDate(Text date) {
		this.date = date;
	}

	public Text getTime() {
		return time;
	}

	public void setTime(Text time) {
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
