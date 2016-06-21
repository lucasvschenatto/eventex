package main.persistence.mongo;

import main.domain.participant.Participant;
import main.domain.participant.ParticipantRepository;

public class MongoParticipantRepository extends MongoRepository<Participant> implements ParticipantRepository {
	public MongoParticipantRepository(){
		super("participants",null);
	}
}