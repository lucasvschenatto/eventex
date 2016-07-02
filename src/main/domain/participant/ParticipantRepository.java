package main.domain.participant;

import main.domain.Repository;
import main.domain.Text;

public interface ParticipantRepository extends Repository<Participant> {
	boolean hasWithUserId(Text userId);
	Participant getByUserId(Text userId);
}
