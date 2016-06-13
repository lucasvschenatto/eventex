package main.domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class ArbitraryAddressTest {

	@Test
	public void test() {
		assertTrue(new ArbitraryAddress(null).isValid());
	}

}
