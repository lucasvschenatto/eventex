package main.domain.covenant.creating;

import main.domain.Booleanic;
import main.domain.Date;
import main.domain.Text;
import main.domain.category.ParticipantCategoryRepository;
import main.domain.covenant.Covenant;
import main.domain.covenant.CovenantRepository;
import main.persistence.EntityNotFoundException;

public class CreateCovenantUseCase {
    private final CovenantRepository covenantRepository;
    private final ParticipantCategoryRepository categoryRepository;
    private final Text categoryId;
    private final Text code;
    private final Text name;
    private final Date updateDate;
    private final Booleanic active;
    private final CreateCovenantResponse response;

    public CreateCovenantUseCase(CovenantRepository covenantRepository, ParticipantCategoryRepository categoryRepository, CreateCovenantRequest request, CreateCovenantResponse response) {
        this.covenantRepository = covenantRepository;
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
        covenantRepository.save(makeCovenant());
        response.success = true;
    }

    private Covenant makeCovenant() {
        Covenant covenant = new Covenant();
        covenant.setCategoryId(categoryId);
        covenant.setCode(code);
        covenant.setName(name);
        covenant.setUpdateDate(updateDate);
        covenant.setActive(active);
        return covenant;
    }

    private void sendErrors() {
    	response.invalidCategoryId = (!categoryId.isValid()) || (!categoryIdExists());
    	response.invalidCode = !code.isValid();
        response.invalidName = !name.isValid();
        response.invalidUpdateDate = !updateDate.isValid();
        response.invalidActive = !active.isValid();
    }
}
