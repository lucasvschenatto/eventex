package main.domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class PhoneTest {

	@Test
	public void givenAPhoneAsString_itShouldConvertBackToIt() {
		assertEquals("(51) 3085-5570", new Phone("(51) 3085-5570").toString());
	}

	@Test
	public void givenAPhoneSurroundedBySpaceAsString_itShouldConvertBackToIt() {
		assertEquals("(51) 3085-5570", new Phone("    (51) 3085-5570    ").toString());
	}

	@Test
	public void givenAText_itShouldConvertToZero() {
		assertEquals("(00) 0000-0000", new Phone("not a phone").toString());
		assertEquals("(00) 0000-0000", new Phone("(51) 3085-5570 not a phone").toString());
		assertEquals("(00) 0000-0000", new Phone("(51)A3085-5570").toString());
		assertEquals("(00) 0000-0000", new Phone("'51' 3085-5570").toString());
	}

	@Test
	public void givenPhoneWithoutMask_itShouldConvertToZero() {
		assertEquals("(00) 0000-0000", new Phone("5130855570").toString());
	}

	@Test
	public void givenNotEnougthNumbers_itShouldConvertToZero() {
		assertEquals("(00) 0000-0000", new Phone("9191").toString());
	}
	
	@Test
	public void givenExceedingNumbers_itShouldConvertToZero() {
		assertEquals("(00) 0000-0000", new Phone("(513) 3085-5570").toString());
		assertEquals("(00) 0000-0000", new Phone("(51) 30858-5570").toString());
		assertEquals("(00) 0000-0000", new Phone("(51) 3085-55709").toString());
	}

	@Test
	public void givenAnEmptyValue_itShouldConvertToZero() {
		assertEquals("(00) 0000-0000", new Phone("").toString());
	}
	
	@Test
	public void givenANullValue_itShouldConvertToZero() {
		assertEquals("(00) 0000-0000", new Phone(null).toString());
	}

	@Test
	public void itIsInvalidWhenNull() {
		assertFalse(new Phone(null).isValid());
	}
	
	@Test
	public void itIsInvalidWhenEmpty() {
		assertFalse(new Phone("").isValid());
	}
	
	@Test
	public void itIsInvalidWhenOnlySpaces() {
		assertFalse(new Phone("      ").isValid());
	}
	
	@Test
	public void itIsInvalidWhenNotAPhone() {
		assertFalse(new Phone("not a number").isValid());
	}

	@Test
	public void itIsInvalidWhenNotEnougthNumbers() {
		assertFalse(new Phone("1").isValid());
		assertFalse(new Phone("123").isValid());
		assertFalse(new Phone("1234-1234").isValid());
		assertFalse(new Phone("92345-1234").isValid());
	}
	
	@Test
	public void itIsInvalidWhenExceedingNumbers() {
		assertFalse(new Phone("(513) 3085-5570").isValid());
		assertFalse(new Phone("(51) 30851-5570").isValid());
		assertFalse(new Phone("(51) 930851-5570").isValid());
		assertFalse(new Phone("(51) 3085-55702").isValid());
		assertFalse(new Phone("(51) 93085-55702").isValid());
	}

	
	@Test
	public void itIsInvalidWithoutMask() {
		assertFalse(new Phone("(51)3085-55702").isValid());
		assertFalse(new Phone("(51) 308555702").isValid());
		assertFalse(new Phone("51 3085-55702").isValid());
		assertFalse(new Phone("51308555702").isValid());
	}
	
	@Test
	public void itIsValidWhenZero() {
		assertTrue(new Phone("(00) 0000-0000").isValid());
	}
	
	@Test
	public void itIsValidWhenPhone() {
		assertTrue(new Phone("(51) 3085-5570").isValid());
	}
	
	@Test
	public void itIsValidWhen9DigitCellphone() {
		assertTrue(new Phone("(11) 9852-5452").isValid());
	}

	@Test
	public void validPhonesAreEqualWhenTheyHaveTheSameValue() {
		assertEquals(new Phone("(51) 3085-5570"), new Phone("(51) 3085-5570"));
		assertEquals(new Phone("(11) 98452-5452"), new Phone("(11) 98452-5452"));
	}

	@Test
	public void invalidPhones_forDifferentReasons_areEqualNonetheless() {
		assertEquals(new Phone("not a phone"), new Phone(null));
	}

}
