package main.domain;

public class Adress {
	private String street;
	private int number;
	private String complement;
	private String neighborhood;
	private String city;
	private String state;
	private CEP cep;

	public String getStreet() {
		return street;
	}

	public int getNumber() {
		return number;
	}

	public String getComplement() {
		return complement;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public CEP getCEP() {
		return cep;
	}

}
