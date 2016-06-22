package main.persistence.mongo.converters;

import main.domain.participant.Participant;
import java.util.Map;

public class ParticipantConverter extends EntityConverter<Participant> {
    private TextConverter textConverter = new TextConverter();
    private DateConverter dateConverter = new DateConverter();
    private AddressConverter addressConverter = new AddressConverter();
    private PhoneConverter phoneConverter = new PhoneConverter();
    private EmailConverter emailConverter = new EmailConverter();

    protected void defineGetters(Map<String, Getter<Participant>> getters) {
        getters.put("name", (p) -> textConverter.to(p.getName()));
        getters.put("user_id", (p) -> textConverter.to(p.getUserId()));
        getters.put("nametag", (p) -> textConverter.to(p.getNametag()));
        getters.put("nationality", (p) -> textConverter.to(p.getNationality()));
        getters.put("gender", (p) -> textConverter.to(p.getGender()));
        getters.put("education", (p) -> textConverter.to(p.getEducation()));
        getters.put("birth", (p) -> dateConverter.to(p.getBirth()));
        getters.put("home_address", (p) -> addressConverter.to(p.getHomeAddress()));
        getters.put("home_phone", (p) -> phoneConverter.to(p.getHomePhone()));
        getters.put("cellphone", (p) -> phoneConverter.to(p.getCellphone()));
        getters.put("profession_id", (p) -> textConverter.to(p.getProfessionId()));
        getters.put("organization", (p) -> textConverter.to(p.getOrganization()));
        getters.put("department", (p) -> textConverter.to(p.getDepartment()));
        getters.put("role", (p) -> textConverter.to(p.getRole()));
        getters.put("work_address", (p) -> addressConverter.to(p.getWorkAddress()));
        getters.put("work_phone", (p) -> phoneConverter.to(p.getWorkPhone()));
        getters.put("work_cellphone", (p) -> phoneConverter.to(p.getWorkCellphone()));
        getters.put("work_email", (p) -> emailConverter.to(p.getWorkEmail()));
    }

    protected void defineSetters(Map<String, Setter<Participant>> setters) {
        setters.put("_id", (p, v) -> p.setId(v.toString()));
        setters.put("name", (p, v) -> p.setName(textConverter.from(v)));
        setters.put("user_id", (p, v) -> p.setUserId(textConverter.from(v)));
        setters.put("nametag", (p, v) -> p.setNametag(textConverter.from(v)));
        setters.put("nationality", (p, v) -> p.setNationality(textConverter.from(v)));
		setters.put("gender", (p, v) -> p.setGender(textConverter.from(v)));
        setters.put("education", (p, v) -> p.setEducation(textConverter.from(v)));
        setters.put("birth", (p, v) -> p.setBirth(dateConverter.from(v)));
        setters.put("home_address", (p, v) -> p.setHomeAddress(addressConverter.from(v)));
        setters.put("home_phone", (p, v) -> p.setHomePhone(phoneConverter.from(v)));
        setters.put("cellphone", (p, v) -> p.setCellphone(phoneConverter.from(v)));
        setters.put("profession_id", (p, v) -> p.setProfessionId(textConverter.from(v)));
        setters.put("organization", (p, v) -> p.setOrganization(textConverter.from(v)));
        setters.put("department", (p, v) -> p.setDepartment(textConverter.from(v)));
        setters.put("role", (p, v) -> p.setRole(textConverter.from(v)));
        setters.put("work_address", (p, v) -> p.setWorkAddress(addressConverter.from(v)));
        setters.put("work_phone", (p, v) -> p.setWorkPhone(phoneConverter.from(v)));
        setters.put("work_cellphone", (p, v) -> p.setWorkCellphone(phoneConverter.from(v)));
        setters.put("work_email", (p, v) -> p.setWorkEmail(emailConverter.from(v)));
    }

    protected Participant makeNew() {
        return new Participant();
    }
}
