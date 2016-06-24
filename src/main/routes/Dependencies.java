package main.routes;

import main.domain.RepositoryFactory;
import main.domain.account.Encryptor;
import main.domain.account.UserRepository;
import main.domain.activity.ActivityRepository;
import main.domain.associate.AssociateRepository;
import main.domain.category.CategoryRepository;
import main.domain.event.EventRepository;
import main.domain.inscription.InscriptionRepository;
import main.domain.participant.ParticipantRepository;
import main.domain.profession.ProfessionRepository;

public class Dependencies {
	private ActivityRepository activityRepository;
	private AssociateRepository associateRepository;
	private CategoryRepository categoryRepository;
	private Encryptor encryptor;
	private EventRepository eventRepository;
	private ParticipantRepository participantRepository;
	private ProfessionRepository professionRepository;
	private UserRepository userRepository;
	private InscriptionRepository inscriptionRepository;
	private String externalFileLocation;
	public ActivityRepository getActivityRepository() {
		return activityRepository;
	}

	public AssociateRepository getAssociateRepository() {
		return associateRepository;
	}

	public CategoryRepository getCategoryRepository() {
		return categoryRepository;
	}

	public Encryptor getEncryptor() {
		return encryptor;
	}

	public EventRepository getEventRepository() {
		return eventRepository;
	}

	public InscriptionRepository getInscriptionRepository() {
		return inscriptionRepository;
	}

	public ProfessionRepository getProfessionRepository() {
		return professionRepository;
	}

	public UserRepository getUserRepository() {
		return userRepository;
	}

	public ParticipantRepository getParticipantRepository() {
		return participantRepository;
	}

	public void setEncryptor(Encryptor encryptor) {
		this.encryptor = encryptor;
	}

	public void setRepositoryFactory(RepositoryFactory factory) {
		activityRepository = factory.getActivityRepository();
		associateRepository = factory.getAssociateRepository();
		categoryRepository = factory.getCategoryRepository();
		eventRepository = factory.getEventRepository();
		inscriptionRepository = factory.getInscriptionRepository();
		participantRepository = factory.getParticipantRepository();
		professionRepository = factory.getProfessionRepository();
		userRepository = factory.getUserRepository();
		participantRepository = factory.getParticipantRepository();
	}
	
	public String getStaticFileLocation(){
		return externalFileLocation;
	}

	public void setStaticFileLocation(String externalFileLocation) {
		this.externalFileLocation = externalFileLocation;		
	}
}
