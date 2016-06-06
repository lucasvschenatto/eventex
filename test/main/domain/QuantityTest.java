package main.domain;

import static org.junit.Assert.*;
import org.junit.Test;

import main.domain.Quantity;

public class QuantityTest {
    @Test
    public void givenAnIntegerAsString_itShouldConvertBackToIt() {
        assertEquals(10, new Quantity("10").toInt());
    }

    @Test
    public void givenAnIntegerAsString_itShouldConvertToSameString() {
    	assertEquals("10", new Quantity("10").toString());
    }
    
    @Test
    public void givenAnIntegerSurroundedBySpacesAsString_itShouldConvertToSameString() {
    	assertEquals("10", new Quantity("    10    ").toString());
    }

    @Test
    public void givenAnInvalidIntegerString_itShouldConvertToZero() {
        assertEquals(0, new Quantity("not a number").toInt());
    }

    @Test
    public void givenNullValue_itShouldConvertToZero() {
        assertEquals(0, new Quantity(null).toInt());
    }

    @Test
    public void itIsInvalidWhenNotANumber() {
        assertFalse(new Quantity("not a number").isValid());
    }

    @Test
    public void itIsInvalidWhenNegative() {
        assertFalse(new Quantity("-1").isValid());
    }

    @Test
    public void itIsValidWhenZeroOrGreater() {
        assertTrue(new Quantity("0").isValid());
        assertTrue(new Quantity("1").isValid());
    }

    @Test
    public void validNumbersAreEqualWhenTheyHaveTheSameValue() {
        assertEquals(new Quantity("10"), new Quantity("10"));
    }

    @Test
    public void invalidNumbers_forDifferentReasons_areEqualNonetheless() {
        assertEquals(new Quantity("not a number"), new Quantity(null));
    }
}