package main.domain.inscription.reading;

import java.util.Collection;

import main.domain.inscription.Inscription;
import main.domain.inscription.InscriptionRepository;

public class ReadInscriptionsSummaryUseCase {
    private final InscriptionRepository repository;
    private final Collection<InscriptionSummary> response;

    public ReadInscriptionsSummaryUseCase(InscriptionRepository repository,
    		Collection<InscriptionSummary> response) {
        this.repository = repository;
        this.response = response;
    }

    public void execute() {
        for (Inscription inscription : repository.getAll())
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
