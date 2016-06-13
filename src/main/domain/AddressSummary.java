package main.domain;

public class AddressSummary {
	public String street;
	public int number;
	public String complement;
	public String neighborhood;
	public String city;
	public String state;
	public String country;
	public String cep;
	
	public boolean equals(Object other){
		return other instanceof AddressSummary && equalsValue((AddressSummary)other);
	}
	private boolean equalsValue(AddressSummary other) {
		return (street.equals(other.street)) && (number == other.number)
				 && (complement.equals(other.complement)) && (neighborhood.equals(other.neighborhood))
				 && (city.equals(other.city)) && (state.equals(other.state))
				 && (country.equals(other.country)) && (cep.equals(other.cep));
	}
}
