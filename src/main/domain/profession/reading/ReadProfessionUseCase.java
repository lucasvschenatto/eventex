package main.domain.profession.reading;

import main.domain.profession.Profession;
import main.domain.profession.ProfessionRepository;

public class ReadProfessionUseCase {
	private final ReadProfessionRequest request;
    private final ProfessionRepository repository;
    private final ProfessionSummary response;

    public ReadProfessionUseCase(ProfessionRepository repository, ReadProfessionRequest request,
    		ProfessionSummary response) {
    	this.request = request;
        this.repository = repository;
        this.response = response;
    }

    public void execute() {
    	if(professionExists())
    		sendProfession();
    }

    private boolean professionExists() {
		return repository.hasWithId(request.id);
	}

	private void sendProfession() {
		Profession profession = repository.getById(request.id);
        response.id = profession.getId();
        response.name = profession.getName().toString();
        response.description = profession.getDescription().toString();
    }
}
