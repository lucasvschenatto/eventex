package main.persistence.mongo.converters;

import main.domain.admin.Admin;
import java.util.Map;

public class AdminConverter extends EntityConverter<Admin> {
    private TextConverter textConverter = new TextConverter();

    protected void defineGetters(Map<String, Getter<Admin>> getters) {
        getters.put("name", (p) -> textConverter.to(p.getName()));
        getters.put("user_id", (p) -> textConverter.to(p.getUserId()));
        getters.put("role", (p) -> textConverter.to(p.getRole()));
    }

    protected void defineSetters(Map<String, Setter<Admin>> setters) {
        setters.put("_id", (p, v) -> p.setId(v.toString()));
        setters.put("name", (p, v) -> p.setName(textConverter.from(v)));
        setters.put("user_id", (p, v) -> p.setUserId(textConverter.from(v)));
        setters.put("role", (p, v) -> p.setRole(textConverter.from(v)));
    }

    protected Admin makeNew() {
        return new Admin();
    }
}
