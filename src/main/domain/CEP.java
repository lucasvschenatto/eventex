package main.domain;

import java.text.ParseException;

import javax.swing.text.MaskFormatter;

public class CEP {
	public static final CEP ZERO = new CEP("00000-000");
	private String value;
	private boolean parsed;

	public CEP(String value) {
		try {
			if(value == null) throw new NullPointerException();
			this.value = new MaskFormatter("#####-###").valueToString(value.trim());
			parsed = true;
		} catch (ParseException | NullPointerException ignored) {
			this.value = "00000-000";
			parsed = false;
		}		
	}
	public String toString(){
		return value;
	}
	public boolean isValid() {
		return parsed;
	}
	
	public boolean equals(Object other){
		return other instanceof CEP && equalsValue((CEP)other);
	}
	private boolean equalsValue(CEP other) {
		return value.equals(other.value);
	}
}
