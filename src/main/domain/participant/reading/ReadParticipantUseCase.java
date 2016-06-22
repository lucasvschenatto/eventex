package main.domain.participant.reading;

import main.domain.participant.Participant;
import main.domain.participant.ParticipantRepository;

public class ReadParticipantUseCase {
	private final String id;
    private final ParticipantRepository repository;
    private final ParticipantSummary response;

    public ReadParticipantUseCase(ParticipantRepository repository, ReadParticipantRequest request, ParticipantSummary response) {
        id = request.id;
    	this.repository = repository;
        this.response = response;
    }

    public void execute() {
    	if(participantExists())
    		sendParticipant();
    }

    private boolean participantExists() {
		return repository.hasWithId(id);
	}

	private void sendParticipant() {
		Participant participant = repository.getById(id);
		response.id = participant.getId();
		response.name = participant.getName().toString();
		response.userId = participant.getUserId().toString();
		response.nametag = participant.getNametag().toString();
		response.nationality = participant.getNationality().toString();
		response.gender = participant.getGender().toString();
		response.education = participant.getEducation().toString();
		response.birth = participant.getBirth().toString();
		response.homeAddress = participant.getHomeAddress().toSummary();
		response.homePhone = participant.getHomePhone().toString();
		response.cellphone = participant.getCellphone().toString();
		response.professionId = participant.getProfessionId().toString();
		response.organization = participant.getOrganization().toString();
		response.department = participant.getDepartment().toString();
		response.role = participant.getRole().toString();
		response.workAddress = participant.getWorkAddress().toSummary();
		response.workPhone = participant.getWorkPhone().toString();
		response.workCellphone = participant.getWorkCellphone().toString();
		response.workEmail = participant.getWorkEmail().toString();
    }
}
