package main.domain.certificate;

import main.domain.Date;
import main.domain.Quantity;
import main.domain.Repository;
import main.domain.RepositoryTest;
import main.domain.Text;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public abstract class CertificateRepositoryTest extends RepositoryTest<Certificate> {
    private static final Text NAME1 = new Text("Name 1");
    private static final Text COURSE1 = new Text("Course 1");
    private static final Quantity HOURS1 = new Quantity("60");
    private static final Date DATE1 = new Date("2010-01-01");
    private static final Quantity SCORE1 = new Quantity("10");
    
    private static final Text NAME2 = new Text("Name 2");
    private static final Text COURSE2 = new Text("Course 2");
    private static final Quantity HOURS2 = new Quantity("30");
    private static final Date DATE2 = new Date("2012-02-02");
    private static final Quantity SCORE2 = new Quantity("20");
    
    private CertificateRepository repository;

    protected abstract CertificateRepository getRepository();

	@Override
	protected Repository<Certificate> getAbstractRepository() {
		return getRepository();
	}

	@Override
	protected Certificate makeNewEntity() {
		return new Certificate();
	}

	@Override
	protected Certificate makeEntityWithId(String id) {
		Certificate certificate = new Certificate();
        certificate.setId(id);
        certificate.setName(NAME1);
        certificate.setCourse(COURSE1);
        certificate.setHours(HOURS1);
        certificate.setDate(DATE1);
        certificate.setScore(SCORE1);
        return certificate;
	}

	@Override
	protected void changeEntity(Certificate entity) {
		entity.setName(NAME2);
		entity.setCourse(COURSE2);
		entity.setHours(HOURS2);
		entity.setDate(DATE2);
		entity.setScore(SCORE2);
	}

	@Override
	protected void assertEntityHasSameValues(Certificate original, Certificate saved) {
		assertEquals(original.getId(), saved.getId());
        assertEquals(original.getName(), saved.getName());
        assertEquals(original.getCourse(), saved.getCourse());
        assertEquals(original.getHours(), saved.getHours());
        assertEquals(original.getDate(),saved.getDate());
        assertEquals(original.getScore(), saved.getScore());
	}

	@Override
	protected void assertEntityDoesNotHaveSameValues(Certificate original, Certificate saved) {
		assertEquals(original.getId(), saved.getId());
		assertNotEquals(original.getName(), saved.getName());
		assertNotEquals(original.getCourse(), saved.getCourse());
        assertNotEquals(original.getHours(), saved.getHours());
        assertNotEquals(original.getDate(),saved.getDate());
        assertNotEquals(original.getScore(), saved.getScore());
	}

	@Before
	public void setUp() throws Exception{
		super.setUp();
		repository = getRepository();
	}
	
	@Test
	public void givenNoCertificate_returnsEmptyCollection(){
		Iterable<Certificate> certificates = repository.getAll();
		assertFalse(certificates.iterator().hasNext());
	}

}
