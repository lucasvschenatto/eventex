package main.persistence.inmemory;

import main.domain.admin.AdminRepository;
import main.domain.admin.AdminRepositoryTest;

public class InMemoryAdminRepositoryTest extends AdminRepositoryTest {
    protected AdminRepository getRepository() {
        return new InMemoryAdminRepository();
    }

    protected String getValidId() {
        return "1";
    }

    protected String getInvalidId() {
        return "";
    }
}