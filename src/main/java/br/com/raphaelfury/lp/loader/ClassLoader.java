package br.com.raphaelfury.lp.loader;

import java.io.IOException;
import java.util.Scanner;

import br.com.raphaelfury.lp.Initializer;
import br.com.raphaelfury.lp.exercises.Exercise;
import br.com.raphaelfury.lp.loader.reader.ClassReader;

public class ClassLoader {
	
	public static java.lang.ClassLoader classLoader = Initializer.class.getClassLoader();

	public static final boolean TEST = true;

	// Código para varrer o endereço de tal package e carregar as classes
	// pedidas.
	@SuppressWarnings("resource")
	public void load() {
		System.out.println("Iniciando o LOADER");
		Scanner scanner = new Scanner(System.in);
		
		Initializer.logger.clearScreen();
		Initializer.logger.log("Deseja iniciar exercícios de qual semestre?");
		Initializer.SEMESTER = scanner.nextInt();
		
		if (!TEST) {
			for (Class<?> classes : ClassReader.getClassesForPackage("br.com.raphaelfury.lp.exercises")) {
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
				for(Class<?> classes : ClassReader.getClasses("br.com.raphaelfury.lp.exercises.semestre_" + Initializer.SEMESTER)) {
					if(Exercise.class.isAssignableFrom(classes) && !classes.getSimpleName().equals("Exercise")) {
						Initializer.exercises.add(classes.getSimpleName());
					}
				}
			} catch (ClassNotFoundException | IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/*
	 * 			for (int i = 1; i <= EXERCISES; i++) {
				try {
					Class<?> exercise = classLoader.loadClass("br.com.raphaelfury.lp.exercises.semestre_" + Initializer.SEMESTER + ".ex" + i + ".Ex" + i);
					if (Exercise.class.isAssignableFrom(exercise) && !exercise.getSimpleName().equals("Exercise")) {
						Initializer.exercises.add(exercise.getSimpleName());
					}
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
					System.out.println("Falha ao iniciar o LOADER");
				}
			}
	 */
	
}
