package main.domain.activity;

public class Minutes {
	public static final Minutes ZERO = new Minutes("0");
	private int value;
	private boolean wasParsed;

	public Minutes(String value) {
		try{
            this.value = Integer.parseInt(value);
            wasParsed = true;
        } catch (NullPointerException | NumberFormatException ignored) {
            this.value = 0;
            wasParsed = false;
        }
	}
	public int toInteger() {
		return value;
	}
	public boolean isValid() {
		return wasParsed && value >= 0;
	}
	
	public String toString(){
		return Integer.toString(value);
	}
	
	public boolean equals(Object other){
		return other instanceof Minutes && equalsValue((Minutes) other);
	}
	private boolean equalsValue(Minutes other) {
		return value == other.value;
	}
	

}
