package br.com.raphaelfury.lp.exercises.semestre_5.ex7.controller.impl;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

import br.com.raphaelfury.core.confirmation.InputConfirmation;
import br.com.raphaelfury.lp.exercises.semestre_5.ex7.Ex7;
import br.com.raphaelfury.lp.exercises.semestre_5.ex7.controller.Server;
import br.com.raphaelfury.lp.exercises.semestre_5.ex7.controller.types.Administrative;
import br.com.raphaelfury.lp.exercises.semestre_5.ex7.controller.types.Student;
import br.com.raphaelfury.lp.exercises.semestre_5.ex7.controller.types.Teacher;
import br.com.raphaelfury.lp.exercises.semestre_5.ex7.controller.types.controller.ServerType;

public class ServerImpl {
	
	public static void register() {
		StringBuilder builder = new StringBuilder();
		builder.append("\n");
		builder.append("1. Administrativo");
		builder.append("\n");
		builder.append("2. Professor");
		builder.append("\n");
		builder.append("3. Aluno");
		builder.append("\n");
		builder.append("\n");
		int type = Integer.valueOf(Ex7.getPanel().input(builder.toString(), "Cadastro", -1));
		switch (type) {
		case 1:
			Administrative administrative = new Administrative();
			administrative.register();
			Ex7.getServerMap().add(administrative);
			break;
		case 2:
			Teacher teacher = new Teacher();
			teacher.register();
			Ex7.getServerMap().add(teacher);
			break;
		case 3:
			Student student = new Student();
			student.register();
			Ex7.getServerMap().add(student);
			String benefit = Ex7.getPanel().input("Recebe algum auxílio?", "Cadastro", -1);
			if (InputConfirmation.isConfirmable(benefit))
				student.setRemuneration(student.getRemuneration() + 100);
			//Ex7.getPanel().message(student.getName() + " " + student.getSemester() + " " + student.getRegCode() + " " + student.getRemuneration() + " " + student.getWorkStation() + " " + student.getType().getName());
			break;
		default:
			Ex7.getPanel().displayWrongOption();
			break;
		}
	}
	
	public static void list() {
		int a = 0, t = 0, s = 0;
		for(Server servers : Ex7.getServerMap().getServers()) {
			if(servers.getType() == ServerType.ADMINISTRATIVE)
				a++;
			if(servers.getType() == ServerType.TEACHER) 
				t++;
			if(servers.getType() == ServerType.STUDENT)
				s++;
		}
		
		Ex7.getPanel().message(Arrays.asList("\n" + a + (a != 1 ? " funcionários administrativos" : " funcionário administrativo"), "\n" + t + (t != 1 ? " professores" : " professor") + "\n" + s + (s != 1 ? " alunos" : " aluno") + "\n\nTotal: " + Ex7.getServerMap().getServers().size() + (Ex7.getServerMap().getServers().size() != 1 ? " servidores" : " servidor")).toString().replace("[", "").replace("]", "").replace(",", ""), "Listagem", -1);
	}
	
	public static void getServerWithMoreSalary() {
		Server server = Ex7.getServerMap().getStream().collect(Collectors.maxBy(Comparator.comparingDouble(Server::getRemuneration))).get();
		Ex7.getPanel().message("Servidor com o maior salário:\n\n" + "#" + server.getRegCode() + " " + server.getName() + " | R$" + server.getRemuneration(), "Consulta", -1);
	}
	
	public static void listAll() {
		StringBuilder list = new StringBuilder();
		list.append("Servidores:");
		list.append("\n");
		for (Server servers : Ex7.getServerMap().getServers()) {
			list.append("============================");
			list.append("\n");
			list.append("Código de registro: #" + servers.getRegCode());
			list.append("\n");
			list.append("Nome: " + servers.getName());
			list.append("\n");
			list.append("Tipo: " + servers.getType().getName());
			list.append("\n");
			if (servers.getType() != ServerType.STUDENT)
				list.append((servers.getType() == ServerType.TEACHER ? "Matéria: " : "Área de atuação: ") + servers.getWorkStation() + "\n");
			
			if (servers.getType() == ServerType.TEACHER)
				list.append("Títulação: " + "Indisponível" + "\n");
			list.append((servers.getType() == ServerType.STUDENT ? "Auxílio: " : "Salário: ") + servers.getRemuneration());
			list.append("\n");
		}
		list.append("============================");
		Ex7.getPanel().longMessage(list.toString(), "Listagem geral", -1);
	}
	
}