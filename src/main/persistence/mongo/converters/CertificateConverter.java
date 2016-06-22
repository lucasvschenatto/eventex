package main.persistence.mongo.converters;

import main.domain.certificate.Certificate;
import java.util.Map;

public class CertificateConverter extends EntityConverter<Certificate> {
    private TextConverter textConverter = new TextConverter();
    private QuantityConverter quantityConverter = new QuantityConverter();
    private DateConverter dateConverter = new DateConverter();

    protected void defineGetters(Map<String, Getter<Certificate>> getters) {
        getters.put("name", (p) -> textConverter.to(p.getName()));
        getters.put("course", (p) -> textConverter.to(p.getCourse()));
        getters.put("hours", (p) -> quantityConverter.to(p.getHours()));
        getters.put("date", (p) -> dateConverter.to(p.getDate()));
        getters.put("score", (p) -> quantityConverter.to(p.getScore()));
    }

    protected void defineSetters(Map<String, Setter<Certificate>> setters) {
        setters.put("_id", (p, v) -> p.setId(v.toString()));
        setters.put("name", (p, v) -> p.setName(textConverter.from(v)));
        setters.put("course", (p, v) -> p.setCourse(textConverter.from(v)));
        setters.put("hours", (p, v) -> p.setHours(quantityConverter.from(v)));
        setters.put("date", (p, v) -> p.setDate(dateConverter.from(v)));
        setters.put("score", (p, v) -> p.setScore(quantityConverter.from(v)));
    }

    protected Certificate makeNew() {
        return new Certificate();
    }
}
