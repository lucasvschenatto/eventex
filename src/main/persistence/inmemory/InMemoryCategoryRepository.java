package main.persistence.inmemory;

import main.domain.category.Category;
import main.domain.category.CategoryRepository;

public class InMemoryCategoryRepository extends InMemoryRepository<Category> implements CategoryRepository {
}
