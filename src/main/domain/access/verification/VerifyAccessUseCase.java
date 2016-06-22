package main.domain.access.verification;

import main.domain.account.UserRepository;
import main.domain.activity.ActivityRepository;
import main.domain.associate.AssociateRepository;
import main.domain.category.CategoryRepository;
import main.domain.certificate.CertificateRepository;
import main.domain.event.EventRepository;
import main.domain.inscription.InscriptionRepository;
import main.domain.participant.ParticipantRepository;
import main.domain.profession.ProfessionRepository;

public class VerifyAccessUseCase {
	private ActivityRepository activityRepository;
	private AssociateRepository associateRepository;
	private CategoryRepository categoryRepository;
	private CertificateRepository certificateRepository;
	private EventRepository eventRepository;
	private ParticipantRepository participantRepository;
	private ProfessionRepository professionRepository;
	private UserRepository userRepository;
	private InscriptionRepository inscriptionRepository;

}
