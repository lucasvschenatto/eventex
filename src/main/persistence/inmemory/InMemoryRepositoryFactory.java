package main.persistence.inmemory;

import main.domain.account.UserRepository;
import main.domain.activity.ActivityRepository;
import main.domain.associate.AssociateRepository;
import main.domain.category.CategoryRepository;
import main.domain.event.EventRepository;
import main.domain.inscription.InscriptionRepository;
import main.domain.participant.ParticipantRepository;
import main.domain.profession.ProfessionRepository;

public abstract class InMemoryRepositoryFactory {
	private static InMemoryActivityRepository activity;
	private static AssociateRepository associate;
	private static CategoryRepository category;
	private static InMemoryEventRepository event;
	private static InscriptionRepository inscription;
	private static ParticipantRepository participant;
	private static InMemoryProfessionRepository profession;
	private static InMemoryUserRepository user;
	public static void resetAll() {
		activity = null;
		event = null;
		category = null;
		associate = null;
		user = null;
		profession = null;
	}

	public static ActivityRepository getActivityRepository() {
		if(activity == null)
			activity = new InMemoryActivityRepository();
		return activity;
	}
	
	public static AssociateRepository getAssociateRepository() {
		if(associate == null)
			associate = new InMemoryAssociateRepository();
		return associate;
	}

	public static CategoryRepository getCategoryRepository() {
		if(category == null)
			category = new InMemoryCategoryRepository();
		return category;
	}

	public static EventRepository getEventRepository() {
		if(event == null)
			event = new InMemoryEventRepository();
		return event;
	}
	
	public static InscriptionRepository getInscriptionRepository() {
		if(inscription == null)
			inscription = new InMemoryInscriptionRepository();
		return inscription;
	}

	public static ParticipantRepository getParticipantRepository() {
		if(participant == null)
			participant = new InMemoryParticipantRepository();
		return participant;
	}

	public static ProfessionRepository getProfessionRepository() {
		if(profession == null)
			profession = new InMemoryProfessionRepository();
		return profession;
	}

	public static UserRepository getUserRepository() {
		if(user == null)
			user = new InMemoryUserRepository();
		return user;
	}

}
