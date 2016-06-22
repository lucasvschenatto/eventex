package main.persistence.mongo;

import main.domain.RepositoryFactory;
import main.domain.account.UserRepository;
import main.domain.activity.ActivityRepository;
import main.domain.associate.AssociateRepository;
import main.domain.category.CategoryRepository;
import main.domain.certificate.CertificateRepository;
import main.domain.event.EventRepository;
import main.domain.inscription.InscriptionRepository;
import main.domain.participant.ParticipantRepository;
import main.domain.profession.ProfessionRepository;

public class MongoFactory implements RepositoryFactory {
	
	private static MongoFactory instance;
	
	private ActivityRepository activity;
	private AssociateRepository associate;
	private CategoryRepository category;
	private CertificateRepository certificate;
	private EventRepository event;
	private InscriptionRepository inscription;
	private ParticipantRepository participant;
	private ProfessionRepository profession;
	private UserRepository user;
	
	private MongoFactory(){
		activity = new MongoActivityRepository();
		associate = new MongoAssociateRepository();
		category = new MongoCategoryRepository();
		certificate = new MongoCertificateRepository();
		event = new MongoEventRepository();
		inscription = new MongoInscriptionRepository();
		participant = new MongoParticipantRepository();
		profession = new MongoProfessionRepository();
		user = new MongoUserRepository();
	}
	
	public static MongoFactory getInstance(){
		if(instance == null)
			instance = new MongoFactory();
		return instance;
	}

	public ActivityRepository getActivityRepository() {
		return activity;
	}
	
	public AssociateRepository getAssociateRepository() {
		return associate;
	}

	public CategoryRepository getCategoryRepository() {
		return category;
	}

	public EventRepository getEventRepository() {
		return event;
	}
	
	public InscriptionRepository getInscriptionRepository() {
		return inscription;
	}

	public ParticipantRepository getParticipantRepository() {
		return participant;
	}

	public ProfessionRepository getProfessionRepository() {
		return profession;
	}

	public UserRepository getUserRepository() {
		return user;
	}

	@Override
	public CertificateRepository getCertificateRepository() {
		return certificate;
	}

}
