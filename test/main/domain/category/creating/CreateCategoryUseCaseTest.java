package main.domain.category.creating;

import main.domain.category.CategoryRepository;
import main.domain.category.reading.CategorySummary;
import main.domain.category.reading.ReadCategoriesSummaryUseCase;
import main.persistence.inmemory.InMemoryCategoryRepository;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class CreateCategoryUseCaseTest {
	private static final String VALID_NAME = "Valid name";
	private static final String VALID_DESCRIPTION = "Valid description";
	private static final String VALID_DISCOUNT = "63";
	private CreateCategoryRequest request;
	private CreateCategoryResponse response;
	private CategoryRepository repository;

    private void givenParticipantCategoryInformation(String name, String description, String discount) {
        request = new CreateCategoryRequest();
        request.name = name;
        request.description = description;
        request.discount = discount;
    }

    private void whenCreatingTheParticipantCategory() {
        new CreateCategoryUseCase(repository, request, response).execute();
    }

    private void andItShouldReturnTheErrors(String... expectedErrors) {
        assertFalse(response.success);
        assertArrayEquals(expectedErrors, makeErrorsArray());
    }

    private String[] makeErrorsArray() {
        ArrayList<String> list = new ArrayList<>();
        if (response.invalidName) list.add("invalidName");
        if (response.invalidDescription) list.add("invalidDescription");
        if (response.invalidDiscount) list.add("invalidDiscount");
        return list.toArray(new String[list.size()]);
    }

    private void thenItShouldNotBeCreated() {
        assertFalse(response.success);
        assertEquals(0, getSummaries().size());
    }

    private void thenItShouldBeCreatedWithTheData(String name, String description, String discount) {
        assertTrue(response.success);
        CategorySummary summary = getSummaries().get(0);
        assertEquals(name, summary.name);
        assertEquals(description, summary.description);
        assertEquals(Integer.parseInt(discount), summary.discount);
    }

    private ArrayList<CategorySummary> getSummaries() {
        ArrayList<CategorySummary> summaries = new ArrayList<>();
        new ReadCategoriesSummaryUseCase(repository, summaries).execute();
        return summaries;
    }

    private void andItShouldNotReturnErrors() {
        assertEquals(0, makeErrorsArray().length);
    }

    @Before
    public void setUp() {
        response = new CreateCategoryResponse();
        repository = new InMemoryCategoryRepository();
    }

    @Test
    public void givenNullName_itIsInvalid() {
        givenParticipantCategoryInformation(null, VALID_DESCRIPTION, VALID_DISCOUNT);
        whenCreatingTheParticipantCategory();
        thenItShouldNotBeCreated();
        andItShouldReturnTheErrors("invalidName");
    }

    @Test
    public void givenEmptyName_itIsInvalid() {
        givenParticipantCategoryInformation("", VALID_DESCRIPTION, VALID_DISCOUNT);
        whenCreatingTheParticipantCategory();
        thenItShouldNotBeCreated();
        andItShouldReturnTheErrors("invalidName");
    }

    @Test
    public void givenNameWithOnlySpaces_itIsInvalid() {
        givenParticipantCategoryInformation("   ", VALID_DESCRIPTION, VALID_DISCOUNT);
        whenCreatingTheParticipantCategory();
        thenItShouldNotBeCreated();
        andItShouldReturnTheErrors("invalidName");
    }

    @Test
    public void givenNullDescription_itIsInvalid() {
        givenParticipantCategoryInformation(VALID_NAME, null, VALID_DISCOUNT);
        whenCreatingTheParticipantCategory();
        thenItShouldNotBeCreated();
        andItShouldReturnTheErrors("invalidDescription");
    }

    @Test
    public void givenEmptyDescription_itIsInvalid() {
        givenParticipantCategoryInformation(VALID_NAME, "", VALID_DISCOUNT);
        whenCreatingTheParticipantCategory();
        thenItShouldNotBeCreated();
        andItShouldReturnTheErrors("invalidDescription");
    }

    @Test
    public void givenDescriptionWithOnlySpaces_itIsInvalid() {
        givenParticipantCategoryInformation(VALID_NAME, "  ", VALID_DISCOUNT);
        whenCreatingTheParticipantCategory();
        thenItShouldNotBeCreated();
        andItShouldReturnTheErrors("invalidDescription");
    }
    
    @Test
    public void givenNullDiscount_itIsInvalid() {
        givenParticipantCategoryInformation(VALID_NAME, VALID_DESCRIPTION, null);
        whenCreatingTheParticipantCategory();
        thenItShouldNotBeCreated();
        andItShouldReturnTheErrors("invalidDiscount");
    }

    @Test
    public void givenEmptyDiscount_itIsInvalid() {
        givenParticipantCategoryInformation(VALID_NAME, VALID_DESCRIPTION, "");
        whenCreatingTheParticipantCategory();
        thenItShouldNotBeCreated();
        andItShouldReturnTheErrors("invalidDiscount");
    }

    @Test
    public void givenDiscountWithOnlySpaces_itIsInvalid() {
        givenParticipantCategoryInformation(VALID_NAME, VALID_DESCRIPTION, "  ");
        whenCreatingTheParticipantCategory();
        thenItShouldNotBeCreated();
        andItShouldReturnTheErrors("invalidDiscount");
    }


    @Test
    public void givenAllValidInput_theParticipantCategoryMustBeCreated() {
        givenParticipantCategoryInformation(VALID_NAME, VALID_DESCRIPTION, VALID_DISCOUNT);
        whenCreatingTheParticipantCategory();
        thenItShouldBeCreatedWithTheData(VALID_NAME, VALID_DESCRIPTION, VALID_DISCOUNT);
        andItShouldNotReturnErrors();
    }

    @Test
    public void givenNameAndDescriptionSurroundedBySpaces_theParticipantCategoryIsCreatedWithTheTextsTrimmed() {
        givenParticipantCategoryInformation("  Valid name  ", "  Valid description  ", VALID_DISCOUNT);
        whenCreatingTheParticipantCategory();
        thenItShouldBeCreatedWithTheData(VALID_NAME, VALID_DESCRIPTION, VALID_DISCOUNT);
        andItShouldNotReturnErrors();
    }
}