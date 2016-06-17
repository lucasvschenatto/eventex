package main.domain.category;

import main.domain.Booleanic;
import main.domain.Percentage;
import main.domain.Repository;
import main.domain.RepositoryTest;
import main.domain.Text;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public abstract class CategoryRepositoryTest extends RepositoryTest<Category> {
    private static final Text NAME1 = new Text("Name 1");
    private static final Text DESCRIPTION1 = new Text("Description 1");
    private static final Percentage DISCOUNT1 = new Percentage("15");
    private static final Booleanic NEED_CODE_AT_INSCRIPTION1 = new Booleanic("false");
    
    private static final Text NAME2 = new Text("Name 2");
    private static final Text DESCRIPTION2 = new Text("Description 2");
    private static final Percentage DISCOUNT2 = new Percentage("22");
    private static final Booleanic NEED_CODE_AT_INSCRIPTION2 = new Booleanic("true");
    private CategoryRepository repository;

    protected abstract CategoryRepository getRepository();

    protected Repository<Category> getAbstractRepository() {
        return getRepository();
    }

    protected Category makeNewEntity() {
        return new Category();
    }

    protected Category makeEntityWithId(String id) {
        Category category = new Category();
        category.setId(id);
        category.setName(NAME1);
        category.setDescription(DESCRIPTION1);
        category.setDiscount(DISCOUNT1);
        category.setNeedCodeAtInscription(NEED_CODE_AT_INSCRIPTION1);
        return category;
    }

    protected void changeEntity(Category category) {
        category.setName(NAME2);
        category.setDescription(DESCRIPTION2);
        category.setDiscount(DISCOUNT2);
        category.setNeedCodeAtInscription(NEED_CODE_AT_INSCRIPTION2);
    }

    protected void assertEntityHasSameValues(Category original, Category saved) {
        assertEquals(original.getId(), saved.getId());
        assertEquals(original.getName(), saved.getName());
        assertEquals(original.getDescription(), saved.getDescription());
        assertEquals(original.getDiscount(),saved.getDiscount());
        assertEquals(original.getNeedCodeAtInscription(), saved.getNeedCodeAtInscription());
    }

    protected void assertEntityDoesNotHaveSameValues(Category original, Category saved) {
        assertEquals(original.getId(), saved.getId());
        assertNotEquals(original.getName(), saved.getName());
        assertNotEquals(original.getDescription(), saved.getDescription());
        assertNotEquals(original.getDiscount(),saved.getDiscount());
        assertNotEquals(original.getNeedCodeAtInscription(), saved.getNeedCodeAtInscription());
    }

    @Before
    public void setUp() throws Exception {
        super.setUp();
        repository = getRepository();
    }

    @Test
    public void givenNoParticipantCategorys_returnsEmptyCollection() {
        Iterable<Category> categories = repository.getAll();
        assertFalse(categories.iterator().hasNext());
    }

	@Test@SuppressWarnings("unused")
    public void givenTwoParticipantCategorys_itReturnsTheTwo() {
        repository.save(new Category());
        repository.save(new Category());
        Iterable<Category> categories = repository.getAll();
        int counter = 0;
        for (Category ignored : categories)
        	counter++;
        assertEquals(2, counter);
    }
	
}
