package main.domain.associate;

import main.domain.EntityTest;
import main.domain.Text;
import main.domain.associate.Associate;
import main.domain.Date;
import main.domain.Booleanic;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class AssociateTest extends EntityTest<Associate> {
    protected Associate makeNewSubject() {
        return new Associate();
    }

    protected Associate makeSubjectWithData() {
        Associate associate = makeNewSubject();
        associate.setCategoryId(new Text("1234567890"));
        associate.setCode(new Text("code"));
        associate.setName(new Text("name"));
        associate.setUpdateDate(new Date("2015-01-01"));
        associate.setActive(new Booleanic("true"));
        return associate;
    }

    protected void assertSameData(Associate entity, Associate copy) {
        assertEquals(entity.getId(), copy.getId());
        assertEquals(entity.getCategoryId(), copy.getCategoryId());
        assertEquals(entity.getCode(), copy.getCode());
        assertEquals(entity.getName(), copy.getName());
        assertEquals(entity.getUpdateDate(), copy.getUpdateDate());
        assertEquals(entity.getActive(),copy.getActive());
    }

    @Test
    public void newAssociatetHasEmptyAttributes() {
        assertEquals(Text.EMPTY, subject.getCategoryId());
        assertEquals(Text.EMPTY, subject.getCode());
        assertEquals(Text.EMPTY, subject.getName());
        assertEquals(Date.MIN, subject.getUpdateDate());
        assertEquals(Booleanic.FALSE, subject.getActive());
    }
}