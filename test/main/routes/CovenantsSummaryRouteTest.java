package main.routes;

//import com.mongodb.MongoClient;
//import com.mongodb.MongoClientURI;
//import com.mongodb.client.MongoDatabase;

//import main.persistence.mongo.MongoProductRepository;
import org.junit.*;

import main.domain.Booleanic;
import main.domain.Date;
import main.domain.Percentage;
import main.domain.Text;
import main.domain.category.ParticipantCategory;
import main.domain.covenant.Covenant;
import main.persistence.inmemory.InMemoryRepositoryFactory;

public class CovenantsSummaryRouteTest extends RouteTest {
    @Test
    public void integration() throws Exception {
    	ParticipantCategory category = new ParticipantCategory();
    	category.setId("E3edrGT");
    	category.setName(new Text("cat name"));
    	category.setDescription(new Text("cat descr"));
    	category.setDiscount(new Percentage("45"));    	
    	
        Covenant covenant = new Covenant();
        covenant.setId("55ec9e9ad8699a069f77a024");
        covenant.setCategoryId(new Text("E3edrGT"));
        covenant.setCode(new Text("CODE"));
        covenant.setName(new Text("Name 1"));
        covenant.setUpdateDate(new Date("2016-01-01"));
        covenant.setActive(new Booleanic("true"));
        
        InMemoryRepositoryFactory.getCategoryRepository().save(category);
        InMemoryRepositoryFactory.getCovenantRepository().save(covenant);
        
        assertRouteResponse("GET", "/covenants",
                "[{" +
                "\"id\":\"55ec9e9ad8699a069f77a024\"," +
                "\"categoryId\":\"E3edrGT\"," +
                "\"code\":\"CODE\"," +
                "\"name\":\"Name 1\"," +
                "\"updateDate\":\"2016-01-01\"," +
                "\"active\":true" +
                "}]");
    }
}