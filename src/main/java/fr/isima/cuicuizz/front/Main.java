package fr.isima.cuicuizz.front;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import fr.isima.cuicuizz.front.mode.ModeEnum;

public class Main {
	
	private Main() {}
	
	private static BufferedReader entry = new BufferedReader(new InputStreamReader(System.in));	 
	
	public static void launch() throws IOException {
		System.out.println("************* Welcome to cuicuizz !! :) *************\n");
		System.out.println("Enter your pseudo:");
		String pseudo = readEntry();
		User user = User.getInstance();
		user.setPseudo(pseudo);
		System.out.println();
		
		menu();
	}
	
	public static String readEntry() throws IOException {
		String string = entry.readLine();
		if ("exit".equals(string)) {
			launch();
			return null;
		}else {
			return string;
		}
	}
	
	public static void modeChoose() throws IOException {
		for (int index = 0; index < ModeEnum.values().length; index++) {
			ModeEnum mode = ModeEnum.getById(index);
			System.out.println(index + "." + mode.getName());
		}
		System.out.println(ModeEnum.values().length + ".Back");
		System.out.println("Enter the number of the mode:"); 
		String i = readEntry();
		if (Integer.parseInt(i) < ModeEnum.values().length) {
			ModeEnum mode = ModeEnum.getById(Integer.parseInt(i));
			List<Question> questions = chooseTheme();
			try {
				mode.getInstance().execute(questions);
			} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | IllegalAccessException
					| IllegalArgumentException | InvocationTargetException e) {
				e.printStackTrace();
			}
		} else {
			if (Integer.parseInt(i) == ModeEnum.values().length) {
				menu();
			} else {
				System.out.println("incorrect entry");
				modeChoose();
			}
		}
		System.out.println();
	}
	
	public static void menu() throws IOException {
		System.out.println("Menu:");
		System.out.println("0.Show history");
		System.out.println("1.New game");
		 
		String i = readEntry();
		switch((i != null) ? i : "-1") {
			case("0"):
				System.out.println("history");
				break;
			case("1"):
				modeChoose();
				break;
			default:
				System.out.println("incorrect entry");
				menu();
		}
		System.out.println();
	}
	
	//to recover in db
	private static String[] theme = {"General"};
	
	//to remove when the back is ready
	private static List<Question> getQuestionOfTheme(String theme, int number) {
		List<Question> questions = new ArrayList<Question>();

		Question q2 = new Question();
		q2.setValue("q2 ?");
		Answer a21 = new Answer();
		a21.setAnswer("a21"); a21.setIsCorrect(true);a21.setId(4);
		q2.getAnswers().add(a21);
		Answer a22 = new Answer();
		a22.setAnswer("a22"); a22.setIsCorrect(false);a22.setId(5);
		q2.getAnswers().add(a22);
		Answer a23 = new Answer();
		a23.setAnswer("a23"); a23.setIsCorrect(false);a23.setId(5);
		q2.getAnswers().add(a23);
		Answer a24 = new Answer();
		a24.setAnswer("a24"); a24.setIsCorrect(false);a24.setId(5);
		q2.getAnswers().add(a24);
		questions.add(q2);
		
		Question q1 = new Question();
		q1.setValue("q1 ?");
		Answer a1 = new Answer();
		a1.setAnswer("a1"); a1.setIsCorrect(false); a1.setId(0);
		q1.getAnswers().add(a1);
		Answer a2 = new Answer();
		a2.setAnswer("a2"); a2.setIsCorrect(false);a2.setId(1);
		q1.getAnswers().add(a2);
		Answer a3 = new Answer();
		a3.setAnswer("a3"); a3.setIsCorrect(false);a3.setId(2);
		q1.getAnswers().add(a3);
		Answer a4 = new Answer();
		a4.setAnswer("a4"); a4.setIsCorrect(true);a4.setId(3);
		q1.getAnswers().add(a4);
		questions.add(q1);
		
		
		return questions;
	}
	
	public static List<Question> chooseTheme() throws IOException {
		System.out.println("Choose the theme of the question:");
		for (int i=0; i<theme.length ;i++) {
			System.out.println(i+"."+theme[i]);
		}
		String i = readEntry();
		List<Question> questions = getQuestionOfTheme(i,2);
		
		return questions;
	}
	
	public static boolean displayQuestion(Question q) throws IOException {
		System.out.println(q.getValue());
		List<Answer> answers = q.getAnswers();
		for (int i = 0;i<answers.size();i++) {
			System.out.println(i+"."+answers.get(i).getAnswer());
		}
		String i = null;
		boolean wrongAnswer = true;
		while(wrongAnswer) {
			i = readEntry();
			if (Integer.parseInt(i) >= answers.size()) {
				System.out.println("incorrect response");
			} 
		}
		if(answers.get(Integer.parseInt(i)).isIsCorrect()) 
			return true;
		return false;
	}
	
	public static void visualizeCorrectResponse(List<Question> questions) throws IOException {
		for (Question q: questions) {
			System.out.print(q.getValue() + ":");
			for (Answer a: q.getAnswers()) {
				if (a.isIsCorrect()) {
					System.out.println(a.getAnswer());
					break;
				}
			}
		}
		System.out.println();
	}
}
