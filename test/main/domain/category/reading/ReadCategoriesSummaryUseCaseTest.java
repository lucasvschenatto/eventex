package main.domain.category.reading;

import main.domain.category.CategoryRepository;
import main.domain.category.creating.CreateCategoryRequest;
import main.domain.category.creating.CreateCategoryResponse;
import main.domain.category.creating.CreateCategoryUseCase;
import main.persistence.inmemory.InMemoryCategoryRepository;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class ReadCategoriesSummaryUseCaseTest {
    private CategoryRepository repository;
    private ArrayList<CategorySummary> response;

    private void givenCategory(String name, String description, String discount) {
        CreateCategoryRequest request = new CreateCategoryRequest();
        request.name = name;
        request.description = description;
        request.discount = discount;
        CreateCategoryResponse response = new CreateCategoryResponse();
        new CreateCategoryUseCase(repository, request, response).execute();
    }

    private void whenReadingSummaries() {
        new ReadCategoriesSummaryUseCase(repository, response).execute();
    }

    private void thenTheSizeMustBe(int size) {
        assertEquals(size, response.size());
    }

    private void andItMustPresentAtIndex(int index, String id, String name, String description, int discount) {
        CategorySummary summary = response.get(index);
        assertEquals(id, summary.id);
        assertEquals(name, summary.name);
        assertEquals(description, summary.description);
        assertEquals(discount, summary.discount);
    }

    @Before
    public void setUp() throws Exception {
        repository = new InMemoryCategoryRepository();
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