package main.persistence.mongo;

import main.domain.profession.Profession;
import main.domain.profession.ProfessionRepository;
import main.persistence.mongo.converters.ProfessionConverter;

public class MongoProfessionRepository extends MongoRepository<Profession> implements ProfessionRepository {
	public MongoProfessionRepository(){
		super("professions", new ProfessionConverter());
	}
}
