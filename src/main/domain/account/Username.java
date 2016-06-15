package main.domain.account;

import main.domain.Text;

public class Username extends Text {
	public static final Username EMPTY = new Username("");

	public Username(String value) {
		super(value);
	}
	
	protected boolean equalsText(Text other){
		String otherLowerCase = other.toString().toLowerCase();
		String thisLowerCase = this.value.toLowerCase();
		return otherLowerCase.equals(thisLowerCase);
	}
	
	public String toString(){
		return value.toLowerCase();
	}
	
	public boolean isValid(){
		return super.isValid() && hasNoSpaces() && isValidSize() && 
				startsWithAlphanumeric() && endsWithAlphanumeric() &&
				isOnlyAlphanumericAndDots() && hasAtLeastSixAlphanumeric();
	}

	private boolean hasAtLeastSixAlphanumeric() {
		String alphanumerics = value.replaceAll("[^a-zA-Z0-9]*", "");
		return (alphanumerics.length() >= 6);
	}

	private boolean isOnlyAlphanumericAndDots() {
		return value.matches("^[a-zA-Z0-9.]*$");
	}

	private boolean startsWithAlphanumeric() {
		return value.matches("[\\p{Alnum}].*");
	}
	
	private boolean endsWithAlphanumeric() {
		return value.matches(".*[\\p{Alnum}]");
	}

	private boolean hasNoSpaces() {
		return value.indexOf(" ") == -1;
	}

	private boolean isValidSize(){
		return (value.length() >= 6) && (value.length() <= 30);
	}
}
