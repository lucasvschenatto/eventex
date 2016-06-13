package main.domain;

public class ArbitraryAddress extends Address {
	public ArbitraryAddress(AddressData data) {
		super(data);
	}

	public boolean isValid(){
		return true;
	}

}
