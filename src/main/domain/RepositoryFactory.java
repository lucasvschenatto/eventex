package main.domain;

import main.domain.account.UserRepository;
import main.domain.activity.ActivityRepository;
import main.domain.admin.AdminRepository;
import main.domain.associate.AssociateRepository;
import main.domain.category.CategoryRepository;
import main.domain.event.EventRepository;
import main.domain.inscription.InscriptionRepository;
import main.domain.participant.ParticipantRepository;
import main.domain.profession.ProfessionRepository;

public interface RepositoryFactory {

	public ActivityRepository getActivityRepository();
	
	public AdminRepository getAdminRepository();

	public AssociateRepository getAssociateRepository();

	public CategoryRepository getCategoryRepository();

	public EventRepository getEventRepository();
	
	public InscriptionRepository getInscriptionRepository();

	public ParticipantRepository getParticipantRepository();

	public ProfessionRepository getProfessionRepository();

	public UserRepository getUserRepository();

}