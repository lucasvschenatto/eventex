package main.persistence.mongo.converters;

import main.domain.account.User;

import java.util.Map;

public class UserConverter extends EntityConverter<User> {
	private CPFConverter cpfConverter = new CPFConverter();
    private EmailConverter emailConverter = new EmailConverter();
    private PasswordConverter passwordConverter = new PasswordConverter();
    private UsernameConverter usernameConverter = new UsernameConverter();

    protected void defineGetters(Map<String, Getter<User>> getters) {
        getters.put("cpf", (u) -> cpfConverter.to(u.getCPF()));
        getters.put("email", (u) -> emailConverter.to(u.getEmail()));
        getters.put("password", (u) -> passwordConverter.to(u.getPassword()));
        getters.put("username", (u) -> usernameConverter.to(u.getUsername()));
    }

    protected void defineSetters(Map<String, Setter<User>> setters) {
        setters.put("_id", (u, v) -> u.setId(v.toString()));
        setters.put("cpf", (u, v) -> u.setCPF(cpfConverter.from(v)));
        setters.put("email", (u, v) -> u.setEmail(emailConverter.from(v)));
        setters.put("password", (u, v) -> u.setPassword(passwordConverter.from(v)));
        setters.put("username", (u, v) -> u.setUsername(usernameConverter.from(v)));
    }

    protected User makeNew() {
        return new User();
    }
}
