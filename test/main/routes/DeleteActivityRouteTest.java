package main.routes;

import org.junit.Test;

public class DeleteActivityRouteTest extends RouteTest{
	@Override
	public void responseCodeForNoRequestBody() throws Exception {
		assertRouteResponse("DELETE", "/activities/id", 200);
	}

	@Test
    public void integration() throws Exception {
        assertRouteResponse("DELETE", "/activities/id", "null");
    }
}
