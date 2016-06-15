package main.routes;

//import com.mongodb.MongoClient;
//import com.mongodb.MongoClientURI;
//import com.mongodb.client.MongoDatabase;

//import main.persistence.mongo.MongoProductRepository;
import org.junit.*;

import main.domain.Address;
import main.domain.AddressData;
import main.domain.Date;
import main.domain.Email;
import main.domain.Phone;
import main.domain.Text;
import main.domain.participant.Participant;
import main.persistence.inmemory.InMemoryRepositoryFactory;

public class ParticipantsSummaryRouteTest extends RouteTest {
    @Test
    public void integration() throws Exception {
        Participant participant = new Participant();
        participant.setId("55ec9e9ad8699a069f77a024");
        participant.setName(new Text("Name"));
        participant.setUserId(new Text("userid"));
        participant.setNametag(new Text("nametag"));
        participant.setNationality(new Text("nationality"));
        participant.setGender(new Text("gender"));
        participant.setEducation(new Text("education"));
        participant.setBirth(new Date("2000-01-30"));
        participant.setHomeAddress(new Address(makeAddressData()));
        participant.setHomePhone(new Phone("(11) 1111-1111"));
        participant.setCellphone(new Phone("(11) 1111-1111"));
        participant.setProfessionId(new Text("professionId"));
        participant.setOrganization(new Text("organization"));
        participant.setDepartment(new Text("department"));
        participant.setRole(new Text("role"));
        participant.setWorkAddress(new Address(makeAddressData()));
        participant.setWorkPhone(new Phone("(11) 1111-1111"));
        participant.setWorkCellphone(new Phone("(11) 1111-1111"));
        participant.setWorkEmail(new Email("name@domain.com"));
        
        InMemoryRepositoryFactory.getParticipantRepository().save(participant);
        
        assertRouteResponse("GET", "/participants",
                "[{" +
                "\"id\":\"55ec9e9ad8699a069f77a024\"," +
                "\"name\":\"Name\"," +
                "\"userId\":\"userid\"," +
                "\"nametag\":\"nametag\"," +
                "\"nationality\":\"nationality\"," +
                "\"gender\":\"gender\"," +
                "\"education\":\"education\"," +
                "\"birth\":\"2000-01-30\"," +
                "\"homeAddress\":" +
	                "{" +
	                "\"street\":\"street\"," +
	                "\"number\":1," +
	                "\"complement\":\"complement\"," +
	                "\"neighborhood\":\"neighborhood\"," +
	                "\"city\":\"city\"," +
	                "\"state\":\"state\"," +
	                "\"country\":\"country\","+
	                "\"cep\":\"11111-111\"" +
	                "},"+
                "\"homePhone\":\"(11) 1111-1111\"," +
                "\"cellphone\":\"(11) 1111-1111\"," +
                "\"professionId\":\"professionId\"," +
                "\"organization\":\"organization\"," +
                "\"department\":\"department\"," +
                "\"role\":\"role\"," +
                "\"workAddress\":" +
	                "{" +
	                "\"street\":\"street\"," +
	                "\"number\":1," +
	                "\"complement\":\"complement\"," +
	                "\"neighborhood\":\"neighborhood\"," +
	                "\"city\":\"city\"," +
	                "\"state\":\"state\"," +
	                "\"country\":\"country\","+
	                "\"cep\":\"11111-111\"" +
	                "},"+
                "\"workPhone\":\"(11) 1111-1111\"," +
                "\"workCellphone\":\"(11) 1111-1111\"," +
                "\"workEmail\":\"name@domain.com\"" +
                "}]");
    }
    
    private AddressData makeAddressData(){
    	AddressData address = new AddressData();
    	address.street = "street";
    	address.number = "1";
    	address.complement = "complement";
    	address.neighborhood = "neighborhood";
    	address.city = "city";
    	address.state = "state";
    	address.country = "country";
    	address.cep = "11111-111";
    	return address;
    }
    
}