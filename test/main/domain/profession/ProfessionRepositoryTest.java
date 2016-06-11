package main.domain.profession;

import main.domain.Repository;
import main.domain.RepositoryTest;
import main.domain.Text;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public abstract class ProfessionRepositoryTest extends RepositoryTest<Profession> {
    private static final Text NAME1 = new Text("Name 1");
    private static final Text DESCRIPTION1 = new Text("Description 1");
    
    private static final Text NAME2 = new Text("Name 2");
    private static final Text DESCRIPTION2 = new Text("Description 2");
    private ProfessionRepository repository;

    protected abstract ProfessionRepository getRepository();

    protected Repository<Profession> getAbstractRepository() {
        return getRepository();
    }

    protected Profession makeNewEntity() {
        return new Profession();
    }

    protected Profession makeEntityWithId(String id) {
        Profession profession = new Profession();
        profession.setId(id);
        profession.setName(NAME1);
        profession.setDescription(DESCRIPTION1);
        return profession;
    }

    protected void changeEntity(Profession profession) {
        profession.setName(NAME2);
        profession.setDescription(DESCRIPTION2);
    }

    protected void assertEntityHasSameValues(Profession original, Profession saved) {
        assertEquals(original.getId(), saved.getId());
        assertEquals(original.getName(), saved.getName());
        assertEquals(original.getDescription(), saved.getDescription());
    }

    protected void assertEntityDoesNotHaveSameValues(Profession original, Profession saved) {
        assertEquals(original.getId(), saved.getId());
        assertNotEquals(original.getName(), saved.getName());
        assertNotEquals(original.getDescription(), saved.getDescription());
    }

    @Before
    public void setUp() throws Exception {
        super.setUp();
        repository = getRepository();
    }

    @Test
    public void givenNoParticipantProfessions_returnsEmptyCollection() {
        Iterable<Profession> categories = repository.getAll();
        assertFalse(categories.iterator().hasNext());
    }

	@Test@SuppressWarnings("unused")
    public void givenTwoParticipantProfessions_itReturnsTheTwo() {
        repository.save(new Profession());
        repository.save(new Profession());
        Iterable<Profession> categories = repository.getAll();
        int counter = 0;
        for (Profession ignored : categories)
        	counter++;
        assertEquals(2, counter);
    }
}
