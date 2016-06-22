package main.persistence.mongo.converters;


import main.domain.activity.Minutes;
import main.persistence.mongo.Converter;

public class MinutesConverter implements Converter<Minutes, String> {
    public String to(Minutes entity) {
        return entity.toString();
    }

    public Minutes fromPersisted(String document) {
        return new Minutes(document);
    }
}
