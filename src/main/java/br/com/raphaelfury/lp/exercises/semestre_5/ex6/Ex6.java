package br.com.raphaelfury.lp.exercises.semestre_5.ex6;

import br.com.raphaelfury.lp.exercises.Exercise;
import br.com.raphaelfury.lp.exercises.semestre_5.ex6.controller.Animal;
import br.com.raphaelfury.lp.exercises.semestre_5.ex6.controller.animals.Cat;
import br.com.raphaelfury.lp.exercises.semestre_5.ex6.controller.animals.Dog;

public class Ex6 extends Exercise {

	public Ex6() {
		super("Ex6", "Polimorfismo I", true);
	}

	@Override
	public void start() {
		@SuppressWarnings("unused")
		Animal animal = new Animal();
		@SuppressWarnings("unused")
		Animal cat = new Cat();
		@SuppressWarnings("unused")
		Animal dog = new Dog();
	}

}
