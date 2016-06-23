package main.domain.inscription;

import main.domain.Repository;
import main.domain.Text;

public interface InscriptionRepository extends Repository<Inscription> {
	
	public boolean inscriptionExists(Text participantId, Text activityId);
	
	public boolean hasWithParticipantId(Text participantId);
	
	public Iterable<Inscription> getAllByParticipantId(Text participantId);
}
