package main.routes;

import org.junit.Ignore;
import org.junit.Test;

public class LoginRouteTest extends RouteTest {
    @Test@Ignore
    public void integration() throws Exception {
        assertRouteResponse("POST", "/login", "{}", "{\"success\":false,\"invalidEmailOrPassword\":true}");
    }
}
