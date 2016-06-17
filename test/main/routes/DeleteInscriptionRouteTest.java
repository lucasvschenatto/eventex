package main.routes;

import org.junit.*;

public class DeleteInscriptionRouteTest extends RouteTest {
    @Test
    public void integration() throws Exception {
        assertRouteResponse("DELETE", "/inscriptions/id", "null");
    }
}
