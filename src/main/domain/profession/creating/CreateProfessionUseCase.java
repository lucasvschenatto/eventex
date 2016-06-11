package main.domain.profession.creating;

import main.domain.Text;
import main.domain.profession.Profession;
import main.domain.profession.ProfessionRepository;

public class CreateProfessionUseCase {
    private final ProfessionRepository repository;
    private final Text name;
    private final Text description;
    private final CreateProfessionResponse response;

    public CreateProfessionUseCase(ProfessionRepository repository, CreateProfessionRequest request, CreateProfessionResponse response) {
        this.repository = repository;
        name = new Text(request.name);
        description = new Text(request.description);
        this.response = response;
    }

    public void execute() {
        if (isValidRequest())
            create();
        else
            sendErrors();
    }

    private boolean isValidRequest() {
        return name.isValid() && description.isValid();
    }

    private void create() {
        repository.save(makeProfession());
        response.success = true;
    }

    private Profession makeProfession() {
        Profession profession = new Profession();
        profession.setName(name);
        profession.setDescription(description);
        return profession;
    }

    private void sendErrors() {
        response.invalidName = !name.isValid();
        response.invalidDescription = !description.isValid();
    }
}
