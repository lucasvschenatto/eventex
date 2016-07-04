package main.domain.admin.updating;

import main.domain.admin.Admin;
import main.domain.admin.AdminRepository;
import main.domain.admin.creating.CreateAdminUseCase;
import main.persistence.EntityNotFoundException;

public class UpdateAdminUseCase extends CreateAdminUseCase{
    private final String id;

    public UpdateAdminUseCase(AdminRepository repository, UpdateAdminRequest request, UpdateAdminResponse response) {
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

	protected Admin makeAdmin() {
        Admin admin = super.makeAdmin();
        admin.setId(id);
        return admin;
    }

    protected void sendErrors() {
    	super.sendErrors();
        ((UpdateAdminResponse)response).invalidId = ! idExists();
    }
}
