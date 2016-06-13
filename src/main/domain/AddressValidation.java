package main.domain;

public class AddressValidation {
	public boolean invalidStreet;
	public boolean invalidNumber;
	public boolean invalidComplement;
	public boolean invalidNeighborhood;
	public boolean invalidCity;
	public boolean invalidState;
	public boolean invalidCountry;
	public boolean invalidCEP;
	
	public boolean isValid() {
		return !invalidStreet && !invalidNumber && !invalidCity && 
				!invalidState && !invalidCountry && !invalidCEP;
	}
}
