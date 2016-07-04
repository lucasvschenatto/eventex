package main.routes;

import org.junit.*;

import main.domain.Booleanic;
import main.domain.Date;
import main.domain.Percentage;
import main.domain.Text;
import main.domain.associate.Associate;
import main.domain.category.Category;
import main.persistence.inmemory.InMemoryFactory;

public class AssociatesSummaryRouteTest extends RouteTest {
    @Override
	public void responseCodeForNoRequestBody() throws Exception {
    	assertRouteResponse("GET", "/associates",200);
	}

	@Test
    public void integration() throws Exception {
    	Category category = new Category();
    	category.setId("E3edrGT");
    	category.setName(new Text("cat name"));
    	category.setDescription(new Text("cat descr"));
    	category.setDiscount(new Percentage("45"));    	
    	
        Associate associate = new Associate();
        associate.setId("55ec9e9ad8699a069f77a024");
        associate.setCategoryId(new Text("E3edrGT"));
        associate.setCode(new Text("CODE"));
        associate.setName(new Text("Name 1"));
        associate.setUpdateDate(new Date("2016-01-01"));
        associate.setActive(new Booleanic("true"));
        
        InMemoryFactory.getInstance().getCategoryRepository().save(category);
        InMemoryFactory.getInstance().getAssociateRepository().save(associate);
        
        assertRouteResponse("GET", "/associates",
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