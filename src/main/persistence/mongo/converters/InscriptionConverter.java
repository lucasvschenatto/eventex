package main.persistence.mongo.converters;

import main.domain.inscription.Inscription;

import java.util.Map;

public class InscriptionConverter extends EntityConverter<Inscription> {
    private TextConverter textConverter = new TextConverter();

    protected void defineGetters(Map<String, Getter<Inscription>> getters) {
        getters.put("participant_id", (p) -> textConverter.to(p.getParticipantId()));
        getters.put("activity_id", (p) -> textConverter.to(p.getActivityId()));
        getters.put("category_id", (p) -> textConverter.to(p.getCategoryId()));
        getters.put("associate_code", (p) -> textConverter.to(p.getAssociateCode()));
    }

    protected void defineSetters(Map<String, Setter<Inscription>> setters) {
        setters.put("_id", (p, v) -> p.setId(v.toString()));
        setters.put("participant_id", (p, v) -> p.setParticipantId(textConverter.from(v)));
        setters.put("activity_id", (p, v) -> p.setActivityId(textConverter.from(v)));
        setters.put("category_id", (p, v) -> p.setCategoryId(textConverter.from(v)));
        setters.put("associate_code", (p, v) -> p.setAssociateCode(textConverter.from(v)));
    }

    protected Inscription makeNew() {
        return new Inscription();
    }
}
