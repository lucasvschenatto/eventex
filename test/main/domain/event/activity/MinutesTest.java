package main.domain.event.activity;

import static org.junit.Assert.*;

import org.junit.Test;

public class MinutesTest {

	@Test
    public void givenAnDurationAsString_itShouldConvertBackToIt() {
        assertEquals(10, new Minutes("10").toInteger());
    }
	@Test
    public void givenAnInvalidIntegerString_itShouldConvertToZero() {
        assertEquals(0, new Minutes("not a number").toInteger());
    }
	@Test
    public void givenANullValue_itShouldConvertToZero() {
        assertEquals(0, new Minutes(null).toInteger());
    }
	@Test
    public void itIsInvalidWhenNotANumber() {
        assertFalse(new Minutes("not a number").isValid());
    }
	@Test
    public void itIsInvalidWhenNegative() {
        assertFalse(new Minutes("-1").isValid());
    }
	@Test
    public void itIsValidWhenZeroOrGreater() {
        assertTrue(new Minutes("0").isValid());
        assertTrue(new Minutes("1").isValid());
    }
	@Test
    public void validNumbersAreEqualWhenTheyHaveTheSameValue() {
        assertEquals(new Minutes("10"), new Minutes("10"));
    }
	@Test
    public void invalidNumbers_forDifferentReasons_areEqualNonetheless() {
        assertEquals(new Minutes("not a number"), new Minutes(null));
    }
}
