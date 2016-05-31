package main.domain.event;

import java.time.LocalTime;
import java.time.format.DateTimeParseException;

public class Time {
	public static final Time MIN = new Time(LocalTime.MIN.toString());
	private LocalTime value;
	private boolean parsed;
	public Time(String value) {
		try{
			this.value = LocalTime.parse(value);
			this.parsed = true;
		}catch( DateTimeParseException | NullPointerException ignored){
			this.value = LocalTime.MIN;
			this.parsed = false;
		}
	}
	
	public String toString(){
		return value.toString();
	}

	public int getHour() {
		return value.getHour();
	}

	public int getMinute() {
		return value.getMinute();
	}
	
	public int getSecond(){
		return value.getSecond();
	}

	public boolean isValid() {
		return parsed;
	}
	
	public boolean equals(Object other){
		return other instanceof Time && equalsPhysicalTime((Time)other);
	}

	private boolean equalsPhysicalTime(Time other) {
		return value.equals(other.value);
	}

}
