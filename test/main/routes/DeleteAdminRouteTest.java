package main.routes;

import org.junit.*;

public class DeleteAdminRouteTest extends RouteTest {
    @Override
	public void responseCodeForNoRequestBody() throws Exception {
    	assertRouteResponse("DELETE", "/admins/id", 200);
	}

	@Test
    public void integration() throws Exception {
        assertRouteResponse("DELETE", "/admins/id", "null");
    }
}