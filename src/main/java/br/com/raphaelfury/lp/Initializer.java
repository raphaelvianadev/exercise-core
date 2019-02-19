package br.com.raphaelfury.lp;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Scanner;

import br.com.raphaelfury.lp.loader.ClassLoader;
import br.com.raphaelfury.lp.utils.Logger;

public class Initializer {

	// Declaração de variáveis
	public static ArrayList<Object> exercises = new ArrayList<Object>();
	public static Initializer instance;
	
	// Main
	public static void main(String[] args) {
		new Initializer().main();
	}

	public void main() {
		//Definindo a instance
		instance = this;
		
		//Carregando e registrando os exercícios
		new ClassLoader().load();
		
		//Iniciando o "método principal"
		init();
	}

	@SuppressWarnings("resource")
	public static void init() {
		Logger logger = new Logger();
		Scanner scanner = new Scanner(System.in);
		String ex = null;

		logger.clearScreen();
		logger.log("Deseja iniciar qual exercício?");
		logger.log("OBS: Digite o nome do exercício corretamente e com os devidos caracteres. Exemplo: Ex1.");
		logger.log("Exercícios disponíveis: " + exercises.toString().replace("[", "").replace("]", ""));

		ex = scanner.next();

		if (exercises.contains(ex)) {
			logger.log("Carregando o exercício: '" + ex + "'...");
			String[] names = { "Iniciando.", "Iniciando..", "Iniciando..." };
			boolean hasSelected = false;
			int id = 0;
			while (!hasSelected) {
				if (id == names.length) {
					logger.clearScreen();
					logger.log("Exercício carregado: " + ex);
					try {
						Class<?> c = Class.forName("br.com.raphaelfury.lp.exercises.semestre_5." + ex.toLowerCase() + "." + ex);
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

				logger.clearScreen();
				logger.log(names[id]);
				id++;
				sleep();
			}
		} else {
			logger.log("O exercício '" + ex + "' não foi encontrado");
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
}
