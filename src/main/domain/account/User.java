package main.domain.account;

import main.domain.Entity;

public class User extends Entity {
    private Email email;
    private EncryptedPassword password;
	private Username username;

    public User() {
        this("", Email.EMPTY, EncryptedPassword.EMPTY, Username.EMPTY);
    }

    private User(String id, Email email, EncryptedPassword password, Username username) {
        super(id);
        this.email = email;
        this.password = password;
        this.username = username;
    }

    public User copy() {
        return new User(id, email, password, username);
    }

    public Email getEmail() {
        return email;
    }

    public EncryptedPassword getPassword() {
        return password;
    }

    public Username getUsername() {
		return username;
	}

	public void setEmail(Email email) {
        this.email = email;
    }

    public void setPassword(EncryptedPassword password) {
        this.password = password;
    }

	public void setUsername(Username username) {
		this.username = username;
	}
}
