package main.persistence.mongo;

import main.domain.inscription.Inscription;
import main.domain.inscription.InscriptionRepository;

public class MongoInscriptionRepository extends MongoRepository<Inscription> implements InscriptionRepository {

	protected MongoInscriptionRepository() {
		super("inscriptions", null);
		// TODO Auto-generated constructor stub
	}
}
