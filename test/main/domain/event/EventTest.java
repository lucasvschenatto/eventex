package main.domain.event;

import main.domain.EntityTest;
import main.domain.Text;
import main.domain.event.Event;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class EventTest extends EntityTest<Event> {
    protected Event makeNewSubject() {
        return new Event();
    }

    protected Event makeSubjectWithData() {
        Event product = makeNewSubject();
        product.setName(new Text("name"));
        product.setDescription(new Text("description"));
        product.setDate(new Text("1900-01-01"));
        product.setTime(new Text("6:59:59"));
        product.setPlace(new Text("place"));
        product.setAddress(new Text("address"));
        return product;
    }

    protected void assertSameData(Event entity, Event copy) {
        assertEquals(entity.getId(), copy.getId());
        assertEquals(entity.getName(), copy.getName());
        assertEquals(entity.getDescription(), copy.getDescription());
        assertEquals(entity.getDate(),copy.getDate());
        assertEquals(entity.getTime(),copy.getTime());
        assertEquals(entity.getPlace(),copy.getPlace());
        assertEquals(entity.getAddress(),copy.getAddress());
    }

    @Test
    public void newEventtHasEmptyAttributes() {
        assertEquals(Text.EMPTY, subject.getName());
        assertEquals(Text.EMPTY, subject.getDescription());
        assertEquals(Text.EMPTY, subject.getDate());
        assertEquals(Text.EMPTY,subject.getTime());
        assertEquals(Text.EMPTY,subject.getPlace());
        assertEquals(Text.EMPTY,subject.getAddress());
    }
}