package main.persistence.inmemory;

import main.domain.RepositoryFactory;
import main.domain.account.UserRepository;
import main.domain.activity.ActivityRepository;
import main.domain.admin.AdminRepository;
import main.domain.associate.AssociateRepository;
import main.domain.category.CategoryRepository;
import main.domain.event.EventRepository;
import main.domain.inscription.InscriptionRepository;
import main.domain.participant.ParticipantRepository;
import main.domain.profession.ProfessionRepository;

public class InMemoryFactory implements RepositoryFactory {

	private static InMemoryFactory instance;

	private ActivityRepository activity;
	private AdminRepository admin;
	private AssociateRepository associate;
	private CategoryRepository category;
	private EventRepository event;
	private InscriptionRepository inscription;
	private ParticipantRepository participant;
	private ProfessionRepository profession;
	private UserRepository user;


	private InMemoryFactory(){
		activity = new InMemoryActivityRepository();
		admin = new InMemoryAdminRepository();
		associate = new InMemoryAssociateRepository();
		category = new InMemoryCategoryRepository();
		event = new InMemoryEventRepository();
		inscription = new InMemoryInscriptionRepository();
		participant = new InMemoryParticipantRepository();
		profession = new InMemoryProfessionRepository();
		user = new InMemoryUserRepository();
	}
	
	public static InMemoryFactory getInstance(){
		if( instance == null)
			instance = new InMemoryFactory();
		return instance;
	}
	public static void reset() {
		instance = null;
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
	public AdminRepository getAdminRepository() {
		return admin;
	}

}
