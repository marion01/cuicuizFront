package fr.isima.cuicuizz.front;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;

import fr.isima.cuicuizz.front.mode.ModeEnum;

public class Main {
	
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
			try {
				mode.getInstance().execute();
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
		switch(i) {
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
}
