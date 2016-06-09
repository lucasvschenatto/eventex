package main.domain.covenant.creating;

import main.domain.Percentage;
import main.domain.Text;
import main.domain.category.ParticipantCategory;
import main.domain.category.ParticipantCategoryRepository;
import main.domain.covenant.CovenantRepository;
import main.domain.covenant.reading.CovenantSummary;
import main.domain.covenant.reading.ReadCovenantsSummaryUseCase;
import main.persistence.inmemory.InMemoryCovenantRepository;
import main.persistence.inmemory.InMemoryParticipantCategoryRepository;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class CreateCovenantUseCaseTest {
	private static final String VALID_CATEGORY_ID = "123456";
	private static final String VALID_CODE = "VALID_CODE";
	private static final String VALID_NAME = "Valid name";
	private static final String VALID_UPDATE_DATE = "2015-12-31";
	private static final String VALID_ACTIVE = "true";
	private CreateCovenantRequest request;
	private CreateCovenantResponse response;
	private CovenantRepository covenantRepository;
	private ParticipantCategoryRepository categoryRepository;

    private void givenCovenantInformation(String categoryId, String code, String name, String updateDate, String active) {
        request = new CreateCovenantRequest();
        request.categoryId = categoryId;
        request.code = code;
        request.name = name;
        request.updateDate = updateDate;
        request.active = active;
    }

    private void whenCreatingTheCovenant() {
        new CreateCovenantUseCase(covenantRepository, categoryRepository, request, response).execute();
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
        CovenantSummary summary = getSummaries().get(0);
        assertEquals(categoryId, summary.categoryId);
        assertEquals(code, summary.code);
        assertEquals(name, summary.name);
        assertEquals(updateDate, summary.updateDate);
        assertEquals(Boolean.parseBoolean(active), summary.active);
    }

    private ArrayList<CovenantSummary> getSummaries() {
        ArrayList<CovenantSummary> summaries = new ArrayList<>();
        new ReadCovenantsSummaryUseCase(covenantRepository, summaries).execute();
        return summaries;
    }

    private void andItShouldNotReturnErrors() {
        assertEquals(0, makeErrorsArray().length);
    }

    @Before
    public void setUp() {
        response = new CreateCovenantResponse();
        covenantRepository = new InMemoryCovenantRepository();
        categoryRepository = new InMemoryParticipantCategoryRepository();
        
        ParticipantCategory category = new ParticipantCategory();
        category.setId(VALID_CATEGORY_ID);
        category.setName(new Text("category name"));
        category.setDescription(new Text("category description"));
        category.setDiscount(new Percentage("35"));
        categoryRepository.save(category);
    }

    @Test
    public void givenNullCategortId_itIsInvalid() {
        givenCovenantInformation(null, VALID_CODE, VALID_NAME, VALID_UPDATE_DATE, VALID_ACTIVE);
        whenCreatingTheCovenant();
        thenItShouldNotBeCreated();
        andItShouldReturnTheErrors("invalidCategoryId");
    }

    @Test
    public void givenEmptyCategoryId_itIsInvalid() {
        givenCovenantInformation("", VALID_CODE, VALID_NAME, VALID_UPDATE_DATE, VALID_ACTIVE);
        whenCreatingTheCovenant();
        thenItShouldNotBeCreated();
        andItShouldReturnTheErrors("invalidCategoryId");
    }

    @Test
    public void givenCategoryIdWithOnlySpaces_itIsInvalid() {
        givenCovenantInformation("    ", VALID_CODE, VALID_NAME, VALID_UPDATE_DATE, VALID_ACTIVE);
        whenCreatingTheCovenant();
        thenItShouldNotBeCreated();
        andItShouldReturnTheErrors("invalidCategoryId");
    }
    
    @Test
    public void givenNullCode_itIsInvalid() {
    	givenCovenantInformation(VALID_CATEGORY_ID, null, VALID_NAME, VALID_UPDATE_DATE, VALID_ACTIVE);
    	whenCreatingTheCovenant();
    	thenItShouldNotBeCreated();
    	andItShouldReturnTheErrors("invalidCode");
    }
    
    @Test
    public void givenEmptyCode_itIsInvalid() {
    	givenCovenantInformation(VALID_CATEGORY_ID, "", VALID_NAME, VALID_UPDATE_DATE, VALID_ACTIVE);
    	whenCreatingTheCovenant();
    	thenItShouldNotBeCreated();
    	andItShouldReturnTheErrors("invalidCode");
    }
    
    @Test
    public void givenCodeWithOnlySpaces_itIsInvalid() {
    	givenCovenantInformation(VALID_CATEGORY_ID, "    ", VALID_NAME, VALID_UPDATE_DATE, VALID_ACTIVE);
    	whenCreatingTheCovenant();
    	thenItShouldNotBeCreated();
    	andItShouldReturnTheErrors("invalidCode");
    }
    
    @Test
    public void givenNullName_itIsInvalid() {
    	givenCovenantInformation(VALID_CATEGORY_ID, VALID_CODE, null, VALID_UPDATE_DATE, VALID_ACTIVE);
    	whenCreatingTheCovenant();
    	thenItShouldNotBeCreated();
    	andItShouldReturnTheErrors("invalidName");
    }
    
    @Test
    public void givenEmptyName_itIsInvalid() {
    	givenCovenantInformation(VALID_CATEGORY_ID, VALID_CODE, "", VALID_UPDATE_DATE, VALID_ACTIVE);
    	whenCreatingTheCovenant();
    	thenItShouldNotBeCreated();
    	andItShouldReturnTheErrors("invalidName");
    }
    
    @Test
    public void givenNameWithOnlySpaces_itIsInvalid() {
    	givenCovenantInformation(VALID_CATEGORY_ID, VALID_CODE, "   ", VALID_UPDATE_DATE, VALID_ACTIVE);
    	whenCreatingTheCovenant();
    	thenItShouldNotBeCreated();
    	andItShouldReturnTheErrors("invalidName");
    }
    
    @Test
    public void givenNullUpdateDate_itIsInvalid() {
    	givenCovenantInformation(VALID_CATEGORY_ID, VALID_CODE, VALID_NAME, null, VALID_ACTIVE);
    	whenCreatingTheCovenant();
    	thenItShouldNotBeCreated();
    	andItShouldReturnTheErrors("invalidUpdateDate");
    }
    
    @Test
    public void givenEmptyUpdateDate_itIsInvalid() {
    	givenCovenantInformation(VALID_CATEGORY_ID, VALID_CODE, VALID_NAME, "", VALID_ACTIVE);
    	whenCreatingTheCovenant();
    	thenItShouldNotBeCreated();
    	andItShouldReturnTheErrors("invalidUpdateDate");
    }
    
    @Test
    public void givenUpdateDateWithOnlySpaces_itIsInvalid() {
    	givenCovenantInformation(VALID_CATEGORY_ID, VALID_CODE, VALID_NAME, "    ", VALID_ACTIVE);
    	whenCreatingTheCovenant();
    	thenItShouldNotBeCreated();
    	andItShouldReturnTheErrors("invalidUpdateDate");
    }
    
    @Test
    public void givenNullActive_itIsInvalid() {
    	givenCovenantInformation(VALID_CATEGORY_ID, VALID_CODE, VALID_NAME, VALID_UPDATE_DATE, null);
    	whenCreatingTheCovenant();
    	thenItShouldNotBeCreated();
    	andItShouldReturnTheErrors("invalidActive");
    }
    
    @Test
    public void givenEmptyActive_itIsInvalid() {
    	givenCovenantInformation(VALID_CATEGORY_ID, VALID_CODE, VALID_NAME, VALID_UPDATE_DATE, "");
    	whenCreatingTheCovenant();
    	thenItShouldNotBeCreated();
    	andItShouldReturnTheErrors("invalidActive");
    }
    
    @Test
    public void givenActiveWithOnlySpaces_itIsInvalid() {
    	givenCovenantInformation(VALID_CATEGORY_ID, VALID_CODE, VALID_NAME, VALID_UPDATE_DATE, "    ");
    	whenCreatingTheCovenant();
    	thenItShouldNotBeCreated();
    	andItShouldReturnTheErrors("invalidActive");
    }

    @Test
    public void givenAllValidInput_theCovenantMustBeCreated() {
        givenCovenantInformation(VALID_CATEGORY_ID, VALID_CODE, VALID_NAME, VALID_UPDATE_DATE, VALID_ACTIVE);
        whenCreatingTheCovenant();
        thenItShouldBeCreatedWithTheData(VALID_CATEGORY_ID, VALID_CODE, VALID_NAME, VALID_UPDATE_DATE, VALID_ACTIVE);
        andItShouldNotReturnErrors();
    }

    @Test
    public void givenTextsSurroundedBySpaces_theCovenantIsCreatedWithTheTextsTrimmed() {
        givenCovenantInformation("  123456  ","  VALID_CODE  ","  Valid name  ", VALID_UPDATE_DATE, VALID_ACTIVE);
        whenCreatingTheCovenant();
        thenItShouldBeCreatedWithTheData(VALID_CATEGORY_ID, VALID_CODE, VALID_NAME, VALID_UPDATE_DATE, VALID_ACTIVE);
        andItShouldNotReturnErrors();
    }
    
    @Test
    public void givenInexistentEventId_ItIsInvalid(){
    	givenCovenantInformation("AWsd345", VALID_CODE, VALID_NAME, VALID_UPDATE_DATE, VALID_ACTIVE);
    	whenCreatingTheCovenant();
    	thenItShouldNotBeCreated();
    	andItShouldReturnTheErrors("invalidCategoryId");
    }
}