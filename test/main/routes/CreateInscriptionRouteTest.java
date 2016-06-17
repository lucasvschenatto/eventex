package main.routes;

import org.junit.*;

public class CreateInscriptionRouteTest extends RouteTest {
    @Test
    public void integration() throws Exception {
        assertRouteResponse("POST", "/inscriptions", "{}",
                "{" +
        		"\"success\":false," +
        		"\"invalidParticipantId\":true," +
        		"\"invalidActivityId\":true," +
        		"\"invalidCategoryId\":true," +
        		"\"invalidAssociateCode\":false" +
                "}");
    }
}