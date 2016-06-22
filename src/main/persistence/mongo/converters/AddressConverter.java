package main.persistence.mongo.converters;

import main.domain.Address;
import main.domain.AddressData;
import main.persistence.mongo.Converter;
import org.bson.Document;

public class AddressConverter implements Converter<Address, Document> {
    public Document to(Address entity) {
        Document document = new Document();
        document.put("street", entity.getStreet().toString());
        document.put("number", entity.getNumber().toString());
        document.put("complement", entity.getComplement().toString());
        document.put("neighborhood", entity.getNeighborhood().toString());
        document.put("city", entity.getCity().toString());
        document.put("state", entity.getState().toString());
        document.put("country", entity.getCountry().toString());
        document.put("cep", entity.getCEP().toString());
        return document;
    }

    public Address fromPersisted(Document document) {
    	AddressData data = new AddressData();
    	data.street = document.getString("street");
    	data.number = document.getString("number");
    	data.complement = document.getString("complement");
    	data.neighborhood = document.getString("neighborhood");
    	data.city = document.getString("city");
    	data.state = document.getString("state");
    	data.country = document.getString("country");
    	data.cep = document.getString("cep");
        return new Address(data);
    }
}
