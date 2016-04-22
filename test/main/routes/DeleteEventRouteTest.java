package main.routes;

import org.junit.Ignore;
import org.junit.Test;

public class DeleteEventRouteTest extends RouteTest {
    @Test@Ignore
    public void integration() throws Exception {
        assertRouteResponse("DELETE", "/products/id", "null");
    }
}
