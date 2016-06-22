package main.persistence.mongo.converters;

import main.domain.activity.Activity;
import java.util.Map;

public class ActivityConverter extends EntityConverter<Activity> {
    private TextConverter textConverter = new TextConverter();
    private DateConverter dateConverter = new DateConverter();
    private TimeConverter timeConverter = new TimeConverter();
    private AddressConverter addressConverter = new AddressConverter();
    private QuantityConverter quantityConverter = new QuantityConverter();
    private MinutesConverter minutesConverter = new MinutesConverter();
    private BooleanicConverter booleanicConverter = new BooleanicConverter();

    protected void defineGetters(Map<String, Getter<Activity>> getters) {
        getters.put("event_id", (p) -> textConverter.to(p.getEventId()));
        getters.put("name", (p) -> textConverter.to(p.getName()));
        getters.put("description", (p) -> textConverter.to(p.getDescription()));
        getters.put("date", (p) -> dateConverter.to(p.getDate()));
        getters.put("time", (p) -> timeConverter.to(p.getTime()));
        getters.put("place", (p) -> textConverter.to(p.getPlace()));
        getters.put("address", (p) -> addressConverter.to(p.getAddress()));
        getters.put("spots", (p) -> quantityConverter.to(p.getSpots()));
        getters.put("duration", (p) -> minutesConverter.to(p.getDuration()));
        getters.put("points", (p) -> quantityConverter.to(p.getPoints()));
        getters.put("group_discount", (p) -> booleanicConverter.to(p.getGroupDiscount()));
        getters.put("voucher", (p) -> booleanicConverter.to(p.getVoucher()));
    }

    protected void defineSetters(Map<String, Setter<Activity>> setters) {
        setters.put("_id", (p, v) -> p.setId(v.toString()));
        setters.put("event_id", (p, v) -> p.setEventId(textConverter.from(v)));
        setters.put("name", (p, v) -> p.setName(textConverter.from(v)));
        setters.put("description", (p, v) -> p.setDescription(textConverter.from(v)));
        setters.put("date", (p, v) -> p.setDate(dateConverter.from(v)));
        setters.put("time", (p, v) -> p.setTime(timeConverter.from(v)));
        setters.put("place", (p, v) -> p.setPlace(textConverter.from(v)));
        setters.put("address", (p, v) -> p.setAddress(addressConverter.from(v)));
        setters.put("spots", (p, v) -> p.setSpots(quantityConverter.from(v)));
        setters.put("duration", (p, v) -> p.setDuration(minutesConverter.from(v)));
        setters.put("points", (p, v) -> p.setPoints(quantityConverter.from(v)));
        setters.put("group_discount", (p, v) -> p.setGroupDiscount(booleanicConverter.from(v)));
        setters.put("voucher", (p, v) -> p.setVoucher(booleanicConverter.from(v)));
    }

    protected Activity makeNew() {
        return new Activity();
    }
}
