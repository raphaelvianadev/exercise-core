package br.com.raphaelfury.lp.exercises;

import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

import br.com.raphaelfury.lp.Initializer;
import br.com.raphaelfury.lp.utils.Logger;

public abstract class Exercise {

	private static final Scanner scanner = new Scanner(System.in);
	private static final Logger logger = new Logger();

	private String name;
	private String description;
	private boolean restartable, ended;

	public Exercise(String name, String description, boolean restartable) {
		super();
		this.setName(name);
		this.setDescription(description);
		this.setRestartable(restartable);
		
		sendInformations();
	}

	public abstract void start(); //Iniciar o método principal de exercícios.

	public Scanner getScanner() {
		return scanner;
	}

	public Logger getLogger() {
		return logger;
	}

	public void log(String log) {
		logger.log("[" + getName().toUpperCase() + "] " + log);
	}

	public void blankLine() {
		log(" ");
	}

	public void log(String type, String log) {
		logger.log("[" + getName().toUpperCase() + "] [" + type + "] " + log);
	}

	public void error(String error) {
		logger.error(error);
	}
	
	public void sendInformations() {
	}
	
	public void finalize() {
		setEnded(true);
		
		String option;
		log("Deseja reiniciar o exercício?");
		option = getScanner().next();
		
		if (option.equalsIgnoreCase("s") || option.equalsIgnoreCase("sim") || option.equalsIgnoreCase("y") || option.equalsIgnoreCase("yes")) {
			try {
				Class<?> c = Class.forName("br.com.raphaelfury.lp.exercises." + getName().toLowerCase() + "." + getName());
				try {
					c.getMethod("start").invoke(c.newInstance());
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException | InstantiationException e) {
					e.printStackTrace();
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		} else if (option.equalsIgnoreCase("n") || option.equalsIgnoreCase("nao") || option.equalsIgnoreCase("não") || option.equalsIgnoreCase("no")) {
			Initializer.init();
		} else if (option.equalsIgnoreCase("finalizar") || option.equalsIgnoreCase("finalize")) {
			log("Exercício e programa encerrados.");
			System.exit(0);
		}
	}

	public void restart(String option) {
		if (isEnded() && isRestartable()) {
			if (option.equalsIgnoreCase("s") || option.equalsIgnoreCase("sim") || option.equalsIgnoreCase("y")
					|| option.equalsIgnoreCase("yes")) {
					Initializer.init();
			} else if (option.equalsIgnoreCase("n") || option.equalsIgnoreCase("nao") || option.equalsIgnoreCase("não")
					|| option.equalsIgnoreCase("no")) {
				log("Exercício e programa encerrados.");
				System.exit(0);
			}
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
