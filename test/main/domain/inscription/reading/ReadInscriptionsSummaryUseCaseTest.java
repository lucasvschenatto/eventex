package main.domain.inscription.reading;

import main.domain.Booleanic;
import main.domain.Text;
import main.domain.activity.Activity;
import main.domain.activity.ActivityRepository;
import main.domain.associate.Associate;
import main.domain.associate.AssociateRepository;
import main.domain.category.Category;
import main.domain.category.CategoryRepository;
import main.domain.inscription.InscriptionRepository;
import main.domain.inscription.creating.CreateInscriptionRequest;
import main.domain.inscription.creating.CreateInscriptionResponse;
import main.domain.inscription.creating.CreateInscriptionUseCase;
import main.domain.participant.Participant;
import main.domain.participant.ParticipantRepository;
import main.persistence.inmemory.InMemoryActivityRepository;
import main.persistence.inmemory.InMemoryAssociateRepository;
import main.persistence.inmemory.InMemoryCategoryRepository;
import main.persistence.inmemory.InMemoryInscriptionRepository;
import main.persistence.inmemory.InMemoryParticipantRepository;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class ReadInscriptionsSummaryUseCaseTest {
    private InscriptionRepository inscriptionRepository;
    private ParticipantRepository participantRepository;
    private ActivityRepository activityRepository;
    private CategoryRepository categoryRepository;
    private AssociateRepository associateRepository;
    private ArrayList<InscriptionSummary> response;

    private void givenInscription(String participantId, String activityId, String categoryId, String associateCode) {
        Participant participant = new Participant();
        participant.setId(participantId);
    	participantRepository.save(participant);
    	
    	Activity activity = new Activity();
    	activity.setId(activityId);
    	activityRepository.save(activity);
    	
    	Category category = new Category();
    	category.setId(categoryId);
    	category.setNeedCodeAtInscription(new Booleanic("true"));
    	categoryRepository.save(category);
    	
    	Associate associate = new Associate();
    	associate.setCategoryId(new Text(categoryId));
    	associate.setCode(new Text(associateCode));
    	associateRepository.save(associate);
    	
    	CreateInscriptionRequest request = new CreateInscriptionRequest();
        request.participantId = participantId;
        request.activityId = activityId;
        request.categoryId = categoryId;
        request.associateCode = associateCode;
        CreateInscriptionResponse response = new CreateInscriptionResponse();
        new CreateInscriptionUseCase(inscriptionRepository, participantRepository,
        		activityRepository, categoryRepository,
        		associateRepository, request, response).execute();
    }

    private void whenReadingSummaries() {
        new ReadInscriptionsUseCase(inscriptionRepository, response).execute();
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
        inscriptionRepository = new InMemoryInscriptionRepository();
        participantRepository = new InMemoryParticipantRepository();
        activityRepository = new InMemoryActivityRepository();
        categoryRepository = new InMemoryCategoryRepository();
        associateRepository = new InMemoryAssociateRepository();
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