package br.com.raphaelfury.lp;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Scanner;

import br.com.raphaelfury.core.logger.FormattedLogger;
import br.com.raphaelfury.lp.loader.ClassLoader;
import br.com.raphaelfury.lp.utils.Logger;

public class Initializer {

	// Declaração de variáveis
	public static ArrayList<Object> exercises = new ArrayList<Object>();
	public static Initializer instance;
	
	public static final String VERSION = "1.3.35";

	public static final Logger logger = new Logger();
	private static FormattedLogger formattedLogger;
	private static Scanner scanner;

	public static int SEMESTER = 0;

	// Main
	public static void main(String[] args) {
		setScanner(new Scanner(System.in));
		setFormattedLogger(new FormattedLogger(java.util.logging.Logger.getGlobal(), null, true));
		new Initializer().main();
		
	}
	
	public void main() {
		// Definindo a instance
		instance = this;

		// Carregando e registrando os exercícios
		new ClassLoader().load();

		// Iniciando o "método principal"
		init();
	}

	@SuppressWarnings("resource")
	public static void init() {
		Logger logger = new Logger();
		Scanner scanner = new Scanner(System.in);
		int ex;
		
		//logger.clearScreen();
		logger.simpleLog("ExerciseCore " + VERSION + " | " + (ClassLoader.TEST ? "Modo de teste | " : "") + (ClassLoader.casuals ? "Exercícios casuais." : "Exercícios eventuais."));
		logger.log("Deseja iniciar qual exercício?");
		logger.log("OBS: Digite o nome do exercício corretamente e com os devidos caracteres. Exemplo: Ex1.");
		logger.log("Exercícios disponíveis: " + exercises.toString().replace("[", "").replace("]", "").replace("Ex", ""));

		ex = scanner.nextInt();

		if (exercises.contains("Ex" + ex)) {
			logger.log("Carregando o exercício: '" + ex + "'...");
			String[] names = { "Iniciando.", "Iniciando..", "Iniciando..." };
			boolean hasSelected = false;
			int id = 0;
			while (!hasSelected) {
				if (ClassLoader.TEST) {
					if (id == names.length) {
						logger.clearScreen();
						logger.log("Exercício carregado: " + ex);
						try {
							Class<?> c = Class.forName(ClassLoader.casuals ? "br.com.raphaelfury.lp.exercises.semestre_" + SEMESTER + ".ex" + ex + ".Ex" + ex : "br.com.raphaelfury.lp.events.ex" + ex + ".Ex" + ex);
							try {
								c.getMethod("start").invoke(c.newInstance());
							} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException | InstantiationException e) {
								e.printStackTrace();
							}
						} catch (ClassNotFoundException e) {
							e.printStackTrace();
						}
						hasSelected = true;
						return;
					}

					logger.clearScreen();
					logger.log(names[id]);
					id++;
					sleep();
				} else {
					logger.clearScreen();
					logger.log("Exercício carregado: " + ex);
					try {
						Class<?> c = Class.forName("br.com.raphaelfury.lp.exercises.semestre_" + SEMESTER + ".ex" + ex + ".Ex" + ex);
						try {
							c.getMethod("start").invoke(c.newInstance());
						} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
								| NoSuchMethodException | SecurityException | InstantiationException e) {
							e.printStackTrace();
						}
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					}
					hasSelected = true;
					return;
				}
			}
		} else {
			logger.log("O exercício '" + ex + " (" + SEMESTER + ")' não foi encontrado");
			init();
		}
	}

	public static void sleep() {
		try {
			Thread.sleep(1000L);
		} catch (InterruptedException exception) {
			exception.printStackTrace();
		}
	}

	public static Logger getLogger() {
		return logger;
	}
	
	public static FormattedLogger getFormattedLogger() {
		return formattedLogger;
	}

	public static void setFormattedLogger(FormattedLogger formattedLogger) {
		Initializer.formattedLogger = formattedLogger;
	}

	public static Scanner getScanner() {
		return scanner;
	}

	public static void setScanner(Scanner scanner) {
		Initializer.scanner = scanner;
	}
}
