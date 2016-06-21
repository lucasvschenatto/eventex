package main.persistence.mongo.converters;

import main.domain.Booleanic;
import main.persistence.mongo.Converter;

public class BooleanicConverter implements Converter<Booleanic, String> {
    public String to(Booleanic entity) {
        return entity.toString();
    }

    public Booleanic fromPersisted(String document) {
        return new Booleanic(document);
    }
}
