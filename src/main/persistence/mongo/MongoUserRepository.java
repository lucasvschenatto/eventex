package main.persistence.mongo;

import org.bson.Document;
import org.bson.conversions.Bson;

import main.domain.Email;
import main.domain.account.User;
import main.domain.account.UserRepository;
import main.persistence.mongo.converters.EmailConverter;
import main.persistence.mongo.converters.UserConverter;

public class MongoUserRepository extends MongoRepository<User> implements UserRepository {
	private EmailConverter emailConverter = new EmailConverter();

	protected MongoUserRepository() {
		super("users", new UserConverter());
	}

	public boolean hasWithEmail(Email email) {
		return email.isValid() && hasWith(makeEmailQuery(email));
	}

	public User getByEmail(Email email) {
		return getBy(makeEmailQuery(email));
	}
	
	private Bson makeEmailQuery(Email email) {
        return new Document("email", emailConverter.to(email));
    }
}
