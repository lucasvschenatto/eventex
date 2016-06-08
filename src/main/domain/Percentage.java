package main.domain;

public class Percentage extends IntNumber{
	public static final Percentage ZERO = new Percentage("0");

	public Percentage(String value) {
		super(value);
	}
	
	public boolean isValid(){
		return super.isValid() && value <= 100;
	}

}
