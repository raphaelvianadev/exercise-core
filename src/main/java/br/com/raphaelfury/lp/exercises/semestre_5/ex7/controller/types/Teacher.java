package br.com.raphaelfury.lp.exercises.semestre_5.ex7.controller.types;

import br.com.raphaelfury.lp.exercises.semestre_5.ex7.Ex7;
import br.com.raphaelfury.lp.exercises.semestre_5.ex7.controller.Server;
import br.com.raphaelfury.lp.exercises.semestre_5.ex7.controller.types.controller.ServerType;

public class Teacher extends Server {
	
	private String titration;
	
	public void register() {
		setType(ServerType.TEACHER);
		setRegCode(Integer.valueOf(Ex7.getPanel().input("Insira o código de registro", "Cadastro", -1)));
		setName(Ex7.getPanel().input("Insira o nome do servidor", "Cadastro", -1));
		setWorkStation(Ex7.getPanel().input("Insira o a matéria ministrada", "Cadastro", -1).toUpperCase());
		setRemuneration(Double.valueOf(Ex7.getPanel().input("Insira o salário", "Cadastro", -1)));
		setTitration(Ex7.getPanel().input("Insira a títulação do servidor", "Cadastro", -1).toUpperCase());
	}
	
	@Override
	public void list() {
	}

	public String getTitration() {
		return titration;
	}

	public void setTitration(String titration) {
		this.titration = titration;
	}

}
