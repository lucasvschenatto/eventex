package main.domain.category.reading;

import java.util.Collection;

import main.domain.category.Category;
import main.domain.category.CategoryRepository;

public class ReadCategoriesSummaryUseCase {
    private final CategoryRepository repository;
    private final Collection<CategorySummary> response;

    public ReadCategoriesSummaryUseCase(CategoryRepository repository,
    		Collection<CategorySummary> response) {
        this.repository = repository;
        this.response = response;
    }

    public void execute() {
        for (Category category : repository.getAll())
            response.add(makeParticipantCategorySummary(category));
    }

    private CategorySummary makeParticipantCategorySummary(Category category) {
        CategorySummary summary = new CategorySummary();
        summary.id = category.getId();
        summary.name = category.getName().toString();
        summary.description = category.getDescription().toString();
        summary.discount = category.getDiscount().toInt();
        summary.needCodeAtInscription = category.getNeedCodeAtInscription().toBoolean();
        return summary;
    }
}
