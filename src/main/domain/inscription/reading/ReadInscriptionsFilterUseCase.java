package main.domain.inscription.reading;

import java.util.Collection;

import main.domain.Text;
import main.domain.inscription.Inscription;
import main.domain.inscription.InscriptionRepository;

public class ReadInscriptionsFilterUseCase {
    private final InscriptionRepository repository;
    private final ReadInscriptionsFilterRequest request;
    private final Collection<InscriptionSummary> response;

    public ReadInscriptionsFilterUseCase(InscriptionRepository repository, ReadInscriptionsFilterRequest request,
    		Collection<InscriptionSummary> response) {
        this.repository = repository;
        this.request = request;
        this.response = response;
    }

    public void execute() {
        for (Inscription inscription : repository.getAllForActivityId(new Text(request.activityId)))
            response.add(makeParticipantInscriptionSummary(inscription));
    }

    private InscriptionSummary makeParticipantInscriptionSummary(Inscription inscription) {
        InscriptionSummary summary = new InscriptionSummary();
        summary.id = inscription.getId();
        summary.participantId = inscription.getParticipantId().toString();
        summary.activityId = inscription.getActivityId().toString();
        summary.categoryId = inscription.getCategoryId().toString();
        summary.associateCode = inscription.getAssociateCode().toString();
        return summary;
    }
}
