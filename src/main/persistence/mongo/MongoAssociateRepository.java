package main.persistence.mongo;

import main.domain.Text;
import main.domain.associate.Associate;
import main.domain.associate.AssociateRepository;

public class MongoAssociateRepository extends MongoRepository<Associate> implements AssociateRepository{

	protected MongoAssociateRepository() {
		super("associates",null);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Associate getByCode(Text associateCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasWithCode(Text associateCode) {
		// TODO Auto-generated method stub
		return false;
	}

}
