package main.domain.associate.updating;

import main.domain.associate.Associate;
import main.domain.associate.AssociateRepository;
import main.domain.associate.creating.CreateAssociateUseCase;
import main.domain.category.CategoryRepository;
import main.persistence.EntityNotFoundException;

public class UpdateAssociateUseCase extends CreateAssociateUseCase{
	private final String id;

    public UpdateAssociateUseCase(AssociateRepository associateRepository, CategoryRepository categoryRepository, UpdateAssociateRequest request, UpdateAssociateResponse response) {
        super(associateRepository, categoryRepository, request, response);
        id = request.id;
    }
    
    protected boolean isValidRequest() {
        return super.isValidRequest() && idExists();
    }
    
    private boolean idExists() {
    	try{
    		associateRepository.getById(id);   
    		return true;
    	}
    	catch(EntityNotFoundException ignored){
    		return false;
    	}
	}
    protected Associate makeAssociate() {
        Associate associate = super.makeAssociate();
        associate.setId(id);
        return associate;
    }

    protected void sendErrors() {
    	super.sendErrors();
    	((UpdateAssociateResponse)response).invalidId = ! idExists();
    }
}
