package main.routes;

import org.junit.*;

public class DeleteCovenantRouteTest extends RouteTest {
    @Test
    public void integration() throws Exception {
        assertRouteResponse("DELETE", "/covenants/id", "null");
    }
}
