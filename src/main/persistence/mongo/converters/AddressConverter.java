package main.persistence.mongo.converters;

import main.domain.Address;
import main.domain.AddressData;
import main.persistence.mongo.Converter;
import org.bson.Document;

public class AddressConverter implements Converter<Address, Document> {
    public Document to(Address entity) {
        Document document = new Document();
        document.put("street", entity.getStreet());
        document.put("number", entity.getNumber());
        document.put("complement", entity.getComplement());
        document.put("neighborhood", entity.getNeighborhood());
        document.put("city", entity.getCity());
        document.put("state", entity.getState());
        document.put("country", entity.getCountry());
        document.put("cep", entity.getCEP());
        return document;
    }

    public Address fromPersisted(Document document) {
    	AddressData data = new AddressData();
    	data.street = document.getString("street");
    	data.number = document.getString("number");
    	data.complement = document.getString("complement");
    	data.neighborhood = document.getString("neighborhod");
    	data.city = document.getString("city");
    	data.state = document.getString("state");
    	data.country = document.getString("country");
    	data.cep = document.getString("cep");
        return new Address(data);
    }
}
