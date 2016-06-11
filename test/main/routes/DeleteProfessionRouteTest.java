package main.routes;

import org.junit.*;

public class DeleteProfessionRouteTest extends RouteTest {
    @Test
    public void integration() throws Exception {
        assertRouteResponse("DELETE", "/professions/id", "null");
    }
}
