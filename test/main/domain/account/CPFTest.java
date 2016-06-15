package main.domain.account;

import static org.junit.Assert.*;
import org.junit.Test;

public class CPFTest {

	@Test
	public void givenACPFAsString_itShouldConvertBackToIt() {
		assertEquals("123456789-09", new CPF("123456789-09").toString());
	}

	@Test
	public void givenACPFSurroundedBySpaceAsString_itShouldConvertBackToIt() {
		assertEquals("123456789-09", new CPF("    123456789-09    ").toString());
	}

	@Test
	public void givenAText_itShouldConvertToZero() {
		assertEquals("000000000-00", new CPF("not a number").toString());
		assertEquals("000000000-00", new CPF("123456789-09 not a number").toString());
		assertEquals("000000000-00", new CPF("123456789A-09").toString());
		assertEquals("000000000-00", new CPF("123456789A09").toString());
	}

	@Test
	public void givenCPFWithoutLine_itShouldConvertToZero() {
		assertEquals("000000000-00", new CPF("12345678909").toString());
	}

	@Test
	public void givenNotEnougthNumbers_itShouldConvertToZero() {
		assertEquals("000000000-00", new CPF("12345").toString());
	}
	
	@Test
	public void givenExceedingNumbers_itShouldConvertToZero() {
		assertEquals("000000000-00", new CPF("123456789-091").toString());
		assertEquals("000000000-00", new CPF("1234567890-09").toString());
		assertEquals("000000000-00", new CPF("123456789009").toString());
		assertEquals("000000000-00", new CPF("1234567890123").toString());
	}

	@Test
	public void givenAnEmptyValue_itShouldConvertToZero() {
		assertEquals("000000000-00", new CPF("").toString());
	}
	
	@Test
	public void givenANullValue_itShouldConvertToZero() {
		assertEquals("000000000-00", new CPF(null).toString());
	}
	
	@Test
	public void givenCorrectVerifyingDigits_itIsValid() {
		assertTrue(new CPF("123456789-09").isValid());
		assertTrue(new CPF("000000001-91").isValid());
		assertTrue(new CPF("000000020-54").isValid());
		assertTrue(new CPF("123123123-87").isValid());
		assertTrue(new CPF("987654321-00").isValid());
		assertTrue(new CPF("135792468-28").isValid());
		assertTrue(new CPF("100000000-19").isValid());
	}
	
	@Test
	public void givenAllSameDigit_itIsInvalid() {
		assertFalse(new CPF("000000000-00").isValid());
		assertFalse(new CPF("111111111-11").isValid());
		assertFalse(new CPF("222222222-22").isValid());
		assertFalse(new CPF("333333333-33").isValid());
		assertFalse(new CPF("444444444-44").isValid());
		assertFalse(new CPF("555555555-55").isValid());
		assertFalse(new CPF("666666666-66").isValid());
		assertFalse(new CPF("777777777-77").isValid());
		assertFalse(new CPF("888888888-88").isValid());
		assertFalse(new CPF("999999999-99").isValid());
	}
	
	@Test
	public void givenWrongVerifyingDigit_itIsInvalid(){
		assertFalse(new CPF("123456789-00").isValid());
	}

	@Test
	public void itIsInvalidWhenNull() {
		assertFalse(new CPF(null).isValid());
	}
	
	@Test
	public void itIsInvalidWhenEmpty() {
		assertFalse(new CPF("").isValid());
	}
	
	@Test
	public void itIsInvalidWhenOnlySpaces() {
		assertFalse(new CPF("      ").isValid());
	}
	
	@Test
	public void itIsInvalidWhenNotACPF() {
		assertFalse(new CPF("not a number").isValid());
	}

	@Test
	public void itIsInvalidWhenNotEnougthNumbers() {
		assertFalse(new CPF("1").isValid());
		assertFalse(new CPF("123").isValid());
		assertFalse(new CPF("12345678-09").isValid());
		assertFalse(new CPF("123456789-0").isValid());
	}
	
	@Test
	public void itIsInvalidWhenExceedingNumbers() {
		assertFalse(new CPF("123456789-091").isValid());
		assertFalse(new CPF("123456789012").isValid());
		assertFalse(new CPF("1234567890-09").isValid());
	}
	
	@Test
	public void itIsInvalidWhenMinusInWrongPlace() {
		assertFalse(new CPF("-12345678909").isValid());
		assertFalse(new CPF("1-2345678909").isValid());
		assertFalse(new CPF("12-345678909").isValid());
		assertFalse(new CPF("123-45678909").isValid());
		assertFalse(new CPF("1234-5678909").isValid());
		assertFalse(new CPF("12345-678909").isValid());
		assertFalse(new CPF("123456-78909").isValid());
		assertFalse(new CPF("1234567-8909").isValid());
		assertFalse(new CPF("12345678-909").isValid());
		assertFalse(new CPF("1234567890-9").isValid());
		assertFalse(new CPF("12345678909-").isValid());
	}
	
	@Test
	public void itIsInvalidWithoutMinus() {
		assertFalse(new CPF("12345678909").isValid());
		assertFalse(new CPF("123456789 09").isValid());
		assertFalse(new CPF("123456789A09").isValid());
		assertFalse(new CPF("123456789^09").isValid());
	}

	@Test
	public void validCPFsAreEqualWhenTheyHaveTheSameValue() {
		assertEquals(new CPF("123456789-09"), new CPF("123456789-09"));
	}

	@Test
	public void invalidCPFs_forDifferentReasons_areEqualNonetheless() {
		assertEquals(new CPF("not a cpf"), new CPF(null));
	}

}
