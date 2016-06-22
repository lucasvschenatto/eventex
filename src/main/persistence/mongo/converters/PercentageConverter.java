package main.persistence.mongo.converters;

import main.domain.Percentage;
import main.persistence.mongo.Converter;

public class PercentageConverter implements Converter<Percentage, String> {
    public String to(Percentage entity) {
        return entity.toString();
    }

    public Percentage fromPersisted(String document) {
        return new Percentage(document);
    }
}
