package main.routes;

import org.junit.*;

public class DeleteParticipantRouteTest extends RouteTest {
    @Test
    public void integration() throws Exception {
        assertRouteResponse("DELETE", "/participants/id", "null");
    }
}