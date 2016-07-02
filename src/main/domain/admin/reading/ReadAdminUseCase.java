package main.domain.admin.reading;

import main.domain.admin.Admin;
import main.domain.admin.AdminRepository;

public class ReadAdminUseCase {
	private final ReadAdminRequest request;
    private final AdminRepository repository;
    private final ReadAdminResponse response;

    public ReadAdminUseCase(AdminRepository repository, ReadAdminRequest request, ReadAdminResponse response) {
        this.request = request;
    	this.repository = repository;
        this.response = response;
    }

    public void execute() {
    	if(adminExists())
    		sendAdmin();
    }

    private boolean adminExists() {
		return repository.hasWithId(request.id);
	}

	private void sendAdmin() {
		Admin admin = repository.getById(request.id);
		response.name = admin.getName().toString();
		response.role = admin.getRole().toString();
		response.success = true;
    }
}
