package main.domain;

public class Numeric {
	public static final Numeric ZERO = new Numeric("0");
    private int value;
    private boolean wasParsed;

    public Numeric(String value) {
        try {
            this.value = Integer.parseInt(value);
            this.wasParsed = true;
        } catch (NullPointerException | NumberFormatException ignored) {
            this.value = 0;
            this.wasParsed = false;
        }
    }

    public boolean isValid() {
        return wasParsed && value >= 0;
    }

    public String toString() {
        return String.valueOf(toInteger());
    }

    public int toInteger() {
        return value;
    }

    public boolean equals(Object other) {
        return other instanceof Numeric && equalsPhysicalNumber((Numeric) other);
    }

    protected boolean equalsPhysicalNumber(Numeric other) {
        return value == other.value;
    }
}
