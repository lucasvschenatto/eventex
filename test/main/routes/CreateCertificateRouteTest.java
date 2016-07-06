package main.routes;

import org.junit.*;

public class CreateCertificateRouteTest extends RouteTest {

	@Override
	public void responseCodeForNoRequestBody() throws Exception {
		assertRouteResponse("POST", "/certificates",404);
	}

	@Test@Ignore
    public void integration() throws Exception {		
        assertRouteResponse("POST", "/certificates", "{}",
                "{" +
        		"\"success\":false," +
        		"\"invalidName\":true," +
        		"\"invalidCourse\":true," +
        		"\"invalidHours\":true," +
        		"\"invalidDate\":true," +
        		"\"invalidScore\":true" +
                "}");
    }
}