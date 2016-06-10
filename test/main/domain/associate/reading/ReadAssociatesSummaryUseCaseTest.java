package main.domain.associate.reading;

import main.domain.Percentage;
import main.domain.Text;
import main.domain.associate.AssociateRepository;
import main.domain.associate.creating.CreateAssociateRequest;
import main.domain.associate.creating.CreateAssociateResponse;
import main.domain.associate.creating.CreateAssociateUseCase;
import main.domain.associate.reading.AssociateSummary;
import main.domain.associate.reading.ReadAssociatesSummaryUseCase;
import main.domain.category.Category;
import main.domain.category.CategoryRepository;
import main.persistence.inmemory.InMemoryAssociateRepository;
import main.persistence.inmemory.InMemoryCategoryRepository;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class ReadAssociatesSummaryUseCaseTest {
    private AssociateRepository associateRepository;
    private CategoryRepository categoryRepository;
    private ArrayList<AssociateSummary> response;

    private void givenAssociate(String categoryId, String code, String name, String updateDate, String active) {
        createDummyCategoryWithId(categoryId);
    	CreateAssociateRequest request = new CreateAssociateRequest();
        request.categoryId = categoryId;
        request.code = code;
        request.name = name;
        request.updateDate = updateDate;
        request.active = active;
        CreateAssociateResponse response = new CreateAssociateResponse();
        new CreateAssociateUseCase(associateRepository, categoryRepository, request, response).execute();
    }

    private void createDummyCategoryWithId(String id) {
		Category category = new Category();
		category.setId(id);
		category.setName(new Text("name"));
		category.setDescription(new Text("description"));
		category.setDiscount(new Percentage("60"));
		categoryRepository.save(category);		
	}

	private void whenReadingSummaries() {
        new ReadAssociatesSummaryUseCase(associateRepository, response).execute();
    }

    private void thenTheSizeMustBe(int size) {
        assertEquals(size, response.size());
    }

    private void andItMustPresentAtIndex(int index, String id, String categoryId, String code, String name, String updateDate, boolean active) {
        AssociateSummary summary = response.get(index);
        assertEquals(id, summary.id);
        assertEquals(categoryId, summary.categoryId);
        assertEquals(code, summary.code);
        assertEquals(name, summary.name);
        assertEquals(updateDate, summary.updateDate);
        assertEquals(active, summary.active);
    }

    @Before
    public void setUp() throws Exception {
        associateRepository = new InMemoryAssociateRepository();
        categoryRepository = new InMemoryCategoryRepository();
        response = new ArrayList<>();
    }

    @Test
    public void givenNoAssociates_itReturnsAnEmptyCollection() {
        whenReadingSummaries();
        thenTheSizeMustBe(0);
    }

    @Test
    public void givenAAssociate_itMustBeReturnedInTheSummary() {
    	givenAssociate("cat1", "CODE1", "name 1", "2001-01-01", "true");
        givenAssociate("cat2", "CODE2", "name 2", "2002-02-02", "false");
        whenReadingSummaries();
        thenTheSizeMustBe(2);
        andItMustPresentAtIndex(0, "1", "cat1", "CODE1", "name 1", "2001-01-01", true);
        andItMustPresentAtIndex(1, "2", "cat2", "CODE2", "name 2", "2002-02-02", false);
    }
}