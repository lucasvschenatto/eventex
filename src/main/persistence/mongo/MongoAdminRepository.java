package main.persistence.mongo;

import org.bson.Document;
import org.bson.conversions.Bson;

import main.domain.Text;
import main.domain.admin.Admin;
import main.domain.admin.AdminRepository;
import main.persistence.mongo.converters.AdminConverter;
import main.persistence.mongo.converters.TextConverter;

public class MongoAdminRepository extends MongoRepository<Admin> implements AdminRepository {
	private TextConverter textConverter = new TextConverter();
	
	public MongoAdminRepository(){
		super("admins", new AdminConverter());
	}
	
	public boolean hasWithUserId(Text code) {
		return code.isValid() && 
			hasWith(makeAssociateCodeQuery(code));
	}

	public Admin  getByUserId(Text code) {
		return getBy(makeAssociateCodeQuery(code));
	}

	private Bson makeAssociateCodeQuery(Text code) {
		return new Document("user_id", textConverter.to(code));
	}
}