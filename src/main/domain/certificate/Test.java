package main.domain.certificate;

import main.persistence.inmemory.InMemoryFactory;

public class Test {

	public static void main(String[] args) {
		PrintCertificateRequest request = new PrintCertificateRequest();
		new PrintCertificateUseCase(
				InMemoryFactory.getInstance().getActivityRepository(),
				InMemoryFactory.getInstance().getParticipantRepository(),
				InMemoryFactory.getInstance().getInscriptionRepository(),
				"resources/public",
				request,new PrintCertificateResponse()).execute();
	}

}
