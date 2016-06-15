package main.domain.participant;

import main.domain.Address;
import main.domain.AddressData;
import main.domain.Date;
import main.domain.EntityTest;
import main.domain.Text;
import main.domain.Phone;
import main.domain.Email;

import static org.junit.Assert.*;

import org.junit.Test;

public class ParticipantTest extends EntityTest<Participant> {
    protected Participant makeNewSubject() {
        return new Participant();
    }

    protected Participant makeSubjectWithData() {
        Participant participant = makeNewSubject();
        participant.setName(new Text("name lastname"));
        participant.setUserId(new Text("123456789"));
        participant.setNametag(new Text("nickname"));
        participant.setNationality(new Text("nationality"));
        participant.setGender(new Text("gender"));
        participant.setEducation(new Text("degree"));
        participant.setBirth(new Date("2000-06-30"));
        participant.setHomeAddress(new Address(validAddressData()));
        participant.setHomePhone(new Phone("(11) 1111-1111"));
        participant.setCellphone(new Phone("(12) 3456-7890"));
        participant.setProfessionId(new Text("prof123456"));
        participant.setOrganization(new Text("organization"));
        participant.setDepartment(new Text("department"));
        participant.setRole(new Text("job role"));
        participant.setWorkAddress(new Address(validAddressData()));
        participant.setWorkPhone(new Phone("(98) 7654-3210"));
        participant.setWorkCellphone(new Phone("(13) 9750-2468"));
        participant.setWorkEmail(new Email("name@workdomain.com"));
        return participant;
    }

	protected void assertSameData(Participant entity, Participant copy) {
        assertEquals(entity.getId(), copy.getId());
        assertEquals(entity.getName(), copy.getName());
        assertEquals(entity.getUserId(), copy.getUserId());
        assertEquals(entity.getNametag(), copy.getNametag());
        assertEquals(entity.getNationality(), copy.getNationality());
        assertEquals(entity.getGender(), copy.getGender());
        assertEquals(entity.getEducation(), copy.getEducation());
        assertEquals(entity.getBirth(), copy.getBirth());
        assertEquals(entity.getHomeAddress(), copy.getHomeAddress());
        assertEquals(entity.getHomePhone(), copy.getHomePhone());
        assertEquals(entity.getCellphone(), copy.getCellphone());
        assertEquals(entity.getProfessionId(), copy.getProfessionId());
        assertEquals(entity.getOrganization(), copy.getOrganization());
        assertEquals(entity.getDepartment(), copy.getDepartment());
        assertEquals(entity.getRole(), copy.getRole());
        assertEquals(entity.getWorkAddress(), copy.getWorkAddress());
        assertEquals(entity.getWorkPhone(), copy.getWorkPhone());
        assertEquals(entity.getWorkCellphone(), copy.getWorkCellphone());
        assertEquals(entity.getWorkEmail(), copy.getWorkEmail());
        
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
    public void newParticipanttHasEmptyAttributes() {
    	assertEquals( Text.EMPTY, subject.getName());
    	assertEquals( Text.EMPTY, subject.getUserId());
    	assertEquals( Text.EMPTY, subject.getNametag());
    	assertEquals( Text.EMPTY, subject.getNationality());
    	assertEquals( Text.EMPTY, subject.getGender());
    	assertEquals( Text.EMPTY, subject.getEducation());
    	assertEquals( Date.MIN,   subject.getBirth());
    	assertEquals( Address.EMPTY, subject.getHomeAddress());
    	assertEquals( Phone.ZERO, subject.getHomePhone());
    	assertEquals( Phone.ZERO, subject.getCellphone());
    	assertEquals( Text.EMPTY, subject.getProfessionId());
    	assertEquals( Text.EMPTY, subject.getOrganization());
    	assertEquals( Text.EMPTY, subject.getDepartment());
    	assertEquals( Text.EMPTY, subject.getRole());
    	assertEquals( Address.EMPTY, subject.getWorkAddress());
    	assertEquals( Phone.ZERO, subject.getWorkPhone());
    	assertEquals( Phone.ZERO, subject.getWorkCellphone());
    	assertEquals( Email.EMPTY, subject.getWorkEmail());
    }
}