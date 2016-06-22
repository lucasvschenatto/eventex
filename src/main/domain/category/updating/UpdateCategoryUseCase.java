package main.domain.category.updating;

import main.domain.category.Category;
import main.domain.category.CategoryRepository;
import main.domain.category.creating.CreateCategoryUseCase;
import main.persistence.EntityNotFoundException;

public class UpdateCategoryUseCase extends CreateCategoryUseCase{
    private final String id;

    public UpdateCategoryUseCase(CategoryRepository repository, UpdateCategoryRequest request, UpdateCategoryResponse response) {
    	super(repository, request, response);
    	this.id = request.id;
    }
    
    protected boolean isValidRequest() {
        return super.isValidRequest() && idExists();
    }

    private boolean idExists() {
    	try{
    		repository.getById(id);   
    		return true;
    	}
    	catch(EntityNotFoundException ignored){
    		return false;
    	}
	}

    protected Category makeCategory() {
        Category category = super.makeCategory();
        category.setId(id);
        return category;
    }

    protected void sendErrors() {
    	super.sendErrors();
        ((UpdateCategoryResponse)response).invalidId = ! idExists();
    }
}
