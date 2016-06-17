package main.domain.inscription;

import main.domain.Repository;
import main.domain.RepositoryTest;
import main.domain.Text;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public abstract class InscriptionRepositoryTest extends RepositoryTest<Inscription> {
    private static final Text PARTICIPANT_ID1 = new Text("participant1");
    private static final Text ACTIVITY_ID1 = new Text("activity1");
    private static final Text CATEGORY_ID1 = new Text("category1");
    private static final Text ASSOCIATE_CODE1 = new Text("CODE_YES");
    
    private static final Text PARTICIPANT_ID2 = new Text("participant2");
    private static final Text ACTIVITY_ID2 = new Text("activity2");
    private static final Text CATEGORY_ID2 = new Text("category2");
    private static final Text ASSOCIATE_CODE2 = new Text("CODE_NO");
    private InscriptionRepository repository;

    protected abstract InscriptionRepository getRepository();

    protected Repository<Inscription> getAbstractRepository() {
        return getRepository();
    }

    protected Inscription makeNewEntity() {
        return new Inscription();
    }

    protected Inscription makeEntityWithId(String id) {
        Inscription category = new Inscription();
        category.setId(id);
        category.setParticipantId(PARTICIPANT_ID1);
        category.setActivityId(ACTIVITY_ID1);
        category.setCategoryId(CATEGORY_ID1);
        category.setAssociateCode(ASSOCIATE_CODE1);
        return category;
    }

    protected void changeEntity(Inscription category) {
        category.setParticipantId(PARTICIPANT_ID2);
        category.setActivityId(ACTIVITY_ID2);
        category.setCategoryId(CATEGORY_ID2);
        category.setAssociateCode(ASSOCIATE_CODE2);
    }

    protected void assertEntityHasSameValues(Inscription original, Inscription saved) {
        assertEquals(original.getId(), saved.getId());
        assertEquals(original.getParticipantId(), saved.getParticipantId());
        assertEquals(original.getActivityId(), saved.getActivityId());
        assertEquals(original.getCategoryId(),saved.getCategoryId());
        assertEquals(original.getAssociateCode(), saved.getAssociateCode());
    }

    protected void assertEntityDoesNotHaveSameValues(Inscription original, Inscription saved) {
        assertEquals(original.getId(), saved.getId());
        assertNotEquals(original.getParticipantId(), saved.getParticipantId());
        assertNotEquals(original.getActivityId(), saved.getActivityId());
        assertNotEquals(original.getCategoryId(),saved.getCategoryId());
        assertNotEquals(original.getAssociateCode(), saved.getAssociateCode());
    }

    @Before
    public void setUp() throws Exception {
        super.setUp();
        repository = getRepository();
    }

    @Test
    public void givenNoParticipantCategorys_returnsEmptyCollection() {
        Iterable<Inscription> categories = repository.getAll();
        assertFalse(categories.iterator().hasNext());
    }

	@Test@SuppressWarnings("unused")
    public void givenTwoParticipantCategorys_itReturnsTheTwo() {
        repository.save(new Inscription());
        repository.save(new Inscription());
        Iterable<Inscription> categories = repository.getAll();
        int counter = 0;
        for (Inscription ignored : categories)
        	counter++;
        assertEquals(2, counter);
    }
}
