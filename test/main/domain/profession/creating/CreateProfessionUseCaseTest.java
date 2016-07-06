package main.domain.profession.creating;

import main.domain.profession.ProfessionRepository;
import main.domain.profession.reading.ProfessionSummary;
import main.domain.profession.reading.ReadProfessionsUseCase;
import main.persistence.inmemory.InMemoryProfessionRepository;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class CreateProfessionUseCaseTest {
	private static final String VALID_NAME = "Valid name";
	private static final String VALID_DESCRIPTION = "Valid description";
	private CreateProfessionRequest request;
	private CreateProfessionResponse response;
	private ProfessionRepository repository;

    private void givenProfessionInformation(String name, String description) {
        request = new CreateProfessionRequest();
        request.name = name;
        request.description = description;
    }

    private void whenCreatingTheProfession() {
        new CreateProfessionUseCase(repository, request, response).execute();
    }

    private void andItShouldReturnTheErrors(String... expectedErrors) {
        assertFalse(response.success);
        assertArrayEquals(expectedErrors, makeErrorsArray());
    }

    private String[] makeErrorsArray() {
        ArrayList<String> list = new ArrayList<>();
        if (response.invalidName) list.add("invalidName");
        if (response.invalidDescription) list.add("invalidDescription");
        return list.toArray(new String[list.size()]);
    }

    private void thenItShouldNotBeCreated() {
        assertFalse(response.success);
        assertEquals(0, getSummaries().size());
    }

    private void thenItShouldBeCreatedWithTheData(String name, String description) {
        assertTrue(response.success);
        ProfessionSummary summary = getSummaries().get(0);
        assertEquals(name, summary.name);
        assertEquals(description, summary.description);
    }

    private ArrayList<ProfessionSummary> getSummaries() {
        ArrayList<ProfessionSummary> summaries = new ArrayList<>();
        new ReadProfessionsUseCase(repository, summaries).execute();
        return summaries;
    }

    private void andItShouldNotReturnErrors() {
        assertEquals(0, makeErrorsArray().length);
    }

    @Before
    public void setUp() {
        response = new CreateProfessionResponse();
        repository = new InMemoryProfessionRepository();
    }

    @Test
    public void givenNullName_itIsInvalid() {
        givenProfessionInformation(null, VALID_DESCRIPTION);
        whenCreatingTheProfession();
        thenItShouldNotBeCreated();
        andItShouldReturnTheErrors("invalidName");
    }

    @Test
    public void givenEmptyName_itIsInvalid() {
        givenProfessionInformation("", VALID_DESCRIPTION);
        whenCreatingTheProfession();
        thenItShouldNotBeCreated();
        andItShouldReturnTheErrors("invalidName");
    }

    @Test
    public void givenNameWithOnlySpaces_itIsInvalid() {
        givenProfessionInformation("   ", VALID_DESCRIPTION);
        whenCreatingTheProfession();
        thenItShouldNotBeCreated();
        andItShouldReturnTheErrors("invalidName");
    }

    @Test
    public void givenNullDescription_itIsInvalid() {
        givenProfessionInformation(VALID_NAME, null);
        whenCreatingTheProfession();
        thenItShouldNotBeCreated();
        andItShouldReturnTheErrors("invalidDescription");
    }

    @Test
    public void givenEmptyDescription_itIsInvalid() {
        givenProfessionInformation(VALID_NAME, "");
        whenCreatingTheProfession();
        thenItShouldNotBeCreated();
        andItShouldReturnTheErrors("invalidDescription");
    }

    @Test
    public void givenDescriptionWithOnlySpaces_itIsInvalid() {
        givenProfessionInformation(VALID_NAME, "  ");
        whenCreatingTheProfession();
        thenItShouldNotBeCreated();
        andItShouldReturnTheErrors("invalidDescription");
    }

    @Test
    public void givenAllValidInput_theProfessionMustBeCreated() {
        givenProfessionInformation(VALID_NAME, VALID_DESCRIPTION);
        whenCreatingTheProfession();
        thenItShouldBeCreatedWithTheData(VALID_NAME, VALID_DESCRIPTION);
        andItShouldNotReturnErrors();
    }

    @Test
    public void givenNameAndDescriptionSurroundedBySpaces_theProfessionIsCreatedWithTheTextsTrimmed() {
        givenProfessionInformation("  Valid name  ", "  Valid description  ");
        whenCreatingTheProfession();
        thenItShouldBeCreatedWithTheData(VALID_NAME, VALID_DESCRIPTION);
        andItShouldNotReturnErrors();
    }
}