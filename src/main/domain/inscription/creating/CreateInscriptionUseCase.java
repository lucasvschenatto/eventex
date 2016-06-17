package main.domain.inscription.creating;

import main.domain.Text;
import main.domain.inscription.Inscription;
import main.domain.inscription.InscriptionRepository;

public class CreateInscriptionUseCase {
    private final InscriptionRepository repository;
    private final Text participantId;
    private final Text activityId;
    private final Text categoryId;
    private final Text associateCode;
    private final CreateInscriptionResponse response;

    public CreateInscriptionUseCase(InscriptionRepository repository, CreateInscriptionRequest request, CreateInscriptionResponse response) {
        this.repository = repository;
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

    private boolean isValidRequest() {
        return participantId.isValid() && activityId.isValid() && categoryId.isValid() && associateCode.isValid();
    }

    private void create() {
        repository.save(makeInscription());
        response.success = true;
    }

    private Inscription makeInscription() {
        Inscription inscription = new Inscription();
        inscription.setParticipantId(participantId);
        inscription.setActivityId(activityId);
        inscription.setCategoryId(categoryId);
        inscription.setAssociateCode(associateCode);
        return inscription;
    }

    private void sendErrors() {
        response.invalidParticipantId = !participantId.isValid();
        response.invalidActivityId = !activityId.isValid();
        response.invalidCategoryId = !categoryId.isValid();
        response.invalidAssociateCode = !associateCode.isValid();
    }
}
