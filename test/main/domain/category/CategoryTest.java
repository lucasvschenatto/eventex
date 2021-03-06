package main.domain.category;

import main.domain.Booleanic;
import main.domain.EntityTest;
import main.domain.Percentage;
import main.domain.Text;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CategoryTest extends EntityTest<Category> {
    protected Category makeNewSubject() {
        return new Category();
    }

    protected Category makeSubjectWithData() {
        Category category = makeNewSubject();
        category.setName(new Text("name"));
        category.setDescription(new Text("description"));
        category.setDiscount(new Percentage("50"));
        category.setNeedCodeAtInscription(new Booleanic("true"));
        return category;
    }

    protected void assertSameData(Category entity, Category copy) {
        assertEquals(entity.getId(), copy.getId());
        assertEquals(entity.getName(), copy.getName());
        assertEquals(entity.getDescription(), copy.getDescription());
        assertEquals(entity.getDiscount(),copy.getDiscount());
        assertEquals(entity.getNeedCodeAtInscription(), copy.getNeedCodeAtInscription());
    }

    @Test
    public void newParticipantCategorytHasEmptyAttributes() {
        assertEquals(Text.EMPTY, subject.getName());
        assertEquals(Text.EMPTY, subject.getDescription());
        assertEquals(Percentage.ZERO, subject.getDiscount());
        assertEquals(Booleanic.FALSE, subject.getNeedCodeAtInscription());
    }
}