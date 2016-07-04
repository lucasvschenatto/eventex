package main.routes;

import org.junit.*;

public class CreateCategoryRouteTest extends RouteTest {
    @Override
	public void responseCodeForNoRequestBody() throws Exception {
    	assertRouteResponse("POST", "/categories", 422);
	}

	@Test@Ignore
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