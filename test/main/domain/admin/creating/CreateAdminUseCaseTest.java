package main.domain.admin.creating;

import main.domain.admin.AdminRepository;
import main.domain.admin.reading.AdminSummary;
import main.domain.admin.reading.ReadAdminsSummaryUseCase;
import main.persistence.inmemory.InMemoryAdminRepository;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class CreateAdminUseCaseTest {
	private static final String VALID_NAME = "Valid name";
	private static final String VALID_USER_ID =  "userId";
	private static final String VALID_ROLE =  "role";
	private CreateAdminRequest request;
	private CreateAdminResponse response;
	private AdminRepository repository;

    private void givenAdminInformation(String name, String userId,String role) {
        request = new CreateAdminRequest();
        request.name = name;
        request.userId = userId;
        request.role = role;
    }

	private void whenCreatingTheAdmin() {
        new CreateAdminUseCase(repository, request, response).execute();
    }

    private void andItShouldReturnTheErrors(String... expectedErrors) {
        assertFalse(response.success);
        assertArrayEquals(expectedErrors, makeErrorsArray());
    }

    private String[] makeErrorsArray() {
        ArrayList<String> list = new ArrayList<>();
        if (response.invalidName) list.add("invalidName");
        if (response.invalidUserId) list.add("invalidUserId");
        if (response.invalidRole) list.add("invalidRole");
        return list.toArray(new String[list.size()]);
    }

    private void thenItShouldNotBeCreated() {
        assertFalse(response.success);
        assertEquals(0, getSummaries().size());
    }

    private void thenItShouldBeCreatedWithTheData(String name, String userId, String role) {
        assertTrue(response.success);
        AdminSummary summary = getSummaries().get(0);
        assertEquals(name, summary.name);
        assertEquals(userId, summary.userId);
        assertEquals(role, summary.role);
    }

    private ArrayList<AdminSummary> getSummaries() {
        ArrayList<AdminSummary> summaries = new ArrayList<>();
        new ReadAdminsSummaryUseCase(repository, summaries).execute();
        return summaries;
    }

    private void andItShouldNotReturnErrors() {
        assertEquals(0, makeErrorsArray().length);
    }

    @Before
    public void setUp() {
        response = new CreateAdminResponse();
        repository = new InMemoryAdminRepository();
    }

    @Test
	public void givenAllValidInput_theAdminMustBeCreated() {
	    givenAdminInformation(VALID_NAME, VALID_USER_ID, VALID_ROLE);
	    whenCreatingTheAdmin();
	    thenItShouldBeCreatedWithTheData(VALID_NAME, VALID_USER_ID, VALID_ROLE);
	    andItShouldNotReturnErrors();
	}

	@Test
	public void givenNameSurroundedBySpaces_theAdminIsCreatedWithTheTextsTrimmed() {
	    givenAdminInformation("  Valid name  ", VALID_USER_ID, VALID_ROLE);
	    whenCreatingTheAdmin();
	    thenItShouldBeCreatedWithTheData(VALID_NAME, VALID_USER_ID, VALID_ROLE);
	    andItShouldNotReturnErrors();
	}

	@Test
    public void givenNullName_itIsInvalid() {
        givenAdminInformation(null, VALID_USER_ID, VALID_ROLE);
        whenCreatingTheAdmin();
        thenItShouldNotBeCreated();
        andItShouldReturnTheErrors("invalidName");
    }

    @Test
    public void givenEmptyName_itIsInvalid() {
        givenAdminInformation("", VALID_USER_ID, VALID_ROLE);
        whenCreatingTheAdmin();
        thenItShouldNotBeCreated();
        andItShouldReturnTheErrors("invalidName");
    }

    @Test
    public void givenNameWithOnlySpaces_itIsInvalid() {
        givenAdminInformation("   ", VALID_USER_ID, VALID_ROLE);
        whenCreatingTheAdmin();
        thenItShouldNotBeCreated();
        andItShouldReturnTheErrors("invalidName");
    }
}