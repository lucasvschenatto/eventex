package main.routes;

import org.junit.*;

public class ReadUserRouteTest extends RouteTest {
    @Override
	public void responseCodeForNoRequestBody() throws Exception {
    	assertRouteResponse("GET", "/read-user",404);
	}

	@Test@Ignore
    public void integration() throws Exception {
        assertRouteResponse("GET", "/read-user", "{\"success\":false}");
    }
}