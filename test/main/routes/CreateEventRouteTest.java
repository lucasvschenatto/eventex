package main.routes;

import org.junit.*;

public class CreateEventRouteTest extends RouteTest {
    @Test
    public void integration() throws Exception {
        assertRouteResponse("POST", "/events", "{}",
                "{" +
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