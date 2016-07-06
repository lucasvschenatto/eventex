package main.domain.participant.creating;

import main.domain.AddressData;
import main.domain.AddressSummary;
import main.domain.participant.ParticipantRepository;
import main.domain.participant.reading.ParticipantSummary;
import main.domain.participant.reading.ReadParticipantsUseCase;
import main.persistence.inmemory.InMemoryParticipantRepository;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class CreateParticipantUseCaseTest {
	private static final String VALID_NAME = "Valid name";
	private static final String VALID_USER_ID =  "userId";
	private static final String VALID_NAMETAG = "nametag";
	private static final String VALID_NATIONALITY =  "nationality";
	private static final String VALID_GENDER =  "gender";
	private static final String VALID_EDUCATION =  "education";
	private static final String VALID_BIRTH = "2010-01-01";
	                            
	private static final String VALID_PHONE = "(11) 1111-1111";
	private static final String VALID_PROFESSION_ID =  "professionId";
	private static final String VALID_ORGANIZATION =  "organization";
	private static final String VALID_DEPARTMENT =  "department";
	private static final String VALID_ROLE =  "role";
	                            
	private static final String VALID_WORK_EMAIL = "email1@domain.com";
	
	private static final AddressData VALID_ADDRESS_DATA = makeValidAddressData();
	private static final AddressSummary VALID_ADDRESS_SUMMARY = makeValidAddressSummary();
	private CreateParticipantRequest request;
	private CreateParticipantResponse response;
	private ParticipantRepository repository;

    private void givenParticipantInformation(String name, String userId, String nametag, String nationality, 
    		String gender, String education, String birth, AddressData homeAddress, String homePhone, 
    		String cellphone, String professionId, String organization, String department, String role,
    		AddressData workAddress, String workPhone, String workCellphone, String workEmail) {
        request = new CreateParticipantRequest();
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
    }

    private static AddressSummary makeValidAddressSummary() {
    	AddressSummary summary = new AddressSummary();
		summary.street = "valid Street";
		summary.number = 510;
		summary.complement = "valid complement";
		summary.neighborhood = "valid neighborhood";
		summary.city = "valid city";
		summary.state = "valid state";
		summary.country = "valid country";
		summary.cep = "10000-123";
		return summary;
	}

	private static AddressData makeValidAddressData() {
    	AddressData data = new AddressData();
		data.street = "valid Street";
		data.number = "510";
		data.complement = "valid complement";
		data.neighborhood = "valid neighborhood";
		data.city = "valid city";
		data.state = "valid state";
		data.country = "valid country";
		data.cep = "10000-123";
		return data;
	}

	private void whenCreatingTheParticipant() {
        new CreateParticipantUseCase(repository, request, response).execute();
    }

    private void andItShouldReturnTheErrors(String... expectedErrors) {
        assertFalse(response.success);
        assertArrayEquals(expectedErrors, makeErrorsArray());
    }

    private String[] makeErrorsArray() {
        ArrayList<String> list = new ArrayList<>();
        if (response.invalidName) list.add("invalidName");
        if (response.invalidUserId) list.add("invalidUserId");
        if (response.invalidNametag) list.add("invalidNametag");
        if (response.invalidNationality) list.add("invalidNationality");
        if (response.invalidGender) list.add("invalidGender");
        if (response.invalidEducation) list.add("invalidEducation");
        if (response.invalidBirth) list.add("invalidBirth");
        if (!response.homeAddress.isValid()) list.add("invalidHomeAddress");
        if (response.invalidHomePhone) list.add("invalidHomePhone");
        if (response.invalidCellphone) list.add("invalidCellphone");
        if (response.invalidProfessionId) list.add("invalidProfessionId");
        if (response.invalidOrganization) list.add("invalidOrganization");
        if (response.invalidDepartment) list.add("invalidDepartment");
        if (response.invalidRole) list.add("invalidRole");
        if (!response.workAddress.isValid()) list.add("invalidWorkAddress");
        if (response.invalidWorkPhone) list.add("invalidWorkPhone");
        if (response.invalidWorkCellphone) list.add("invalidWorkCellphone");
        if (response.invalidWorkEmail) list.add("invalidWorkEmail");
        return list.toArray(new String[list.size()]);
    }

    private void thenItShouldNotBeCreated() {
        assertFalse(response.success);
        assertEquals(0, getSummaries().size());
    }

    private void thenItShouldBeCreatedWithTheData(String name, String userId, String nametag, String nationality, 
    		String gender, 
    		String education, String birth, AddressSummary homeAddress, String homePhone, String cellphone, 
    		String professionId, String organization, String department, String role,
    		AddressSummary workAddress, String workPhone, String workCellphone, String workEmail) {
        assertTrue(response.success);
        ParticipantSummary summary = getSummaries().get(0);
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

    private ArrayList<ParticipantSummary> getSummaries() {
        ArrayList<ParticipantSummary> summaries = new ArrayList<>();
        new ReadParticipantsUseCase(repository, summaries).execute();
        return summaries;
    }

    private void andItShouldNotReturnErrors() {
        assertEquals(0, makeErrorsArray().length);
    }

    @Before
    public void setUp() {
        response = new CreateParticipantResponse();
        repository = new InMemoryParticipantRepository();
    }

    @Test
	public void givenAllValidInput_theParticipantMustBeCreated() {
	    givenParticipantInformation(VALID_NAME, VALID_USER_ID, VALID_NAMETAG, VALID_NATIONALITY, VALID_GENDER,
	    		VALID_EDUCATION, VALID_BIRTH, VALID_ADDRESS_DATA, VALID_PHONE, VALID_PHONE, VALID_PROFESSION_ID,
	    		VALID_ORGANIZATION, VALID_DEPARTMENT, VALID_ROLE, VALID_ADDRESS_DATA, VALID_PHONE, VALID_PHONE,
	    		VALID_WORK_EMAIL);
	    whenCreatingTheParticipant();
	    thenItShouldBeCreatedWithTheData(VALID_NAME, VALID_USER_ID, VALID_NAMETAG, VALID_NATIONALITY, 
	    		VALID_GENDER, VALID_EDUCATION, VALID_BIRTH, VALID_ADDRESS_SUMMARY, VALID_PHONE, VALID_PHONE, 
	    		VALID_PROFESSION_ID, VALID_ORGANIZATION, VALID_DEPARTMENT, VALID_ROLE, VALID_ADDRESS_SUMMARY, 
	    		VALID_PHONE, VALID_PHONE, VALID_WORK_EMAIL);
	    andItShouldNotReturnErrors();
	}

	@Test
	public void givenNameSurroundedBySpaces_theParticipantIsCreatedWithTheTextsTrimmed() {
	    givenParticipantInformation("  Valid name  ", VALID_USER_ID, VALID_NAMETAG, VALID_NATIONALITY, VALID_GENDER,
	    		VALID_EDUCATION, VALID_BIRTH, VALID_ADDRESS_DATA, VALID_PHONE, VALID_PHONE, VALID_PROFESSION_ID,
	    		VALID_ORGANIZATION, VALID_DEPARTMENT, VALID_ROLE, VALID_ADDRESS_DATA, VALID_PHONE, VALID_PHONE,
	    		VALID_WORK_EMAIL);
	    whenCreatingTheParticipant();
	    thenItShouldBeCreatedWithTheData(VALID_NAME, VALID_USER_ID, VALID_NAMETAG, VALID_NATIONALITY, 
	    		VALID_GENDER, VALID_EDUCATION, VALID_BIRTH, VALID_ADDRESS_SUMMARY, VALID_PHONE, VALID_PHONE, 
	    		VALID_PROFESSION_ID, VALID_ORGANIZATION, VALID_DEPARTMENT, VALID_ROLE, VALID_ADDRESS_SUMMARY, 
	    		VALID_PHONE, VALID_PHONE, VALID_WORK_EMAIL);
	    andItShouldNotReturnErrors();
	}

	@Test
    public void givenNullName_itIsInvalid() {
        givenParticipantInformation(null, VALID_USER_ID, VALID_NAMETAG, VALID_NATIONALITY, VALID_GENDER,
	    		VALID_EDUCATION, VALID_BIRTH, VALID_ADDRESS_DATA, VALID_PHONE, VALID_PHONE, VALID_PROFESSION_ID,
	    		VALID_ORGANIZATION, VALID_DEPARTMENT, VALID_ROLE, VALID_ADDRESS_DATA, VALID_PHONE, VALID_PHONE,
	    		VALID_WORK_EMAIL);
        whenCreatingTheParticipant();
        thenItShouldNotBeCreated();
        andItShouldReturnTheErrors("invalidName");
    }

    @Test
    public void givenEmptyName_itIsInvalid() {
        givenParticipantInformation("", VALID_USER_ID, VALID_NAMETAG, VALID_NATIONALITY, VALID_GENDER,
	    		VALID_EDUCATION, VALID_BIRTH, VALID_ADDRESS_DATA, VALID_PHONE, VALID_PHONE, VALID_PROFESSION_ID,
	    		VALID_ORGANIZATION, VALID_DEPARTMENT, VALID_ROLE, VALID_ADDRESS_DATA, VALID_PHONE, VALID_PHONE,
	    		VALID_WORK_EMAIL);
        whenCreatingTheParticipant();
        thenItShouldNotBeCreated();
        andItShouldReturnTheErrors("invalidName");
    }

    @Test
    public void givenNameWithOnlySpaces_itIsInvalid() {
        givenParticipantInformation("   ", VALID_USER_ID, VALID_NAMETAG, VALID_NATIONALITY, VALID_GENDER,
	    		VALID_EDUCATION, VALID_BIRTH, VALID_ADDRESS_DATA, VALID_PHONE, VALID_PHONE, VALID_PROFESSION_ID,
	    		VALID_ORGANIZATION, VALID_DEPARTMENT, VALID_ROLE, VALID_ADDRESS_DATA, VALID_PHONE, VALID_PHONE,
	    		VALID_WORK_EMAIL);
        whenCreatingTheParticipant();
        thenItShouldNotBeCreated();
        andItShouldReturnTheErrors("invalidName");
    }
}