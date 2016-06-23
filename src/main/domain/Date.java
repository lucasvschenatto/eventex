package main.domain;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
public class Date {
	public static final Date MIN = new Date(LocalDate.MIN.toString());
	private LocalDate value;
	private boolean parsed;
	
	public static Date now(){
		return new Date(LocalDate.now().toString());
	}
	public Date(String value) {
		try{
			this.value = LocalDate.parse(value.trim());
			this.parsed = true;
		}catch( DateTimeParseException | NullPointerException ignored){
			this.value = LocalDate.MIN;
			this.parsed = false;
		}
	}
	public String toString(){
		return getDate();
	}
	private String getDate() {
		return value.toString();
	}
	public int getYear() {
		return value.getYear();
	}
	public int getMonth() {
		return value.getMonthValue();
	}
	public int getDay() {
		return value.getDayOfMonth();
	}
	public boolean isValid() {
		return parsed;
	}
	public boolean equals(Object other){
		return other instanceof Date && equalsPhysicalDate((Date) other);
	}
	private boolean equalsPhysicalDate(Date other) {
		return value.equals(other.value);
	}
}
