package main.domain.participant.updating;

import main.domain.participant.Participant;
import main.domain.participant.ParticipantRepository;
import main.domain.participant.creating.CreateParticipantUseCase;
import main.persistence.EntityNotFoundException;

public class UpdateParticipantUseCase extends CreateParticipantUseCase{
    private final String id;

    public UpdateParticipantUseCase(ParticipantRepository repository, UpdateParticipantRequest request, UpdateParticipantResponse response) {
        super(repository, request, response);
        id = request.id;
    }

    protected boolean isValidRequest() {
        return super.isValidRequest() && idExists();
    }

    private boolean idExists() {
    	try{
    		repository.getById(id);   
    		return true;
    	}
    	catch(EntityNotFoundException ignored){
    		return false;
    	}
	}

	protected Participant makeParticipant() {
        Participant participant = super.makeParticipant();
        participant.setId(id);
        return participant;
    }

    protected void sendErrors() {
    	super.sendErrors();
        ((UpdateParticipantResponse)response).invalidId = ! idExists();
    }
}
