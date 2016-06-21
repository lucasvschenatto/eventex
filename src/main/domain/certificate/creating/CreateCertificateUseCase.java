package main.domain.certificate.creating;

import main.domain.Date;
import main.domain.certificate.Certificate;
import main.domain.certificate.CertificateRepository;
import main.domain.Quantity;
import main.domain.Text;

public class CreateCertificateUseCase {
	private final CertificateRepository repository;
	private final Text name;
	private final Text course;
	private final Quantity hours;
	private final Date date;
	private final Quantity score;
	private final CreateCertificateResponse response;
	
	public CreateCertificateUseCase(CertificateRepository repository, CreateCertificateRequest request, CreateCertificateResponse response){
		this.repository = repository;
		name = new Text(request.name);
		course = new Text(request.course);
		hours = new Quantity(request.hours);
		date = new Date(request.date);
		score = new Quantity(request.score);
		this.response = response;
	}
	
	public void execute(){
		if(isValidRequest())
			create();
		else
			sendErrors();
	}
	
	public boolean isValidRequest(){
		return name.isValid() && course.isValid() && hours.isValid() && date.isValid() && score.isValid();
	}
	
	private void create() {
		repository.save(makeCertificate());
		response.success = true;
	}
	
	private Certificate makeCertificate() {
		Certificate certificate = new Certificate();
		certificate.setName(name);
		certificate.setCourse(course);
		certificate.setHours(hours);
		certificate.setDate(date);
		certificate.setScore(score);
		return certificate;
	}
	
	private void sendErrors() {
		response.invalidName = !name.isValid();
		response.invalidCourse = !course.isValid();
		response.invalidHours = !hours.isValid();
		response.invalidDate = !date.isValid();
		response.invalidScore = !score.isValid();
	}
}
