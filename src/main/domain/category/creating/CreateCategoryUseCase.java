package main.domain.category.creating;

import main.domain.Percentage;
import main.domain.Text;
import main.domain.category.Category;
import main.domain.category.CategoryRepository;

public class CreateCategoryUseCase {
    private final CategoryRepository repository;
    private final Text name;
    private final Text description;
    private final Percentage discount;
    private final CreateCategoryResponse response;

    public CreateCategoryUseCase(CategoryRepository repository, CreateCategoryRequest request, CreateCategoryResponse response) {
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
        repository.save(makeCategory());
        response.success = true;
    }

    private Category makeCategory() {
        Category category = new Category();
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
