package main.domain.category.creating;

import main.domain.category.CategoryRepository;
import main.domain.category.reading.CategorySummary;
import main.domain.category.reading.ReadCategoriesUseCase;
import main.persistence.inmemory.InMemoryCategoryRepository;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class CreateCategoryUseCaseTest {
	private static final String VALID_NAME = "Valid name";
	private static final String VALID_DESCRIPTION = "Valid description";
	private static final String VALID_DISCOUNT = "63";
	private static final String VALID_NEED_CODE_AT_INSCRIPTION = "true";
	private CreateCategoryRequest request;
	private CreateCategoryResponse response;
	private CategoryRepository repository;

    private void givenCategoryInformation(String name, String description, 
    		String discount, String needCodeAtInscription) {
        request = new CreateCategoryRequest();
        request.name = name;
        request.description = description;
        request.discount = discount;
        request.needCodeAtInscription = needCodeAtInscription;
    }

    private void whenCreatingTheCategory() {
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
        if (response.invalidNeedCodeAtInscription) list.add("invalidNeedCodeAtInscription");
        return list.toArray(new String[list.size()]);
    }

    private void thenItShouldNotBeCreated() {
        assertFalse(response.success);
        assertEquals(0, getSummaries().size());
    }

    private void thenItShouldBeCreatedWithTheData(String name, String description,
    		String discount, String needDiscountAtInscription) {
        assertTrue(response.success);
        CategorySummary summary = getSummaries().get(0);
        assertEquals(name, summary.name);
        assertEquals(description, summary.description);
        assertEquals(Integer.parseInt(discount), summary.discount);
        assertEquals(Boolean.parseBoolean(needDiscountAtInscription), summary.needCodeAtInscription);
    }

    private ArrayList<CategorySummary> getSummaries() {
        ArrayList<CategorySummary> summaries = new ArrayList<>();
        new ReadCategoriesUseCase(repository, summaries).execute();
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
        givenCategoryInformation(null, VALID_DESCRIPTION, VALID_DISCOUNT, VALID_NEED_CODE_AT_INSCRIPTION);
        whenCreatingTheCategory();
        thenItShouldNotBeCreated();
        andItShouldReturnTheErrors("invalidName");
    }

    @Test
    public void givenEmptyName_itIsInvalid() {
        givenCategoryInformation("", VALID_DESCRIPTION, VALID_DISCOUNT, VALID_NEED_CODE_AT_INSCRIPTION);
        whenCreatingTheCategory();
        thenItShouldNotBeCreated();
        andItShouldReturnTheErrors("invalidName");
    }

    @Test
    public void givenNameWithOnlySpaces_itIsInvalid() {
        givenCategoryInformation("   ", VALID_DESCRIPTION, VALID_DISCOUNT, VALID_NEED_CODE_AT_INSCRIPTION);
        whenCreatingTheCategory();
        thenItShouldNotBeCreated();
        andItShouldReturnTheErrors("invalidName");
    }

    @Test
    public void givenNullDescription_itIsInvalid() {
        givenCategoryInformation(VALID_NAME, null, VALID_DISCOUNT, VALID_NEED_CODE_AT_INSCRIPTION);
        whenCreatingTheCategory();
        thenItShouldNotBeCreated();
        andItShouldReturnTheErrors("invalidDescription");
    }

    @Test
    public void givenEmptyDescription_itIsInvalid() {
        givenCategoryInformation(VALID_NAME, "", VALID_DISCOUNT, VALID_NEED_CODE_AT_INSCRIPTION);
        whenCreatingTheCategory();
        thenItShouldNotBeCreated();
        andItShouldReturnTheErrors("invalidDescription");
    }

    @Test
    public void givenDescriptionWithOnlySpaces_itIsInvalid() {
        givenCategoryInformation(VALID_NAME, "  ", VALID_DISCOUNT, VALID_NEED_CODE_AT_INSCRIPTION);
        whenCreatingTheCategory();
        thenItShouldNotBeCreated();
        andItShouldReturnTheErrors("invalidDescription");
    }
    
    @Test
    public void givenNullDiscount_itIsInvalid() {
        givenCategoryInformation(VALID_NAME, VALID_DESCRIPTION, null, VALID_NEED_CODE_AT_INSCRIPTION);
        whenCreatingTheCategory();
        thenItShouldNotBeCreated();
        andItShouldReturnTheErrors("invalidDiscount");
    }

    @Test
    public void givenEmptyDiscount_itIsInvalid() {
        givenCategoryInformation(VALID_NAME, VALID_DESCRIPTION, "", VALID_NEED_CODE_AT_INSCRIPTION);
        whenCreatingTheCategory();
        thenItShouldNotBeCreated();
        andItShouldReturnTheErrors("invalidDiscount");
    }

    @Test
    public void givenDiscountWithOnlySpaces_itIsInvalid() {
        givenCategoryInformation(VALID_NAME, VALID_DESCRIPTION, "  ", VALID_NEED_CODE_AT_INSCRIPTION);
        whenCreatingTheCategory();
        thenItShouldNotBeCreated();
        andItShouldReturnTheErrors("invalidDiscount");
    }


    @Test
    public void givenAllValidInput_theCategoryMustBeCreated() {
        givenCategoryInformation(VALID_NAME, VALID_DESCRIPTION, VALID_DISCOUNT, VALID_NEED_CODE_AT_INSCRIPTION);
        whenCreatingTheCategory();
        thenItShouldBeCreatedWithTheData(VALID_NAME, VALID_DESCRIPTION, VALID_DISCOUNT, VALID_NEED_CODE_AT_INSCRIPTION);
        andItShouldNotReturnErrors();
    }

    @Test
    public void givenNameAndDescriptionSurroundedBySpaces_theCategoryIsCreatedWithTheTextsTrimmed() {
        givenCategoryInformation("  Valid name  ", "  Valid description  ", VALID_DISCOUNT, VALID_NEED_CODE_AT_INSCRIPTION);
        whenCreatingTheCategory();
        thenItShouldBeCreatedWithTheData(VALID_NAME, VALID_DESCRIPTION, VALID_DISCOUNT, VALID_NEED_CODE_AT_INSCRIPTION);
        andItShouldNotReturnErrors();
    }
}