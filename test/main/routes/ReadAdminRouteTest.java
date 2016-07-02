package main.routes;

import org.junit.*;

import main.domain.Text;
import main.domain.admin.Admin;
import main.persistence.inmemory.InMemoryFactory;

public class ReadAdminRouteTest extends RouteTest {
    @Override
	public void responseCodeForNoRequestBody() throws Exception {
    	assertRouteResponse("GET", "/admins/not_exists",404);
	}

	@Test@Ignore
    public void integration() throws Exception {
        Admin admin = new Admin();
        admin.setId("55ec9e9ad8699a069f77a024");
        admin.setName(new Text("Name"));
        admin.setUserId(new Text("userid"));
        admin.setRole(new Text("role"));
        
        InMemoryFactory.getInstance().getAdminRepository().save(admin);
        
        assertRouteResponse("GET", "/admins/55ec9e9ad8699a069f77a024",
                "{" +
                "\"id\":\"55ec9e9ad8699a069f77a024\"," +
                "\"name\":\"Name\"," +
                "\"userId\":\"userid\"," +
                "\"role\":\"role\""+
                "}");
    }
}