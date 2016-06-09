package main.domain.covenant;

import main.domain.EntityTest;
import main.domain.Text;
import main.domain.Date;
import main.domain.Booleanic;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CovenantTest extends EntityTest<Covenant> {
    protected Covenant makeNewSubject() {
        return new Covenant();
    }

    protected Covenant makeSubjectWithData() {
        Covenant covenant = makeNewSubject();
        covenant.setCategoryId(new Text("1234567890"));
        covenant.setCode(new Text("code"));
        covenant.setName(new Text("name"));
        covenant.setUpdateDate(new Date("2015-01-01"));
        covenant.setActive(new Booleanic("true"));
        return covenant;
    }

    protected void assertSameData(Covenant entity, Covenant copy) {
        assertEquals(entity.getId(), copy.getId());
        assertEquals(entity.getCategoryId(), copy.getCategoryId());
        assertEquals(entity.getCode(), copy.getCode());
        assertEquals(entity.getName(), copy.getName());
        assertEquals(entity.getUpdateDate(), copy.getUpdateDate());
        assertEquals(entity.getActive(),copy.getActive());
    }

    @Test
    public void newCovenanttHasEmptyAttributes() {
        assertEquals(Text.EMPTY, subject.getCategoryId());
        assertEquals(Text.EMPTY, subject.getCode());
        assertEquals(Text.EMPTY, subject.getName());
        assertEquals(Date.MIN, subject.getUpdateDate());
        assertEquals(Booleanic.FALSE, subject.getActive());
    }
}