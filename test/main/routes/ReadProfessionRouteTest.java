package main.routes;

import org.junit.*;

import main.domain.Text;
import main.domain.profession.Profession;
import main.persistence.inmemory.InMemoryFactory;

public class ReadProfessionRouteTest extends RouteTest {
    @Override
	public void responseCodeForNoRequestBody() throws Exception {
    	assertRouteResponse("GET", "/professions/not_exists",404);
	}

	@Test
    public void integration() throws Exception {
        Profession profession = new Profession();
        profession.setId("55ec9e9ad8699a069f77a024");
        profession.setName(new Text("Name 1"));
        profession.setDescription(new Text("Description 1"));
        
        InMemoryFactory.getInstance().getProfessionRepository().save(profession);
        
        assertRouteResponse("GET", "/professions/55ec9e9ad8699a069f77a024",
                "{" +
                "\"id\":\"55ec9e9ad8699a069f77a024\"," +
                "\"name\":\"Name 1\"," +
                "\"description\":\"Description 1\"" +
                "}");
    }
}