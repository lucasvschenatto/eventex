package main.persistence.mongo.converters;

import main.domain.profession.Profession;

import java.util.Map;

public class ProfessionConverter extends EntityConverter<Profession> {
    private TextConverter textConverter = new TextConverter();

    protected void defineGetters(Map<String, Getter<Profession>> getters) {
        getters.put("name", (p) -> textConverter.to(p.getName()));
        getters.put("description", (p) -> textConverter.to(p.getDescription()));
    }

    protected void defineSetters(Map<String, Setter<Profession>> setters) {
        setters.put("_id", (p, v) -> p.setId(v.toString()));
        setters.put("name", (p, v) -> p.setName(textConverter.from(v)));
        setters.put("description", (p, v) -> p.setDescription(textConverter.from(v)));
    }

    protected Profession makeNew() {
        return new Profession();
    }
}
