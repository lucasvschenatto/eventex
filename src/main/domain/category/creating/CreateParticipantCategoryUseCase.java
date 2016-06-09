package main.domain.category.creating;

import main.domain.Percentage;
import main.domain.Text;
import main.domain.category.ParticipantCategory;
import main.domain.category.ParticipantCategoryRepository;

public class CreateParticipantCategoryUseCase {
    private final ParticipantCategoryRepository repository;
    private final Text name;
    private final Text description;
    private final Percentage discount;
    private final CreateParticipantCategoryResponse response;

    public CreateParticipantCategoryUseCase(ParticipantCategoryRepository repository, CreateParticipantCategoryRequest request, CreateParticipantCategoryResponse response) {
        this.repository = repository;
        name = new Text(request.name);
        description = new Text(request.description);
        discount = new Percentage(request.discount);
        this.response = response;
    }

    public void execute() {
        if (isValidRequest())
            create();
        else
            sendErrors();
    }

    private boolean isValidRequest() {
        return name.isValid() && description.isValid() && discount.isValid();
    }

    private void create() {
        repository.save(makeParticipantCategory());
        response.success = true;
    }

    private ParticipantCategory makeParticipantCategory() {
        ParticipantCategory category = new ParticipantCategory();
        category.setName(name);
        category.setDescription(description);
        category.setDiscount(discount);
        return category;
    }

    private void sendErrors() {
        response.invalidName = !name.isValid();
        response.invalidDescription = !description.isValid();
        response.invalidDiscount = !discount.isValid();
    }
}
