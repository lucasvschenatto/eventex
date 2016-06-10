package main.domain.associate.creating;

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

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class CreateAssociateUseCaseTest {
	private static final String VALID_CATEGORY_ID = "123456";
	private static final String VALID_CODE = "VALID_CODE";
	private static final String VALID_NAME = "Valid name";
	private static final String VALID_UPDATE_DATE = "2015-12-31";
	private static final String VALID_ACTIVE = "true";
	private CreateAssociateRequest request;
	private CreateAssociateResponse response;
	private AssociateRepository associateRepository;
	private CategoryRepository categoryRepository;

    private void givenAssociateInformation(String categoryId, String code, String name, String updateDate, String active) {
        request = new CreateAssociateRequest();
        request.categoryId = categoryId;
        request.code = code;
        request.name = name;
        request.updateDate = updateDate;
        request.active = active;
    }

    private void whenCreatingTheAssociate() {
        new CreateAssociateUseCase(associateRepository, categoryRepository, request, response).execute();
    }

    private void andItShouldReturnTheErrors(String... expectedErrors) {
        assertFalse(response.success);
        assertArrayEquals(expectedErrors, makeErrorsArray());
    }

    private String[] makeErrorsArray() {
        ArrayList<String> list = new ArrayList<>();
        if (response.invalidCategoryId) list.add("invalidCategoryId");
        if (response.invalidCode) list.add("invalidCode");
        if (response.invalidName) list.add("invalidName");
        if (response.invalidUpdateDate) list.add("invalidUpdateDate");
        if (response.invalidActive) list.add("invalidActive");
        return list.toArray(new String[list.size()]);
    }

    private void thenItShouldNotBeCreated() {
        assertFalse(response.success);
        assertEquals(0, getSummaries().size());
    }

    private void thenItShouldBeCreatedWithTheData(String categoryId, String code, String name, String updateDate, String active) {
        assertTrue(response.success);
        AssociateSummary summary = getSummaries().get(0);
        assertEquals(categoryId, summary.categoryId);
        assertEquals(code, summary.code);
        assertEquals(name, summary.name);
        assertEquals(updateDate, summary.updateDate);
        assertEquals(Boolean.parseBoolean(active), summary.active);
    }

    private ArrayList<AssociateSummary> getSummaries() {
        ArrayList<AssociateSummary> summaries = new ArrayList<>();
        new ReadAssociatesSummaryUseCase(associateRepository, summaries).execute();
        return summaries;
    }

    private void andItShouldNotReturnErrors() {
        assertEquals(0, makeErrorsArray().length);
    }

    @Before
    public void setUp() {
        response = new CreateAssociateResponse();
        associateRepository = new InMemoryAssociateRepository();
        categoryRepository = new InMemoryCategoryRepository();
        
        Category category = new Category();
        category.setId(VALID_CATEGORY_ID);
        category.setName(new Text("category name"));
        category.setDescription(new Text("category description"));
        category.setDiscount(new Percentage("35"));
        categoryRepository.save(category);
    }

    @Test
    public void givenNullCategortId_itIsInvalid() {
        givenAssociateInformation(null, VALID_CODE, VALID_NAME, VALID_UPDATE_DATE, VALID_ACTIVE);
        whenCreatingTheAssociate();
        thenItShouldNotBeCreated();
        andItShouldReturnTheErrors("invalidCategoryId");
    }

    @Test
    public void givenEmptyCategoryId_itIsInvalid() {
        givenAssociateInformation("", VALID_CODE, VALID_NAME, VALID_UPDATE_DATE, VALID_ACTIVE);
        whenCreatingTheAssociate();
        thenItShouldNotBeCreated();
        andItShouldReturnTheErrors("invalidCategoryId");
    }

    @Test
    public void givenCategoryIdWithOnlySpaces_itIsInvalid() {
        givenAssociateInformation("    ", VALID_CODE, VALID_NAME, VALID_UPDATE_DATE, VALID_ACTIVE);
        whenCreatingTheAssociate();
        thenItShouldNotBeCreated();
        andItShouldReturnTheErrors("invalidCategoryId");
    }
    
    @Test
    public void givenNullCode_itIsInvalid() {
    	givenAssociateInformation(VALID_CATEGORY_ID, null, VALID_NAME, VALID_UPDATE_DATE, VALID_ACTIVE);
    	whenCreatingTheAssociate();
    	thenItShouldNotBeCreated();
    	andItShouldReturnTheErrors("invalidCode");
    }
    
    @Test
    public void givenEmptyCode_itIsInvalid() {
    	givenAssociateInformation(VALID_CATEGORY_ID, "", VALID_NAME, VALID_UPDATE_DATE, VALID_ACTIVE);
    	whenCreatingTheAssociate();
    	thenItShouldNotBeCreated();
    	andItShouldReturnTheErrors("invalidCode");
    }
    
    @Test
    public void givenCodeWithOnlySpaces_itIsInvalid() {
    	givenAssociateInformation(VALID_CATEGORY_ID, "    ", VALID_NAME, VALID_UPDATE_DATE, VALID_ACTIVE);
    	whenCreatingTheAssociate();
    	thenItShouldNotBeCreated();
    	andItShouldReturnTheErrors("invalidCode");
    }
    
    @Test
    public void givenNullName_itIsInvalid() {
    	givenAssociateInformation(VALID_CATEGORY_ID, VALID_CODE, null, VALID_UPDATE_DATE, VALID_ACTIVE);
    	whenCreatingTheAssociate();
    	thenItShouldNotBeCreated();
    	andItShouldReturnTheErrors("invalidName");
    }
    
    @Test
    public void givenEmptyName_itIsInvalid() {
    	givenAssociateInformation(VALID_CATEGORY_ID, VALID_CODE, "", VALID_UPDATE_DATE, VALID_ACTIVE);
    	whenCreatingTheAssociate();
    	thenItShouldNotBeCreated();
    	andItShouldReturnTheErrors("invalidName");
    }
    
    @Test
    public void givenNameWithOnlySpaces_itIsInvalid() {
    	givenAssociateInformation(VALID_CATEGORY_ID, VALID_CODE, "   ", VALID_UPDATE_DATE, VALID_ACTIVE);
    	whenCreatingTheAssociate();
    	thenItShouldNotBeCreated();
    	andItShouldReturnTheErrors("invalidName");
    }
    
    @Test
    public void givenNullUpdateDate_itIsInvalid() {
    	givenAssociateInformation(VALID_CATEGORY_ID, VALID_CODE, VALID_NAME, null, VALID_ACTIVE);
    	whenCreatingTheAssociate();
    	thenItShouldNotBeCreated();
    	andItShouldReturnTheErrors("invalidUpdateDate");
    }
    
    @Test
    public void givenEmptyUpdateDate_itIsInvalid() {
    	givenAssociateInformation(VALID_CATEGORY_ID, VALID_CODE, VALID_NAME, "", VALID_ACTIVE);
    	whenCreatingTheAssociate();
    	thenItShouldNotBeCreated();
    	andItShouldReturnTheErrors("invalidUpdateDate");
    }
    
    @Test
    public void givenUpdateDateWithOnlySpaces_itIsInvalid() {
    	givenAssociateInformation(VALID_CATEGORY_ID, VALID_CODE, VALID_NAME, "    ", VALID_ACTIVE);
    	whenCreatingTheAssociate();
    	thenItShouldNotBeCreated();
    	andItShouldReturnTheErrors("invalidUpdateDate");
    }
    
    @Test
    public void givenNullActive_itIsInvalid() {
    	givenAssociateInformation(VALID_CATEGORY_ID, VALID_CODE, VALID_NAME, VALID_UPDATE_DATE, null);
    	whenCreatingTheAssociate();
    	thenItShouldNotBeCreated();
    	andItShouldReturnTheErrors("invalidActive");
    }
    
    @Test
    public void givenEmptyActive_itIsInvalid() {
    	givenAssociateInformation(VALID_CATEGORY_ID, VALID_CODE, VALID_NAME, VALID_UPDATE_DATE, "");
    	whenCreatingTheAssociate();
    	thenItShouldNotBeCreated();
    	andItShouldReturnTheErrors("invalidActive");
    }
    
    @Test
    public void givenActiveWithOnlySpaces_itIsInvalid() {
    	givenAssociateInformation(VALID_CATEGORY_ID, VALID_CODE, VALID_NAME, VALID_UPDATE_DATE, "    ");
    	whenCreatingTheAssociate();
    	thenItShouldNotBeCreated();
    	andItShouldReturnTheErrors("invalidActive");
    }

    @Test
    public void givenAllValidInput_theAssociateMustBeCreated() {
        givenAssociateInformation(VALID_CATEGORY_ID, VALID_CODE, VALID_NAME, VALID_UPDATE_DATE, VALID_ACTIVE);
        whenCreatingTheAssociate();
        thenItShouldBeCreatedWithTheData(VALID_CATEGORY_ID, VALID_CODE, VALID_NAME, VALID_UPDATE_DATE, VALID_ACTIVE);
        andItShouldNotReturnErrors();
    }

    @Test
    public void givenTextsSurroundedBySpaces_theAssociateIsCreatedWithTheTextsTrimmed() {
        givenAssociateInformation("  123456  ","  VALID_CODE  ","  Valid name  ", VALID_UPDATE_DATE, VALID_ACTIVE);
        whenCreatingTheAssociate();
        thenItShouldBeCreatedWithTheData(VALID_CATEGORY_ID, VALID_CODE, VALID_NAME, VALID_UPDATE_DATE, VALID_ACTIVE);
        andItShouldNotReturnErrors();
    }
    
    @Test
    public void givenInexistentEventId_ItIsInvalid(){
    	givenAssociateInformation("AWsd345", VALID_CODE, VALID_NAME, VALID_UPDATE_DATE, VALID_ACTIVE);
    	whenCreatingTheAssociate();
    	thenItShouldNotBeCreated();
    	andItShouldReturnTheErrors("invalidCategoryId");
    }
}