package fr.isima.cuicuizz.front.mode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public interface IMode {

	/**
	 * Execute the correct mode
	 * @throws IOException 
	 */
	public void execute() throws IOException;

	public static IMode getInstance() {
		return null;}
}
