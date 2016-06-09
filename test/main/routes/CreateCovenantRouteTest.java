package main.routes;

import org.junit.*;

public class CreateCovenantRouteTest extends RouteTest {
    @Test
    public void integration() throws Exception {
        assertRouteResponse("POST", "/covenants", "{}",
                "{" +
        		"\"success\":false," +
        		"\"invalidCategoryId\":true," +
        		"\"invalidCode\":true," +
        		"\"invalidName\":true," +
        		"\"invalidUpdateDate\":true," +
        		"\"invalidActive\":true" +
                "}");
    }
}