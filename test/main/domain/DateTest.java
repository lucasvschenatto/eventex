package main.domain;

import static org.junit.Assert.*;

import org.junit.Test;

import main.domain.Date;

public class DateTest {

	@Test
    public void givenADateAsString_itShouldConvertBackToIt() {
        assertEquals("2014-12-31", new Date("2014-12-31").toString());
    }
	@Test
    public void givenADateAsString_itShouldSeparateYear() {
        assertEquals(2014, new Date("2014-12-31").getYear());
    }
	@Test
    public void givenADateAsString_itShouldSeparateMonth() {
        assertEquals(12, new Date("2014-12-31").getMonth());
    }
	@Test
    public void givenADateAsString_itShouldSeparateDay() {
        assertEquals(31, new Date("2014-12-31").getDay());
    }
	@Test
    public void givenAInvalidString_itShouldConvertToMinimum() {
        assertEquals("-999999999-01-01", new Date("not a date").toString());
    }
	@Test
    public void givenANullValue_itShouldConvertToMinimum() {
        assertEquals("-999999999-01-01", new Date(null).toString());
    }
	@Test
    public void itIsInvalidWhenNotADate() {
        assertFalse(new Date("not a number").isValid());
    }
	@Test
    public void itIsValidWhenAMinimumDate() {
        assertTrue(new Date("-999999999-01-01").isValid());
    }
	@Test
    public void validDatesAreEqualWhenTheyHaveTheSameValue() {
        assertEquals(new Date("2013-07-25"), new Date("2013-07-25"));
    }
	@Test
    public void invalidDates_forDifferentReasons_areEqualNonetheless() {
        assertEquals(new Date("not a date"), new Date(null));
    }	
}
