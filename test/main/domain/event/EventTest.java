package main.domain.event;

import main.domain.Address;
import main.domain.AddressData;
import main.domain.Date;
import main.domain.EntityTest;
import main.domain.Text;
import main.domain.Time;
import main.domain.event.Event;

import static org.junit.Assert.*;

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
        event.setAddress(new Address(validAddressData()));
        
        return event;
    }

    protected void assertSameData(Event entity, Event copy) {
        assertEquals(entity.getId(), copy.getId());
        assertEquals(entity.getName(), copy.getName());
        assertEquals(entity.getDescription(), copy.getDescription());
        assertEquals(entity.getDate(),copy.getDate());
        assertEquals(entity.getTime(),copy.getTime());
        assertEquals(entity.getPlace(),copy.getPlace());
        assertEquals(entity.getAddress(), copy.getAddress());
    }
    
    private AddressData validAddressData(){
    	AddressData data = new AddressData();
    	data.street = "street";
        data.number = "1";
        data.complement = "complement";
        data.neighborhood = "neighborhood";
        data.city = "city";
        data.state = "state";
        data.country = "country";
        data.cep = "11111-111";
    	return data;
    }

    @Test
    public void newEventtHasEmptyAttributes() {
        assertEquals(Text.EMPTY, subject.getName());
        assertEquals(Text.EMPTY, subject.getDescription());
        assertEquals(Date.MIN, subject.getDate());
        assertEquals(Time.MIN,subject.getTime());
        assertEquals(Text.EMPTY,subject.getPlace());
        assertEquals(Address.EMPTY,subject.getAddress());
    }
}