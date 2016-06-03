package main.routes;

import static org.junit.Assert.*;

import org.junit.Test;

public class CreateActivityRouteTest extends RouteTest {

	@Test
    public void integration() throws Exception {
        assertRouteResponse("POST", "/activities", "{}",
                "{" +
        		"\"invalidSpots\":true," +
        		"\"invalidDuration\":true," +
        		"\"invalidPoints\":true," +
        		"\"invalidGroupDiscount\":false," +
        		"\"invalidVoucher\":false," +
        		"\"success\":false," +
        		"\"invalidName\":true," +
        		"\"invalidDescription\":true," +
        		"\"invalidDate\":true," +
        		"\"invalidTime\":true," +
        		"\"invalidPlace\":true," +
        		"\"invalidStreet\":true," +
        		"\"invalidNumber\":true," +
        		"\"invalidComplement\":true," +
        		"\"invalidNeighborhood\":true," +
        		"\"invalidCity\":true," +
        		"\"invalidState\":true," +
        		"\"invalidCEP\":true" +
                "}");
    }

}
