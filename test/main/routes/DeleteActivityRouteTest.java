package main.routes;

import org.junit.Test;

public class DeleteActivityRouteTest extends RouteTest{
	@Test
    public void integration() throws Exception {
        assertRouteResponse("DELETE", "/activities/id", "null");
    }
}
