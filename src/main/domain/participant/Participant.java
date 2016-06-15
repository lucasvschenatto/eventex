package main.domain.participant;

import main.domain.Address;
import main.domain.Date;
import main.domain.Email;
import main.domain.Entity;
import main.domain.Phone;
import main.domain.Text;

public class Participant extends Entity {
    protected Text name;
    protected Text userId;
    protected Text nametag;
    protected Text nationality;
    protected Text gender;
    protected Text education;
    protected Date birth;
    protected Address homeAddress;
    protected Phone homePhone;
    protected Phone cellphone;
    protected Text professionId;
    protected Text organization;
    protected Text department;
    protected Text role;
    protected Address workAddress;
    protected Phone workPhone;
    protected Phone workCellphone;
    protected Email workEmail;

    public Participant() {
        this("", Text.EMPTY, Text.EMPTY, Text.EMPTY, Text.EMPTY, Text.EMPTY, Text.EMPTY, Date.MIN, Address.EMPTY,
        		Phone.ZERO, Phone.ZERO, Text.EMPTY, Text.EMPTY, Text.EMPTY, Text.EMPTY, Address.EMPTY,
        		Phone.ZERO, Phone.ZERO, Email.EMPTY);
    }

    protected Participant(String id, Text name, Text userId, Text nametag, Text nationality, Text gender, 
    		Text education, Date birth, Address homeAddress, Phone homePhone, Phone cellphone, 
    		Text professionId, Text organization, Text department, Text role,
    		Address workAddress, Phone workPhone, Phone workCellphone, Email workEmail) {
        super(id);
        this.name          = name;
        this.userId          = userId;
        this.nametag       = nametag;
        this.nationality   = nationality;
        this.gender        = gender;
        this.education     = education;
        this.birth         = birth;
        this.homeAddress   = homeAddress;
        this.homePhone     = homePhone;
        this.cellphone     = cellphone;
        this.professionId    = professionId;
        this.organization  = organization;
        this.department    = department;
        this.role          = role;
        this.workAddress   = workAddress;
        this.workPhone     = workPhone;
        this.workCellphone = workCellphone;
        this.workEmail     = workEmail;
    }

    public Entity copy() {
        return new Participant(id, name, userId, nametag, nationality, gender,
        		education, birth, homeAddress.copy(), homePhone, cellphone, 
        		professionId, organization, department, role, 
        		workAddress.copy(), workPhone, workCellphone, workEmail);
    }

    public Text getName() {
    	return name;
    }

	public void setName(Text name) {
		this.name = name;
	}

	public Text getUserId() {
		return userId;
	}

	public Text getNametag() {
		return nametag;
	}

	public Text getNationality() {
		return nationality;
	}

	public Text getGender() {
		return gender;
	}

	public Text getEducation() {
		return education;
	}

	public Date getBirth() {
		return birth;
	}

	public Address getHomeAddress() {
		return homeAddress;
	}

	public Phone getHomePhone() {
		return homePhone;
	}

	public Phone getCellphone() {
		return cellphone;
	}

	public Text getProfessionId() {
		return professionId;
	}

	public Text getOrganization() {
		return organization;
	}

	public Text getDepartment() {
		return department;
	}

	public Text getRole() {
		return role;
	}

	public Address getWorkAddress() {
		return workAddress;
	}

	public Phone getWorkPhone() {
		return workPhone;
	}

	public Phone getWorkCellphone() {
		return workCellphone;
	}

	public Email getWorkEmail() {
		return workEmail;
	}

	public void setUserId(Text userId) {
		this.userId = userId;
	}

	public void setNametag(Text nametag) {
		this.nametag = nametag;
	}

	public void setNationality(Text nationality) {
		this.nationality = nationality;
	}

	public void setGender(Text gender) {
		this.gender = gender;
	}

	public void setEducation(Text education) {
		this.education = education;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}

	public void setHomePhone(Phone homePhone) {
		this.homePhone = homePhone;
	}

	public void setCellphone(Phone cellphone) {
		this.cellphone = cellphone;
	}

	public void setProfessionId(Text professionId) {
		this.professionId = professionId;
	}

	public void setOrganization(Text organization) {
		this.organization = organization;
	}

	public void setDepartment(Text department) {
		this.department = department;
	}

	public void setRole(Text role) {
		this.role = role;
	}

	public void setWorkAddress(Address workAddress) {
		this.workAddress = workAddress;
	}

	public void setWorkPhone(Phone workPhone) {
		this.workPhone = workPhone;
	}

	public void setWorkCellphone(Phone workCellphone) {
		this.workCellphone = workCellphone;
	}

	public void setWorkEmail(Email workEmail) {
		this.workEmail = workEmail;
	}
}
