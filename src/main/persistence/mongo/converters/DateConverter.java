package main.persistence.mongo.converters;

import main.domain.Date;
import main.persistence.mongo.Converter;

public class DateConverter implements Converter<Date, String> {
    public String to(Date entity) {
        return entity.toString();
    }

    public Date fromPersisted(String document) {
        return new Date(document);
    }
}
