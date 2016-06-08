package main.routes;

import org.junit.*;

public class CreateParticipantCategoryRouteTest extends RouteTest {
    @Test
    public void integration() throws Exception {
        assertRouteResponse("POST", "/participant_categories", "{}",
                "{" +
        		"\"success\":false," +
        		"\"invalidName\":true," +
        		"\"invalidDescription\":true," +
        		"\"invalidDiscount\":true" +
                "}");
    }
}