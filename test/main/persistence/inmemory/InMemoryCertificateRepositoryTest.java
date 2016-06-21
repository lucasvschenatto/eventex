package main.persistence.inmemory;

import main.domain.certificate.CertificateRepository;
import main.domain.certificate.CertificateTest;

public class InMemoryCertificateRepositoryTest extends CertificateTest {

	protected CertificateRepository getRepository() {
		return new InMemoryCertificateRepository();
	}
	
	public String getValidId() {
		return "1";
	}
	
	protected String getInvalidId(){
		return "";
	}
}