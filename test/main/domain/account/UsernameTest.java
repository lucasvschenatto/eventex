package main.domain.account;

import static org.junit.Assert.*;

import org.junit.Test;

public class UsernameTest {
	
	private Username makeUsername(String value) {
		return new Username(value);
	}

	@Test
	public void givenNullValue_printsEmptyString() {
		Username username = makeUsername(null);
		assertEquals("",username.toString());
	}
	
	@Test
    public void givenNullValue_equalsAnotherWithEmptyValue() {
		Username nullUsername = makeUsername(null);
		Username emptyUsername = makeUsername("");
		assertEquals(emptyUsername,nullUsername);
	}
	
	@Test
    public void givenUsernameSurroundedBySpaces_itIgnoresTheSpaces() {
		Username username = makeUsername("      validusername      ");
		assertEquals("validusername",username.toString());
	}
	
	@Test
    public void givenUsernameSurroundedBySpaces_itShouldEqualAnotherWithoutTheSpaces() {
		Username trimmed = makeUsername("      validusername      ");
		Username username = makeUsername("validusername");
		assertEquals(trimmed,username);
	}
	@Test
	public void givenUppercaseUsername_itShouldEqualSameLowercase() {
		Username upper = makeUsername("VALIDUSERNAME");
		Username lower = makeUsername("validusername");
		assertEquals(upper,lower);
	}
	
	@Test
	public void givenCorrectUsername_itPrintsItAsIs() {
		Username username = makeUsername("validusername");
		assertEquals("validusername",username.toString());
	}
	
	@Test
    public void givenUppercaseUsername_itPrintsAsLowercase() {
		assertEquals("validusername",makeUsername("VALIDUSERNAME").toString());
		assertEquals("validusername",makeUsername("ValidUsername").toString());
	}
	
	@Test
    public void anyDifferenceInValue_andItWillNotEqualTheOther() {
		Username first = makeUsername("validusername1");
		Username second = makeUsername("validusername2");
		assertNotEquals(first,second);
	}
	
	@Test
	public void givenCorrectUsername_itIsValid(){
		assertTrue( makeUsername("validusername").isValid());
		assertTrue( makeUsername("moreThanFiveCharacters").isValid());
		assertTrue( makeUsername("lessThanThirtyOneCharacters").isValid());
		assertTrue( makeUsername("123numbers987").isValid());
		assertTrue( makeUsername("dot.is.valid").isValid());
		assertTrue( makeUsername("valid.2.username345").isValid());
	}
	
	@Test
	public void givenIncorrectSize_itIsInalid(){
		assertFalse( makeUsername("12345").isValid());
		assertFalse( makeUsername("moreThanThirty56789012345678901").isValid());
	}
	
	@Test
	public void givenLessThanSixAlphanumeric_itIsInvalid(){
		assertFalse( makeUsername("abc.de").isValid());
		assertFalse( makeUsername("1.2345").isValid());
	}
	
	@Test
	public void givenSpaceInTheMiddle_itIsInalid(){
		assertFalse( makeUsername("space in the middle").isValid());
	}
	
	@Test
	public void givenFirstOrLastChar_notLetterNorNumber_itIsInalid(){
		assertFalse( makeUsername("lastChar123.").isValid());
		assertFalse( makeUsername(".firstChar123").isValid());
	}
	
	@Test
	public void givenNotAllowedChar_itIsInvalid(){
		assertFalse( makeUsername("aaaaaa,a").isValid());
		assertFalse( makeUsername("aaaaaa<a").isValid());
		assertFalse( makeUsername("aaaaaa>a").isValid());
		assertFalse( makeUsername("aaaaaa;a").isValid());
		assertFalse( makeUsername("aaaaaa:a").isValid());
		assertFalse( makeUsername("aaaaaa?a").isValid());
		assertFalse( makeUsername("aaaaaa/a").isValid());
		assertFalse( makeUsername("aaaaaa°a").isValid());
		assertFalse( makeUsername("aaaaaa^a").isValid());
		assertFalse( makeUsername("aaaaaa~a").isValid());
		assertFalse( makeUsername("aaaaaa]a").isValid());
		assertFalse( makeUsername("aaaaaa}a").isValid());
		assertFalse( makeUsername("aaaaaaºa").isValid());
		assertFalse( makeUsername("aaaaaaªa").isValid());
		assertFalse( makeUsername("aaaaaa[a").isValid());
		assertFalse( makeUsername("aaaaaa{a").isValid());
		assertFalse( makeUsername("aaaaaa=a").isValid());
		assertFalse( makeUsername("aaaaaa+a").isValid());
		assertFalse( makeUsername("aaaaaa§a").isValid());
		assertFalse( makeUsername("aaaaaa-a").isValid());
		assertFalse( makeUsername("aaaaaa_a").isValid());
		assertFalse( makeUsername("aaaaaa)a").isValid());
		assertFalse( makeUsername("aaaaaa(a").isValid());
		assertFalse( makeUsername("aaaaaa*a").isValid());
		assertFalse( makeUsername("aaaaaa&a").isValid());
		assertFalse( makeUsername("aaaaaa¨a").isValid());
		assertFalse( makeUsername("aaaaaa¬a").isValid());
		assertFalse( makeUsername("aaaaaa%a").isValid());
		assertFalse( makeUsername("aaaaaa¢a").isValid());
		assertFalse( makeUsername("aaaaaa$a").isValid());
		assertFalse( makeUsername("aaaaaa£a").isValid());
		assertFalse( makeUsername("aaaaaa#a").isValid());
		assertFalse( makeUsername("aaaaaa³a").isValid());
		assertFalse( makeUsername("aaaaaa@a").isValid());
		assertFalse( makeUsername("aaaaaa²a").isValid());
		assertFalse( makeUsername("aaaaaa!a").isValid());
		assertFalse( makeUsername("aaaaaa¹a").isValid());
		assertFalse( makeUsername("aaaaaa\"a").isValid());
		assertFalse( makeUsername("aaaaaa'a").isValid());
		assertFalse( makeUsername("aaaaaa|a").isValid());
		assertFalse( makeUsername("aaaaaa\\a").isValid());
	}

}
