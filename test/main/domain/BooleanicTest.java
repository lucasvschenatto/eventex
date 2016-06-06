package main.domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class BooleanicTest {

	@Test
    public void givenAnBooleanAsString_itShouldConvertBackToIt() {
        assertEquals(true, new Booleanic("true").toBoolean());
        assertEquals(false, new Booleanic("false").toBoolean());
    }
	
	@Test
	public void givenAnBooleanSurroundedBySpaceAsString_itShouldConvertBackToIt() {
		assertEquals(true,  new Booleanic("    true     ").toBoolean());
		assertEquals(false, new Booleanic("    false    ").toBoolean());
	}
	
	@Test
    public void givenAnBooleanAsString_itShouldConvertToSameString() {
		assertEquals("true", new Booleanic("true").toString());
	}

    @Test
    public void givenAnInvalidString_itShouldConvertToFalse() {
        assertEquals(false, new Booleanic("not a boolean").toBoolean());
    }

    @Test
    public void givenNullValue_itShouldConvertToFalse() {
        assertEquals(false, new Booleanic(null).toBoolean());
    }

    @Test
    public void givennotBoolean_itIsInvalid() {
    	assertFalse(new Booleanic("not a boolean").isValid());
        assertFalse(new Booleanic("1").isValid());
        assertFalse(new Booleanic("").isValid());
        assertFalse(new Booleanic(null).isValid());
    }

    @Test
    public void givenBoolean_itIsValid() {
    	assertTrue(new Booleanic("true").isValid());
    	assertTrue(new Booleanic("false").isValid());;
    }

    @Test
    public void validBooleansAreEqualWhenTheyHaveTheSameValue() {
        assertEquals(new Booleanic("true"), new Booleanic("true"));
        assertEquals(new Booleanic("false"), new Booleanic("false"));
    }

    @Test
    public void invalidBooleans_forDifferentReasons_areEqualNonetheless() {
        assertEquals(new Booleanic("not a boolean"), new Booleanic(null));
    }

}
