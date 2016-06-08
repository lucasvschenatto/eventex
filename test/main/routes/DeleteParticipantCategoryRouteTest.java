package main.routes;

import org.junit.*;

public class DeleteParticipantCategoryRouteTest extends RouteTest {
    @Test
    public void integration() throws Exception {
        assertRouteResponse("DELETE", "/participant_categories/id", "null");
    }
}
