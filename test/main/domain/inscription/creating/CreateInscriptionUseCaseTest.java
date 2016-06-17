package main.domain.inscription.creating;

import main.domain.inscription.InscriptionRepository;
import main.domain.inscription.reading.InscriptionSummary;
import main.domain.inscription.reading.ReadInscriptionsSummaryUseCase;
import main.persistence.inmemory.InMemoryInscriptionRepository;

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
	private InscriptionRepository repository;

    private void givenInscriptionInformation(String participantId, String activityId, 
    		String categoryId, String associateCode) {
        request = new CreateInscriptionRequest();
        request.participantId = participantId;
        request.activityId = activityId;
        request.categoryId = categoryId;
        request.associateCode = associateCode;
    }

    private void whenCreatingTheInscription() {
        new CreateInscriptionUseCase(repository, request, response).execute();
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
        new ReadInscriptionsSummaryUseCase(repository, summaries).execute();
        return summaries;
    }

    private void andItShouldNotReturnErrors() {
        assertEquals(0, makeErrorsArray().length);
    }

    @Before
    public void setUp() {
        response = new CreateInscriptionResponse();
        repository = new InMemoryInscriptionRepository();
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
        givenInscriptionInformation(VALID_PARTICIPANT_ID, VALID_ACTIVITY_ID, null, VALID_ASSOCIATE_CODE);
        whenCreatingTheInscription();
        thenItShouldNotBeCreated();
        andItShouldReturnTheErrors("invalidCategoryId");
    }

    @Test
    public void givenEmptyCategoryId_itIsInvalid() {
        givenInscriptionInformation(VALID_PARTICIPANT_ID, VALID_ACTIVITY_ID, "", VALID_ASSOCIATE_CODE);
        whenCreatingTheInscription();
        thenItShouldNotBeCreated();
        andItShouldReturnTheErrors("invalidCategoryId");
    }

    @Test
    public void givenCategoryIdWithOnlySpaces_itIsInvalid() {
        givenInscriptionInformation(VALID_PARTICIPANT_ID, VALID_ACTIVITY_ID, "  ", VALID_ASSOCIATE_CODE);
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
    public void givenParticipantIdAndActivityIdSurroundedBySpaces_theInscriptionIsCreatedWithTheTextsTrimmed() {
        givenInscriptionInformation("  participant  ", "  activity  ", VALID_CATEGORY_ID, VALID_ASSOCIATE_CODE);
        whenCreatingTheInscription();
        thenItShouldBeCreatedWithTheData(VALID_PARTICIPANT_ID, VALID_ACTIVITY_ID, VALID_CATEGORY_ID, VALID_ASSOCIATE_CODE);
        andItShouldNotReturnErrors();
    }
}