package br.com.raphaelfury.lp.loader;

import java.io.IOException;
import java.util.Scanner;

import br.com.raphaelfury.lp.Initializer;
import br.com.raphaelfury.lp.exercises.Exercise;
import br.com.raphaelfury.lp.loader.reader.ClassReader;

public class ClassLoader {
	
	public static java.lang.ClassLoader classLoader = Initializer.class.getClassLoader();

	public static final boolean TEST = true;
	public static boolean casuals = false;

	// Código para varrer o endereço de tal package e carregar as classes
	// desejadas.
	@SuppressWarnings("resource")
	public void load() {
		System.out.println("Iniciando o LOADER");
		Scanner scanner = new Scanner(System.in);
		String casualsOrEvents;
		
		Initializer.logger.clearScreen();
		Initializer.logger.log("Deseja iniciar exercícios casuais ou de eventos?");
		casualsOrEvents = scanner.next();

		if (casualsOrEvents.startsWith("cas")) {
			casuals = true;
			Initializer.logger.clearScreen();
			Initializer.logger.log("Deseja iniciar exercícios de qual semestre?");
			Initializer.SEMESTER = scanner.nextInt();
		}
		
		if (!TEST) {
			for (Class<?> classes : ClassReader.getClassesForPackage(casuals ? "br.com.raphaelfury.lp.exercises" : "br.com.raphaelfury.lp.events")) {
				try {
					if (Exercise.class.isAssignableFrom(classes) && !classes.getSimpleName().equals("Exercise")) {
						System.out.println(classes.getSimpleName());
						Initializer.exercises.add(classes.getSimpleName());
					}
				} catch (Exception exception) {
					exception.printStackTrace();
					System.out.println("Falha ao iniciar o LOADER");
				}
			}
		} else {
			System.out.println("Iniciando em modo de teste.");
			try {
				for(Class<?> classes : ClassReader.getClasses(casuals ? "br.com.raphaelfury.lp.exercises.semestre_" + Initializer.SEMESTER : "br.com.raphaelfury.lp.events")) 
					if(Exercise.class.isAssignableFrom(classes) && !classes.getSimpleName().equals("Exercise")) 
						Initializer.exercises.add(classes.getSimpleName());
				
			} catch (ClassNotFoundException | IOException e) {
				e.printStackTrace();
			}
		}
	}
}
