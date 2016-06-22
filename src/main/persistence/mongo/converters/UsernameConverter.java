package main.persistence.mongo.converters;

import main.domain.account.Username;
import main.persistence.mongo.Converter;

public class UsernameConverter implements Converter<Username, String>{

	public String to(Username entity) {
		return entity.toString();
	}

	public Username fromPersisted(String document) {
		return new Username(document);
	}

}
