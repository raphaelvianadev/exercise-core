package br.com.raphaelfury.lp.exercises.semestre_5.ex6.controller.animals;

import br.com.raphaelfury.lp.Initializer;
import br.com.raphaelfury.lp.exercises.semestre_5.ex6.controller.Animal;

public class Cat extends Animal {
	
	public Cat() {
		setId(2);
		sendSound();
	}
	
	@Override
	protected void sendSound() {
		Initializer.getFormattedLogger().log("Miau!");
	}
	
	@Override
	public void setId(int id) {
		super.setId(id);
	}

}
