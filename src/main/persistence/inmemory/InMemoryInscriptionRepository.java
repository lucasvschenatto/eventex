package main.persistence.inmemory;

import main.domain.Text;
import main.domain.inscription.Inscription;
import main.domain.inscription.InscriptionRepository;

public class InMemoryInscriptionRepository extends InMemoryRepository<Inscription> implements InscriptionRepository {

	@Override
	public boolean inscriptionExists(Text participantId, Text activityId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasWithParticipantId(Text participantId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Inscription> getAllByParticipantId(Text participantId) {
		// TODO Auto-generated method stub
		return null;
	}
}
