package main.routes;

import org.junit.*;

public class CreateAssociateRouteTest extends RouteTest {
    @Override
	public void responseCodeForNoRequestBody() throws Exception {
    	assertRouteResponse("POST", "/associates",200);
	}

	@Test@Ignore
    public void integration() throws Exception {
        assertRouteResponse("POST", "/associates", "{}",
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