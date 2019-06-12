package br.com.raphaelfury.lp.exercises.semestre_5.ex6.controller.animals;

import br.com.raphaelfury.lp.Initializer;
import br.com.raphaelfury.lp.exercises.semestre_5.ex6.controller.Animal;

public class Dog extends Animal {
	
	public Dog() {
		setId(1);
		sendSound();
	}
	
	@Override
	protected void sendSound() {
		Initializer.getFormattedLogger().log("Auau");
	}
	
	@Override
	public void setId(int id) {
		super.setId(id);
	}


}
