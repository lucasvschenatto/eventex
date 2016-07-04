package main.persistence.mongo;

import org.bson.Document;
import org.bson.conversions.Bson;

import main.domain.Text;
import main.domain.participant.Participant;
import main.domain.participant.ParticipantRepository;
import main.persistence.mongo.converters.ParticipantConverter;
import main.persistence.mongo.converters.TextConverter;

public class MongoParticipantRepository extends MongoRepository<Participant> implements ParticipantRepository {
	private TextConverter textConverter = new TextConverter();
	
	public MongoParticipantRepository(){
		super("participants", new ParticipantConverter());
	}
	
	public boolean hasWithUserId(Text code) {
		return code.isValid() && 
			hasWith(makeAssociateCodeQuery(code));
	}

	public Participant getByUserId(Text code) {
		return getBy(makeAssociateCodeQuery(code));
	}

	private Bson makeAssociateCodeQuery(Text code) {
		return new Document("user_id", textConverter.to(code));
	}
}