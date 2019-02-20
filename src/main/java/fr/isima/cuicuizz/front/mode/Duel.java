package fr.isima.cuicuizz.front.mode;

import java.io.IOException;
import java.util.List;

import fr.isima.cuicuizz.front.Question;

public class Duel implements IMode{
	
	private static Duel instance;

	@Override
	public void execute(List<Question> questions) throws IOException {
		System.out.println("Duel mode");		
	}

	public static IMode getInstance() {
		if (instance == null) {
			instance = new Duel();
		} 
		return instance;
	}

}
