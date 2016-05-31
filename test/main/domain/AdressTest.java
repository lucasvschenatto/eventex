package main.domain;

import static org.junit.Assert.*;
import org.junit.Test;

public class AdressTest{
	@Test
	public void newAdressHasEmptyAttributes(){
		Adress subject = new Adress();
		assertEquals("",subject.getStreet());
		assertEquals(0,subject.getNumber());
		assertEquals("",subject.getComplement());
		assertEquals("",subject.getNeighborhood());
		assertEquals("",subject.getCity());
		assertEquals("",subject.getState());
		assertEquals("",subject.getCEP());
	}

//	@Test
//    public void givenAAdressAsString_itShouldConvertBackToIt() {
//        assertEquals("2014-12-31", new Adress("2014-12-31").toString());
//    }
//	@Test
//    public void givenAAdressAsString_itShouldSeparateYear() {
//        assertEquals(2014, new Adress("2014-12-31").getYear());
//    }
//	@Test
//    public void givenAAdressAsString_itShouldSeparateMonth() {
//        assertEquals(12, new Adress("2014-12-31").getMonth());
//    }
//	@Test
//    public void givenAAdressAsString_itShouldSeparateDay() {
//        assertEquals(31, new Adress("2014-12-31").getDay());
//    }
//	@Test
//    public void givenAInvalidString_itShouldConvertToMinimum() {
//        assertEquals("-999999999-01-01", new Adress("not a date").toString());
//    }
//	@Test
//    public void givenANullValue_itShouldConvertToMinimum() {
//        assertEquals("-999999999-01-01", new Adress(null).toString());
//    }
//	@Test
//    public void itIsInvalidWhenNotAAdress() {
//        assertFalse(new Adress("not a number").isValid());
//    }
//	@Test
//    public void itIsValidWhenAMinimumAdress() {
//        assertTrue(new Adress("-999999999-01-01").isValid());
//    }
//	@Test
//    public void validAdresssAreEqualWhenTheyHaveTheSameValue() {
//        assertEquals(new Adress("2013-07-25"), new Adress("2013-07-25"));
//    }
//	@Test
//    public void invalidAdresss_forDifferentReasons_areEqualNonetheless() {
//        assertEquals(new Adress("not a date"), new Adress(null));
//    }

}
