package main.domain.participantCategory;

import main.domain.Percentage;
import main.domain.Repository;
import main.domain.RepositoryTest;
import main.domain.Text;
import main.domain.participantCategory.ParticipantCategory;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public abstract class ParticipantCategoryRepositoryTest extends RepositoryTest<ParticipantCategory> {
    private static final Text NAME1 = new Text("Name 1");
    private static final Text DESCRIPTION1 = new Text("Description 1");
    private static final Percentage DISCOUNT1 = new Percentage("15");
    
    private static final Text NAME2 = new Text("Name 2");
    private static final Text DESCRIPTION2 = new Text("Description 2");
    private static final Percentage DISCOUNT2 = new Percentage("22");
    private ParticipantCategoryRepository repository;

    protected abstract ParticipantCategoryRepository getRepository();

    protected Repository<ParticipantCategory> getAbstractRepository() {
        return getRepository();
    }

    protected ParticipantCategory makeNewEntity() {
        return new ParticipantCategory();
    }

    protected ParticipantCategory makeEntityWithId(String id) {
        ParticipantCategory category = new ParticipantCategory();
        category.setId(id);
        category.setName(NAME1);
        category.setDescription(DESCRIPTION1);
        category.setDiscount(DISCOUNT1);
        return category;
    }

    protected void changeEntity(ParticipantCategory category) {
        category.setName(NAME2);
        category.setDescription(DESCRIPTION2);
        category.setDiscount(DISCOUNT2);
    }

    protected void assertEntityHasSameValues(ParticipantCategory original, ParticipantCategory saved) {
        assertEquals(original.getId(), saved.getId());
        assertEquals(original.getName(), saved.getName());
        assertEquals(original.getDescription(), saved.getDescription());
        assertEquals(original.getDiscount(),saved.getDiscount());
    }

    protected void assertEntityDoesNotHaveSameValues(ParticipantCategory original, ParticipantCategory saved) {
        assertEquals(original.getId(), saved.getId());
        assertNotEquals(original.getName(), saved.getName());
        assertNotEquals(original.getDescription(), saved.getDescription());
        assertNotEquals(original.getDiscount(),saved.getDiscount());
    }

    @Before
    public void setUp() throws Exception {
        super.setUp();
        repository = getRepository();
    }

    @Test
    public void givenNoParticipantCategorys_returnsEmptyCollection() {
        Iterable<ParticipantCategory> categories = repository.getAll();
        assertFalse(categories.iterator().hasNext());
    }

	@Test@SuppressWarnings("unused")
    public void givenTwoParticipantCategorys_itReturnsTheTwo() {
        repository.save(new ParticipantCategory());
        repository.save(new ParticipantCategory());
        Iterable<ParticipantCategory> categories = repository.getAll();
        int counter = 0;
        for (ParticipantCategory ignored : categories)
        	counter++;
        assertEquals(2, counter);
    }
}
