package main.domain.admin.creating;

import main.domain.Text;
import main.domain.admin.Admin;
import main.domain.admin.AdminRepository;

public class CreateAdminUseCase {
    protected final AdminRepository repository;
    protected final CreateAdminResponse response;
    private final Text name;
    private final Text userId;
    private final Text role;

    public CreateAdminUseCase(AdminRepository repository, CreateAdminRequest request, CreateAdminResponse response) {
        this.repository = repository;
        name = new Text(request.name);
        userId = new Text(request.userId);
        role = new Text(request.role);
        this.response = response;
    }

    public void execute() {
        if (isValidRequest())
            create();
        else
            sendErrors();
    }

    protected boolean isValidRequest() {
        return name.isValid() && userId.isValid() && role.isValid();
    }

    private void create() {
        repository.save(makeAdmin());
        response.success = true;
    }
    
	protected Admin makeAdmin() {
        Admin admin = new Admin();
        admin.setName(name);
        admin.setUserId(userId);
        admin.setRole(role);
        return admin;
    }

    protected void sendErrors() {
        response.invalidName = !name.isValid();
        response.invalidName = !name.isValid();
        response.invalidUserId = !userId.isValid();
        response.invalidRole = !role.isValid();
    }
}
