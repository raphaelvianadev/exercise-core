package br.com.raphaelfury.lp.exercises.semestre_5.ex7;

import br.com.raphaelfury.core.panel.PanelBuilder;
import br.com.raphaelfury.lp.exercises.Exercise;
import br.com.raphaelfury.lp.exercises.semestre_5.ex7.controller.Server;
import br.com.raphaelfury.lp.exercises.semestre_5.ex7.controller.impl.ServerImpl;
import br.com.raphaelfury.lp.exercises.semestre_5.ex7.controller.map.ServerMap;
import br.com.raphaelfury.lp.exercises.semestre_5.ex7.controller.types.Administrative;
import br.com.raphaelfury.lp.exercises.semestre_5.ex7.controller.types.Student;
import br.com.raphaelfury.lp.exercises.semestre_5.ex7.controller.types.Teacher;
import br.com.raphaelfury.lp.exercises.semestre_5.ex7.controller.types.controller.ServerType;

public class Ex7 extends Exercise {
	
	private static PanelBuilder panel = new PanelBuilder("Ex7");
	private static ServerMap serverMap = new ServerMap();

	public Ex7() {
		super("Ex7", "Escola", true);
	}

	@Override
	public void start() {
		boolean running = true;
		
		new Server();
		
		Teacher t1 = new Teacher();
		t1.setRegCode(1);
		t1.setName("Prof 1");
		t1.setWorkStation("PT");
		t1.setRemuneration(50000);
		t1.setType(ServerType.TEACHER);
		
		Administrative a1 = new Administrative();
		a1.setRegCode(2);
		a1.setName("Admin 1");
		a1.setWorkStation("Coordenação");
		a1.setRemuneration(80000);
		a1.setType(ServerType.ADMINISTRATIVE);
		
		Student s1 = new Student();
		s1.setRegCode(3);
		s1.setName("Stud 1");
		s1.setRemuneration(100);
		s1.setType(ServerType.STUDENT);
		
		getServerMap().add(t1);
		getServerMap().add(a1);
		getServerMap().add(s1);
		
		while (running) {
			switch (sendOptionsPane()) {
			case 1:
				ServerImpl.register();
				break;
			case 2:
				ServerImpl.list();
				break;
			case 3:
				ServerImpl.getServerWithMoreSalary();
				break;
			case 4:
				ServerImpl.listAll();
				break;
			case 5:
				running = false;
				getPanel().displayFinish();
				break;
			default:
				getPanel().displayWrongOption();
				break;
			}
		}
	}

	public static PanelBuilder getPanel() {
		return panel;
	}
	
	public static ServerMap getServerMap() {
		return serverMap;
	}

	public int sendOptionsPane() {
		StringBuilder builder = new StringBuilder();
		builder.append("\n");
		builder.append("1. Cadastrar servidor");
		builder.append("\n");
		builder.append("2. Listar servidores");
		builder.append("\n");
		builder.append("3. Mostra o maior salário");
		builder.append("\n");
		builder.append("4. Listar todos os dados");
		builder.append("\n");
		builder.append("5. Finalizar");
		builder.append("\n");
		builder.append("\n");
		
		return Integer.valueOf(getPanel().input(builder.toString(), "Menu", -1));
	}

}
