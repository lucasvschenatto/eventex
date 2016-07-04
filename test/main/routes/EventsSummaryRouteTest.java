package main.routes;

import org.junit.*;

import main.domain.Address;
import main.domain.AddressData;
import main.domain.Date;
import main.domain.Text;
import main.domain.Time;
import main.domain.event.Event;
import main.persistence.inmemory.InMemoryFactory;

public class EventsSummaryRouteTest extends RouteTest {
    @Override
	public void responseCodeForNoRequestBody() throws Exception {
    	assertRouteResponse("GET", "/events",200);
	}

	@Test
    public void integration() throws Exception {
        Event event = new Event();
        event.setId("55ec9e9ad8699a069f77a024");
        event.setName(new Text("Name 1"));
        event.setDescription(new Text("Description 1"));
        event.setDate(new Date("1900-01-01"));
        event.setTime(new Time("06:59:59"));
        event.setPlace(new Text("place"));
        event.setAddress(new Address(makeAddressData()));
        
        InMemoryFactory.getInstance().getEventRepository().save(event);
        
        assertRouteResponse("GET", "/events",
                "[{" +
                "\"id\":\"55ec9e9ad8699a069f77a024\"," +
                "\"name\":\"Name 1\"," +
                "\"description\":\"Description 1\"," +
                "\"date\":\"1900-01-01\"," +
                "\"time\":\"06:59:59\"," +
                "\"place\":\"place\"," +
                "\"address\":" +
	    			"{" +
	                "\"street\":\"street\"," +
	                "\"number\":1," +
	                "\"complement\":\"complement\"," +
	                "\"neighborhood\":\"neighborhood\"," +
	                "\"city\":\"city\"," +
	                "\"state\":\"state\"," +
	                "\"country\":\"country\","+
	                "\"cep\":\"11111-111\"" +
	                "}"+
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