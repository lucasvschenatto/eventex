package main.domain;

public class Booleanic {
	public static final Booleanic FALSE = new Booleanic("false");
    private boolean value;
    private boolean parsed;

    public Booleanic(String value) {
    	if(value != null && ( "true".equalsIgnoreCase(value.trim()) || "false".equalsIgnoreCase(value.trim())) ){
    		parsed = true;
    		if("true".equalsIgnoreCase(value.trim()))
    			this.value = true;
    		else
    			this.value = false;
    	}
    	else
    		parsed = false;
    }

    public boolean isValid() {
        return parsed;
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
