package fr.isima.cuicuizz.front.mode;

public class Speed implements IMode{
	
	private static Speed instance;

	@Override
	public void execute() {
		System.out.println("Speed mode");
		// TODO Auto-generated method stub
		
	}

	public static IMode getInstance() {
		if (instance == null) {
			instance = new Speed();
		} 
		return instance;
	}

}
