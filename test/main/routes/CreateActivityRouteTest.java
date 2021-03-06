package main.routes;

import org.junit.Ignore;
import org.junit.Test;

public class CreateActivityRouteTest extends RouteTest {
	
	public void responseCodeForNoRequestBody() throws Exception {
        assertRouteResponse("POST", "/activities",200);
    }

	@Test@Ignore
    public void integration() throws Exception {
        assertRouteResponse("POST", "/activities", "{}",
                "{" +
        		"\"invalidEventId\":true," +
        		"\"invalidSpots\":true," +
        		"\"invalidDuration\":true," +
        		"\"invalidPoints\":true," +
        		"\"invalidGroupDiscount\":true," +
        		"\"invalidVoucher\":true," +
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
