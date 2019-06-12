package br.com.raphaelfury.lp.exercises.semestre_5.ex7.controller.types;

import br.com.raphaelfury.lp.exercises.semestre_5.ex7.Ex7;
import br.com.raphaelfury.lp.exercises.semestre_5.ex7.controller.Server;
import br.com.raphaelfury.lp.exercises.semestre_5.ex7.controller.types.controller.ServerType;

public class Administrative extends Server {
	
	public void register() {
		setType(ServerType.ADMINISTRATIVE);
		setRegCode(Integer.valueOf(Ex7.getPanel().input("Insira o código de registro", "Cadastro", -1)));
		setName(Ex7.getPanel().input("Insira o nome do servidor", "Cadastro", -1));
		setWorkStation(Ex7.getPanel().input("Insira o local de trabalho", "Cadastro", -1).toUpperCase());
		setRemuneration(Double.valueOf(Ex7.getPanel().input("Insira o salário", "Cadastro", -1)));
	}
	
	@Override
	public void list() {
	}
}
