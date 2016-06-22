package main.routes;

import org.junit.*;

public class CreateCertificateRouteTest extends RouteTest {

	@Test
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