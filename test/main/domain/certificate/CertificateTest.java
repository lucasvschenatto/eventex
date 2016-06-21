package main.domain.certificate;

import main.domain.Date;
import main.domain.EntityTest;
import main.domain.Quantity;
import main.domain.Text;

import static org.junit.Assert.*;

import org.junit.Test;

public class CertificateTest extends EntityTest<Certificate> {
	
	protected Certificate makeNewSubject() {
		return new Certificate();
	}
	
	protected Certificate makeSubjectWithData(){
		Certificate certificate = makeNewSubject();
		certificate.setName(new Text("Name"));
		certificate.setCourse(new Text("course"));
		certificate.setHours(new Quantity("60"));
		certificate.setDate(new Date("1900-01-01"));
		certificate.setScore(new Quantity("10"));
		return certificate;
	}
	
	protected void assertSameData(Certificate entity, Certificate copy) {
		assertEquals(entity.getId(), copy.getId());
		assertEquals(entity.getName(), copy.getName());
		assertEquals(entity.getCourse(), copy.getCourse());
		assertEquals(entity.getHours(), copy.getHours());
		assertEquals(entity.getDate(), copy.getDate());
		assertEquals(entity.getScore(), copy.getScore());
	}

	@Test
	public void newCertificateHasEmptyAttributes(){
		assertEquals(Text.EMPTY, subject.getName());
		assertEquals(Text.EMPTY, subject.getCourse());
		assertEquals(Quantity.ZERO, subject.getHours());
		assertEquals(Date.MIN, subject.getDate());
		assertEquals(Quantity.ZERO, subject.getScore());
	}	

}