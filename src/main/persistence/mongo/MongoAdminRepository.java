package main.persistence.mongo;

import main.domain.admin.Admin;
import main.domain.admin.AdminRepository;
import main.persistence.mongo.converters.AdminConverter;

public class MongoAdminRepository extends MongoRepository<Admin> implements AdminRepository {
	public MongoAdminRepository(){
		super("admins", new AdminConverter());
	}
}