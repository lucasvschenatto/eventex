package main.persistence.mongo;

import main.domain.certificate.Certificate;
import main.domain.certificate.CertificateRepository;
import main.persistence.mongo.converters.CertificateConverter;

public class MongoCertificateRepository extends MongoRepository<Certificate> implements CertificateRepository {

	protected MongoCertificateRepository() {
		super("certificates", new CertificateConverter());
	}

}
