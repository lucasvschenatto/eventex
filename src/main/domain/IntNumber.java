package main.domain;

public class IntNumber {
	public static final IntNumber ZERO = new IntNumber("0");
    protected int value;
    private boolean wasParsed;

    public IntNumber(String value) {
        try {
            this.value = Integer.parseInt(value.trim());
            this.wasParsed = true;
        } catch (NullPointerException | NumberFormatException ignored) {
            this.value = 0;
            this.wasParsed = false;
        }
    }

    public boolean isValid() {
        return wasParsed && value >= 0;
    }

    public int toInt() {
        return value;
    }
    
    public String toString(){
    	return Integer.toString(value);
    }
    
    public boolean equals(Object other) {
        return other instanceof IntNumber && equalsPhysicalNumber((IntNumber) other);
    }

    protected boolean equalsPhysicalNumber(IntNumber other) {
        return value == other.value;
    }
}
