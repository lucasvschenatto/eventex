package main.domain.associate.reading;

import java.util.Collection;

import main.domain.Text;
import main.domain.associate.Associate;
import main.domain.associate.AssociateRepository;

public class ReadAssociatesFilterUseCase {
    private final AssociateRepository repository;
    private final ReadAssociatesFilterRequest request;
    private final Collection<AssociateSummary> response;

    public ReadAssociatesFilterUseCase(AssociateRepository repository, ReadAssociatesFilterRequest request,
    		Collection<AssociateSummary> response) {
        this.repository = repository;
        this.request = request;
        this.response = response;
    }

    public void execute() {
        for (Associate associate : repository.getAllForCategoryId(new Text(request.categoryId)))
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
