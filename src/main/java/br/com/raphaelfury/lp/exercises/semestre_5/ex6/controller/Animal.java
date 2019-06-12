package br.com.raphaelfury.lp.exercises.semestre_5.ex6.controller;

import br.com.raphaelfury.lp.Initializer;

public class Animal {
	
	private int id;
	
	protected void sendSound() {
		Initializer.getFormattedLogger().log("");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
