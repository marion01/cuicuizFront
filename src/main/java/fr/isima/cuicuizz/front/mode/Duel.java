package fr.isima.cuicuizz.front.mode;

import java.io.IOException;

public class Duel implements IMode{
	
	private static Duel instance;

	@Override
	public void execute() throws IOException {
		System.out.println("Duel mode");		
	}

	public static IMode getInstance() {
		if (instance == null) {
			instance = new Duel();
		} 
		return instance;
	}

}
