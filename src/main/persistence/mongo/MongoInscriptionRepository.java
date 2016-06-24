package main.persistence.mongo;

import java.util.HashMap;
import java.util.Map;

import org.bson.Document;
import org.bson.conversions.Bson;

import main.domain.Text;
import main.domain.inscription.Inscription;
import main.domain.inscription.InscriptionRepository;
import main.persistence.mongo.converters.InscriptionConverter;
import main.persistence.mongo.converters.TextConverter;

public class MongoInscriptionRepository extends MongoRepository<Inscription> implements InscriptionRepository {
	private TextConverter textConverter = new TextConverter();
	
	protected MongoInscriptionRepository() {
		super("inscriptions", new InscriptionConverter());
	}

	public boolean inscriptionExists(Text participantId, Text activityId) {
		return participantId.isValid() && activityId.isValid() &&
				hasWith(makeParticipantActivityQuery(participantId, activityId));
	}

	private Bson makeParticipantActivityQuery(Text participantId, Text activityId) {
		Map<String, Object> conditions = new HashMap<String, Object>();
		conditions.put("participant_id", textConverter.to(participantId));
		conditions.put("activity_id", textConverter.to(activityId));
		return new Document(conditions);
	}

	public boolean hasWithParticipantId(Text participantId) {
		return hasWith(makeParticipantIdQuery(participantId));
	}

	public Iterable<Inscription> getAllByParticipantId(Text participantId) {
		return getAllBy(makeParticipantIdQuery(participantId));
	}
	
	private Bson makeParticipantIdQuery(Text participantId) {
		return new Document("participant_id", textConverter.to(participantId));
	}
}
