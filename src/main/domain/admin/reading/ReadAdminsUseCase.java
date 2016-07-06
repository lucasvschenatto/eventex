package main.domain.admin.reading;

import java.util.Collection;

import main.domain.admin.Admin;
import main.domain.admin.AdminRepository;

public class ReadAdminsUseCase {
    private final AdminRepository repository;
    private final Collection<AdminSummary> response;

    public ReadAdminsUseCase(AdminRepository repository, Collection<AdminSummary> response) {
        this.repository = repository;
        this.response = response;
    }

    public void execute() {
        for (Admin admin : repository.getAll())
            response.add(makeAdminSummary(admin));
    }

    private AdminSummary makeAdminSummary(Admin admin) {
        AdminSummary summary = new AdminSummary();
        summary.id = admin.getId();
        summary.name = admin.getName().toString();
        summary.userId = admin.getUserId().toString();
        summary.role = admin.getRole().toString();
        return summary;
    }
}
