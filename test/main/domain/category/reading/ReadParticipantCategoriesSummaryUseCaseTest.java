package main.domain.category.reading;

import main.domain.category.ParticipantCategoryRepository;
import main.domain.category.creating.CreateParticipantCategoryRequest;
import main.domain.category.creating.CreateParticipantCategoryResponse;
import main.domain.category.creating.CreateParticipantCategoryUseCase;
import main.persistence.inmemory.InMemoryParticipantCategoryRepository;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class ReadParticipantCategoriesSummaryUseCaseTest {
    private ParticipantCategoryRepository repository;
    private ArrayList<ParticipantCategorySummary> response;

    private void givenCategory(String name, String description, String discount) {
        CreateParticipantCategoryRequest request = new CreateParticipantCategoryRequest();
        request.name = name;
        request.description = description;
        request.discount = discount;
        CreateParticipantCategoryResponse response = new CreateParticipantCategoryResponse();
        new CreateParticipantCategoryUseCase(repository, request, response).execute();
    }

    private void whenReadingSummaries() {
        new ReadParticipantCategoriesSummaryUseCase(repository, response).execute();
    }

    private void thenTheSizeMustBe(int size) {
        assertEquals(size, response.size());
    }

    private void andItMustPresentAtIndex(int index, String id, String name, String description, int discount) {
        ParticipantCategorySummary summary = response.get(index);
        assertEquals(id, summary.id);
        assertEquals(name, summary.name);
        assertEquals(description, summary.description);
        assertEquals(discount, summary.discount);
    }

    @Before
    public void setUp() throws Exception {
        repository = new InMemoryParticipantCategoryRepository();
        response = new ArrayList<>();
    }

    @Test
    public void givenNoCategories_itReturnsAnEmptyCollection() {
        whenReadingSummaries();
        thenTheSizeMustBe(0);
    }

    @Test
    public void givenACategory_itMustBeReturnedInTheSummary() {
        givenCategory("name 1", "description 1", "14");
        givenCategory("name 2", "description 2", "27");
        whenReadingSummaries();
        thenTheSizeMustBe(2);
        andItMustPresentAtIndex(0, "1", "name 1", "description 1", 14);
        andItMustPresentAtIndex(1, "2", "name 2", "description 2", 27);
    }
}