package main;

import main.persistence.inmemory.InMemoryFactory;

public class LocalRunMain {

	public static void main(String[] args) {
		Main.setFactory(InMemoryFactory.getInstance());
		Main.main();
	}

}