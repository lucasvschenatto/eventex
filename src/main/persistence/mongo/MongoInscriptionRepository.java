package main.persistence.mongo;

import main.domain.inscription.Inscription;
import main.domain.inscription.InscriptionRepository;
import main.persistence.mongo.converters.InscriptionConverter;

public class MongoInscriptionRepository extends MongoRepository<Inscription> implements InscriptionRepository {

	protected MongoInscriptionRepository() {
		super("inscriptions", new InscriptionConverter());
	}
}
