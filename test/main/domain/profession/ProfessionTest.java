package main.domain.profession;

import main.domain.EntityTest;
import main.domain.Text;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ProfessionTest extends EntityTest<Profession> {
    protected Profession makeNewSubject() {
        return new Profession();
    }

    protected Profession makeSubjectWithData() {
        Profession profession = makeNewSubject();
        profession.setName(new Text("name"));
        profession.setDescription(new Text("description"));
        return profession;
    }

    protected void assertSameData(Profession entity, Profession copy) {
        assertEquals(entity.getId(), copy.getId());
        assertEquals(entity.getName(), copy.getName());
        assertEquals(entity.getDescription(), copy.getDescription());
    }

    @Test
    public void newParticipantProfessiontHasEmptyAttributes() {
        assertEquals(Text.EMPTY, subject.getName());
        assertEquals(Text.EMPTY, subject.getDescription());
    }
}