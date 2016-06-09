package main.domain.covenant;

import main.domain.Date;
import main.domain.Booleanic;
import main.domain.Repository;
import main.domain.RepositoryTest;
import main.domain.Text;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public abstract class CovenantRepositoryTest extends RepositoryTest<Covenant> {
    private static final Text CATEGORY_ID1 = new Text("11111AaA");
    private static final Text CODE1 = new Text("COV1");
    private static final Text NAME1 = new Text("Name 1");
    private static final Date UPDATE_DATE1 = new Date("2011-01-01");
    private static final Booleanic ACTIVE1 = new Booleanic("false");
    
    private static final Text CATEGORY_ID2 = new Text("22222BbB");
    private static final Text CODE2 = new Text("COV2");
    private static final Text NAME2 = new Text("Name 2");
    private static final Date UPDATE_DATE2 = new Date("2022-02-02");
    private static final Booleanic ACTIVE2 = new Booleanic("true");
    
    private CovenantRepository repository;
    
    protected abstract CovenantRepository getRepository();

    protected Repository<Covenant> getAbstractRepository() {
        return getRepository();
    }

    protected Covenant makeNewEntity() {
        return new Covenant();
    }

    protected Covenant makeEntityWithId(String id) {
        Covenant covenant = new Covenant();
        covenant.setId(id);
        covenant.setCategoryId(CATEGORY_ID1);
        covenant.setCode(CODE1);
        covenant.setName(NAME1);
        covenant.setUpdateDate(UPDATE_DATE1);
        covenant.setActive(ACTIVE1);
        return covenant;
    }

    protected void changeEntity(Covenant covenant) {
    	covenant.setCategoryId(CATEGORY_ID2);
        covenant.setCode(CODE2);
        covenant.setName(NAME2);
        covenant.setUpdateDate(UPDATE_DATE2);
        covenant.setActive(ACTIVE2);
    }

    protected void assertEntityHasSameValues(Covenant original, Covenant saved) {
        assertEquals(original.getId(), saved.getId());
        assertEquals(original.getCategoryId(), saved.getCategoryId());
        assertEquals(original.getCode(), saved.getCode());
        assertEquals(original.getName(), saved.getName());
        assertEquals(original.getUpdateDate(), saved.getUpdateDate());
        assertEquals(original.getActive(),saved.getActive());
    }

    protected void assertEntityDoesNotHaveSameValues(Covenant original, Covenant saved) {
        assertEquals(original.getId(), saved.getId());
        assertNotEquals(original.getCategoryId(), saved.getCategoryId());
        assertNotEquals(original.getCode(), saved.getCode());
        assertNotEquals(original.getName(), saved.getName());
        assertNotEquals(original.getUpdateDate(), saved.getUpdateDate());
        assertNotEquals(original.getActive(),saved.getActive());
    }

    @Before
    public void setUp() throws Exception {
        super.setUp();
        repository = getRepository();
    }

    @Test
    public void givenNoCovenants_returnsEmptyCollection() {
        Iterable<Covenant> categories = repository.getAll();
        assertFalse(categories.iterator().hasNext());
    }

	@Test@SuppressWarnings("unused")
    public void givenTwoCovenants_itReturnsTheTwo() {
        repository.save(new Covenant());
        repository.save(new Covenant());
        Iterable<Covenant> covenants = repository.getAll();
        int counter = 0;
        for (Covenant ignored : covenants)
        	counter++;
        assertEquals(2, counter);
    }
}
