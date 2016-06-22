package main.domain.inscription.reading;

import main.domain.inscription.Inscription;
import main.domain.inscription.InscriptionRepository;

public class ReadInscriptionUseCase {
	private final ReadInscriptionRequest request;
    private final InscriptionRepository repository;
    private final InscriptionSummary response;

    public ReadInscriptionUseCase(InscriptionRepository repository, ReadInscriptionRequest request,
    		InscriptionSummary response) {
    	this.request = request;
        this.repository = repository;
        this.response = response;
    }

    public void execute() {
    	if(inscriptionExists())
    		sendInscription();
    }
    
    private boolean inscriptionExists() {
		return repository.hasWithId(request.id);
	}

    private void sendInscription() {
    	Inscription inscription = repository.getById(request.id);
        response.id = inscription.getId();
        response.participantId = inscription.getParticipantId().toString();
        response.activityId = inscription.getActivityId().toString();
        response.categoryId = inscription.getCategoryId().toString();
        response.associateCode = inscription.getAssociateCode().toString();
    }
}
