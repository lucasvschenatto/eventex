package main.routes;

import org.junit.*;

import main.domain.Booleanic;
import main.domain.Percentage;
import main.domain.Text;
import main.domain.category.Category;
import main.persistence.inmemory.InMemoryFactory;

public class ReadCategoryRouteTest extends RouteTest {
    @Test
    public void integration() throws Exception {
        Category category = new Category();
        category.setId("55ec9e9ad8699a069f77a024");
        category.setName(new Text("Name 1"));
        category.setDescription(new Text("Description 1"));
        category.setDiscount(new Percentage("12"));
        category.setNeedCodeAtInscription(new Booleanic("true"));
        
        InMemoryFactory.getInstance().getCategoryRepository().save(category);
        
        assertRouteResponse("GET", "/categories/55ec9e9ad8699a069f77a024",
                "{" +
                "\"id\":\"55ec9e9ad8699a069f77a024\"," +
                "\"name\":\"Name 1\"," +
                "\"description\":\"Description 1\"," +
                "\"discount\":12," +
                "\"needCodeAtInscription\":true" +
                "}");
    }
}