package main.domain.participantCategory;

import main.domain.EntityTest;
import main.domain.Percentage;
import main.domain.Text;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ParticipantCategoryTest extends EntityTest<ParticipantCategory> {
    protected ParticipantCategory makeNewSubject() {
        return new ParticipantCategory();
    }

    protected ParticipantCategory makeSubjectWithData() {
        ParticipantCategory category = makeNewSubject();
        category.setName(new Text("name"));
        category.setDescription(new Text("description"));
        category.setDiscount(new Percentage("50"));
        return category;
    }

    protected void assertSameData(ParticipantCategory entity, ParticipantCategory copy) {
        assertEquals(entity.getId(), copy.getId());
        assertEquals(entity.getName(), copy.getName());
        assertEquals(entity.getDescription(), copy.getDescription());
        assertEquals(entity.getDiscount(),copy.getDiscount());
    }

    @Test
    public void newParticipantCategorytHasEmptyAttributes() {
        assertEquals(Text.EMPTY, subject.getName());
        assertEquals(Text.EMPTY, subject.getDescription());
        assertEquals(Percentage.ZERO, subject.getDiscount());
    }
}