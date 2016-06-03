package main.domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class NumericTest {

	@Test
    public void givenAnIntegerAsString_itShouldConvertBackToIt() {
        assertEquals(10, new Numeric("10").toInteger());
    }
	
	@Test
    public void givenAnIntegerAsString_itShouldConvertToSameString() {
		assertEquals("10", new Numeric("10").toString());
	}

    @Test
    public void givenAnInvalidIntegerString_itShouldConvertToZero() {
        assertEquals(0, new Numeric("not a number").toInteger());
    }

    @Test
    public void givenNullValue_itShouldConvertToZero() {
        assertEquals(0, new Numeric(null).toInteger());
    }

    @Test
    public void itIsInvalidWhenNotANumber() {
        assertFalse(new Numeric("not a number").isValid());
    }

    @Test
    public void itIsInvalidWhenNegative() {
        assertFalse(new Numeric("-1").isValid());
    }

    @Test
    public void itIsValidWhenZeroOrGreater() {
        assertTrue(new Numeric("0").isValid());
        assertTrue(new Numeric("1").isValid());
    }

    @Test
    public void validNumbersAreEqualWhenTheyHaveTheSameValue() {
        assertEquals(new Numeric("10"), new Numeric("10"));
    }

    @Test
    public void invalidNumbers_forDifferentReasons_areEqualNonetheless() {
        assertEquals(new Numeric("not a number"), new Numeric(null));
    }

}
