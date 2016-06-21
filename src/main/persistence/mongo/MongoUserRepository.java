package main.persistence.mongo;

import main.domain.Email;
import main.domain.account.User;
import main.domain.account.UserRepository;

public class MongoUserRepository extends MongoRepository<User> implements UserRepository {

	protected MongoUserRepository() {
		super("users",null);
	}

	@Override
	public boolean hasWithEmail(Email email) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User getByEmail(Email email) {
		// TODO Auto-generated method stub
		return null;
	}
}
