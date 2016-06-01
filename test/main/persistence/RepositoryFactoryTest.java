package main.persistence;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import main.domain.Repository;

public abstract class RepositoryFactoryTest {

	@Test
	public void sameRepositories() {
		List<Repository<?>> first = getAll();
		List<Repository<?>> second = getAll();
		assertEquals(first, second);
	}
	
	protected abstract List<Repository<?>> getAll();

}
