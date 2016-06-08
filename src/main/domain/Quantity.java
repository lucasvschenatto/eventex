package main.domain;

public class Quantity extends IntNumber{
	public static final Quantity ZERO = new Quantity("0");
	public Quantity(String value) {
		super(value);
	}
	
	public boolean equals(Object other) {
        return other instanceof Quantity && equalsPhysicalNumber((Quantity) other);
    }
    
}
