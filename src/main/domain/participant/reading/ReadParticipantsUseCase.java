package main.domain.participant.reading;

import java.util.Collection;

import main.domain.participant.Participant;
import main.domain.participant.ParticipantRepository;

public class ReadParticipantsUseCase {
    private final ParticipantRepository repository;
    private final Collection<ParticipantSummary> response;

    public ReadParticipantsUseCase(ParticipantRepository repository, Collection<ParticipantSummary> response) {
        this.repository = repository;
        this.response = response;
    }

    public void execute() {
        for (Participant participant : repository.getAll())
            response.add(makeParticipantSummary(participant));
    }

    private ParticipantSummary makeParticipantSummary(Participant participant) {
        ParticipantSummary summary = new ParticipantSummary();
        summary.id = participant.getId();
        summary.name = participant.getName().toString();
        summary.userId = participant.getUserId().toString();
        summary.nametag = participant.getNametag().toString();
        summary.nationality = participant.getNationality().toString();
        summary.gender = participant.getGender().toString();
        summary.education = participant.getEducation().toString();
        summary.birth = participant.getBirth().toString();
        summary.homeAddress = participant.getHomeAddress().toSummary();
        summary.homePhone = participant.getHomePhone().toString();
        summary.cellphone = participant.getCellphone().toString();
        summary.professionId = participant.getProfessionId().toString();
        summary.organization = participant.getOrganization().toString();
        summary.department = participant.getDepartment().toString();
        summary.role = participant.getRole().toString();
        summary.workAddress = participant.getWorkAddress().toSummary();
        summary.workPhone = participant.getWorkPhone().toString();
        summary.workCellphone = participant.getWorkCellphone().toString();
        summary.workEmail = participant.getWorkEmail().toString();
        return summary;
    }
}
