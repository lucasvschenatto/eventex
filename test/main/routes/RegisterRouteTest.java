package main.routes;

import org.junit.*;

public class RegisterRouteTest extends RouteTest {
    @Override
	public void responseCodeForNoRequestBody() throws Exception {
    	assertRouteResponse("POST", "/register",200);
	}

	@Test@Ignore
    public void integration() throws Exception {
        assertRouteResponse("POST", "/register", "{}",
                "{\"success\":false," +
                        "\"invalidUsername\":true," +
                        "\"invalidCPF\":true," +
                        "\"invalidEmail\":true," +
                        "\"invalidPassword\":true," +
                        "\"invalidPasswordConfirmation\":false}");
    }
}