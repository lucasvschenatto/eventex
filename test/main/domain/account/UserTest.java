package main.domain.account;

import main.domain.Email;
import main.domain.EntityTest;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class UserTest extends EntityTest<User> {
    protected User makeNewSubject() {
        return new User();
    }

    protected User makeSubjectWithData() {
        User user = makeNewSubject();
        user.setId("id");
        user.setCPF(new CPF("123456789-09"));
        user.setUsername(new Username("username"));
        user.setEmail(new Email("email@host.com"));
        user.setPassword(new EncryptedPassword("", "password"));
        return user;
    }

    protected void assertSameData(User entity, User copy) {
        assertEquals(entity.getId(), copy.getId());
        assertEquals(entity.getCPF(), copy.getCPF());
        assertEquals(entity.getUsername(), copy.getUsername());
        assertEquals(entity.getEmail(), copy.getEmail());
        assertEquals(entity.getPassword(), copy.getPassword());
    }

    @Test
    public void newUser_hasEmptyAttributes() {
    	assertEquals(CPF.EMPTY, subject.getCPF());
    	assertEquals(Username.EMPTY, subject.getUsername());
        assertEquals(Email.EMPTY, subject.getEmail());
        assertEquals(EncryptedPassword.EMPTY, subject.getPassword());
    }
    
    @Test
    public void userKeepsTheCPFSet(){
    	CPF cpf = new CPF("123456789-09");
    	subject.setCPF(cpf);
    	assertEquals(cpf,subject.getCPF());
    }
    
    @Test
    public void userKeepsTheUsernameSet(){
    	Username username = new Username("username");
    	subject.setUsername(username);
    	assertEquals(username,subject.getUsername());
    }

    @Test
    public void userKeepsTheEmailSet() {
        Email email = new Email("whatever");
        subject.setEmail(email);
        assertEquals(email, subject.getEmail());
    }

    @Test
    public void userKeepsThePasswordSet() {
        EncryptedPassword password = new EncryptedPassword("", "whatever");
        subject.setPassword(password);
        assertEquals(password, subject.getPassword());
    }
}