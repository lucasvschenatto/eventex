package main.persistence.mongo;

import main.domain.Text;
import main.domain.inscription.Inscription;
import main.domain.inscription.InscriptionRepository;
import main.persistence.mongo.converters.InscriptionConverter;

public class MongoInscriptionRepository extends MongoRepository<Inscription> implements InscriptionRepository {

	protected MongoInscriptionRepository() {
		super("inscriptions", new InscriptionConverter());
	}

	public boolean inscriptionExists(Text participantId, Text activityId) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean hasWithParticipantId(Text participantId) {
		// TODO Auto-generated method stub
		return false;
	}

	public Iterable<Inscription> getAllByParticipantId(Text participantId) {
		// TODO Auto-generated method stub
		return null;
	}
}
