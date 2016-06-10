package main.routes;

//import com.mongodb.MongoClient;
//import com.mongodb.MongoClientURI;
//import com.mongodb.client.MongoDatabase;

//import main.persistence.mongo.MongoProductRepository;
import org.junit.*;

import main.domain.Percentage;
import main.domain.Text;
import main.domain.category.Category;
import main.persistence.inmemory.InMemoryRepositoryFactory;

public class CategoriesSummaryRouteTest extends RouteTest {
    @Test
    public void integration() throws Exception {
        Category category = new Category();
        category.setId("55ec9e9ad8699a069f77a024");
        category.setName(new Text("Name 1"));
        category.setDescription(new Text("Description 1"));
        category.setDiscount(new Percentage("12"));
        
        InMemoryRepositoryFactory.getCategoryRepository().save(category);
        
        assertRouteResponse("GET", "/categories",
                "[{" +
                "\"id\":\"55ec9e9ad8699a069f77a024\"," +
                "\"name\":\"Name 1\"," +
                "\"description\":\"Description 1\"," +
                "\"discount\":12" +
                "}]");
    }
}