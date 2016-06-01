package main.routes;

import org.junit.*;

public class LogoutRouteTest extends RouteTest {
    @Test
    public void integration() throws Exception {
        assertRouteResponse("POST", "/logout", "null");
    }
}