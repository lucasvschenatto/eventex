package main.domain;

public class Booleanic {
	public static final Booleanic FALSE = new Booleanic("false");
    private boolean value;

    public Booleanic(String value) {
    	this.value = Boolean.parseBoolean(value);
    }

    public boolean isValid() {
        return true;
    }

    public boolean toBoolean() {
        return value;
    }
    
    public String toString(){
    	return Boolean.toString(value);
    }
    
    public boolean equals(Object other) {
        return other instanceof Booleanic && equalsValue((Booleanic) other);
    }

    protected boolean equalsValue(Booleanic other) {
        return value == other.value;
    }

}
