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
	public void givenAText_itShouldConvertToZero() {
		assertEquals("00000-000", new CEP("not a number").toString());
		assertEquals("00000-000", new CEP("11111-111 not a number").toString());
		assertEquals("00000-000", new CEP("1111A-111").toString());
		assertEquals("00000-000", new CEP("11111A111").toString());
	}

	@Test
	public void givenCEPWithoutLine_itShouldConvertToZero() {
		assertEquals("00000-000", new CEP("91910530").toString());
	}

	@Test
	public void givenNotEnougthNumbers_itShouldConvertToZero() {
		assertEquals("00000-000", new CEP("9191").toString());
	}
	
	@Test
	public void givenExceedingNumbers_itShouldConvertToZero() {
		assertEquals("00000-000", new CEP("12345-1234").toString());
		assertEquals("00000-000", new CEP("123456-123").toString());
		assertEquals("00000-000", new CEP("123456789").toString());
		assertEquals("00000-000", new CEP("1234567890123").toString());
	}

	@Test
	public void givenAnEmptyValue_itShouldConvertToZero() {
		assertEquals("00000-000", new CEP("").toString());
	}
	
	@Test
	public void givenANullValue_itShouldConvertToZero() {
		assertEquals("00000-000", new CEP(null).toString());
	}

	@Test
	public void itIsInvalidWhenNull() {
		assertFalse(new CEP("").isValid());
	}
	
	@Test
	public void itIsInvalidWhenEmpty() {
		assertFalse(new CEP("").isValid());
	}
	
	@Test
	public void itIsInvalidWhenOnlySpaces() {
		assertFalse(new CEP("      ").isValid());
	}
	
	@Test
	public void itIsInvalidWhenNotACEP() {
		assertFalse(new CEP("not a number").isValid());
	}

	@Test
	public void itIsInvalidWhenNotEnougthNumbers() {
		assertFalse(new CEP("1").isValid());
		assertFalse(new CEP("123").isValid());
		assertFalse(new CEP("123-123").isValid());
		assertFalse(new CEP("12345-12").isValid());
	}
	
	@Test
	public void itIsInvalidWhenExceedingNumbers() {
		assertFalse(new CEP("12345-1234").isValid());
		assertFalse(new CEP("123456789").isValid());
		assertFalse(new CEP("123456-123").isValid());
	}
	
	@Test
	public void itIsValidWhenZero() {
		assertTrue(new CEP("00000-000").isValid());
		assertTrue(new CEP("00000000").isValid());
	}
	
	@Test
	public void itIsValidWhenCEP() {
		assertTrue(new CEP("12345-123").isValid());
		assertTrue(new CEP("12345678").isValid());
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
