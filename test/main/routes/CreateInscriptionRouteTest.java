package main.routes;

import org.junit.*;

public class CreateInscriptionRouteTest extends RouteTest {
    @Override
	public void responseCodeForNoRequestBody() throws Exception {
    	assertRouteResponse("POST", "/inscriptions",422);
	}

	@Test@Ignore
    public void integration() throws Exception {
        assertRouteResponse("POST", "/inscriptions", "{}",
                "{" +
        		"\"success\":false," +
        		"\"invalidParticipantId\":true," +
        		"\"invalidActivityId\":true," +
        		"\"invalidCategoryId\":true," +
        		"\"invalidAssociateCode\":false" +
                "}");
    }
}