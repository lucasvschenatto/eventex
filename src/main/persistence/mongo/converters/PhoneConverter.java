package main.persistence.mongo.converters;

import main.domain.Phone;
import main.persistence.mongo.Converter;

public class PhoneConverter implements Converter<Phone, String>{

	public String to(Phone entity) {
		return entity.toString();
	}

	public Phone fromPersisted(String document) {
		return new Phone(document);
	}

}
