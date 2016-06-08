package main.routes;

//import com.mongodb.MongoClient;
//import com.mongodb.MongoClientURI;
//import com.mongodb.client.MongoDatabase;

//import main.persistence.mongo.MongoProductRepository;
import org.junit.*;

import main.domain.CEP;
import main.domain.Date;
import main.domain.IntNumber;
import main.domain.Text;
import main.domain.Time;
import main.domain.event.Event;
import main.persistence.inmemory.InMemoryRepositoryFactory;

public class EventsSummaryRouteTest extends RouteTest {
    @Test
    public void integration() throws Exception {
        Event event = new Event();
        event.setId("55ec9e9ad8699a069f77a024");
        event.setName(new Text("Name 1"));
        event.setDescription(new Text("Description 1"));
        event.setDate(new Date("1900-01-01"));
        event.setTime(new Time("06:59:59"));
        event.setPlace(new Text("place"));
        event.setStreet(new Text("street"));
        event.setNumber(new IntNumber("1"));
        event.setComplement(new Text("complement"));
        event.setNeighborhood(new Text("neighborhood"));
        event.setCity(new Text("city"));
        event.setState(new Text("state"));
        event.setCEP(new CEP("11111-111"));
        
        InMemoryRepositoryFactory.getEventRepository().save(event);
        
        assertRouteResponse("GET", "/events",
                "[{" +
                "\"id\":\"55ec9e9ad8699a069f77a024\"," +
                "\"name\":\"Name 1\"," +
                "\"description\":\"Description 1\"," +
                "\"date\":\"1900-01-01\"," +
                "\"time\":\"06:59:59\"," +
                "\"place\":\"place\"," +
                "\"street\":\"street\"," +
                "\"number\":1," +
                "\"complement\":\"complement\"," +
                "\"neighborhood\":\"neighborhood\"," +
                "\"city\":\"city\"," +
                "\"state\":\"state\"," +
                "\"cep\":\"11111-111\"" +
                "}]");
    }
}