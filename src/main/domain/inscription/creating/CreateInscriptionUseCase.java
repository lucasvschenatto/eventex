package main.domain.inscription.creating;

import main.domain.Text;
import main.domain.activity.ActivityRepository;
import main.domain.associate.Associate;
import main.domain.associate.AssociateRepository;
import main.domain.category.Category;
import main.domain.category.CategoryRepository;
import main.domain.inscription.Inscription;
import main.domain.inscription.InscriptionRepository;
import main.domain.participant.ParticipantRepository;

public class CreateInscriptionUseCase {
    protected final InscriptionRepository inscriptionRepository;
    private final ParticipantRepository participantRepository;
    private final ActivityRepository activityRepository;
    private final CategoryRepository categoryRepository;
    private final AssociateRepository associateRepository;
    private final Text participantId;
    private final Text activityId;
    private final Text categoryId;
    private final Text associateCode;
    protected final CreateInscriptionResponse response;

    public CreateInscriptionUseCase(InscriptionRepository inscriptionRepository,
    		ParticipantRepository participantRepository, ActivityRepository activityRepository,
    		CategoryRepository categoryRepository, AssociateRepository associateRepository,
    		CreateInscriptionRequest request, CreateInscriptionResponse response) {
        this.inscriptionRepository = inscriptionRepository;
        this.participantRepository = participantRepository;
        this.activityRepository = activityRepository;
        this.categoryRepository = categoryRepository;
        this.associateRepository = associateRepository;
        participantId = new Text(request.participantId);
        activityId = new Text(request.activityId);
        categoryId = new Text(request.categoryId);
        associateCode = new Text(request.associateCode);
        this.response = response;
    }

    public void execute() {
        if (isValidRequest())
            create();
        else
            sendErrors();
    }

    protected boolean isValidRequest() {
        return isValidFields() && referencedIdsExist() && associateCodeIsCorrect();
    }

	private boolean associateCodeIsCorrect() {
		Category c = categoryRepository.getById(categoryId.toString());
		if(c.getNeedCodeAtInscription().toBoolean()){
			if(associateRepository.hasWithCode(associateCode)){
				Associate a = associateRepository.getByCode(associateCode);
				return a.getCategoryId().equals(categoryId);
			}else
				return false;
		}
		else
			return associateCode.toString().equals("");
	}

	private boolean isValidFields() {
		return participantId.isValid() && activityId.isValid() && categoryId.isValid();
	}
	
	private boolean referencedIdsExist() {
		if(participantExists() && activityExists() && categoryExists())
			return true;
		else
			return false;
	}

	private boolean categoryExists() {
		return categoryRepository.hasWithId(categoryId.toString());
	}

	private boolean activityExists() {
		return activityRepository.hasWithId(activityId.toString());
	}

	private boolean participantExists() {
		return participantRepository.hasWithId(participantId.toString());
	}

	private void create() {
        inscriptionRepository.save(makeInscription());
        response.success = true;
    }

    protected Inscription makeInscription() {
        Inscription inscription = new Inscription();
        inscription.setParticipantId(participantId);
        inscription.setActivityId(activityId);
        inscription.setCategoryId(categoryId);
        inscription.setAssociateCode(associateCode);
        return inscription;
    }

    protected void sendErrors() {
        response.invalidParticipantId = !isParticipantValid();
        response.invalidActivityId = !isActivityValid();
        response.invalidCategoryId = !isCategoryIdValid();
        response.invalidAssociateCode = !isAssociateCodeValid();
    }

	private boolean isParticipantValid() {
		return participantId.isValid() && participantExists();
	}
	
	private boolean isActivityValid() {
		return activityId.isValid() && activityExists();
	}
	
	private boolean isCategoryIdValid() {
		return categoryId.isValid() && categoryExists();
	}

	private boolean isAssociateCodeValid() {
		if(categoryExists())
			return associateCodeIsCorrect();
		else
			return !associateCode.isValid();
	}

	
}
