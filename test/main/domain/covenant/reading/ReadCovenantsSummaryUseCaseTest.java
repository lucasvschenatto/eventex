package main.domain.covenant.reading;

import main.domain.Percentage;
import main.domain.Text;
import main.domain.category.ParticipantCategory;
import main.domain.category.ParticipantCategoryRepository;
import main.domain.covenant.CovenantRepository;
import main.domain.covenant.creating.CreateCovenantRequest;
import main.domain.covenant.creating.CreateCovenantResponse;
import main.domain.covenant.creating.CreateCovenantUseCase;
import main.persistence.inmemory.InMemoryCovenantRepository;
import main.persistence.inmemory.InMemoryParticipantCategoryRepository;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class ReadCovenantsSummaryUseCaseTest {
    private CovenantRepository covenantRepository;
    private ParticipantCategoryRepository categoryRepository;
    private ArrayList<CovenantSummary> response;

    private void givenCovenant(String categoryId, String code, String name, String updateDate, String active) {
        createDummyCategoryWithId(categoryId);
    	CreateCovenantRequest request = new CreateCovenantRequest();
        request.categoryId = categoryId;
        request.code = code;
        request.name = name;
        request.updateDate = updateDate;
        request.active = active;
        CreateCovenantResponse response = new CreateCovenantResponse();
        new CreateCovenantUseCase(covenantRepository, categoryRepository, request, response).execute();
    }

    private void createDummyCategoryWithId(String id) {
		ParticipantCategory category = new ParticipantCategory();
		category.setId(id);
		category.setName(new Text("name"));
		category.setDescription(new Text("description"));
		category.setDiscount(new Percentage("60"));
		categoryRepository.save(category);		
	}

	private void whenReadingSummaries() {
        new ReadCovenantsSummaryUseCase(covenantRepository, response).execute();
    }

    private void thenTheSizeMustBe(int size) {
        assertEquals(size, response.size());
    }

    private void andItMustPresentAtIndex(int index, String id, String categoryId, String code, String name, String updateDate, boolean active) {
        CovenantSummary summary = response.get(index);
        assertEquals(id, summary.id);
        assertEquals(categoryId, summary.categoryId);
        assertEquals(code, summary.code);
        assertEquals(name, summary.name);
        assertEquals(updateDate, summary.updateDate);
        assertEquals(active, summary.active);
    }

    @Before
    public void setUp() throws Exception {
        covenantRepository = new InMemoryCovenantRepository();
        categoryRepository = new InMemoryParticipantCategoryRepository();
        response = new ArrayList<>();
    }

    @Test
    public void givenNoCovenants_itReturnsAnEmptyCollection() {
        whenReadingSummaries();
        thenTheSizeMustBe(0);
    }

    @Test
    public void givenACovenant_itMustBeReturnedInTheSummary() {
    	givenCovenant("cat1", "CODE1", "name 1", "2001-01-01", "true");
        givenCovenant("cat2", "CODE2", "name 2", "2002-02-02", "false");
        whenReadingSummaries();
        thenTheSizeMustBe(2);
        andItMustPresentAtIndex(0, "1", "cat1", "CODE1", "name 1", "2001-01-01", true);
        andItMustPresentAtIndex(1, "2", "cat2", "CODE2", "name 2", "2002-02-02", false);
    }
}