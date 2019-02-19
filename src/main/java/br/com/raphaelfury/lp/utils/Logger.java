package br.com.raphaelfury.lp.utils;

public class Logger {
	
	/**
	 * Classe contendo apenas métodos de saída de texto.
	 */
	
	public void log(Object object) {
		System.out.println("[ExerciseManager] " + object);
	}
	
	public void logSQL(Object object) {
		System.out.println("[ExerciseManager] [MYSQL] " + object);
	}

	public void debug(Object object) {
		System.out.println("[ExerciseManager] [DEBUG] " + object);
	}

	public void error(Object object) {
		System.out.println("[ExerciseManager] [ERROR]" + object);
	}
	
	public void errorSQL(Object object) {
		System.out.println("[ExerciseManager] [MYSQL] [ERROR] - " + object);
	}

	public void error(Object object, Exception exception) {
		System.out.println("[ExerciseManager] [ERROR]" + object);
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
