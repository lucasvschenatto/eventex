package main;

import main.domain.*;
import main.domain.account.*;
import main.domain.activity.*;
import main.domain.admin.Admin;
import main.domain.admin.AdminRepository;
import main.domain.associate.*;
import main.domain.category.*;
import main.domain.event.*;
import main.domain.inscription.*;
import main.domain.participant.*;
import main.domain.profession.*;
import main.persistence.inmemory.InMemoryFactory;

public class NewFrontEndMain {
	private static final String ACTIVITY_ID = "activityId";
	private static final String ADMIN_ID = "adminId";
	private static final String CATEGORY_ID = "categoryId";
	private static final String EVENT_ID = "eventId";
	private static final String EVENT_ID2 = "eventId2";
	private static final String INSCRIPTION_ID = "inscriptionId";
	private static final String PARTICIPANT_ID = "participantId";
	private static final String PROFESSION_ID = "professionId";
	private static final String PROFESSION_ID2 = "professionId2";
	private static final String PROFESSION_ID3 = "professionId3";
	private static final String USER_ID = "userId";
	private static final String ASSOCIATE_ID = "associateId";
	private static final String ASSOCIATE_CODE = "STDNTUNI16";
	private static ActivityRepository actr;
	private static AdminRepository adminr;
	private static AssociateRepository assr;
	private static CategoryRepository catr;
	private static EventRepository evnr;
	private static InscriptionRepository inscr;
	private static ParticipantRepository partr;
	private static ProfessionRepository profr;
	private static UserRepository ur;
	
	public static void main(String[] args) {
		createDummyData();
		Main.setFactory(InMemoryFactory.getInstance());
		Main.main();
	}

	private static void createDummyData() {
		setRepositories();
		createUserAndProfiles();
		createAssociate();
		createProfessions();
		createCategory();
		createEvents();
		createActivity();
		CreateInscription();
	}

	private static void CreateInscription() {
		Inscription i = new Inscription();
		i.setId(INSCRIPTION_ID);
		i.setParticipantId(new Text(PARTICIPANT_ID));
		i.setActivityId(new Text(ACTIVITY_ID));
		i.setCategoryId(new Text(CATEGORY_ID));
		i.setAssociateCode(new Text(ASSOCIATE_CODE));
		inscr.save(i);
	}

	private static void createUserAndProfiles() {
		User u = new User();
		u.setUsername(new Username("username"));
		u.setEmail(new Email("username@domain.com"));
		u.setCPF(new CPF("000000001-91"));
		u.setId(USER_ID);
		u.setPassword(new EncryptedPassword("","123456"));
		ur.save(u);
		
		createParticipant();
		createAdmin();
	}

	private static void createParticipant() {
		Participant p = new Participant();
		p.setId(PARTICIPANT_ID);
		p.setUserId(new Text(USER_ID));
		p.setName(new Text("Nome do Participante"));
		partr.save(p);
	}

	private static void createAdmin() {
		Admin a = new Admin();
		a.setId(ADMIN_ID);
		a.setUserId(new Text(USER_ID));
		a.setName(new Text("Lucas"));
		a.setRole(new Text("admnistrador do sistema"));
		adminr.save(a);
	}

	private static void setRepositories() {
		RepositoryFactory f = InMemoryFactory.getInstance();
		ur = f.getUserRepository();
		actr = f.getActivityRepository();
		adminr = f.getAdminRepository();
		assr = f.getAssociateRepository();
		catr = f.getCategoryRepository();
		evnr = f.getEventRepository();
		inscr = f.getInscriptionRepository();
		partr = f.getParticipantRepository();
		profr = f.getProfessionRepository();
		
	}

	private static void createAssociate() {
		Associate a = new Associate();
		a.setId(ASSOCIATE_ID);
		a.setActive(new Booleanic("true"));
		a.setCategoryId(new Text(CATEGORY_ID));
		a.setCode(new Text(ASSOCIATE_CODE));
		a.setName(new Text("Estudante Unisinos 2016"));
		a.setUpdateDate(new Date("2016-01-01"));
		assr.save(a);
		
	}

	private static void createActivity() {
		Activity a = new Activity();
		a.setId(ACTIVITY_ID);
		a.setEventId(new Text(EVENT_ID));
		a.setAddress(Address.EMPTY);
		a.setDate(new Date("2016-06-15"));
		a.setDescription(new Text("Descrição da atividade"));
		a.setDuration(new Minutes("90"));
		a.setGroupDiscount(Booleanic.FALSE);
		a.setName(new Text("Workshop de carreira"));
		a.setPlace(new Text("Salão principal"));
		a.setPoints(new Quantity("100"));
		a.setSpots(new Quantity("25"));
		a.setTime(new Time("02:30"));
		a.setVoucher(Booleanic.FALSE);
		actr.save(a);
	}

	private static void createCategory() {
		Category c = new Category();
		c.setId(CATEGORY_ID);
		c.setDescription(new Text("Alunos devidamente matriculados da Unisinos"));
		c.setDiscount(new Percentage("10"));
		c.setName(new Text("Aluno Unisinos"));
		c.setNeedCodeAtInscription(new Booleanic("true"));
		catr.save(c);
	}

	private static void createEvents() {
		Event e = new Event();
		e.setId(EVENT_ID);
		e.setAddress(Address.EMPTY);
		e.setDate(new Date("2016-06-15"));
		e.setDescription(new Text("Descrição do evento"));
		e.setName(new Text("Feira de carros"));
		e.setPlace(new Text("Rua Bento Gonçalves"));
		e.setTime(new Time("02:30"));
		evnr.save(e);
		
		e.setAddress(Address.EMPTY);
		e.setDate(new Date("2016-06-15"));
		e.setDescription(new Text("Descrição do evento"));
		e.setId(EVENT_ID2);
		e.setName(new Text("Chocofest"));
		e.setPlace(new Text("Centro de eventos municipal"));
		e.setTime(new Time("02:30"));
		evnr.save(e);
		
	}

	private static void createProfessions() {
		Profession p = new Profession();
		p.setName(new Text("Estudante"));
		p.setId(PROFESSION_ID);
		p.setDescription(new Text("Pessoa cuja ocupação é estudar"));
		profr.save(p);
		
		p.setName(new Text("Professor"));
		p.setId(PROFESSION_ID2);
		p.setDescription(new Text("Pessoa que ensina"));
		profr.save(p);
		
		p.setName(new Text("Marceneiro"));
		p.setId(PROFESSION_ID3);
		p.setDescription(new Text("Pessoa que trabalha com madeira"));
		profr.save(p);
	}

}