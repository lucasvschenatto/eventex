package main.routes;

import org.junit.*;

public class CreateEventRouteTest extends RouteTest {
    @Override
	public void responseCodeForNoRequestBody() throws Exception {
    	assertRouteResponse("POST", "/events",200);
	}

	@Test@Ignore
    public void integration() throws Exception {
        assertRouteResponse("POST", "/events", "{}",
                "{" +
        		"\"success\":false," +
        		"\"invalidName\":true," +
        		"\"invalidDescription\":true," +
        		"\"invalidDate\":true," +
        		"\"invalidTime\":true," +
        		"\"invalidPlace\":true," +
        		"\"address\":" +
        			"{" +
	        		"\"invalidStreet\":true," +
	        		"\"invalidNumber\":true," +
	        		"\"invalidComplement\":true," +
	        		"\"invalidNeighborhood\":true," +
	        		"\"invalidCity\":true," +
	        		"\"invalidState\":true," +
	        		"\"invalidCountry\":true,"+
	        		"\"invalidCEP\":true" +
	        		"}"+
                "}");
    }
}