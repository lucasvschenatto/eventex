package main.routes;

import org.junit.*;

public class LoginRouteTest extends RouteTest {
    @Override
	public void responseCodeForNoRequestBody() throws Exception {
    	assertRouteResponse("POST", "/login",400);
	}

	@Test@Ignore
    public void integration() throws Exception {
        assertRouteResponse("POST", "/login", "{}", "{\"success\":false,\"invalidEmailOrPassword\":true}");
    }
}
