package main.routes;

import org.junit.Test;

import main.domain.Address;
import main.domain.AddressData;
import main.domain.Booleanic;
import main.domain.Date;
import main.domain.Quantity;
import main.domain.Text;
import main.domain.Time;
import main.domain.activity.Activity;
import main.domain.activity.Minutes;
import main.domain.event.Event;
import main.persistence.inmemory.InMemoryFactory;

public class ActivitiesSummaryRouteTest extends RouteTest {
    @Override
	public void responseCodeForNoRequestBody() throws Exception {
    	assertRouteResponse("GET", "/activities",200);
	}

	@Test
    public void integration() throws Exception {
    	Event event = new Event();
        event.setId("aeuou13542xxx9testk9");
        event.setName(new Text("Name 1"));
        event.setDescription(new Text("Description 1"));
        event.setDate(new Date("1900-01-01"));
        event.setTime(new Time("06:59:59"));
        event.setPlace(new Text("place"));
        event.setAddress(new Address(makeAddressData()));
    	
        Activity activity = new Activity();
        activity.setEventId(new Text("aeuou13542xxx9testk9"));
        activity.setGroupDiscount(new Booleanic("true"));
        activity.setVoucher(new Booleanic("false"));
        activity.setSpots(new Quantity("500"));
        activity.setDuration(new Minutes("90"));
        activity.setPoints(new Quantity("100"));
        activity.setId("55ec9e9ad8699a069f77a024");
        activity.setName(new Text("Name 1"));
        activity.setDescription(new Text("Description 1"));
        activity.setDate(new Date("1900-01-01"));
        activity.setTime(new Time("06:59:59"));
        activity.setPlace(new Text("place"));
        activity.setAddress(new Address(makeAddressData()));
        
        InMemoryFactory.getInstance().getActivityRepository().save(activity);
        InMemoryFactory.getInstance().getEventRepository().save(event);
        
        assertRouteResponse("GET", "/activities",
                "[{" +
                "\"eventId\":\"aeuou13542xxx9testk9\"," +
        		"\"spots\":500," +
        		"\"duration\":90," +
        		"\"points\":100," +
        		"\"groupDiscount\":true," +
        		"\"voucher\":false," +
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
