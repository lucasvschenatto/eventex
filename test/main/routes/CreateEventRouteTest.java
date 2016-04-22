package main.routes;

import org.junit.Ignore;
import org.junit.Test;

public class CreateEventRouteTest extends RouteTest {
    @Test@Ignore
    public void integration() throws Exception {
        assertRouteResponse("POST", "/products", "{}",
                "{\"success\":false," +
                        "\"invalidName\":true," +
                        "\"invalidDescription\":true," +
                        "\"invalidPrice\":true," +
                        "\"invalidUnitsInStock\":true}");
    }
}
