package main.routes;

import org.junit.*;

public class DeleteAssociateRouteTest extends RouteTest {
    @Override
	public void responseCodeForNoRequestBody() throws Exception {
    	assertRouteResponse("DELETE", "/associates/id", 200);
	}

	@Test
    public void integration() throws Exception {
        assertRouteResponse("DELETE", "/associates/id", "null");
    }
}
