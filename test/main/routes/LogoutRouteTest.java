package main.routes;

import org.junit.Ignore;
import org.junit.Test;

public class LogoutRouteTest extends RouteTest {
    @Test@Ignore
    public void integration() throws Exception {
        assertRouteResponse("POST", "/logout", "null");
    }
}