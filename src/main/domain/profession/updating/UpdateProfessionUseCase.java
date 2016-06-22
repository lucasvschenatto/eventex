package main.domain.profession.updating;

import main.domain.profession.Profession;
import main.domain.profession.ProfessionRepository;
import main.domain.profession.creating.CreateProfessionUseCase;
import main.persistence.EntityNotFoundException;

public class UpdateProfessionUseCase extends CreateProfessionUseCase{
    protected final String id;

    public UpdateProfessionUseCase(ProfessionRepository repository, UpdateProfessionRequest request, UpdateProfessionResponse response) {
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

	protected Profession makeProfession() {
        Profession profession = super.makeProfession();
        profession.setId(id);
        return profession;
    }

    protected void sendErrors() {
    	super.sendErrors();
        ((UpdateProfessionResponse)response).invalidId = ! idExists();
    }
}
