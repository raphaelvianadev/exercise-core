package br.com.raphaelfury.lp.exercises.semestre_5.ex7.controller.types.controller;

public enum ServerType {
	
	STUDENT("Aluno", 3),
	TEACHER("Professor", 2), 
	ADMINISTRATIVE("Administrativo", 1);

	private String name;
	private int priority;

	private ServerType(String name, int priority) {
		setName(name);
		setPriority(priority);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

}
