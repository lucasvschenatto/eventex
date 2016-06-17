package main.domain.inscription.reading;

import main.domain.inscription.InscriptionRepository;
import main.domain.inscription.creating.CreateInscriptionRequest;
import main.domain.inscription.creating.CreateInscriptionResponse;
import main.domain.inscription.creating.CreateInscriptionUseCase;
import main.persistence.inmemory.InMemoryInscriptionRepository;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class ReadInscriptionsSummaryUseCaseTest {
    private InscriptionRepository repository;
    private ArrayList<InscriptionSummary> response;

    private void givenInscription(String participantId, String activityId, String categoryId, String associateCode) {
        CreateInscriptionRequest request = new CreateInscriptionRequest();
        request.participantId = participantId;
        request.activityId = activityId;
        request.categoryId = categoryId;
        request.associateCode = associateCode;
        CreateInscriptionResponse response = new CreateInscriptionResponse();
        new CreateInscriptionUseCase(repository, request, response).execute();
    }

    private void whenReadingSummaries() {
        new ReadInscriptionsSummaryUseCase(repository, response).execute();
    }

    private void thenTheSizeMustBe(int size) {
        assertEquals(size, response.size());
    }

    private void andItMustPresentAtIndex(int index, String id, String participantId, 
    		String activityId, String categoryId, String associateCode) {
        InscriptionSummary summary = response.get(index);
        assertEquals(id, summary.id);
        assertEquals(participantId, summary.participantId);
        assertEquals(activityId, summary.activityId);
        assertEquals(categoryId, summary.categoryId);
        assertEquals(associateCode, summary.associateCode);
    }

    @Before
    public void setUp() throws Exception {
        repository = new InMemoryInscriptionRepository();
        response = new ArrayList<>();
    }

    @Test
    public void givenNoInscriptions_itReturnsAnEmptyCollection() {
        whenReadingSummaries();
        thenTheSizeMustBe(0);
    }

    @Test
    public void givenAInscription_itMustBeReturnedInTheSummary() {
        givenInscription("participant 1", "activity 1", "category 1", "CODE_1");
        givenInscription("participant 2", "activity 2", "category 2", "CODE_2");
        whenReadingSummaries();
        thenTheSizeMustBe(2);
        andItMustPresentAtIndex(0, "1", "participant 1", "activity 1", "category 1", "CODE_1");
        andItMustPresentAtIndex(1, "2", "participant 2", "activity 2", "category 2", "CODE_2");
    }
}