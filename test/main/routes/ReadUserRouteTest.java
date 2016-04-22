package main.routes;

import org.junit.Ignore;
import org.junit.Test;

public class ReadUserRouteTest extends RouteTest {
    @Test@Ignore
    public void integration() throws Exception {
        assertRouteResponse("GET", "/read-user", "{\"success\":false}");
    }
}