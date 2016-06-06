package main.domain;

public class Numeric {
	public static final Numeric ZERO = new Numeric("0");
    private int value;
    private boolean wasParsed;

    public Numeric(String value) {
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
        return other instanceof Numeric && equalsPhysicalNumber((Numeric) other);
    }

    protected boolean equalsPhysicalNumber(Numeric other) {
        return value == other.value;
    }
}
