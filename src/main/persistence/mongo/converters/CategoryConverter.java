package main.persistence.mongo.converters;

import main.domain.category.Category;

import java.util.Map;

public class CategoryConverter extends EntityConverter<Category> {
    private TextConverter textConverter = new TextConverter();
    private BooleanicConverter booleanicConverter = new BooleanicConverter();
    private PercentageConverter percentageConverter = new PercentageConverter();

    protected void defineGetters(Map<String, Getter<Category>> getters) {
        getters.put("name", (p) -> textConverter.to(p.getName()));
        getters.put("description", (p) -> textConverter.to(p.getDescription()));
        getters.put("discount", (p) -> percentageConverter.to(p.getDiscount()));
        getters.put("needCodeAtInscription", (p) -> booleanicConverter.to(p.getNeedCodeAtInscription()));
    }

    protected void defineSetters(Map<String, Setter<Category>> setters) {
        setters.put("_id", (p, v) -> p.setId(v.toString()));
        setters.put("name", (p, v) -> p.setName(textConverter.from(v)));
        setters.put("description", (p, v) -> p.setDescription(textConverter.from(v)));
        setters.put("discount", (p, v) -> p.setDiscount(percentageConverter.from(v)));
        setters.put("needCodeAtInscription", (p, v) -> p.setNeedCodeAtInscription(booleanicConverter.from(v)));
    }

    protected Category makeNew() {
        return new Category();
    }
}
