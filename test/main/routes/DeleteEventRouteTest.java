package main.routes;

import org.junit.*;

public class DeleteEventRouteTest extends RouteTest {
    @Override
	public void responseCodeForNoRequestBody() throws Exception {
    	assertRouteResponse("DELETE", "/events/id", 200);
	}

	@Test
    public void integration() throws Exception {
        assertRouteResponse("DELETE", "/events/id", "null");
    }
}
