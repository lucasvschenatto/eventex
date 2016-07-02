package main.domain.account.login;

import main.domain.Text;
import main.domain.account.UserRepository;
import main.domain.account.reading.ReadUserRequest;
import main.domain.account.reading.ReadUserResponse;
import main.domain.account.reading.ReadUserUseCase;
import main.domain.account.registration.RegisterRequest;
import main.domain.account.registration.RegisterResponse;
import main.domain.account.registration.RegisterUseCase;
import main.domain.admin.Admin;
import main.domain.admin.AdminRepository;
import main.domain.participant.Participant;
import main.domain.participant.ParticipantRepository;
import main.persistence.inmemory.InMemoryAdminRepository;
import main.persistence.inmemory.InMemoryParticipantRepository;
import main.persistence.inmemory.InMemoryUserRepository;
import main.security.FakeEncryptor;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class LoginUseCaseTest {
    private LoginRequest request;
    private LoginResponse response;
    private UserRepository userRepository;
    private AdminRepository adminRepository;
    private ParticipantRepository participantRepository;

    private String givenUser(String username, String cpf, String email, String password) {
        RegisterRequest request = new RegisterRequest();
        request.username = username;
        request.cpf = cpf;
        request.email = email;
        request.password = password;
        request.passwordConfirmation = password;
        RegisterResponse response = new RegisterResponse();
        new RegisterUseCase(userRepository, request, response, new FakeEncryptor()).execute();
        return response.id;
    }

    private void givenLogInData(String email, String password) {
        request.email = email;
        request.password = password;
    }

    private void whenLoggingIn() {
        new LoginUseCase(userRepository, adminRepository, participantRepository,
        		request, response, new FakeEncryptor()).execute();
    }

    private void thenEmailOrPasswordShouldBeInvalid() {
        assertFalse(response.success);
        assertTrue(response.invalidEmailOrPassword);
    }

    private void thenItMustHaveLoggedInWithUser(String email) {
        assertTrue(response.success);
        assertFalse(response.invalidEmailOrPassword);
        assertEquals(email, readUser(response.userId).email);
    }
    
    private void thenItMustHaveSessionIds(String userId,String adminId, String participantId) {
        assertTrue(response.success);
        assertFalse(response.invalidEmailOrPassword);
        assertEquals(userId,response.userId);
        assertEquals(adminId, response.adminId);
        assertEquals(participantId, response.participantId);
    }

    private ReadUserResponse readUser(String id) {
        ReadUserRequest request = new ReadUserRequest();
        request.id = id;
        ReadUserResponse response = new ReadUserResponse();
        new ReadUserUseCase(userRepository, request, response).execute();
        return response;
    }

    private void givenParticipant(String userId, String participantId, String name) {
		Participant p = new Participant();
		p.setId(participantId);
		p.setUserId(new Text(userId));
		p.setName(new Text(name));
		participantRepository.save(p);
	}

	private void givenAdmin(String userId, String adminId, String name) {
		Admin a = new Admin();
		a.setId(adminId);
		a.setUserId(new Text(userId));
		a.setName(new Text(name));
		adminRepository.save(a);
		
	}

	@Before
    public void setUp() throws Exception {
        request = new LoginRequest();
        response = new LoginResponse();
        userRepository = new InMemoryUserRepository();
        adminRepository = new InMemoryAdminRepository();
        participantRepository = new InMemoryParticipantRepository();
    }

    @Test
    public void whenNoUserExists_logInMustReturnError() {
        givenLogInData("email@host.com", "Passw0rd");
        whenLoggingIn();
        thenEmailOrPasswordShouldBeInvalid();
    }

    @Test
    public void givenAUser_butLoggingWithAnotherEmail_itMustReturnError() {
        givenUser("username", "000000001-91", "email@host.com", "Passw0rd");
        givenLogInData("another.email@host.com", "Passw0rd");
        whenLoggingIn();
        thenEmailOrPasswordShouldBeInvalid();
    }

    @Test
    public void givenAUser_butLoggingWithIncorrectPassword_itMustReturnError() {
        givenUser("username", "000000001-91", "email@host.com", "Passw0rd");
        givenLogInData("email@host.com", "incorrect password");
        whenLoggingIn();
        thenEmailOrPasswordShouldBeInvalid();
    }

    @Test
    public void givenAUser_andLoggingWithCorrectData_itMustBeSuccessful() {
        givenUser("username", "000000001-91", "email@host.com", "Passw0rd");
        givenLogInData("email@host.com", "Passw0rd");
        whenLoggingIn();
        thenItMustHaveLoggedInWithUser("email@host.com");
    }
    
    @Test
    public void givenAUserWithParticipantAndAdminProfiles_andLoggingWithCorrectData_itMustBeSuccessful() {
        String userId = givenUser("username", "000000001-91", "email@host.com", "Passw0rd");
        String adminId = "adminId", participantId = "participantId";
        givenAdmin(userId,adminId,"nome admin");
        givenParticipant(userId,participantId,"nome participante");
        givenLogInData("email@host.com", "Passw0rd");
        whenLoggingIn();
        thenItMustHaveSessionIds(userId,adminId,participantId);
    }
}