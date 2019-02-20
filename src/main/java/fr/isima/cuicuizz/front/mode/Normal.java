package fr.isima.cuicuizz.front.mode;

public class Normal implements IMode {
	
	private static Normal instance;

	@Override
	public void execute() {
		System.out.println("Normal mode");
		// TODO Auto-generated method stub
		
	}

	public static IMode getInstance() {
		if (instance == null) {
			instance = new Normal();
		} 
		return instance;
	}

}
