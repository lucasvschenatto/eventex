package main.routes;

import org.junit.*;

public class DeleteParticipantRouteTest extends RouteTest {
    @Override
	public void responseCodeForNoRequestBody() throws Exception {
    	assertRouteResponse("DELETE", "/participants/id", 200);
	}

	@Test
    public void integration() throws Exception {
        assertRouteResponse("DELETE", "/participants/id", "null");
    }
}