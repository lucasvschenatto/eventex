package main.domain.certificate;

import main.domain.Date;
import main.domain.Text;
import main.domain.inscription.InscriptionRepository;
import main.domain.participant.Participant;
import main.domain.participant.ParticipantRepository;
import main.domain.activity.Activity;
import main.domain.activity.ActivityRepository;

public class PrintCertificateUseCase {
	private final ActivityRepository activityRepository;
	private final ParticipantRepository participantRepository;
	private final InscriptionRepository inscriptionRepository;
	private final String activityId;
	private final String participantId;
	private final PrintCertificateResponse response;
	
	public PrintCertificateUseCase(ActivityRepository activityRepository, 
			ParticipantRepository participantRepository, InscriptionRepository inscriptionRepository,
			PrintCertificateRequest request, PrintCertificateResponse response){
		this.activityRepository = activityRepository;
		this.participantRepository = participantRepository;
		this.inscriptionRepository = inscriptionRepository;
		activityId = request.activityId;
		participantId = request.participantId;
		this.response = response;
	}
	
	public void execute(){
		if(isValidRequest())
			sendCertificate();
		else
			sendErrors();
	}
	
	public boolean isValidRequest(){
		return activityExists() && participantExists() && attendedInActivity();
	}
	
	private boolean activityExists() {
		return activityRepository.hasWithId(activityId);
	}

	private boolean participantExists() {
		return participantRepository.hasWithId(participantId);
	}

	private boolean attendedInActivity() {
		return inscriptionRepository.inscriptionExists(new Text(participantId), new Text(activityId));
	}

	private void sendCertificate() {
		response.certificate = new PDF().from(makeCertificate());
		response.success = true;
	}
	
	private Certificate makeCertificate() {
		Certificate certificate = new Certificate();
		Participant p = participantRepository.getById(participantId);
		Activity a = activityRepository.getById(activityId);
		certificate.setName(p.getName());
		certificate.setCourse(a.getName());
		certificate.setDuration(a.getDuration());
		certificate.setCourseDate(a.getDate());
		certificate.setScore(a.getPoints());
		certificate.setCertificateDate(Date.now());
		return certificate;
	}
	
	private void sendErrors() {
		response.invalidActivityId = ! activityExists();
		response.invalidParticipantId = ! participantExists();
		response.notAttendedInActivity = activityExists() && participantExists() && attendedInActivity();
	}
}
