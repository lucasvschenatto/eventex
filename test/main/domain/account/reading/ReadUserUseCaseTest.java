package main.domain.account.reading;

import main.domain.account.UserRepository;
import main.domain.account.registration.RegisterRequest;
import main.domain.account.registration.RegisterResponse;
import main.domain.account.registration.RegisterUseCase;
import main.persistence.inmemory.InMemoryUserRepository;
import main.security.FakeEncryptor;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class ReadUserUseCaseTest {
    private ReadUserResponse response;
    private UserRepository repository;
    private String idToRead;

    private void givenNoRegisteredUser() {
        idToRead = "whatever";
    }

    private void givenRegisteredUser(String email, String username, String cpf) {
        RegisterRequest request = new RegisterRequest();
        request.email = email;
        request.username = username;
        request.cpf = cpf;
        request.password = request.passwordConfirmation = "Passw0rd";
        RegisterResponse response = new RegisterResponse();
        new RegisterUseCase(repository, request, response, new FakeEncryptor()).execute();
        idToRead = response.id;
    }

    private void whenReadingUser() {
        ReadUserRequest request = new ReadUserRequest();
        request.id = idToRead;
        new ReadUserUseCase(repository, request, response).execute();
    }

    private void thenItShouldNotExist() {
        assertFalse(response.success);
        assertNull(response.email);
        assertNull(response.username);
    }

    private void thenItShouldReturn(String email, String username) {
        assertTrue(response.success);
        assertEquals(email, response.email);
        assertEquals(username, response.username);
    }

    @Before
    public void setUp() {
        response = new ReadUserResponse();
        repository = new InMemoryUserRepository();
    }

    @Test
    public void whenReadingAUserThatDoesNotExist_itMustIndicate() {
        givenNoRegisteredUser();
        whenReadingUser();
        thenItShouldNotExist();
    }

    @Test
    public void afterRegistering_itMustReturnTheRegisteredData() {
        givenRegisteredUser("email@host.com", "username", "000000001-91");
        whenReadingUser();
        thenItShouldReturn("email@host.com", "username");
    }
}