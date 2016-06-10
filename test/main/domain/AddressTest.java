package main.domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class AddressTest {
	private Address makeValidAddress() {
		Address address = new Address();
		address.setPlace("place");
		address.setStreet("street");
		address.setNumber("1");
		address.setComplement("complement");
		address.setNeighborhood("neighborhood");
		address.setCity("city");
		address.setState("state");
		address.setCountry("country");
		address.setCEP("11111-111");
		return address;
	}
	
	@Test
	public void givenEmptyAddress_itShouldHaveInitialAttributesAndBrasilAsCountry(){
		Address address = new Address();
		
		assertEquals("", address.getPlace());
		assertEquals("",address.getStreet());
		assertEquals(0,address.getNumber());
		assertEquals("",address.getComplement());
		assertEquals("",address.getNeighborhood());
		assertEquals("",address.getCity());
		assertEquals("",address.getState());
		assertEquals("Brasil",address.getCountry());
		assertEquals("00000-000",address.getCEP());
	}

	@Test
	public void givenAttributesAsObjects_itShouldConvertBackToIt(){
		Address address = new Address();
		
		address.setPlace("Armazém do Zé");
		address.setStreet("street");
		address.setNumber("52");
		address.setComplement("ap. 110");
		address.setNeighborhood("downtown");
		address.setCity("city");
		address.setState("state");
		address.setCountry("Brazil");
		address.setCEP("11111-111");
		
		assertEquals("Armazém do Zé", address.getPlace());
		assertEquals("street",address.getStreet());
		assertEquals(52,address.getNumber());
		assertEquals("ap. 110",address.getComplement());
		assertEquals("downtown",address.getNeighborhood());
		assertEquals("city",address.getCity());
		assertEquals("state",address.getState());
		assertEquals("Brazil",address.getCountry());
		assertEquals("11111-111",address.getCEP());
	}
	
	@Test
	public void givenAllInitialAttributes_itIsInvalid(){
		assertFalse(new Address().isValid());
	}

	@Test
	public void givenAllValidAttributes_itIsValid(){
		assertTrue(makeValidAddress().isValid());
	}
	
	@Test
	public void givenNoPlace_itIsValid(){
		Address address = makeValidAddress();
		address.setPlace("");
		assertTrue(address.isValid());
	}
	
	@Test
	public void givenNoNeighborhood_itIsValid(){
		Address address = makeValidAddress();
		address.setNeighborhood("");
		assertTrue(address.isValid());
	}
	
	@Test
	public void givenPlaceButNoStreetNorNumber_itIsValid(){
		Address address = makeValidAddress();
		address.setPlace("place");
		address.setStreet("");
		address.setNumber("");
		assertTrue(address.isValid());
	}

	@Test
	public void givenNoCity_itIsInvalid(){
		Address address = makeValidAddress();
		address.setCity("");
		assertFalse(address.isValid());
	}
	
	@Test
	public void givenNoState_itIsInvalid(){
		Address address = makeValidAddress();
		address.setState("");
		assertFalse(address.isValid());
	}
	
	@Test
	public void givenNoCountry_itIsInvalid(){
		Address address = makeValidAddress();
		address.setCountry("");
		assertFalse(address.isValid());
	}
	
	@Test
	public void givenNoCEP_itIsInvalid(){
		Address address = makeValidAddress();
		address.setCEP("");
		assertFalse(address.isValid());
	}
}
