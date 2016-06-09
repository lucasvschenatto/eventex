package main.domain.covenant.reading;

import java.util.Collection;

import main.domain.covenant.Covenant;
import main.domain.covenant.CovenantRepository;

public class ReadCovenantsSummaryUseCase {
    private final CovenantRepository repository;
    private final Collection<CovenantSummary> response;

    public ReadCovenantsSummaryUseCase(CovenantRepository repository,
    		Collection<CovenantSummary> response) {
        this.repository = repository;
        this.response = response;
    }

    public void execute() {
        for (Covenant covenant : repository.getAll())
            response.add(makeCovenantSummary(covenant));
    }

    private CovenantSummary makeCovenantSummary(Covenant covenant) {
        CovenantSummary summary = new CovenantSummary();
        summary.id = covenant.getId();
        summary.categoryId = covenant.getCategoryId().toString();
        summary.code = covenant.getCode().toString();
        summary.name = covenant.getName().toString();
        summary.updateDate = covenant.getUpdateDate().toString();
        summary.active = covenant.getActive().toBoolean();
        return summary;
    }
}
