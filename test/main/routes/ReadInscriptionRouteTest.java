package main.routes;

import org.junit.*;

import main.domain.Text;
import main.domain.inscription.Inscription;
import main.persistence.inmemory.InMemoryFactory;

public class ReadInscriptionRouteTest extends RouteTest {
    @Override
	public void responseCodeForNoRequestBody() throws Exception {
    	assertRouteResponse("GET", "/inscriptions/not_exists",404);
	}

	@Test
    public void integration() throws Exception {
        Inscription inscription = new Inscription();
        inscription.setId("55ec9e9ad8699a069f77a024");
        inscription.setParticipantId(new Text("participant"));
        inscription.setActivityId(new Text("activity"));
        inscription.setCategoryId(new Text("category"));
        inscription.setAssociateCode(new Text("CODE"));
        
        InMemoryFactory.getInstance().getInscriptionRepository().save(inscription);
        
        assertRouteResponse("GET", "/inscriptions/55ec9e9ad8699a069f77a024",
                "{" +
                "\"id\":\"55ec9e9ad8699a069f77a024\"," +
                "\"participantId\":\"participant\"," +
                "\"activityId\":\"activity\"," +
                "\"categoryId\":\"category\"," +
                "\"associateCode\":\"CODE\"" +
                "}");
    }
}