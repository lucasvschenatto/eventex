package main.persistence.inmemory;

import java.util.HashMap;
import java.util.Map;

import main.domain.Text;
import main.domain.inscription.Inscription;
import main.domain.inscription.InscriptionRepository;

public class InMemoryInscriptionRepository extends InMemoryRepository<Inscription> implements InscriptionRepository {
	private Map<Text, Inscription> participantKey = new HashMap<Text, Inscription>();
	private Map<Text, Inscription> activityKey = new HashMap<Text, Inscription>();
	
	public boolean inscriptionExists(Text participantId, Text activityId) {
		return hasWithParticipantId(participantId) && hasWithActivityId(activityId);
	}

	
	private boolean hasWithActivityId(Text activityId) {
		return activityKey.containsKey(activityId);
	}


	public boolean hasWithParticipantId(Text participantId) {
		return participantKey.containsKey(participantId);
	}

	
	public Iterable<Inscription> getAllByParticipantId(Text participantId) {
		return participantKey.values();
	}
	
	public void save(Inscription inscription){
		super.save(inscription);
		Inscription saved = getById(inscription.getId());
		participantKey.put(inscription.getParticipantId(), saved);
		activityKey.put(inscription.getActivityId(), saved);
	}
}
