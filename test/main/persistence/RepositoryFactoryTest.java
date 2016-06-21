package main.persistence;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import main.domain.RepositoryFactory;

public abstract class RepositoryFactoryTest {
	private RepositoryFactory first;
	private RepositoryFactory second;
	
	protected abstract RepositoryFactory getFactory();

	@Before
	public void setUp(){
		first = getFactory();
		second = getFactory();
	}

	@Test
	public void sameFactoryInstances() {
		assertEquals(first, second);
	}
	
	@Test
	public void repositoriesAreNotNull(){
		RepositoryFactory f = getFactory();
		assertNotNull(f.getActivityRepository());
		assertNotNull(f.getAssociateRepository());
		assertNotNull(f.getCategoryRepository());
		assertNotNull(f.getEventRepository());
		assertNotNull(f.getInscriptionRepository());
		assertNotNull(f.getParticipantRepository());
		assertNotNull(f.getProfessionRepository());
		assertNotNull(f.getUserRepository());
	}
	
	@Test
	public void sameActivityRepository(){
		assertEquals(first.getActivityRepository(), second.getActivityRepository());
	}
	
	@Test
	public void sameAssociateRepository(){
		assertEquals(first.getAssociateRepository(), second.getAssociateRepository());
	}
	
	@Test
	public void sameCategoryRepository(){
		assertEquals(first.getCategoryRepository(), second.getCategoryRepository());
	}
	
	@Test
	public void sameEventRepository(){
		assertEquals(first.getEventRepository(), second.getEventRepository());
	}
	
	@Test
	public void sameInscriptionRepository(){
		assertEquals(first.getInscriptionRepository(), second.getInscriptionRepository());
	}
	
	@Test
	public void sameParticipantRepository(){
		assertEquals(first.getParticipantRepository(), second.getParticipantRepository());
	}
	
	@Test
	public void sameProfessionRepository(){
		assertEquals(first.getProfessionRepository(), second.getProfessionRepository());
	}
	
	@Test
	public void sameUserRepository(){
		assertEquals(first.getUserRepository(), second.getUserRepository());
	}
}
