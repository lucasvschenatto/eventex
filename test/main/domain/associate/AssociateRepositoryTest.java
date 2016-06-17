package main.domain.associate;

import main.domain.Date;
import main.domain.Booleanic;
import main.domain.Repository;
import main.domain.RepositoryTest;
import main.domain.Text;
import main.domain.associate.Associate;
import main.domain.associate.AssociateRepository;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public abstract class AssociateRepositoryTest extends RepositoryTest<Associate> {
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
    
    private AssociateRepository repository;
    
    protected abstract AssociateRepository getRepository();

    protected Repository<Associate> getAbstractRepository() {
        return getRepository();
    }

    protected Associate makeNewEntity() {
        return new Associate();
    }

    protected Associate makeEntityWithId(String id) {
        Associate associate = new Associate();
        associate.setId(id);
        associate.setCategoryId(CATEGORY_ID1);
        associate.setCode(CODE1);
        associate.setName(NAME1);
        associate.setUpdateDate(UPDATE_DATE1);
        associate.setActive(ACTIVE1);
        return associate;
    }

    protected void changeEntity(Associate associate) {
    	associate.setCategoryId(CATEGORY_ID2);
        associate.setCode(CODE2);
        associate.setName(NAME2);
        associate.setUpdateDate(UPDATE_DATE2);
        associate.setActive(ACTIVE2);
    }

    protected void assertEntityHasSameValues(Associate original, Associate saved) {
        assertEquals(original.getId(), saved.getId());
        assertEquals(original.getCategoryId(), saved.getCategoryId());
        assertEquals(original.getCode(), saved.getCode());
        assertEquals(original.getName(), saved.getName());
        assertEquals(original.getUpdateDate(), saved.getUpdateDate());
        assertEquals(original.getActive(),saved.getActive());
    }

    protected void assertEntityDoesNotHaveSameValues(Associate original, Associate saved) {
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
    public void givenNoAssociates_returnsEmptyCollection() {
        Iterable<Associate> categories = repository.getAll();
        assertFalse(categories.iterator().hasNext());
    }

	@Test@SuppressWarnings("unused")
    public void givenTwoAssociates_itReturnsTheTwo() {
        repository.save(new Associate());
        repository.save(new Associate());
        Iterable<Associate> associates = repository.getAll();
        int counter = 0;
        for (Associate ignored : associates)
        	counter++;
        assertEquals(2, counter);
    }
	
	@Test
    public void usingGetByCode_theReturnedCategoryMustEqualTheSavedOne_butNotBeTheSame() {
        Associate associate = makeNewEntity();
        repository.save(associate);
        Associate savedAssociate = repository.getByCode(associate.getCode());
        assertNotSame(associate, savedAssociate);
        assertEntityHasSameValues(associate, savedAssociate);
    }
	
	@Test
    public void beforeSavingTheAssociate_repositoryDoesNotHaveIt() {
        assertFalse(repository.hasWithCode(new Text("UNIQUE_CODE")));
    }
	
	@Test
    public void afterSavingANewEntity_repositoryNowHasIt() {
        Associate associate = new Associate();
        associate.setCode(new Text("UNIQUE_CODE"));
        repository.save(associate);
        assertTrue(repository.hasWithCode(associate.getCode()));
    }
}
