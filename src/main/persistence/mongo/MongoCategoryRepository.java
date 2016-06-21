package main.persistence.mongo;

import main.domain.category.Category;
import main.domain.category.CategoryRepository;

public class MongoCategoryRepository extends MongoRepository<Category> implements CategoryRepository {

	protected MongoCategoryRepository() {
		super("categories", null);
		// TODO Auto-generated constructor stub
	}
}
