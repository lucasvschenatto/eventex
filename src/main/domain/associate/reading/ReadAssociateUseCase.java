package main.domain.associate.reading;

import main.domain.associate.Associate;
import main.domain.associate.AssociateRepository;

public class ReadAssociateUseCase {
	private final String id;
    private final AssociateRepository repository;
    private final AssociateSummary response;

    public ReadAssociateUseCase(AssociateRepository repository, ReadAssociateRequest request,
    		AssociateSummary response) {
    	id = request.id;
        this.repository = repository;
        this.response = response;
    }

    public void execute() {
    	if(associateExists())
    		sendAssociate();
    }

	private boolean associateExists() {
		return repository.hasWithId(id);
	}

	private void sendAssociate() {
		Associate associate = repository.getById(id);
        response.id = associate.getId();
        response.categoryId = associate.getCategoryId().toString();
        response.code = associate.getCode().toString();
        response.name = associate.getName().toString();
        response.updateDate = associate.getUpdateDate().toString();
        response.active = associate.getActive().toBoolean();
	}
}
