package main.domain.inscription.updating;

import main.domain.activity.ActivityRepository;
import main.domain.associate.AssociateRepository;
import main.domain.category.CategoryRepository;
import main.domain.inscription.Inscription;
import main.domain.inscription.InscriptionRepository;
import main.domain.inscription.creating.CreateInscriptionUseCase;
import main.domain.participant.ParticipantRepository;
import main.persistence.EntityNotFoundException;

public class UpdateInscriptionUseCase extends CreateInscriptionUseCase{
    private final String id;

    public UpdateInscriptionUseCase(InscriptionRepository inscriptionRepository,
    		ParticipantRepository participantRepository, ActivityRepository activityRepository,
    		CategoryRepository categoryRepository, AssociateRepository associateRepository,
    		UpdateInscriptionRequest request, UpdateInscriptionResponse response) {
    	super(inscriptionRepository, participantRepository, activityRepository, 
    			categoryRepository, associateRepository, request, response);
    	id = request.id;
    }

    protected boolean isValidRequest() {
        return super.isValidRequest() && idExists();
    }
    
    private boolean idExists() {
    	try{
    		inscriptionRepository.getById(id);   
    		return true;
    	}
    	catch(EntityNotFoundException ignored){
    		return false;
    	}
	}

	protected Inscription makeInscription() {
        Inscription inscription = super.makeInscription();
        inscription.setId(id);
        return inscription;
    }

    protected void sendErrors() {
    	super.sendErrors();
        ((UpdateInscriptionResponse)response).invalidId = ! idExists();
    }

}
