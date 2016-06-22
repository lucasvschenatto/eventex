package main.domain.participant.creating;

import main.domain.Address;
import main.domain.AddressValidation;
import main.domain.Date;
import main.domain.Email;
import main.domain.Phone;
import main.domain.Text;
import main.domain.participant.Participant;
import main.domain.participant.ParticipantRepository;

public class CreateParticipantUseCase {
    protected final ParticipantRepository repository;
    private final Text name;
    private final Text userId;
    private final Text nametag;
    private final Text nationality;
    private final Text gender;
    private final Text education;
    private final Date birth;
    private final Address homeAddress;
    private final Phone homePhone;
    private final Phone cellphone;
    private final Text professionId;
    private final Text organization;
    private final Text department;
    private final Text role;
    private final Address workAddress;
    private final Phone workPhone;
    private final Phone workCellphone;
    private final Email workEmail;
    protected final CreateParticipantResponse response;

    public CreateParticipantUseCase(ParticipantRepository repository, CreateParticipantRequest request, CreateParticipantResponse response) {
        this.repository = repository;
        name = new Text(request.name);
        userId = new Text(request.userId);
        nametag = new Text(request.nametag);
        nationality = new Text(request.nationality);
        gender = new Text(request.gender);
        education = new Text(request.education);
        birth = new Date(request.birth);
        homeAddress = new Address(request.homeAddress);
        homePhone = new Phone(request.homePhone);
        cellphone = new Phone(request.cellphone);
        professionId = new Text(request.professionId);
        organization = new Text(request.organization);
        department = new Text(request.department);
        role = new Text(request.role);
        workAddress = new Address(request.workAddress);
        workPhone = new Phone(request.workPhone);
        workCellphone = new Phone(request.workCellphone);
        workEmail = new Email(request.workEmail);
        this.response = response;
    }

    public void execute() {
        if (isValidRequest())
            create();
        else
            sendErrors();
    }

    protected boolean isValidRequest() {
        return name.isValid() && userId.isValid() && nametag.isValid() && nationality.isValid() &&
        		gender.isValid() && education.isValid() && birth.isValid() && homeAddress.isValid() && 
        		homePhone.isValid() && cellphone.isValid() && professionId.isValid() &&
        		organization.isValid() && department.isValid() && role.isValid() && workAddress.isValid() &&
        		workPhone.isValid() && workCellphone.isValid() && workEmail.isValid();
    }

    private void create() {
        repository.save(makeParticipant());
        response.success = true;
        response.homeAddress = sendAddressIsValid();
        response.workAddress = sendAddressIsValid();
    }

    private AddressValidation sendAddressIsValid() {
    	AddressValidation validation = new AddressValidation();
		return validation;
	}

	protected Participant makeParticipant() {
        Participant participant = new Participant();
        participant.setName(name);
        participant.setUserId(userId);
        participant.setNametag(nametag);
        participant.setNationality(nationality);
        participant.setGender(gender);
        participant.setEducation(education);
        participant.setBirth(birth);
        participant.setHomeAddress(homeAddress);
        participant.setHomePhone(homePhone);
        participant.setCellphone(cellphone);
        participant.setProfessionId(professionId);
        participant.setOrganization(organization);
        participant.setDepartment(department);
        participant.setRole(role);
        participant.setWorkAddress(workAddress);
        participant.setWorkPhone(workPhone);
        participant.setWorkCellphone(workCellphone);
        participant.setWorkEmail(workEmail);
        return participant;
    }

    protected void sendErrors() {
        response.invalidName = !name.isValid();
        response.invalidName = !name.isValid();
        response.invalidUserId = !userId.isValid();
        response.invalidNametag = !nametag.isValid();
        response.invalidNationality = !nationality.isValid();
        response.invalidGender = !gender.isValid();
        response.invalidEducation = !education.isValid();
        response.invalidBirth = !birth.isValid();
        response.homeAddress = homeAddress.getValidation();
        response.invalidHomePhone = !homePhone.isValid();
        response.invalidCellphone = !cellphone.isValid();
        response.invalidProfessionId = !professionId.isValid();
        response.invalidOrganization = !organization.isValid();
        response.invalidDepartment = !department.isValid();
        response.invalidRole = !role.isValid();
        response.workAddress = workAddress.getValidation();
        response.invalidWorkPhone = !workPhone.isValid();
        response.invalidWorkCellphone = !workCellphone.isValid();
        response.invalidWorkEmail = !workEmail.isValid();
    }
}
