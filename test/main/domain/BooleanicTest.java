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
    public void itIsAlwaysValid() {
        assertTrue(new Booleanic("true").isValid());
        assertTrue(new Booleanic("false").isValid());
        assertTrue(new Booleanic("not a boolean").isValid());
        assertTrue(new Booleanic("1").isValid());
        assertTrue(new Booleanic(null).isValid());
    }

    @Test
    public void validBooleansAreEqualWhenTheyHaveTheSameValue() {
        assertEquals(new Booleanic("true"), new Booleanic("true"));
        assertEquals(new Booleanic("false"), new Booleanic("false"));
    }

    @Test
    public void notBooleans_forDifferentReasons_areEqualNonetheless() {
        assertEquals(new Booleanic("not a boolean"), new Booleanic(null));
    }

}
