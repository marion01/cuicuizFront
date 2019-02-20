package fr.isima.cuicuizz.front;

public class User {
	private static User instance;
	
	private String pseudo;
	
	public static User getInstance() {
		if (instance == null) {
			instance = new User();
		} 
		return instance;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pPseudo) {
		pseudo = pPseudo;
	}
}
