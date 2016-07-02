package main.persistence.mongo;

import org.bson.Document;
import org.bson.conversions.Bson;

import main.domain.Text;
import main.domain.associate.Associate;
import main.domain.associate.AssociateRepository;
import main.persistence.mongo.converters.AssociateConverter;
import main.persistence.mongo.converters.TextConverter;

public class MongoAssociateRepository extends MongoRepository<Associate> implements AssociateRepository{
	private TextConverter textConverter = new TextConverter();

	protected MongoAssociateRepository() {
		super("associates", new AssociateConverter());
	}

	public boolean hasWithCode(Text code) {
		return code.isValid() && 
			hasWith(makeAssociateCodeQuery(code));
	}

	public Associate getByCode(Text code) {
		return getBy(makeAssociateCodeQuery(code));
	}

	private Bson makeAssociateCodeQuery(Text code) {
		return new Document("code", textConverter.to(code));
	}
}
