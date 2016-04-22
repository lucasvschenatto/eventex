package eventex;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;

import org.junit.Ignore;
import org.junit.Test;

public class CrudEventTest {

	@Test@Ignore
	public void test() {
		CrudEvent c = new CrudEvent();
		long id = c.create("nomeDoEvento","descricao",null,"local",null);
		Event actual = c.get(id);
		Event expected = new Event("nomeDoEvento","descricao",null,"local",null);
		assertEquals(expected,actual);
	}

}
