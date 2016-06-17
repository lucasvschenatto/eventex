package main.routes;

import org.junit.*;

public class CreateCategoryRouteTest extends RouteTest {
    @Test
    public void integration() throws Exception {
        assertRouteResponse("POST", "/categories", "{}",
                "{" +
        		"\"success\":false," +
        		"\"invalidName\":true," +
        		"\"invalidDescription\":true," +
        		"\"invalidDiscount\":true," +
        		"\"invalidNeedCodeAtInscription\":true" +
                "}");
    }
}