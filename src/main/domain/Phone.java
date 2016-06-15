package main.domain;

import java.text.ParseException;

import javax.swing.text.MaskFormatter;

public class Phone {
	public static final Phone ZERO = new Phone("(00) 0000-0000");
	private String value;
	private boolean parsed;
	
	public Phone(String value){
		try {
			if(value == null) throw new NullPointerException();
			String trimedValue = value.trim();
			switch (trimedValue.length()){
			case 14:
				this.value = new MaskFormatter("(##) ####-####").valueToString(trimedValue);
				break;
			case 15:
				this.value = new MaskFormatter("(##) 9####-####").valueToString(trimedValue);
				break;
			default:
				throw new PhoneFormatException();	
			}			
			parsed = true;
		} catch (ParseException | NullPointerException | PhoneFormatException ignored) {
			this.value = "(00) 0000-0000";
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
		return this.getClass().isInstance(other) && equalsValue((Phone)other);
	}
	private boolean equalsValue(Phone other) {
		return value.equals(other.value);
	}
	
	
	private class PhoneFormatException extends RuntimeException{
		private static final long serialVersionUID = 1L;		
	}
}
