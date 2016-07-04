package main.domain.account.login;

import main.domain.Email;
import main.domain.Text;
import main.domain.account.*;
import main.domain.admin.AdminRepository;
import main.domain.participant.ParticipantRepository;

public class LoginUseCase {
    private final UserRepository userRepository;
    private final AdminRepository adminRepository;
    private final ParticipantRepository participantRepository;
    private final Encryptor encryptor;
    private final LoginResponse response;
    private final Email email;
    private final Password password;

    public LoginUseCase(UserRepository repository, AdminRepository adminRepository, ParticipantRepository participantRepository,
    		LoginRequest request, LoginResponse response, Encryptor encryptor) {
        this.userRepository = repository;
        this.adminRepository = adminRepository;
        this.participantRepository = participantRepository;
        password = new Password(request.password);
        email = new Email(request.email);
        this.response = response;
        this.encryptor = encryptor;
    }

    public void execute() {
        if (emailIsRegistered())
            checkPassword();
        else
            sendInvalidEmailOrPassword();
    }

    private boolean emailIsRegistered() {
        return userRepository.hasWithEmail(email);
    }

    private void checkPassword() {
        User user = userRepository.getByEmail(email);
        if (encryptor.matches(password, user.getPassword())){
            sendSuccess(user.getId());
            loadProfiles(user.getId());
        }
        else
            sendInvalidEmailOrPassword();
    }

    private void loadProfiles(String userId) {
		loadAdminProfile(userId);
		loadParticipantProfile(userId);
	}

	private void loadAdminProfile(String userId) {
		if(adminRepository.hasWithUserId(new Text(userId)))
			response.adminId = adminRepository.getByUserId(new Text(userId)).getId();
	}

	private void loadParticipantProfile(String userId) {
		if(participantRepository.hasWithUserId(new Text(userId)))
			response.participantId = participantRepository.getByUserId(new Text(userId)).getId();
	}

	private void sendInvalidEmailOrPassword() {
        response.invalidEmailOrPassword = true;
    }

    private void sendSuccess(String id) {
        response.userId = id;
        response.success = true;
    }
}
