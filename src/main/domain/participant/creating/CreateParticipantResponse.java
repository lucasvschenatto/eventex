package main.domain.participant.creating;

import main.domain.AddressValidation;

public class CreateParticipantResponse {
	public boolean success;
	public boolean invalidName;
	public boolean invalidUserId;
	public boolean invalidNametag;
	public boolean invalidNationality;
	public boolean invalidGender;
	public boolean invalidEducation;
	public boolean invalidBirth;
	public AddressValidation homeAddress;
	public boolean invalidHomePhone;
	public boolean invalidCellphone;
	public boolean invalidProfessionId;
	public boolean invalidOrganization;
	public boolean invalidDepartment;
	public boolean invalidRole;
	public AddressValidation workAddress;
	public boolean invalidWorkPhone;
	public boolean invalidWorkCellphone;
	public boolean invalidWorkEmail;
}
