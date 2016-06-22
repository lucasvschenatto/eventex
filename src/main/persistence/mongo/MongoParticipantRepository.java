package main.persistence.mongo;

import main.domain.participant.Participant;
import main.domain.participant.ParticipantRepository;
import main.persistence.mongo.converters.ParticipantConverter;

public class MongoParticipantRepository extends MongoRepository<Participant> implements ParticipantRepository {
	public MongoParticipantRepository(){
		super("participants", new ParticipantConverter());
	}
}