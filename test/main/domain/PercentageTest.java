package main.domain;

import static org.junit.Assert.*;

import org.junit.Test;

import main.domain.Percentage;

public class PercentageTest {

	@Test
    public void givenAnIntegerAsString_itShouldConvertBackToIt() {
        assertEquals(10, new Percentage("10").toInt());
    }

    @Test
    public void givenAnIntegerAsString_itShouldConvertToSameString() {
    	assertEquals("10", new Percentage("10").toString());
    }
    
    @Test
    public void givenAnIntegerSurroundedBySpacesAsString_itShouldConvertToSameString() {
    	assertEquals("10", new Percentage("    10    ").toString());
    }

    @Test
    public void givenAnInvalidIntegerString_itShouldConvertToZero() {
        assertEquals(0, new Percentage("not a number").toInt());
    }

    @Test
    public void givenNullValue_itShouldConvertToZero() {
        assertEquals(0, new Percentage(null).toInt());
    }

    @Test
    public void itIsInvalidWhenNotANumber() {
        assertFalse(new Percentage("not a number").isValid());
    }

    @Test
    public void itIsInvalidWhenNegative() {
        assertFalse(new Percentage("-1").isValid());
    }
    
    @Test
    public void itIsInvalidWhenGreaterThanOneHundred(){
    	assertFalse(new Percentage("101").isValid());
    }

    @Test
    public void itIsValidWhenZeroOrGreater() {
        assertTrue(new Percentage("0").isValid());
        assertTrue(new Percentage("1").isValid());
    }

    @Test
    public void validNumbersAreEqualWhenTheyHaveTheSameValue() {
        assertEquals(new Percentage("10"), new Percentage("10"));
    }

    @Test
    public void invalidNumbers_forDifferentReasons_areEqualNonetheless() {
        assertEquals(new Percentage("not a number"), new Percentage(null));
    }

}
