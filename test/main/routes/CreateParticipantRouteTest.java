package main.routes;

import org.junit.*;

public class CreateParticipantRouteTest extends RouteTest {
    @Override
	public void responseCodeForNoRequestBody() throws Exception {
    	assertRouteResponse("POST", "/participants",422);
	}

	@Test@Ignore
    public void integration() throws Exception {
        assertRouteResponse("POST", "/participants", "{}",
                "{" +
        		"\"success\":false," +
        		"\"invalidName\":true," +
        		"\"invalidUserId\":true," +
        		"\"invalidNametag\":true," +
        		"\"invalidNationality\":true," +
        		"\"invalidGender\":true," +
        		"\"invalidEducation\":true," +
        		"\"invalidBirth\":true," +
        		"\"homeAddress\":" +
	    			"{" +
	        		"\"invalidStreet\":true," +
	        		"\"invalidNumber\":true," +
	        		"\"invalidComplement\":true," +
	        		"\"invalidNeighborhood\":true," +
	        		"\"invalidCity\":true," +
	        		"\"invalidState\":true," +
	        		"\"invalidCountry\":true,"+
	        		"\"invalidCEP\":true" +
	        		"},"+
        		"\"invalidHomePhone\":true," +
        		"\"invalidCellphone\":true," +
        		"\"invalidProfessionId\":true," +
        		"\"invalidOrganization\":true," +
        		"\"invalidDepartment\":true," +
        		"\"invalidRole\":true," +
        		"\"workAddress\":" +
	    			"{" +
	        		"\"invalidStreet\":true," +
	        		"\"invalidNumber\":true," +
	        		"\"invalidComplement\":true," +
	        		"\"invalidNeighborhood\":true," +
	        		"\"invalidCity\":true," +
	        		"\"invalidState\":true," +
	        		"\"invalidCountry\":true,"+
	        		"\"invalidCEP\":true" +
	        		"},"+
        		"\"invalidWorkPhone\":true," +
        		"\"invalidWorkCellphone\":true," +
        		"\"invalidWorkEmail\":true" +
                "}");
    }
}