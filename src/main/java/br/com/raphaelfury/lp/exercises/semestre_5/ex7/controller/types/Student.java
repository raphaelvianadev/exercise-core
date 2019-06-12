package br.com.raphaelfury.lp.exercises.semestre_5.ex7.controller.types;

import br.com.raphaelfury.lp.exercises.semestre_5.ex7.Ex7;
import br.com.raphaelfury.lp.exercises.semestre_5.ex7.controller.Server;
import br.com.raphaelfury.lp.exercises.semestre_5.ex7.controller.types.controller.ServerType;

public class Student extends Server {
	
	private int semester;

	public void register() {
		setType(ServerType.STUDENT);
		setRegCode(Integer.valueOf(Ex7.getPanel().input("Insira o código de registro", "Cadastro", -1)));
		setName(Ex7.getPanel().input("Insira o nome do servidor", "Cadastro", -1));
		setWorkStation("ESCOLA");
		setSemester(Integer.valueOf(Ex7.getPanel().input("Insira o semestre", "Cadastro", -1)));
	}
	
	@Override
	public void list() {
	}
	
	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}

}
