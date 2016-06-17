package main.domain.inscription;

import main.domain.Text;
import main.domain.EntityTest;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class InscriptionTest extends EntityTest<Inscription> {
    protected Inscription makeNewSubject() {
        return new Inscription();
    }

    protected Inscription makeSubjectWithData() {
        Inscription inscription = makeNewSubject();
        inscription.setParticipantId(new Text("participant1"));
        inscription.setActivityId(new Text("activity1"));
        inscription.setCategoryId(new Text("category1"));
        inscription.setAssociateCode(new Text("PUCRS2016"));
        return inscription;
    }

    protected void assertSameData(Inscription entity, Inscription copy) {
        assertEquals(entity.getId(), copy.getId());
        assertEquals(entity.getParticipantId(), copy.getParticipantId());
        assertEquals(entity.getActivityId(), copy.getActivityId());
        assertEquals(entity.getCategoryId(),copy.getCategoryId());
        assertEquals(entity.getAssociateCode(), copy.getAssociateCode());
    }

    @Test
    public void newParticipantInscriptiontHasEmptyAttributes() {
        assertEquals(Text.EMPTY, subject.getParticipantId());
        assertEquals(Text.EMPTY, subject.getActivityId());
        assertEquals(Text.EMPTY, subject.getCategoryId());
        assertEquals(Text.EMPTY, subject.getAssociateCode());
    }
}