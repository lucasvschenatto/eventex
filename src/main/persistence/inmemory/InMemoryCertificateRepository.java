package main.persistence.inmemory;

import main.domain.certificate.Certificate;
import main.domain.certificate.CertificateRepository;

public class InMemoryCertificateRepository extends InMemoryRepository<Certificate> implements CertificateRepository {

}