package main.routes;

import org.junit.*;

public class CreateProfessionRouteTest extends RouteTest {
    @Test
    public void integration() throws Exception {
        assertRouteResponse("POST", "/professions", "{}",
                "{" +
        		"\"success\":false," +
        		"\"invalidName\":true," +
        		"\"invalidDescription\":true" +
                "}");
    }
}