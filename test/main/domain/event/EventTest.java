package main.domain.event;

import main.domain.CEP;
import main.domain.Date;
import main.domain.EntityTest;
import main.domain.IntNumber;
import main.domain.Text;
import main.domain.Time;
import main.domain.event.Event;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class EventTest extends EntityTest<Event> {
    protected Event makeNewSubject() {
        return new Event();
    }

    protected Event makeSubjectWithData() {
        Event event = makeNewSubject();
        event.setName(new Text("name"));
        event.setDescription(new Text("description"));
        event.setDate(new Date("1900-01-01"));
        event.setTime(new Time("6:59:59"));
        event.setPlace(new Text("place"));
        event.setStreet(new Text("street"));
        event.setNumber(new IntNumber("1"));
        event.setComplement(new Text("complement"));
        event.setNeighborhood(new Text("neighborhood"));
        event.setCity(new Text("city"));
        event.setState(new Text("state"));
        event.setCEP(new CEP("11111-111"));
        return event;
    }

    protected void assertSameData(Event entity, Event copy) {
        assertEquals(entity.getId(), copy.getId());
        assertEquals(entity.getName(), copy.getName());
        assertEquals(entity.getDescription(), copy.getDescription());
        assertEquals(entity.getDate(),copy.getDate());
        assertEquals(entity.getTime(),copy.getTime());
        assertEquals(entity.getPlace(),copy.getPlace());
        assertEquals(entity.getId(), copy.getId());
        assertEquals(entity.getStreet(), copy.getStreet());
        assertEquals(entity.getNumber(), copy.getNumber());
        assertEquals(entity.getComplement(),copy.getComplement());
        assertEquals(entity.getNeighborhood(),copy.getNeighborhood());
        assertEquals(entity.getCity(),copy.getCity());
        assertEquals(entity.getState(),copy.getState());
        assertEquals(entity.getCEP(),copy.getCEP());
    }

    @Test
    public void newEventtHasEmptyAttributes() {
        assertEquals(Text.EMPTY, subject.getName());
        assertEquals(Text.EMPTY, subject.getDescription());
        assertEquals(Date.MIN, subject.getDate());
        assertEquals(Time.MIN,subject.getTime());
        assertEquals(Text.EMPTY,subject.getPlace());
        assertEquals(Text.EMPTY,subject.getStreet());
		assertEquals(IntNumber.ZERO,subject.getNumber());
		assertEquals(Text.EMPTY,subject.getComplement());
		assertEquals(Text.EMPTY,subject.getNeighborhood());
		assertEquals(Text.EMPTY,subject.getCity());
		assertEquals(Text.EMPTY,subject.getState());
		assertEquals(CEP.ZERO,subject.getCEP());
    }
}