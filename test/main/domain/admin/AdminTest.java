package main.domain.admin;

import main.domain.EntityTest;
import main.domain.Text;
import static org.junit.Assert.*;

import org.junit.Test;

public class AdminTest extends EntityTest<Admin> {
    protected Admin makeNewSubject() {
        return new Admin();
    }

    protected Admin makeSubjectWithData() {
        Admin admin = makeNewSubject();
        admin.setName(new Text("name lastname"));
        admin.setUserId(new Text("123456789"));
        admin.setRole(new Text("job role"));
        return admin;
    }

	protected void assertSameData(Admin entity, Admin copy) {
        assertEquals(entity.getId(), copy.getId());
        assertEquals(entity.getName(), copy.getName());
        assertEquals(entity.getUserId(), copy.getUserId());
        assertEquals(entity.getRole(), copy.getRole());
    }
    @Test
    public void newAdmintHasEmptyAttributes() {
    	assertEquals( Text.EMPTY, subject.getName());
    	assertEquals( Text.EMPTY, subject.getUserId());
    	assertEquals( Text.EMPTY, subject.getRole());
    }
}