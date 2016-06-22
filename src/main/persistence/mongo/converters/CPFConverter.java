package main.persistence.mongo.converters;

import main.domain.account.CPF;
import main.persistence.mongo.Converter;

public class CPFConverter implements Converter<CPF, String>{

	public String to(CPF entity) {
		return entity.toString();
	}

	public CPF fromPersisted(String document) {
		return new CPF(document);
	}

}
