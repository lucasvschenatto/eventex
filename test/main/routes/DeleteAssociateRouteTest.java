package main.routes;

import org.junit.*;

public class DeleteAssociateRouteTest extends RouteTest {
    @Test
    public void integration() throws Exception {
        assertRouteResponse("DELETE", "/associates/id", "null");
    }
}
