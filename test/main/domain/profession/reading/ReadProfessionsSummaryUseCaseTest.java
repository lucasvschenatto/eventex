package main.domain.profession.reading;

import main.domain.profession.ProfessionRepository;
import main.domain.profession.creating.CreateProfessionRequest;
import main.domain.profession.creating.CreateProfessionResponse;
import main.domain.profession.creating.CreateProfessionUseCase;
import main.persistence.inmemory.InMemoryProfessionRepository;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class ReadProfessionsSummaryUseCaseTest {
    private ProfessionRepository repository;
    private ArrayList<ProfessionSummary> response;

    private void givenProfession(String name, String description) {
        CreateProfessionRequest request = new CreateProfessionRequest();
        request.name = name;
        request.description = description;
        CreateProfessionResponse response = new CreateProfessionResponse();
        new CreateProfessionUseCase(repository, request, response).execute();
    }

    private void whenReadingSummaries() {
        new ReadProfessionsUseCase(repository, response).execute();
    }

    private void thenTheSizeMustBe(int size) {
        assertEquals(size, response.size());
    }

    private void andItMustPresentAtIndex(int index, String id, String name, String description) {
        ProfessionSummary summary = response.get(index);
        assertEquals(id, summary.id);
        assertEquals(name, summary.name);
        assertEquals(description, summary.description);
    }

    @Before
    public void setUp() throws Exception {
        repository = new InMemoryProfessionRepository();
        response = new ArrayList<>();
    }

    @Test
    public void givenNoProfessions_itReturnsAnEmptyCollection() {
        whenReadingSummaries();
        thenTheSizeMustBe(0);
    }

    @Test
    public void givenAProfession_itMustBeReturnedInTheSummary() {
        givenProfession("name 1", "description 1");
        givenProfession("name 2", "description 2");
        whenReadingSummaries();
        thenTheSizeMustBe(2);
        andItMustPresentAtIndex(0, "1", "name 1", "description 1");
        andItMustPresentAtIndex(1, "2", "name 2", "description 2");
    }
}