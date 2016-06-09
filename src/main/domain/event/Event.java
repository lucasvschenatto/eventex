package main.domain.event;

import main.domain.CEP;
import main.domain.Date;
import main.domain.Entity;
import main.domain.IntNumber;
import main.domain.Text;
import main.domain.Time;

public class Event extends Entity {
    protected Text name;
    protected Text description;
    protected Date date;
    protected Time time;
    protected Text place;
    protected Text street;
	protected IntNumber number;
	protected Text complement;
	protected Text neighborhood;
	protected Text city;
	protected Text state;
	protected CEP cep;

    public Event() {
        this("", Text.EMPTY, Text.EMPTY, Date.MIN, Time.MIN, Text.EMPTY, Text.EMPTY, IntNumber.ZERO, Text.EMPTY, Text.EMPTY, Text.EMPTY, Text.EMPTY, CEP.ZERO);
    }

    protected Event(String id, Text name, Text description, Date date, Time time, Text place, Text street, IntNumber number, Text complement, Text neighborhood, Text city, Text state, CEP cep) {
        super(id);
        this.name = name;
        this.description = description;
        this.date = date;
        this.time = time;
        this.place = place;
        this.street = street;
		this.number = number;
		this.complement = complement;
		this.neighborhood = neighborhood;
		this.city = city;
		this.state = state;
		this.cep = cep;
    }

    public Entity copy() {
        return new Event(id, name, description, date, time, place, street, number, complement, neighborhood, city, state, cep);
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

	public Text getStreet() {
		return street;
	}

	public IntNumber getNumber() {
		return number;
	}

	public Text getComplement() {
		return complement;
	}

	public Text getNeighborhood() {
		return neighborhood;
	}

	public Text getCity() {
		return city;
	}

	public Text getState() {
		return state;
	}

	public CEP getCEP() {
		return cep;
	}

	public void setStreet(Text street) {
		this.street = street;
	}
	public void setNumber(IntNumber number) {
		this.number = number;
	}
	public void setComplement(Text complement){
		this.complement = complement;
	}
	public void setNeighborhood(Text neighborhood){
		this.neighborhood = neighborhood;
	}
	public void setCity(Text city){
		this.city = city;
	}
	public void setState(Text state){
		this.state = state;
	}
	public void setCEP(CEP cep){
		this.cep = cep;
	}
}
