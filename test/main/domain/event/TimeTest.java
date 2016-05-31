package main.domain.event;

import static org.junit.Assert.*;

import org.junit.Test;

import main.domain.event.Time;

public class TimeTest {

	@Test
    public void givenATimeAsString_itShouldConvertBackToIt() {
        assertEquals("12:15:30", new Time("12:15:30").toString());
    }
	@Test
    public void givenATimeAsString_itShouldSeparateHour() {
        assertEquals(12, new Time("12:15:30").getHour());
    }
	@Test
    public void givenATimeAsString_itShouldSeparateMinute() {
        assertEquals(15, new Time("12:15:30").getMinute());
    }
	@Test
    public void givenATimeAsString_itShouldSeparateSecond() {
        assertEquals(30, new Time("12:15:30").getSecond());
    }
	@Test
    public void givenAInvalidString_itShouldConvertToMinimum() {
        assertEquals("00:00", new Time("not a time").toString());
    }
	@Test
    public void givenANullValue_itShouldConvertToMinimum() {
        assertEquals("00:00", new Time(null).toString());
    }
	@Test
    public void itIsInvalidWhenNotATime() {
        assertFalse(new Time("not a number").isValid());
    }
	@Test
    public void itIsValidWhenAMinimumTime() {
        assertTrue(new Time("00:00").isValid());
    }
	@Test
    public void validTimesAreEqualWhenTheyHaveTheSameValue() {
        assertEquals(new Time("13:27"), new Time("13:27"));
    }
	@Test
    public void invalidTimes_forDifferentReasons_areEqualNonetheless() {
        assertEquals(new Time("not a date"), new Time(null));
    }

}
