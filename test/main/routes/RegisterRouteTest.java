package main.routes;

import org.junit.*;

public class RegisterRouteTest extends RouteTest {
    @Test
    public void integration() throws Exception {
        assertRouteResponse("POST", "/register", "{}",
                "{\"success\":false," +
                        "\"invalidEmail\":true," +
                        "\"invalidPassword\":true," +
                        "\"invalidPasswordConfirmation\":false}");
    }
}