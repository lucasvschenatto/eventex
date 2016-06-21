package main.persistence.mongo.converters;

import main.domain.event.Event;

import java.util.Map;

public class EventConverter extends EntityConverter<Event> {
    private TextConverter textConverter = new TextConverter();
    private DateConverter dateConverter = new DateConverter();
    private TimeConverter timeConverter = new TimeConverter();
    private AddressConverter addressConverter = new AddressConverter();

    protected void defineGetters(Map<String, Getter<Event>> getters) {
        getters.put("name", (p) -> textConverter.to(p.getName()));
        getters.put("description", (p) -> textConverter.to(p.getDescription()));
        getters.put("date", (p) -> dateConverter.to(p.getDate()));
        getters.put("time", (p) -> timeConverter.to(p.getTime()));
        getters.put("place", (p) -> textConverter.to(p.getPlace()));
        getters.put("address", (p) -> addressConverter.to(p.getAddress()));
    }

    protected void defineSetters(Map<String, Setter<Event>> setters) {
        setters.put("_id", (p, v) -> p.setId(v.toString()));
        setters.put("name", (p, v) -> p.setName(textConverter.from(v)));
        setters.put("description", (p, v) -> p.setDescription(textConverter.from(v)));
        setters.put("date", (p, v) -> p.setDate(dateConverter.from(v)));
        setters.put("time", (p, v) -> p.setTime(timeConverter.from(v)));
        setters.put("place", (p, v) -> p.setPlace(textConverter.from(v)));
        setters.put("address", (p, v) -> p.setAddress(addressConverter.from(v)));
    }

    protected Event makeNew() {
        return new Event();
    }
}
