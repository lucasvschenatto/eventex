package main.domain.profession.reading;

import java.util.Collection;

import main.domain.profession.Profession;
import main.domain.profession.ProfessionRepository;

public class ReadProfessionsUseCase {
    private final ProfessionRepository repository;
    private final Collection<ProfessionSummary> response;

    public ReadProfessionsUseCase(ProfessionRepository repository,
    		Collection<ProfessionSummary> response) {
        this.repository = repository;
        this.response = response;
    }

    public void execute() {
        for (Profession profession : repository.getAll())
            response.add(makeParticipantProfessionSummary(profession));
    }

    private ProfessionSummary makeParticipantProfessionSummary(Profession profession) {
        ProfessionSummary summary = new ProfessionSummary();
        summary.id = profession.getId();
        summary.name = profession.getName().toString();
        summary.description = profession.getDescription().toString();
        return summary;
    }
}
