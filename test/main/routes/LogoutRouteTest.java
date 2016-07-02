package main.routes;

import org.junit.*;

public class LogoutRouteTest extends RouteTest {
	@Override
	public void responseCodeForNoRequestBody() throws Exception {
		assertRouteResponse("POST", "/logout", 200);
	}
	
	@Test
    public void integration() throws Exception {
        assertRouteResponse("POST", "/logout", "null");
    }
}