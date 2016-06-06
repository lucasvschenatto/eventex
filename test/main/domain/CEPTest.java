package main.domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class CEPTest {

	@Test
    public void givenACEPAsString_itShouldConvertBackToIt() {
        assertEquals("91910-530", new CEP("91910-530").toString());
    }
	
	@Test
	public void givenACEPSurroundedBySpaceAsString_itShouldConvertBackToIt() {
		assertEquals("91910-530", new CEP("    91910-530    ").toString());
	}
	@Test
    public void givenAInvalidString_itShouldConvertToZero() {
        assertEquals("00000-000", new CEP("not a number").toString());
    }
	@Test
	public void givenCEPWithoutLine_itShouldConvertToZero(){
		assertEquals("00000-000", new CEP("91910530").toString());
	}
	@Test
    public void givenANullValue_itShouldConvertToZero() {
        assertEquals("00000-000", new CEP(null).toString());
    }
	@Test
    public void itIsInvalidWhenNotACEP() {
        assertFalse(new CEP("not a number").isValid());
    }
	@Test
    public void itIsValidWhenZero() {
        assertTrue(new CEP("00000-000").isValid());
    }
	@Test
    public void validCEPsAreEqualWhenTheyHaveTheSameValue() {
        assertEquals(new CEP("91910-530"), new CEP("91910-530"));
    }
	@Test
    public void invalidCEPs_forDifferentReasons_areEqualNonetheless() {
        assertEquals(new CEP("not a cep"), new CEP(null));
    }
}
