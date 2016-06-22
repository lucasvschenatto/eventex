package main.persistence.mongo;

import main.domain.category.Category;
import main.domain.category.CategoryRepository;
import main.persistence.mongo.converters.CategoryConverter;

public class MongoCategoryRepository extends MongoRepository<Category> implements CategoryRepository {

	protected MongoCategoryRepository() {
		super("categories", new CategoryConverter());
	}
}
