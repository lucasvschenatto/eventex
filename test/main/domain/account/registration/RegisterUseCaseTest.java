package main.domain.account.registration;

import main.domain.account.UserRepository;
import main.domain.account.login.LoginRequest;
import main.domain.account.login.LoginResponse;
import main.domain.account.login.LoginUseCase;
import main.domain.account.reading.ReadUserRequest;
import main.domain.account.reading.ReadUserResponse;
import main.domain.account.reading.ReadUserUseCase;
import main.persistence.inmemory.InMemoryUserRepository;
import main.security.FakeEncryptor;
import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class RegisterUseCaseTest {
    private RegisterRequest request;
    private RegisterResponse response;
    private UserRepository repository;

    private void givenRegistrationData(String username, String cpf, String email, String password, String passwordConfirmation) {
    	request.username = username;
    	request.cpf = cpf;
        request.email = email;
        request.password = password;
        request.passwordConfirmation = passwordConfirmation;
    }

    private void whenRegistering() {
        new RegisterUseCase(repository, request, response, new FakeEncryptor()).execute();
    }

    private void thenItShouldBeSuccessful() {
        assertTrue(response.success);
        assertArrayEquals(new String[0], makeErrorsArray());
    }

    private void thenItShouldReturnTheErrors(String... expectedErrors) {
        assertFalse(response.success);
        assertArrayEquals(expectedErrors, makeErrorsArray());
    }

    private String[] makeErrorsArray() {
        ArrayList<String> list = new ArrayList<>();
        if (response.invalidUsername) list.add("invalidUsername");
        if (response.invalidCPF) list.add("invalidCPF");
        if (response.invalidEmail) list.add("invalidEmail");
        if (response.invalidPassword) list.add("invalidPassword");
        if (response.invalidPasswordConfirmation) list.add("invalidPasswordConfirmation");
        return list.toArray(new String[list.size()]);
    }

    private void andItShouldBePossibleToLogInWith(String email, String password) {
        Assert.assertEquals(email, readUser(response.id).email);
        assertTrue(canLogInWith(email, password));
    }

    private void andItShouldNotBePossibleToLogInWith(String email, String password) {
        assertNull(response.id);
        assertFalse(canLogInWith(email, password));
    }

    private boolean canLogInWith(String email, String password) {
        LoginRequest request = new LoginRequest();
        request.email = email;
        request.password = password;
        LoginResponse response = new LoginResponse();
        new LoginUseCase(repository, request, response, new FakeEncryptor()).execute();
        return response.success;
    }

    private ReadUserResponse readUser(String id) {
        ReadUserRequest request = new ReadUserRequest();
        request.id = id;
        ReadUserResponse response = new ReadUserResponse();
        new ReadUserUseCase(repository, request, response).execute();
        return response;
    }

    @Before
    public void setUp() throws Exception {
        request = new RegisterRequest();
        response = new RegisterResponse();
        repository = new InMemoryUserRepository();
    }

    @Test
    public void whenRegisteringWithValidData_itMustReturnTheUserId_andBeSuccessful() {
        givenRegistrationData("username", "000000001-91", "email@host.com", "Passw0rd", "Passw0rd");
        whenRegistering();
        thenItShouldBeSuccessful();
        andItShouldBePossibleToLogInWith("email@host.com", "Passw0rd");
    }
    
    @Test
    public void whenRegisteringWithIncorrectUsername_itMusReturnTheError() {
        givenRegistrationData("", "000000001-91", "email@host.com", "Passw0rd", "Passw0rd");
        whenRegistering();
        thenItShouldReturnTheErrors("invalidUsername");
        andItShouldNotBePossibleToLogInWith("email@host.com", "Passw0rd");
    }
    
    @Test
    public void whenRegisteringWithIncorrectCPF_itMusReturnTheError() {
    	givenRegistrationData("username", "", "email@host.com", "Passw0rd", "Passw0rd");
    	whenRegistering();
    	thenItShouldReturnTheErrors("invalidCPF");
    	andItShouldNotBePossibleToLogInWith("email@host.com", "Passw0rd");
    }

    @Test
    public void whenRegisteringWithAnInvalidEmail_itMustReturnTheError() {
        givenRegistrationData("username", "000000001-91", "", "Passw0rd", "Passw0rd");
        whenRegistering();
        thenItShouldReturnTheErrors("invalidEmail");
        andItShouldNotBePossibleToLogInWith("", "Passw0rd");
    }

    @Test
    public void whenRegisteringWithIncorrectPasswordConfirmation_itMusReturnTheError() {
        givenRegistrationData("username", "000000001-91", "email@host.com", "Passw0rd", "PasswOrd2");
        whenRegistering();
        thenItShouldReturnTheErrors("invalidPasswordConfirmation");
        andItShouldNotBePossibleToLogInWith("email@host.com", "password1");
    }

    @Test
    public void whenRegisteringWithAnInvalidPassword_itMustReturnTheError() {
        givenRegistrationData("username", "000000001-91", "email@host.com", "", "");
        whenRegistering();
        thenItShouldReturnTheErrors("invalidPassword");
        andItShouldNotBePossibleToLogInWith("email@host.com", "");
    }

    @Test
    public void whenRegisteringWithAllDataBeingInvalid_itMustReturnAllErrors() {
        givenRegistrationData("username", "000000001-91", "", "", "PasswOrd2");
        whenRegistering();
        thenItShouldReturnTheErrors("invalidEmail", "invalidPassword", "invalidPasswordConfirmation");
        andItShouldNotBePossibleToLogInWith("", "");
    }
}