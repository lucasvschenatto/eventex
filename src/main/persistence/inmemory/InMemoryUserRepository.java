package main.persistence.inmemory;

import java.util.HashMap;
import java.util.Map;

import main.domain.Email;
import main.domain.account.User;
import main.domain.account.UserRepository;
import main.persistence.EntityNotFoundException;

public class InMemoryUserRepository extends InMemoryRepository<User> implements UserRepository {
	private Map<Email,User> users = new HashMap<Email,User>();

    public User getByEmail(Email email) {
    	if(hasWithEmail(email))
    		return makeCopy(users.get(email));
    	else
    		throw new EntityNotFoundException();
    }

    public boolean hasWithEmail(Email email) {
    	return users.containsKey(email);
    }
    
    public void save(User user){
    	if (hasWithId(user.getId()))
    		users.remove(getById(user.getId()).getEmail());
    	super.save(user);
    	users.put(user.getEmail(), getById(user.getId()));
    }
    
}
