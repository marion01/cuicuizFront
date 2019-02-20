package fr.isima.cuicuizz.front.mode;

import java.io.IOException;
import java.util.List;

import fr.isima.cuicuizz.front.Main;
import fr.isima.cuicuizz.front.Question;

public class Speed implements IMode{
	
	private static Speed instance;

	@Override
	public void execute(List<Question> questions) {
		System.out.println("Speed mode");	
		int nbTrue = 0;
		try {
			long start = System.currentTimeMillis();
			for (Question q: questions) {
				boolean result = Main.displayQuestion(q);
				if (result) nbTrue++;
			}
			long end = System.currentTimeMillis();
			double time = (end - start)/1000;
			System.out.println(time + "s");
			System.out.println("You have "+ nbTrue + " valid response");
			Main.visualizeCorrectResponse(questions);
			Main.menu();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static IMode getInstance() {
		if (instance == null) {
			instance = new Speed();
		} 
		return instance;
	}

}
