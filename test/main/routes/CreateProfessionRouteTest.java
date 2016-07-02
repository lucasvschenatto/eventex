package main.routes;

import org.junit.*;

public class CreateProfessionRouteTest extends RouteTest {
    @Override
	public void responseCodeForNoRequestBody() throws Exception {
    	assertRouteResponse("POST", "/professions",422);
	}

	@Test@Ignore
    public void integration() throws Exception {
        assertRouteResponse("POST", "/professions", "{}",
                "{" +
        		"\"success\":false," +
        		"\"invalidName\":true," +
        		"\"invalidDescription\":true" +
                "}");
    }
}