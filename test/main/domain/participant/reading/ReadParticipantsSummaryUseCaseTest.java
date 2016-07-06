package main.domain.participant.reading;

import main.domain.AddressData;
import main.domain.AddressSummary;
import main.domain.participant.ParticipantRepository;
import main.domain.participant.creating.CreateParticipantRequest;
import main.domain.participant.creating.CreateParticipantResponse;
import main.domain.participant.creating.CreateParticipantUseCase;
import main.domain.participant.reading.ParticipantSummary;
import main.domain.participant.reading.ReadParticipantsUseCase;
import main.persistence.inmemory.InMemoryParticipantRepository;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class ReadParticipantsSummaryUseCaseTest {
    private ParticipantRepository repository;
    private ArrayList<ParticipantSummary> response;
    
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
    private static AddressSummary addressSummary1() {
		AddressSummary data = new AddressSummary();
		data.street = "Street 1";
		data.number = 100;
		data.complement = "apartment 1";
		data.neighborhood = "Downtown 1";
		data.city = "City 1";
		data.state = "State 1";
		data.country = "Country 1";
		data.cep = "10000-111";
		return data;
	}

	private static AddressData addressData2() {
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
	private static AddressSummary addressSummary2() {
    	AddressSummary data = new AddressSummary();
    	data.street = "Street 2";
		data.number = 200;
		data.complement = "apartment 2";
		data.neighborhood = "Downtown 2";
		data.city = "City 2";
		data.state = "State 2";
		data.country = "Country 2";
		data.cep = "20000-222";
		return data;
	}

    private void givenParticipant(String name, String userId, String nametag, String nationality, 
    		String gender, String education, String birth, AddressData homeAddress, String homePhone, 
    		String cellphone, String professionId, String organization, String department, String role,
    		AddressData workAddress, String workPhone, String workCellphone, String workEmail) {
        CreateParticipantRequest request = new CreateParticipantRequest();
        request.name = name;
        request.userId = userId;
        request.nametag = nametag;
        request.nationality = nationality;
        request.gender = gender;
        request.education = education;
        request.birth = birth;
        request.homeAddress = homeAddress;
        request.homePhone = homePhone;
        request.cellphone = cellphone;
        request.professionId = professionId;
        request.organization = organization;
        request.department = department;
        request.role = role;
        request.workAddress = workAddress;
        request.workPhone = workPhone;
        request.workCellphone = workCellphone;
        request.workEmail = workEmail;
        CreateParticipantResponse response = new CreateParticipantResponse();
        new CreateParticipantUseCase(repository, request, response).execute();
    }

    private void whenReadingSummaries() {
        new ReadParticipantsUseCase(repository, response).execute();
    }

    private void thenTheSizeMustBe(int size) {
        assertEquals(size, response.size());
    }

    private void andItMustPresentAtIndex(int index, String id, String name, String userId, String nametag, String nationality, 
    		String gender, String education, String birth, AddressSummary homeAddress, String homePhone, 
    		String cellphone, String professionId, String organization, String department, String role,
    		AddressSummary workAddress, String workPhone, String workCellphone, String workEmail) {
        ParticipantSummary summary = response.get(index);
        assertEquals(id, summary.id);
        assertEquals(name, summary.name);
        assertEquals(userId, summary.userId);
        assertEquals(nametag, summary.nametag);
        assertEquals(nationality, summary.nationality);
        assertEquals(gender, summary.gender);
        assertEquals(education, summary.education);
        assertEquals(birth, summary.birth);
        assertEquals(homeAddress, summary.homeAddress);
        assertEquals(homePhone, summary.homePhone);
        assertEquals(cellphone, summary.cellphone);
        assertEquals(professionId, summary.professionId);
        assertEquals(organization, summary.organization);
        assertEquals(department, summary.department);
        assertEquals(role, summary.role);
        assertEquals(workAddress, summary.workAddress);
        assertEquals(workPhone, summary.workPhone);
        assertEquals(workCellphone, summary.workCellphone);
        assertEquals(workEmail, summary.workEmail);
    }

    @Before
    public void setUp() throws Exception {
        repository = new InMemoryParticipantRepository();
        response = new ArrayList<>();
    }

    @Test
    public void givenNoParticipants_itReturnsAnEmptyCollection() {
        whenReadingSummaries();
        thenTheSizeMustBe(0);
    }

    @Test
    public void givenAnParticipant_itMustBeReturnedInTheSummary() {
        givenParticipant("name 1", "userId 1", "nametag 1", "nationality 1", "gender 1", "education 1", 
        		"2011-01-01", addressData1(), "(11) 1111-1111", "(11) 1111-1111", "professionId 1",
        		"organization 1", "department 1", "role 1", addressData1(),  "(11) 1111-1111", 
        		 "(11) 1111-1111", "email1@domain.com");
        givenParticipant("name 2", "userId 2", "nametag 2", "nationality 2", "gender 2", "education 2", 
        		"2022-02-02", addressData2(), "(22) 2222-2222", "(22) 2222-2222", "professionId 2",
        		"organization 2", "department 2", "role 2", addressData2(),  "(22) 2222-2222", 
        		 "(22) 2222-2222", "email2@domain.com");
        whenReadingSummaries();
        thenTheSizeMustBe(2);
        andItMustPresentAtIndex(0, "1", "name 1", "userId 1", "nametag 1", "nationality 1", "gender 1", "education 1", 
        		"2011-01-01", addressSummary1(), "(11) 1111-1111", "(11) 1111-1111", "professionId 1",
        		"organization 1", "department 1", "role 1", addressSummary1(),  "(11) 1111-1111", 
        		 "(11) 1111-1111", "email1@domain.com");
        andItMustPresentAtIndex(1, "2", "name 2", "userId 2", "nametag 2", "nationality 2", "gender 2", "education 2", 
        		"2022-02-02", addressSummary2(), "(22) 2222-2222", "(22) 2222-2222", "professionId 2",
        		"organization 2", "department 2", "role 2", addressSummary2(),  "(22) 2222-2222", 
        		 "(22) 2222-2222", "email2@domain.com");
    }
}