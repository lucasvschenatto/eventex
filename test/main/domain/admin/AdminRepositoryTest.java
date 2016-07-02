package main.domain.admin;

import main.domain.Repository;
import main.domain.RepositoryTest;
import main.domain.Text;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public abstract class AdminRepositoryTest extends RepositoryTest<Admin> {
    private static final Text NAME1 = new Text("Name 1");
    private static final Text USER_ID1 = new Text("userId 1");
    private static final Text ROLE1 = new Text("role 1");
    
    private static final Text NAME2 = new Text("Name 2");
    private static final Text USER_ID2 = new Text("userId 2");
    private static final Text ROLE2 = new Text("role 2");

    private AdminRepository repository;

    protected abstract AdminRepository getRepository();

	protected Repository<Admin> getAbstractRepository() {
        return getRepository();
    }

    protected Admin makeNewEntity() {
        return new Admin();
    }

    protected Admin makeEntityWithId(String id) {
        Admin admin = new Admin();
        admin.setId(id);
        admin.setName(NAME1);
        admin.setUserId(USER_ID1);
        admin.setRole(ROLE1);
        return admin;
    }

    protected void changeEntity(Admin admin) {
        admin.setName(NAME2);
        admin.setUserId(USER_ID2);
        admin.setRole(ROLE2);
    }

    protected void assertEntityHasSameValues(Admin original, Admin saved) {
        assertEquals(original.getId(), saved.getId());
        assertEquals(original.getName(), saved.getName());
        assertEquals(original.getUserId(), saved.getUserId());
        assertEquals(original.getRole(), saved.getRole());
    }

    protected void assertEntityDoesNotHaveSameValues(Admin original, Admin saved) {
        assertEquals(original.getId(), saved.getId());
        assertNotEquals(original.getName(), saved.getName());
        assertNotEquals(original.getUserId(), saved.getUserId());
        assertNotEquals(original.getRole(), saved.getRole());

    }

    @Before
    public void setUp() throws Exception {
        super.setUp();
        repository = getRepository();
    }

    @Test
    public void givenNoAdmins_returnsEmptyCollection() {
        Iterable<Admin> admins = repository.getAll();
        assertFalse(admins.iterator().hasNext());
    }

	@Test@SuppressWarnings("unused")
    public void givenTwoAdmins_itReturnsTheTwo() {
        repository.save(new Admin());
        repository.save(new Admin());
        Iterable<Admin> admins = repository.getAll();
        int counter = 0;
        for (Admin ignored : admins)
        	counter++;
        assertEquals(2, counter);
    }
}
