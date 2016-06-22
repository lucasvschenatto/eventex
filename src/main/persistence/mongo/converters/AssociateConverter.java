package main.persistence.mongo.converters;

import main.domain.associate.Associate;

import java.util.Map;

public class AssociateConverter extends EntityConverter<Associate> {
    private TextConverter textConverter = new TextConverter();
    private DateConverter dateConverter = new DateConverter();
    private BooleanicConverter booleanicConverter = new BooleanicConverter();

    protected void defineGetters(Map<String, Getter<Associate>> getters) {
        getters.put("category_id", (p) -> textConverter.to(p.getCategoryId()));
        getters.put("code", (p) -> textConverter.to(p.getCode()));
        getters.put("name", (p) -> textConverter.to(p.getName()));
        getters.put("update_date", (p) -> dateConverter.to(p.getUpdateDate()));
        getters.put("active", (p) -> booleanicConverter.to(p.getActive()));
    }

    protected void defineSetters(Map<String, Setter<Associate>> setters) {
        setters.put("_id", (p, v) -> p.setId(v.toString()));
        setters.put("category_id", (p, v) -> p.setCategoryId(textConverter.from(v)));
        setters.put("code", (p, v) -> p.setCode(textConverter.from(v)));
        setters.put("name", (p, v) -> p.setName(textConverter.from(v)));
        setters.put("update_date", (p, v) -> p.setUpdateDate(dateConverter.from(v)));
        setters.put("active", (p, v) -> p.setActive(booleanicConverter.from(v)));
    }

    protected Associate makeNew() {
        return new Associate();
    }
}
