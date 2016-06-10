package main.domain.associate.creating;

import main.domain.Booleanic;
import main.domain.Date;
import main.domain.Text;
import main.domain.associate.Associate;
import main.domain.associate.AssociateRepository;
import main.domain.category.CategoryRepository;
import main.persistence.EntityNotFoundException;

public class CreateAssociateUseCase {
    private final AssociateRepository associateRepository;
    private final CategoryRepository categoryRepository;
    private final Text categoryId;
    private final Text code;
    private final Text name;
    private final Date updateDate;
    private final Booleanic active;
    private final CreateAssociateResponse response;

    public CreateAssociateUseCase(AssociateRepository associateRepository, CategoryRepository categoryRepository, CreateAssociateRequest request, CreateAssociateResponse response) {
        this.associateRepository = associateRepository;
        this.categoryRepository = categoryRepository;
        categoryId = new Text(request.categoryId);
        code = new Text(request.code);
        name = new Text(request.name);
        updateDate = new Date(request.updateDate);
        active = new Booleanic(request.active);
        this.response = response;
    }

    public void execute() {
        if (isValidRequest())
            create();
        else
            sendErrors();
    }

    private boolean isValidRequest() {
        return isValidFields() && categoryIdExists();
    }
    
    private boolean isValidFields(){
    	return categoryId.isValid() && code.isValid() && name.isValid() &&
        		updateDate.isValid() && active.isValid();
    }
    
    private boolean categoryIdExists(){
    	try{
    		categoryRepository.getById(categoryId.toString());
    		return true;
    	}catch(EntityNotFoundException ignored){
    		return false;
    	}
    }

    private void create() {
        associateRepository.save(makeCovenant());
        response.success = true;
    }

    private Associate makeCovenant() {
        Associate associate = new Associate();
        associate.setCategoryId(categoryId);
        associate.setCode(code);
        associate.setName(name);
        associate.setUpdateDate(updateDate);
        associate.setActive(active);
        return associate;
    }

    private void sendErrors() {
    	response.invalidCategoryId = (!categoryId.isValid()) || (!categoryIdExists());
    	response.invalidCode = !code.isValid();
        response.invalidName = !name.isValid();
        response.invalidUpdateDate = !updateDate.isValid();
        response.invalidActive = !active.isValid();
    }
}
