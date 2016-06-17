package main.domain.inscription.creating;

import main.domain.Booleanic;
import main.domain.Text;
import main.domain.activity.Activity;
import main.domain.activity.ActivityRepository;
import main.domain.associate.Associate;
import main.domain.associate.AssociateRepository;
import main.domain.category.Category;
import main.domain.category.CategoryRepository;
import main.domain.inscription.InscriptionRepository;
import main.domain.inscription.reading.InscriptionSummary;
import main.domain.inscription.reading.ReadInscriptionsSummaryUseCase;
import main.domain.participant.Participant;
import main.domain.participant.ParticipantRepository;
import main.persistence.inmemory.InMemoryActivityRepository;
import main.persistence.inmemory.InMemoryAssociateRepository;
import main.persistence.inmemory.InMemoryCategoryRepository;
import main.persistence.inmemory.InMemoryInscriptionRepository;
import main.persistence.inmemory.InMemoryParticipantRepository;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class CreateInscriptionUseCaseTest {
	private static final String VALID_PARTICIPANT_ID = "participant";
	private static final String VALID_ACTIVITY_ID = "activity";
	private static final String VALID_CATEGORY_ID = "category";
	private static final String VALID_ASSOCIATE_CODE = "CODE";
	private CreateInscriptionRequest request;
	private CreateInscriptionResponse response;
	private InscriptionRepository inscriptionRepository;
	private ParticipantRepository participantRepository;
    private ActivityRepository activityRepository;
    private CategoryRepository categoryRepository;
    private AssociateRepository associateRepository;

    private void givenInscriptionInformation(String participantId, String activityId, 
    		String categoryId, String associateCode) {
        request = new CreateInscriptionRequest();
        request.participantId = participantId;
        request.activityId = activityId;
        request.categoryId = categoryId;
        request.associateCode = associateCode;
    }

    private void whenCreatingTheInscription() {
        new CreateInscriptionUseCase(inscriptionRepository, participantRepository,
        		activityRepository, categoryRepository,
        		associateRepository, request, response).execute();
    }

    private void andItShouldReturnTheErrors(String... expectedErrors) {
        assertFalse(response.success);
        assertArrayEquals(expectedErrors, makeErrorsArray());
    }

    private String[] makeErrorsArray() {
        ArrayList<String> list = new ArrayList<>();
        if (response.invalidParticipantId) list.add("invalidParticipantId");
        if (response.invalidActivityId) list.add("invalidActivityId");
        if (response.invalidCategoryId) list.add("invalidCategoryId");
        if (response.invalidAssociateCode) list.add("invalidAssociateCode");
        return list.toArray(new String[list.size()]);
    }

    private void thenItShouldNotBeCreated() {
        assertFalse(response.success);
        assertEquals(0, getSummaries().size());
    }

    private void thenItShouldBeCreatedWithTheData(String participantId, String activityId,
    		String inscriptionId, String needInscriptionIdAtInscription) {
        assertTrue(response.success);
        InscriptionSummary summary = getSummaries().get(0);
        assertEquals(participantId, summary.participantId);
        assertEquals(activityId, summary.activityId);
        assertEquals(inscriptionId, summary.categoryId);
        assertEquals(needInscriptionIdAtInscription, summary.associateCode);
    }

    private ArrayList<InscriptionSummary> getSummaries() {
        ArrayList<InscriptionSummary> summaries = new ArrayList<>();
        new ReadInscriptionsSummaryUseCase(inscriptionRepository, summaries).execute();
        return summaries;
    }

    private void andItShouldNotReturnErrors() {
        assertEquals(0, makeErrorsArray().length);
    }

    @Before
    public void setUp() {
        response = new CreateInscriptionResponse();
        inscriptionRepository = new InMemoryInscriptionRepository();
        participantRepository = new InMemoryParticipantRepository();
        activityRepository = new InMemoryActivityRepository();
        categoryRepository = new InMemoryCategoryRepository();
        associateRepository = new InMemoryAssociateRepository();
        
        Participant participant = new Participant();
        participant.setId(VALID_PARTICIPANT_ID);
        participantRepository.save(participant);
        
        Activity activity = new Activity();
        activity.setId(VALID_ACTIVITY_ID);
        activityRepository.save(activity);
        
        Category category = new Category();
        category.setId(VALID_CATEGORY_ID);
        category.setNeedCodeAtInscription(new Booleanic("true"));
        categoryRepository.save(category);
        
        Associate associate = new Associate();
        associate.setCategoryId(new Text(VALID_CATEGORY_ID));
        associate.setCode(new Text(VALID_ASSOCIATE_CODE));
        associateRepository.save(associate);
    }

    @Test
    public void givenNullParticipantId_itIsInvalid() {
        givenInscriptionInformation(null, VALID_ACTIVITY_ID, VALID_CATEGORY_ID, VALID_ASSOCIATE_CODE);
        whenCreatingTheInscription();
        thenItShouldNotBeCreated();
        andItShouldReturnTheErrors("invalidParticipantId");
    }

    @Test
    public void givenEmptyParticipantId_itIsInvalid() {
        givenInscriptionInformation("", VALID_ACTIVITY_ID, VALID_CATEGORY_ID, VALID_ASSOCIATE_CODE);
        whenCreatingTheInscription();
        thenItShouldNotBeCreated();
        andItShouldReturnTheErrors("invalidParticipantId");
    }

    @Test
    public void givenParticipantIdWithOnlySpaces_itIsInvalid() {
        givenInscriptionInformation("   ", VALID_ACTIVITY_ID, VALID_CATEGORY_ID, VALID_ASSOCIATE_CODE);
        whenCreatingTheInscription();
        thenItShouldNotBeCreated();
        andItShouldReturnTheErrors("invalidParticipantId");
    }

    @Test
    public void givenNullActivityId_itIsInvalid() {
        givenInscriptionInformation(VALID_PARTICIPANT_ID, null, VALID_CATEGORY_ID, VALID_ASSOCIATE_CODE);
        whenCreatingTheInscription();
        thenItShouldNotBeCreated();
        andItShouldReturnTheErrors("invalidActivityId");
    }

    @Test
    public void givenEmptyActivityId_itIsInvalid() {
        givenInscriptionInformation(VALID_PARTICIPANT_ID, "", VALID_CATEGORY_ID, VALID_ASSOCIATE_CODE);
        whenCreatingTheInscription();
        thenItShouldNotBeCreated();
        andItShouldReturnTheErrors("invalidActivityId");
    }

    @Test
    public void givenActivityIdWithOnlySpaces_itIsInvalid() {
        givenInscriptionInformation(VALID_PARTICIPANT_ID, "  ", VALID_CATEGORY_ID, VALID_ASSOCIATE_CODE);
        whenCreatingTheInscription();
        thenItShouldNotBeCreated();
        andItShouldReturnTheErrors("invalidActivityId");
    }
    
    @Test
    public void givenNullCategoryId_itIsInvalid() {
        givenInscriptionInformation(VALID_PARTICIPANT_ID, VALID_ACTIVITY_ID, null, "");
        whenCreatingTheInscription();
        thenItShouldNotBeCreated();
        andItShouldReturnTheErrors("invalidCategoryId");
    }

    @Test
    public void givenEmptyCategoryId_itIsInvalid() {
        givenInscriptionInformation(VALID_PARTICIPANT_ID, VALID_ACTIVITY_ID, "", "");
        whenCreatingTheInscription();
        thenItShouldNotBeCreated();
        andItShouldReturnTheErrors("invalidCategoryId");
    }

    @Test
    public void givenCategoryIdWithOnlySpaces_itIsInvalid() {
        givenInscriptionInformation(VALID_PARTICIPANT_ID, VALID_ACTIVITY_ID, "  ", "");
        whenCreatingTheInscription();
        thenItShouldNotBeCreated();
        andItShouldReturnTheErrors("invalidCategoryId");
    }


    @Test
    public void givenAllValidInput_theInscriptionMustBeCreated() {
        givenInscriptionInformation(VALID_PARTICIPANT_ID, VALID_ACTIVITY_ID, VALID_CATEGORY_ID, VALID_ASSOCIATE_CODE);
        whenCreatingTheInscription();
        thenItShouldBeCreatedWithTheData(VALID_PARTICIPANT_ID, VALID_ACTIVITY_ID, VALID_CATEGORY_ID, VALID_ASSOCIATE_CODE);
        andItShouldNotReturnErrors();
    }

    @Test
    public void givenNoAssociateCodeAndCategoryNoNeed_theInscriptionMustBeCreated(){
    	Category category = new Category();
    	category.setId("catID123");
    	category.setNeedCodeAtInscription(new Booleanic("false"));
    	categoryRepository.save(category);
    	
    	givenInscriptionInformation(VALID_PARTICIPANT_ID, VALID_ACTIVITY_ID, "catID123", "");
        whenCreatingTheInscription();
        thenItShouldBeCreatedWithTheData(VALID_PARTICIPANT_ID, VALID_ACTIVITY_ID, "catID123", "");
        andItShouldNotReturnErrors();
    }
    
    @Test
    public void givenAssociateCodeOfAnotherCategory_AndCategoryDoNeed_itIsInvalid(){
    	Associate a = new Associate();
    	a.setCategoryId(new Text("another category id"));
    	a.setCode(new Text("associateCODE"));
    	associateRepository.save(a);
    	
    	givenInscriptionInformation(VALID_PARTICIPANT_ID, VALID_ACTIVITY_ID, VALID_CATEGORY_ID, "associateCODE");
        whenCreatingTheInscription();
        thenItShouldNotBeCreated();
        andItShouldReturnTheErrors("invalidAssociateCode");
    }
    
    @Test
    public void givenNoAssociateCodeAndCategoryDoNeed_itIsInvalid(){
    	givenInscriptionInformation(VALID_PARTICIPANT_ID, VALID_ACTIVITY_ID, VALID_CATEGORY_ID, "");
        whenCreatingTheInscription();
        thenItShouldNotBeCreated();
        andItShouldReturnTheErrors("invalidAssociateCode");
    }
    @Test
    public void givenInexistentAssociateCodeAndCategoryDoNeed_itIsInvalid(){
    	givenInscriptionInformation(VALID_PARTICIPANT_ID, VALID_ACTIVITY_ID, VALID_CATEGORY_ID, "INEXISTENT");
        whenCreatingTheInscription();
        thenItShouldNotBeCreated();
        andItShouldReturnTheErrors("invalidAssociateCode");
    }
    
    @Test
    public void givenAssociateCodeAndCategoryNoNeed_itIsInvalid(){
    	Category category = new Category();
    	category.setId("catID123");
    	category.setNeedCodeAtInscription(new Booleanic("false"));
    	categoryRepository.save(category);
    	
    	givenInscriptionInformation(VALID_PARTICIPANT_ID, VALID_ACTIVITY_ID, "catID123", VALID_ASSOCIATE_CODE);
        whenCreatingTheInscription();
        thenItShouldNotBeCreated();
        andItShouldReturnTheErrors("invalidAssociateCode");
    }
    
    @Test
    public void givenInexistentAssociateCodeAndCategory_itIsInvalid(){
    	givenInscriptionInformation(VALID_PARTICIPANT_ID, VALID_ACTIVITY_ID, "inexistent category", "INEXISTENT");
    	whenCreatingTheInscription();
    	thenItShouldNotBeCreated();
    	andItShouldReturnTheErrors("invalidCategoryId","invalidAssociateCode");
    }
    
}