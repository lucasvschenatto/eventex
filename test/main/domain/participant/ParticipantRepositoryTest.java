package main.domain.participant;

import main.domain.Address;
import main.domain.AddressData;
import main.domain.Date;
import main.domain.Email;
import main.domain.Phone;
import main.domain.Repository;
import main.domain.RepositoryTest;
import main.domain.Text;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public abstract class ParticipantRepositoryTest extends RepositoryTest<Participant> {
    private static final Text NAME1 = new Text("Name 1");
    private static final Text USER_ID1 = new Text("userId 1");
    private static final Text NAMETAG1 = new Text("nametag 1");
    private static final Text NATIONALITY1 = new Text("nationality 1");
    private static final Text GENDER1 = new Text("gender 1");
    private static final Text EDUCATION1 = new Text("education 1");
    private static final Date BIRTH1 = new Date("2010-01-01");
    private static final Address HOME_ADDRESS1 = new Address(addressData1());
    private static final Phone HOME_PHONE1 = new Phone("(11) 1111-1111");
    private static final Phone CELLPHONE1 = new Phone("(11) 9111-1111");
    private static final Text PROFESSION_ID1 = new Text("professionId 1");
    private static final Text ORGANIZATION1 = new Text("organization 1");
    private static final Text DEPARTMENT1 = new Text("department 1");
    private static final Text ROLE1 = new Text("role 1");
    private static final Address WORK_ADDRESS1 = new Address(addressData1());
    private static final Phone WORK_PHONE1 = new Phone("(12) 1112-1112");
    private static final Phone WORK_CELLPHONE1 = new Phone("(12) 9112-1112");
    private static final Email WORK_EMAIL1 = new Email("email1@domain.com");

    
    private static final Text NAME2 = new Text("Name 2");
    private static final Text USER_ID2 = new Text("userId 2");
    private static final Text NAMETAG2 = new Text("nametag 2");
    private static final Text NATIONALITY2 = new Text("nationality 2");
    private static final Text GENDER2 = new Text("gender 2");
    private static final Text EDUCATION2 = new Text("education 2");
    private static final Date BIRTH2 = new Date("2020-02-02");
    private static final Address HOME_ADDRESS2 = new Address(makeData2());
    private static final Phone HOME_PHONE2 = new Phone("(22) 2222-2222");
    private static final Phone CELLPHONE2 = new Phone("(22) 9222-2222");
    private static final Text PROFESSION_ID2 = new Text("professionId 2");
    private static final Text ORGANIZATION2 = new Text("organization 2");
    private static final Text DEPARTMENT2 = new Text("department 2");
    private static final Text ROLE2 = new Text("role 2");
    private static final Address WORK_ADDRESS2 = new Address(makeData2());
    private static final Phone WORK_PHONE2 = new Phone("(22) 2223-2223");
    private static final Phone WORK_CELLPHONE2 = new Phone("(23) 9223-2223");
    private static final Email WORK_EMAIL2 = new Email("email2@domain.com");

    private ParticipantRepository repository;

    protected abstract ParticipantRepository getRepository();

    private static AddressData addressData1() {
    	AddressData data = new AddressData();
		data.street = "Street 1";
		data.number = "100";
		data.complement = "apartment 1";
		data.neighborhood = "Downtown 1";
		data.city = "City 1";
		data.state = "State 1";
		data.country = "Country 1";
		data.cep = "10000-111";
		return data;
	}

	private static AddressData makeData2() {
    	AddressData data = new AddressData();
    	data.street = "Street 2";
		data.number = "200";
		data.complement = "apartment 2";
		data.neighborhood = "Downtown 2";
		data.city = "City 2";
		data.state = "State 2";
		data.country = "Country 2";
		data.cep = "20000-222";
		return data;
	}

	protected Repository<Participant> getAbstractRepository() {
        return getRepository();
    }

    protected Participant makeNewEntity() {
        return new Participant();
    }

    protected Participant makeEntityWithId(String id) {
        Participant participant = new Participant();
        participant.setId(id);
        participant.setName(NAME1);
        participant.setUserId(USER_ID1);
        participant.setNametag(NAMETAG1);
        participant.setNationality(NATIONALITY1);
        participant.setGender(GENDER1);
        participant.setEducation(EDUCATION1);
        participant.setBirth(BIRTH1);
        participant.setHomeAddress(HOME_ADDRESS1);
        participant.setHomePhone(HOME_PHONE1);
        participant.setCellphone(CELLPHONE1);
        participant.setProfessionId(PROFESSION_ID1);
        participant.setOrganization(ORGANIZATION1);
        participant.setDepartment(DEPARTMENT1);
        participant.setRole(ROLE1);
        participant.setWorkAddress(WORK_ADDRESS1);
        participant.setWorkPhone(WORK_PHONE1);
        participant.setWorkCellphone(WORK_CELLPHONE1);
        participant.setWorkEmail(WORK_EMAIL1);
        return participant;
    }

    protected void changeEntity(Participant participant) {
        participant.setName(NAME2);
        participant.setUserId(USER_ID2);
        participant.setNametag(NAMETAG2);
        participant.setNationality(NATIONALITY2);
        participant.setGender(GENDER2);
        participant.setEducation(EDUCATION2);
        participant.setBirth(BIRTH2);
        participant.setHomeAddress(HOME_ADDRESS2);
        participant.setHomePhone(HOME_PHONE2);
        participant.setCellphone(CELLPHONE2);
        participant.setProfessionId(PROFESSION_ID2);
        participant.setOrganization(ORGANIZATION2);
        participant.setDepartment(DEPARTMENT2);
        participant.setRole(ROLE2);
        participant.setWorkAddress(WORK_ADDRESS2);
        participant.setWorkPhone(WORK_PHONE2);
        participant.setWorkCellphone(WORK_CELLPHONE2);
        participant.setWorkEmail(WORK_EMAIL2);
    }

    protected void assertEntityHasSameValues(Participant original, Participant saved) {
        assertEquals(original.getId(), saved.getId());
        assertEquals(original.getName(), saved.getName());
        assertEquals(original.getUserId(), saved.getUserId());
        assertEquals(original.getNametag(), saved.getNametag());
        assertEquals(original.getNationality(), saved.getNationality());
        assertEquals(original.getGender(), saved.getGender());
        assertEquals(original.getEducation(), saved.getEducation());
        assertEquals(original.getBirth(), saved.getBirth());
        assertEquals(original.getHomeAddress(), saved.getHomeAddress());
        assertEquals(original.getHomePhone(), saved.getHomePhone());
        assertEquals(original.getCellphone(), saved.getCellphone());
        assertEquals(original.getProfessionId(), saved.getProfessionId());
        assertEquals(original.getOrganization(), saved.getOrganization());
        assertEquals(original.getDepartment(), saved.getDepartment());
        assertEquals(original.getRole(), saved.getRole());
        assertEquals(original.getWorkAddress(), saved.getWorkAddress());
        assertEquals(original.getWorkPhone(), saved.getWorkPhone());
        assertEquals(original.getWorkCellphone(), saved.getWorkCellphone());
        assertEquals(original.getWorkEmail(), saved.getWorkEmail());
    }

    protected void assertEntityDoesNotHaveSameValues(Participant original, Participant saved) {
        assertEquals(original.getId(), saved.getId());
        assertNotEquals(original.getName(), saved.getName());
        assertNotEquals(original.getUserId(), saved.getUserId());
        assertNotEquals(original.getNametag(), saved.getNametag());
        assertNotEquals(original.getNationality(), saved.getNationality());
        assertNotEquals(original.getGender(), saved.getGender());
        assertNotEquals(original.getEducation(), saved.getEducation());
        assertNotEquals(original.getBirth(), saved.getBirth());
        assertNotEquals(original.getHomeAddress(), saved.getHomeAddress());
        assertNotEquals(original.getHomePhone(), saved.getHomePhone());
        assertNotEquals(original.getCellphone(), saved.getCellphone());
        assertNotEquals(original.getProfessionId(), saved.getProfessionId());
        assertNotEquals(original.getOrganization(), saved.getOrganization());
        assertNotEquals(original.getDepartment(), saved.getDepartment());
        assertNotEquals(original.getRole(), saved.getRole());
        assertNotEquals(original.getWorkAddress(), saved.getWorkAddress());
        assertNotEquals(original.getWorkPhone(), saved.getWorkPhone());
        assertNotEquals(original.getWorkCellphone(), saved.getWorkCellphone());
        assertNotEquals(original.getWorkEmail(), saved.getWorkEmail());

    }

    @Before
    public void setUp() throws Exception {
        super.setUp();
        repository = getRepository();
    }

    @Test
    public void givenNoParticipants_returnsEmptyCollection() {
        Iterable<Participant> participants = repository.getAll();
        assertFalse(participants.iterator().hasNext());
    }

	@Test@SuppressWarnings("unused")
    public void givenTwoParticipants_itReturnsTheTwo() {
        repository.save(new Participant());
        repository.save(new Participant());
        Iterable<Participant> participants = repository.getAll();
        int counter = 0;
        for (Participant ignored : participants)
        	counter++;
        assertEquals(2, counter);
    }
}
