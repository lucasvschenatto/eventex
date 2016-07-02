package main.persistence.inmemory;

import java.util.HashMap;
import java.util.Map;

import main.domain.Text;
import main.domain.participant.Participant;
import main.domain.participant.ParticipantRepository;
import main.persistence.EntityNotFoundException;

public class InMemoryParticipantRepository extends InMemoryRepository<Participant> implements ParticipantRepository {
	private Map<Text,Participant> participants = new HashMap<Text,Participant>();

	public Participant getByUserId(Text userId) {
		if(hasWithUserId(userId))
			return makeCopy(participants.get(userId));
		else
			throw new EntityNotFoundException();
	}
	public boolean hasWithUserId(Text userId) {
		return participants.containsKey(userId);
	}
	
	public void save(Participant p){
		if (hasWithId(p.getId()))
			participants.remove(getById(p.getId()).getUserId());
		super.save(p);
		participants.put(p.getUserId(), getById(p.getId()));
	}
}