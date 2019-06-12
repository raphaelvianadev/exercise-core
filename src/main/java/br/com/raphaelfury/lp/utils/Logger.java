package br.com.raphaelfury.lp.utils;

public class Logger {
	
	/**
	 * Classe contendo apenas métodos de saída de texto.
	 */
	
	public void simpleLog(Object object) {
		System.out.println(object);
	}
	
	public void log(Object object) {
		System.out.println("[ExerciseCore] " + object);
	}
	
	public void logSQL(Object object) {
		System.out.println("[ExerciseCore] [MYSQL] " + object);
	}

	public void debug(Object object) {
		System.out.println("[ExerciseCore] [DEBUG] " + object);
	}

	public void error(Object object) {
		System.out.println("[ExerciseCore] [ERROR]" + object);
	}
	
	public void errorSQL(Object object) {
		System.out.println("[ExerciseCore] [MYSQL] [ERROR] - " + object);
	}

	public void error(Object object, Exception exception) {
		System.out.println("[ExerciseCore] [ERROR]" + object);
		System.out.println("Aparent error: " + exception.getMessage());
	}
	
	public void clearScreen() {
		for(int i = 0; i < 100; i++)
			System.out.println(" ");
	}
	
	public void clearScreen(int lines) {
		for(int i = 0; i < lines; i++)
			System.out.println(" ");
	}

}
