package main.persistence.inmemory;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import main.domain.Text;
import main.domain.inscription.Inscription;
import main.domain.inscription.InscriptionRepository;

public class InMemoryInscriptionRepository extends InMemoryRepository<Inscription> implements InscriptionRepository {
	private Map<Text, Map<Text,Inscription>> participantKey = new HashMap<Text, Map<Text,Inscription>>();
	
	public boolean inscriptionExists(Text participantId, Text activityId) {
		return hasWithParticipantId(participantId)?
				participantKey.get(participantId).containsKey(activityId) : false;
	}

	public boolean hasWithParticipantId(Text participantId) {
		return participantKey.containsKey(participantId);
	}

	
	public Iterable<Inscription> getAllByParticipantId(Text participantId) {
		Collection<Inscription> inscriptions = new HashSet<Inscription>();
		participantKey.forEach((participant,map)->inscriptions.addAll(map.values()));
		return inscriptions;
				
	}
	
	public void save(Inscription inscription){
		super.save(inscription);
		Inscription saved = getById(inscription.getId());
		if(participantKey.containsKey(saved.getParticipantId())){
			Map<Text,Inscription> existingAKey = participantKey.get(saved.getParticipantId());
			existingAKey.put(saved.getActivityId(), saved);
		}
		else{
			Map<Text,Inscription> newAKey = new HashMap<Text,Inscription>();
			newAKey.put(saved.getActivityId(), saved);
			participantKey.put(saved.getParticipantId(), newAKey);
		}
	}
}
