package main.routes;

import org.junit.*;

public class DeleteCategoryRouteTest extends RouteTest {
    @Test
    public void integration() throws Exception {
        assertRouteResponse("DELETE", "/categories/id", "null");
    }
}
