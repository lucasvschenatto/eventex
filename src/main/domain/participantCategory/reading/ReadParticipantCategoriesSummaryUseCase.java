package main.domain.participantCategory.reading;

import java.util.Collection;

import main.domain.participantCategory.ParticipantCategory;
import main.domain.participantCategory.ParticipantCategoryRepository;

public class ReadParticipantCategoriesSummaryUseCase {
    private final ParticipantCategoryRepository repository;
    private final Collection<ParticipantCategorySummary> response;

    public ReadParticipantCategoriesSummaryUseCase(ParticipantCategoryRepository repository,
    		Collection<ParticipantCategorySummary> response) {
        this.repository = repository;
        this.response = response;
    }

    public void execute() {
        for (ParticipantCategory category : repository.getAll())
            response.add(makeParticipantCategorySummary(category));
    }

    private ParticipantCategorySummary makeParticipantCategorySummary(ParticipantCategory category) {
        ParticipantCategorySummary summary = new ParticipantCategorySummary();
        summary.id = category.getId();
        summary.name = category.getName().toString();
        summary.description = category.getDescription().toString();
        summary.discount = category.getDiscount().toInt();
        return summary;
    }
}
