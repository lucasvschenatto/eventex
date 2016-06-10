package main.domain;

public class Address {
	protected Text place;
	protected Text street;
	protected IntNumber number;
	protected Text complement;
	protected Text city;
	protected Text neighborhood;
	protected Text state;
	protected Text country;
	protected CEP cep;
	
	public Address(){
		this(Text.EMPTY,Text.EMPTY,IntNumber.ZERO,Text.EMPTY,Text.EMPTY,Text.EMPTY,Text.EMPTY,new Text("Brasil"),CEP.ZERO);
	}

	protected Address(Text place, Text street, IntNumber number, Text complement, 
			Text city, Text neighborhood, Text state,
			Text country, CEP cep) {
		this.place = place;
		this.street = street;
		this.number = number;
		this.complement = complement;
		this.city = city;
		this.neighborhood = neighborhood;
		this.state = state;
		this.country = country;
		this.cep = cep;
	}

	public String getCEP() {
		return cep.toString();
	}

	public String getCity() {
		return city.toString();
	}

	public String getComplement() {
		return complement.toString();
	}

	public String getCountry() {
		return country.toString();
	}

	public String getNeighborhood() {
		return neighborhood.toString();
	}

	public int getNumber() {
		return number.toInt();
	}

	public String getPlace() {
		return place.toString();
	}

	public String getState() {
		return state.toString();
	}

	public String getStreet() {
		return street.toString();
	}

	public void setCEP(String cep) {
		this.cep = new CEP(cep);
	}

	public void setCity(String city) {
		this.city = new Text(city);
	}

	public void setComplement(String complement) {
		this.complement = new Text(complement);
	}

	public void setCountry(String country) {
		this.country = new Text(country);
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = new Text(neighborhood);
	}

	public void setNumber(String number) {
		this.number = new IntNumber(number);
	}

	public void setPlace(String place) {
		this.place = new Text(place);
	}

	public void setState(String state) {
		this.state = new Text(state);
	}

	public void setStreet(String street) {
		this.street = new Text(street);
	}

	public boolean isValid() {
		return isLocalAddressValid() && isCountryAddressValid();
	}

	private boolean isLocalAddressValid() {
		return (street.isValid() && number.isValid() && !number.equals(IntNumber.ZERO)) ||
				place.isValid();
	}
	
	private boolean isCountryAddressValid() {
		return city.isValid() && state.isValid() && country.isValid() && cep.isValid();
	}

}
