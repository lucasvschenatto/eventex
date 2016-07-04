package main.routes;

import org.junit.*;

public class CreateAdminRouteTest extends RouteTest {
    @Override
	public void responseCodeForNoRequestBody() throws Exception {
    	assertRouteResponse("POST", "/admins",200);
	}

	@Test@Ignore
    public void integration() throws Exception {
        assertRouteResponse("POST", "/admins", "{}",
                "{" +
        		"\"success\":false," +
        		"\"invalidName\":true," +
        		"\"invalidUserId\":true," +
        		"\"invalidRole\":true" +
                "}");
    }
}