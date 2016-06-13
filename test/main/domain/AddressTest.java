package main.domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class AddressTest {
	private AddressData validAddressData() {
		AddressData data = new AddressData();
		data.street = "street";
		data.number = "1";
		data.complement = "complement";
		data.neighborhood = "neighborhood";
		data.city = "city";
		data.state = "state";
		data.country = "country";
		data.cep = "11111-111";
		return data;
	}
	
	@Test
	public void givenEmptyAddress_itShouldHaveInitialAttributesAndBrasilAsCountry(){
		Address address = new Address(null);
		
		assertEquals(new Text(""),address.getStreet());
		assertEquals(new IntNumber("0"),address.getNumber());
		assertEquals(new Text(""),address.getComplement());
		assertEquals(new Text(""),address.getNeighborhood());
		assertEquals(new Text(""),address.getCity());
		assertEquals(new Text(""),address.getState());
		assertEquals(new Text("Brasil"),address.getCountry());
		assertEquals(new CEP("00000-000"),address.getCEP());
	}

	@Test
	public void givenAttributesAsObjects_itShouldConvertBackToIt(){
		AddressData data = new AddressData();
		data.street = "street";
		data.number = "52";
		data.complement = "ap. 110";
		data.neighborhood = "downtown";
		data.city = "city";
		data.state = "state";
		data.country = "country";
		data.cep = "11111-111";
		Address address = new Address(data);
		
		assertEquals(new Text("street"),address.getStreet());
		assertEquals(new IntNumber("52"),address.getNumber());
		assertEquals(new Text("ap. 110"),address.getComplement());
		assertEquals(new Text("downtown"),address.getNeighborhood());
		assertEquals(new Text("city"),address.getCity());
		assertEquals(new Text("state"),address.getState());
		assertEquals(new Text("country"),address.getCountry());
		assertEquals(new CEP("11111-111"),address.getCEP());
	}
	
	@Test
	public void givenAllInitialAttributes_itIsInvalid(){
		assertFalse(new Address(null).isValid());
	}

	@Test
	public void givenAllValidAttributes_itIsValid(){
		assertTrue(new Address(validAddressData()).isValid());
	}
	
	@Test
	public void givenNoNeighborhood_itIsValid(){
		AddressData data = validAddressData();
		data.neighborhood = "";
		Address address = new Address(data);
		assertTrue(address.isValid());
	}

	@Test
	public void givenNoCity_itIsInvalid(){
		AddressData data = validAddressData();
		data.city = "";
		Address address = new Address(data);
		assertFalse(address.isValid());
	}
	
	@Test
	public void givenNoState_itIsInvalid(){
		AddressData data = validAddressData();
		data.state = "";
		Address address = new Address(data);
		assertFalse(address.isValid());
	}
	
	@Test
	public void givenNoCountry_itIsInvalid(){
		AddressData data = validAddressData();
		data.country = "";
		Address address = new Address(data);
		assertFalse(address.isValid());
	}
	
	@Test
	public void givenNoCEP_itIsInvalid(){
		AddressData data = validAddressData();
		data.cep = "";
		Address address = new Address(data);
		assertFalse(address.isValid());
	}
}
