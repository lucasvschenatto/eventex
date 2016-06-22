package main.persistence.mongo.converters;

import main.domain.Time;
import main.persistence.mongo.Converter;

public class TimeConverter implements Converter<Time, String> {
    public String to(Time entity) {
        return entity.toString();
    }

    public Time fromPersisted(String document) {
        return new Time(document);
    }
}
