package main.routes;

import org.junit.Test;

import main.domain.CEP;
import main.domain.Date;
import main.domain.Numeric;
import main.domain.Quantity;
import main.domain.Text;
import main.domain.Time;
import main.domain.activity.Activity;
import main.domain.activity.Minutes;
import main.persistence.inmemory.InMemoryRepositoryFactory;

public class ActivitiesSummaryRouteTest extends RouteTest {
    @Test
    public void integration() throws Exception {
        Activity activity = new Activity();
        activity.setSpots(new Quantity("500"));
        activity.setDuration(new Minutes("90"));
        activity.setPoints(new Quantity("100"));
        activity.setId("55ec9e9ad8699a069f77a024");
        activity.setName(new Text("Name 1"));
        activity.setDescription(new Text("Description 1"));
        activity.setDate(new Date("1900-01-01"));
        activity.setTime(new Time("06:59:59"));
        activity.setPlace(new Text("place"));
        activity.setStreet(new Text("street"));
        activity.setNumber(new Numeric("1"));
        activity.setComplement(new Text("complement"));
        activity.setNeighborhood(new Text("neighborhood"));
        activity.setCity(new Text("city"));
        activity.setState(new Text("state"));
        activity.setCEP(new CEP("11111-111"));
        
        InMemoryRepositoryFactory.getActivityRepository().save(activity);
        
        assertRouteResponse("GET", "/activities",
                "[{" +
        		"\"spots\":\"500\"," +
        		"\"duration\":\"90\"," +
        		"\"points\":\"100\"," +
                "\"id\":\"55ec9e9ad8699a069f77a024\"," +
                "\"name\":\"Name 1\"," +
                "\"description\":\"Description 1\"," +
                "\"date\":\"1900-01-01\"," +
                "\"time\":\"06:59:59\"," +
                "\"place\":\"place\"," +
                "\"street\":\"street\"," +
                "\"number\":\"1\"," +
                "\"complement\":\"complement\"," +
                "\"neighborhood\":\"neighborhood\"," +
                "\"city\":\"city\"," +
                "\"state\":\"state\"," +
                "\"cep\":\"11111-111\"" +
                "}]");
	}

}