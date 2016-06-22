package main.domain;

public class Address {
	public static final Address EMPTY = new Address(null);
	private Text street;
	private IntNumber number;
	private Text complement;
	private Text neighborhood;
	private Text city;
	private Text state;
	private Text country;
	private CEP cep;
	
	public Address(AddressData data){
		if(data == null)
			data = new AddressData();
		street = new Text(data.street); 
		number = new IntNumber(data.number); 
		complement = new Text(data.complement); 
		neighborhood = new Text(data.neighborhood);
		city = new Text(data.city); 
		state = new Text(data.state); 
		country = new Text(data.country); 
		cep = new CEP(data.cep);
	}
	
	public AddressData getData(){
		AddressData data = new AddressData();
		data.street = street.toString();
		data.number = number.toString();
		data.complement = complement.toString();
		data.neighborhood = neighborhood.toString();
		data.city = city.toString();
		data.state = state.toString();
		data.country = country.toString();
		data.cep = cep.toString();
		return data;
	}
	
	public Text getStreet() {
		return street;
	}
	public IntNumber getNumber() {
		return number;
	}
	public Text getComplement() {
		return complement;
	}
	public Text getNeighborhood() {
		return neighborhood;
	}
	public Text getCity() {
		return city;
	}
	public Text getState() {
		return state;
	}
	public Text getCountry() {
		return country;
	}
	public CEP getCEP() {
		return cep;
	}
	
	public AddressValidation getValidation(){
		AddressValidation validation = new AddressValidation();
		validation.invalidStreet = !street.isValid();
		validation.invalidNumber = !number.isValid();
        validation.invalidComplement = !complement.isValid();
        validation.invalidNeighborhood = !neighborhood.isValid();
        validation.invalidCity = !city.isValid();
        validation.invalidState = !state.isValid();
        validation.invalidCountry = !country.isValid();
        validation.invalidCEP = !cep.isValid();
        return validation;
	}
	
	public boolean isValid() {
		return isLocalAddressValid() && isCountryAddressValid();
	}

	private boolean isLocalAddressValid() {
		return (street.isValid() && number.isValid() && !number.equals(IntNumber.ZERO));
	}
	
	private boolean isCountryAddressValid() {
		return city.isValid() && state.isValid() && country.isValid() && cep.isValid();
	}
	
	public Address copy() {
	return new Address(getData());
}

	public AddressSummary toSummary() {
		AddressSummary summary = new AddressSummary();
		summary.street = street.toString();
		summary.number = number.toInt();
		summary.complement = complement.toString();
		summary.neighborhood = neighborhood.toString();
		summary.city = city.toString();
		summary.state = state.toString();
		summary.country = country.toString();
		summary.cep = cep.toString();
		return summary;
	}
	
	public boolean equals(Object other){
		return other instanceof Address && equalsValue((Address)other);
	}

	private boolean equalsValue(Address other) {
		return street.equals(other.street) && number.equals(other.number) &&
				complement.equals(other.complement) && neighborhood.equals(other.neighborhood) &&
						city.equals(other.city) && state.equals(other.state) &&
						country.equals(other.country) && cep.equals(other.cep);
	}
}
