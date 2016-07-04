package main.domain.admin.reading;

import main.domain.admin.AdminRepository;
import main.domain.admin.creating.CreateAdminRequest;
import main.domain.admin.creating.CreateAdminResponse;
import main.domain.admin.creating.CreateAdminUseCase;
import main.domain.admin.reading.AdminSummary;
import main.domain.admin.reading.ReadAdminsSummaryUseCase;
import main.persistence.inmemory.InMemoryAdminRepository;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class ReadAdminSummaryUseCaseTest {
    private AdminRepository repository;
    private ArrayList<AdminSummary> response;

    private void givenAdmin(String name, String userId, String role) {
        CreateAdminRequest request = new CreateAdminRequest();
        request.name = name;
        request.userId = userId;
        request.role = role;
        CreateAdminResponse response = new CreateAdminResponse();
        new CreateAdminUseCase(repository, request, response).execute();
    }

    private void whenReadingSummaries() {
        new ReadAdminsSummaryUseCase(repository, response).execute();
    }

    private void thenTheSizeMustBe(int size) {
        assertEquals(size, response.size());
    }

    private void andItMustPresentAtIndex(int index, String id, String name, String userId, String role) {
        AdminSummary summary = response.get(index);
        assertEquals(id, summary.id);
        assertEquals(name, summary.name);
        assertEquals(userId, summary.userId);
        assertEquals(role, summary.role);
    }

    @Before
    public void setUp() throws Exception {
        repository = new InMemoryAdminRepository();
        response = new ArrayList<>();
    }

    @Test
    public void givenNoAdmins_itReturnsAnEmptyCollection() {
        whenReadingSummaries();
        thenTheSizeMustBe(0);
    }

    @Test
    public void givenAnAdmin_itMustBeReturnedInTheSummary() {
        givenAdmin("name 1", "userId 1", "role 1");
        givenAdmin("name 2", "userId 2", "role 2");
        whenReadingSummaries();
        thenTheSizeMustBe(2);
        andItMustPresentAtIndex(0, "1", "name 1", "userId 1", "role 1");
        andItMustPresentAtIndex(1, "2", "name 2", "userId 2", "role 2");
    }
}