package main.persistence.inmemory;

import main.domain.category.CategoryRepository;
import main.domain.category.CategoryRepositoryTest;

public class InMemoryCategoryRepositoryTest extends CategoryRepositoryTest{

	protected CategoryRepository getRepository() {
		return new InMemoryCategoryRepository();
	}

	@Override
	protected String getValidId() {
		return "1";
	}

	@Override
	protected String getInvalidId() {
		return "";
	}

}
