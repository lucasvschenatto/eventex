package main.routes;

import org.junit.*;

public class DeleteInscriptionRouteTest extends RouteTest {
    @Override
	public void responseCodeForNoRequestBody() throws Exception {
    	assertRouteResponse("DELETE", "/inscriptions/id",200);
	}

	@Test
    public void integration() throws Exception {
        assertRouteResponse("DELETE", "/inscriptions/id", "null");
    }
}
