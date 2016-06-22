package main.domain.category.reading;

import main.domain.category.Category;
import main.domain.category.CategoryRepository;

public class ReadCategoryUseCase {
	private final ReadCategoryRequest request;
    private final CategoryRepository repository;
    private final CategorySummary response;

    public ReadCategoryUseCase(CategoryRepository repository, ReadCategoryRequest request,
    		CategorySummary response) {
    	this.request = request;
        this.repository = repository;
        this.response = response;
    }

    public void execute() {
    	if(categoryExists())
    		sendCategory();
    }

	private boolean categoryExists() {
		return repository.hasWithId(request.id);
	}

	private void sendCategory() {
		Category category = repository.getById(request.id);
        response.id = category.getId();
        response.name = category.getName().toString();
        response.description = category.getDescription().toString();
        response.discount = category.getDiscount().toInt();
        response.needCodeAtInscription = category.getNeedCodeAtInscription().toBoolean();
	}
}
