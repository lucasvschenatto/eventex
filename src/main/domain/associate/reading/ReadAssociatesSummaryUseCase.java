package main.domain.associate.reading;

import java.util.Collection;

import main.domain.associate.Associate;
import main.domain.associate.AssociateRepository;

public class ReadAssociatesSummaryUseCase {
    private final AssociateRepository repository;
    private final Collection<AssociateSummary> response;

    public ReadAssociatesSummaryUseCase(AssociateRepository repository,
    		Collection<AssociateSummary> response) {
        this.repository = repository;
        this.response = response;
    }

    public void execute() {
        for (Associate associate : repository.getAll())
            response.add(makeCovenantSummary(associate));
    }

    private AssociateSummary makeCovenantSummary(Associate associate) {
        AssociateSummary summary = new AssociateSummary();
        summary.id = associate.getId();
        summary.categoryId = associate.getCategoryId().toString();
        summary.code = associate.getCode().toString();
        summary.name = associate.getName().toString();
        summary.updateDate = associate.getUpdateDate().toString();
        summary.active = associate.getActive().toBoolean();
        return summary;
    }
}
