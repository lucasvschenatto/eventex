package main.routes;

import main.domain.account.Encryptor;
import main.domain.account.UserRepository;
import main.domain.activity.ActivityRepository;
import main.domain.associate.AssociateRepository;
import main.domain.category.CategoryRepository;
import main.domain.event.EventRepository;
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

	public ProfessionRepository getProfessionRepository() {
		return professionRepository;
	}

	public UserRepository getUserRepository() {
		return userRepository;
	}

	public void setActivityRepository(ActivityRepository activityRepository) {
		this.activityRepository = activityRepository;
	}

	public void setAssociateRepository(AssociateRepository associateRepository) {
		this.associateRepository = associateRepository;
	}

	public void setEncryptor(Encryptor encryptor) {
		this.encryptor = encryptor;
	}

	public void setEventRepository(EventRepository eventRepository) {
		this.eventRepository = eventRepository;
	}

	public void setCategoryRepository(CategoryRepository participantCategoryRepository) {
		this.categoryRepository = participantCategoryRepository;
	}

	public void setProfessionRepository(ProfessionRepository professionRepository){
		this.professionRepository = professionRepository;
	}
	
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public ParticipantRepository getParticipantRepository() {
		return participantRepository;
	}

	public void setParticipantRepository(ParticipantRepository participantRepository) {
		this.participantRepository = participantRepository;
	}

}
