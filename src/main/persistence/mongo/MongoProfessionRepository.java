package main.persistence.mongo;

import main.domain.profession.Profession;
import main.domain.profession.ProfessionRepository;

public class MongoProfessionRepository extends MongoRepository<Profession> implements ProfessionRepository {
	public MongoProfessionRepository(){
		super("professions",null);
	}
}
