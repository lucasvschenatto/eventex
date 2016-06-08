package main.domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class NumericTest {

	@Test
    public void givenAnIntegerAsString_itShouldConvertBackToIt() {
        assertEquals(10, new IntNumber("10").toInt());
    }
	
	@Test
    public void givenAnIntegerAsString_itShouldConvertToSameString() {
		assertEquals("10", new IntNumber("10").toString());
	}

	@Test
	public void givenAnIntegerSurroundedBySpacesAsString_itShouldConvertToSameString() {
		assertEquals("10", new IntNumber("    10    ").toString());
	}

    @Test
    public void givenAnInvalidIntegerString_itShouldConvertToZero() {
        assertEquals(0, new IntNumber("not a number").toInt());
    }

    @Test
    public void givenNullValue_itShouldConvertToZero() {
        assertEquals(0, new IntNumber(null).toInt());
    }

    @Test
    public void itIsInvalidWhenNotANumber() {
        assertFalse(new IntNumber("not a number").isValid());
    }

    @Test
    public void itIsInvalidWhenNegative() {
        assertFalse(new IntNumber("-1").isValid());
    }

    @Test
    public void itIsValidWhenZeroOrGreater() {
        assertTrue(new IntNumber("0").isValid());
        assertTrue(new IntNumber("1").isValid());
    }

    @Test
    public void validNumbersAreEqualWhenTheyHaveTheSameValue() {
        assertEquals(new IntNumber("10"), new IntNumber("10"));
    }

    @Test
    public void invalidNumbers_forDifferentReasons_areEqualNonetheless() {
        assertEquals(new IntNumber("not a number"), new IntNumber(null));
    }

}
