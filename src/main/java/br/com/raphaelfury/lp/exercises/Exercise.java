package br.com.raphaelfury.lp.exercises;

import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

import br.com.raphaelfury.core.confirmation.InputConfirmation;
import br.com.raphaelfury.core.logger.FormattedLogger;
import br.com.raphaelfury.lp.Initializer;
import br.com.raphaelfury.lp.utils.Logger;

public abstract class Exercise {

	private static final Scanner scanner = new Scanner(System.in);
	private static final Logger logger = new Logger();

	private static String name;
	private String description;
	private boolean restartable, ended;

	public Exercise(String name, String description, boolean restartable) {
		super();
		this.setName(name);
		this.setDescription(description);
		this.setRestartable(restartable);
	}

	public abstract void start(); //Iniciar o método principal de exercícios.

	public Scanner getScanner() {
		return scanner;
	}

	public FormattedLogger getLogger() {
		return Initializer.getFormattedLogger();
	}

	public void log(String log) {
		//logger.log("[" + getName().toUpperCase() + "] " + log);
		getLogger().log(log);
	}

	public void blankLine() {
		logger.log(" ");
	}

	public void log(String type, String log) {
		logger.log("[" + getName().toUpperCase() + "] [" + type + "] " + log);
	}

	public void error(String error) {
		logger.error(error);
	}
	
	public void finalize() {
		if (!isEnded())
			setEnded(true);
		
		if (!isRestartable())
			Initializer.init();
		
		String option;
		log("Deseja reiniciar o exercício?");
		option = getScanner().next();
		
		if (option.equalsIgnoreCase("finalizar") || option.equalsIgnoreCase("finalize")) {
			log("Exercício e programa encerrados.");
			System.exit(0);
		 }
		
		if (InputConfirmation.isConfirmable(option)) {
			try {
				Class<?> c = Class.forName("br.com.raphaelfury.lp.exercises.semestre_" + Initializer.SEMESTER + "." + getName().toLowerCase() + "." + getName());
				try {
					c.getMethod("start").invoke(c.newInstance());
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException | InstantiationException e) {
					e.printStackTrace();
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		} else
			Initializer.init();
	}

	public static String getName() {
		return name;
	}

	public void setName(String name) {
		Exercise.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isRestartable() {
		return restartable;
	}

	public void setRestartable(boolean restartable) {
		this.restartable = restartable;
	}

	public boolean isEnded() {
		return ended;
	}

	public void setEnded(boolean ended) {
		this.ended = ended;
	}
}
