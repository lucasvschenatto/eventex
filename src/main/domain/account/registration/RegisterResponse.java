package main.domain.account.registration;

public class RegisterResponse {
    public boolean success;
    public String id;
    public boolean invalidUsername;
    public boolean invalidCPF;
    public boolean invalidEmail;
    public boolean invalidPassword;
    public boolean invalidPasswordConfirmation;
}
